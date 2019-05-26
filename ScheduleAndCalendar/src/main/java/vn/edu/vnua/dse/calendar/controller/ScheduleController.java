package vn.edu.vnua.dse.calendar.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.vnua.dse.calendar.co.CustomUserDetails;
import vn.edu.vnua.dse.calendar.co.ScheduleCreate;
import vn.edu.vnua.dse.calendar.common.AppConstant;
import vn.edu.vnua.dse.calendar.common.AppUtils;
import vn.edu.vnua.dse.calendar.crawling.SubjectEventDetails;
import vn.edu.vnua.dse.calendar.ggcalendar.jsonobj.GoogleCalendar;
import vn.edu.vnua.dse.calendar.ggcalendar.jsonobj.GoogleEvent;
import vn.edu.vnua.dse.calendar.ggcalendar.wrapperapi.APIWrapper;
import vn.edu.vnua.dse.calendar.model.Calendar;
import vn.edu.vnua.dse.calendar.model.CalendarDetail;
import vn.edu.vnua.dse.calendar.model.Event;
import vn.edu.vnua.dse.calendar.model.Semester;
import vn.edu.vnua.dse.calendar.model.User;
import vn.edu.vnua.dse.calendar.repository.CalendarDetailRepository;
import vn.edu.vnua.dse.calendar.repository.CalendarRepository;
import vn.edu.vnua.dse.calendar.repository.SemesterRepository;
import vn.edu.vnua.dse.calendar.repository.UserRepository;
import vn.edu.vnua.dse.calendar.service.ScheduleService;
import vn.edu.vnua.dse.calendar.service.UserDetailsServiceImpl;

@Controller
@RequestMapping
public class ScheduleController {

	@Autowired
	CalendarRepository calendarRepository;

	@Autowired
	CalendarDetailRepository calendarDetailRepository;

	@Autowired
	APIWrapper aPIWrapper;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ScheduleService scheduleService;

	@Autowired
	SemesterRepository semesterRepository;

	
	
	@RequestMapping(value = "/schedule/create", method = RequestMethod.GET)
	public String Create(Model model) {
		Map<String, String> semesters = new HashMap<String, String>();
		List<Semester> lstSemester = semesterRepository.findAll();
		for (Semester semester : lstSemester) {
			semesters.put(semester.getId(), semester.getName());
		}

		// 1.kiểm tra xem đã cấp quyền(có refreshToken) chưa
		User user = UserDetailsServiceImpl.getUser();
		
		String refreshToken = user.getRefreshToken();
		

		// 2.nếu chưa => yêu cầu cấp quyền
		if (AppUtils.isNullOrEmpty(refreshToken)) {
			String email = user.getEmail();
			String authUrl;
			if (AppUtils.isNullOrEmpty(email)) {
				authUrl = APIWrapper.getAuthUrl();
			} else {
				authUrl = APIWrapper.getAuthUrl(email);
			}

			return "redirect:" + authUrl;
		} else { // Nếu đã có refreshToken
			model.addAttribute("scheduleCreate", new ScheduleCreate());
			model.addAttribute("semesters", semesters);
			return "schedule/create";
		}
	}

	@RequestMapping(value = "/schedule/create", method = RequestMethod.POST)
	public String Create(@ModelAttribute("scheduleCreate") ScheduleCreate scheduleCreate, Model model)
			throws IOException, ParseException, NoSuchAlgorithmException {
		aPIWrapper = new APIWrapper(UserDetailsServiceImpl.getRefreshToken());
		
		String semester = scheduleCreate.getSemester();
		String studentId = scheduleCreate.getStudentId();

		// 1. Kiểm tra xem lịch với mã sinh viên nhập vào đã được thêm chưa find calendar by student id
		Optional<Calendar> calenOptional = calendarRepository.findByStudentId(studentId);
		if (calenOptional.isPresent()) {
			Calendar calendar = calenOptional.get();
			// kiểm tra xem calendar còn trên google calendar không
			String calendarId = calendar.getCalendarId();
			GoogleCalendar googleCalendar = aPIWrapper.getCalendar(calendarId);
			if (googleCalendar == null) {
				calendarRepository.delete(calendar.getId());
				if(!addCalendar(scheduleCreate)) {
					//bao loi
				};
			} else {
				// kiem tra xem calendar voi hoc ky nhap vao da co chua
				Optional<CalendarDetail> calenDetailOptional = calendarDetailRepository.findByCalendarAndSemester(calendar,
						semesterRepository.findById(semester));

				if (calenDetailOptional.isPresent()) {
					CalendarDetail calendarDetail = calenDetailOptional.get();
					List<GoogleEvent> newEvents = SubjectEventDetails.getEventsFromSchedule(studentId, semester);
					
					if(!calendarDetail.getScheduleHash().equals(SubjectEventDetails.scheduleHash)) {//neu thoi khoa bieu thay doi
						HashSet<Event> oldEvents = (HashSet<Event>) calendarDetail.getEvents();
						//xoa events cu
						for (Event oldEvent : oldEvents) {
							aPIWrapper.deleteEvent(calendar.getCalendarId(), oldEvent.getEventId());
						}
						//them event moi
						scheduleService.insert(calendar.getCalendarId(), newEvents);
						//thong bao cap nhat thoi khoa bieu thanh cong
					}
				} else {
					updateCalendar(calendar, scheduleCreate);
					//them thoi khoa bieu thanh cong
				}

				return "redirect:create";
			}
		} else {
			// Nếu chưa thêm thì insert vào ggcalen và thêm calendar vào db
			addCalendar(scheduleCreate);
		}
		return "redirect:create";
	}

	private boolean addCalendar(ScheduleCreate scheduleCreate) {
		String studentId = scheduleCreate.getStudentId();
		String semesId = scheduleCreate.getSemester();
		
		String summary = AppConstant.SCHEDULE_SUMMARY + studentId;
		try {
			aPIWrapper = new APIWrapper(UserDetailsServiceImpl.getRefreshToken());
			
			GoogleCalendar ggcalen = aPIWrapper.insertCalendar(summary);
			User user = UserDetailsServiceImpl.getUser();
			// lấy tkb
			HashSet<String> eventIds = new HashSet<>();
			try {
				eventIds = (HashSet<String>) scheduleService.insert(ggcalen.getId(), scheduleCreate);
			} catch (NoSuchAlgorithmException | ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			// insert list event, calendardetail, calendar
			if(eventIds.size() > 0) {
				HashSet<Event> events = new HashSet<>();
				for (String eventId : eventIds) {
					Event e = new Event(eventId);
					events.add(e);
				}
				
				Semester semester = semesterRepository.findById(semesId);
				String scheduleHash = SubjectEventDetails.scheduleHash;
				
				CalendarDetail calendarDetail = new CalendarDetail(semester, scheduleHash, events);

				Calendar calendar = new Calendar(user, studentId, ggcalen.getId(), calendarDetail);

				calendarRepository.save(calendar);
				return true;
			}else {
				//thong bao khong co lich
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//thong bao loi
		return false;
	}
	
	private void updateCalendar(Calendar calendar, ScheduleCreate scheduleCreate) {
		HashSet<String> eventIds;
		
		try {
			eventIds = (HashSet<String>) scheduleService.insert(calendar.getCalendarId(), scheduleCreate);
			// insert list event, calendardetail, calendar
			if(eventIds.size() > 0) {
				HashSet<Event> events = new HashSet<>();
				for (String eventId : eventIds) {
					Event e = new Event(eventId);
					events.add(e);
				}

				CalendarDetail calendarDetail = 
						new CalendarDetail(semesterRepository.findById(scheduleCreate.getSemester()), SubjectEventDetails.scheduleHash, events);
				// cập nhật calendar
				calendar.addCalendarDetails(calendarDetail);

				calendarRepository.save(calendar);
			}else {
				//thong bao khong co lich
			}
	
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}

}
