package vn.edu.vnua.dse.calendar.crawling;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.gson.Gson;

import vn.edu.vnua.dse.calendar.common.AppUtils;
import vn.edu.vnua.dse.calendar.ggcalendar.jsonobj.GoogleDateTime;
import vn.edu.vnua.dse.calendar.ggcalendar.jsonobj.GoogleEvent;
import vn.edu.vnua.dse.calendar.ggcalendar.wrapperapi.CalendarConstant;

public class ExamEventDetails {
	private static final String DESCRIPTION = 
			"Mã học phần: %s" + 
			"\nNhóm: %s" + 
			"\nTổ: %s";

	public static String examScheduleHash;
	// lấy danh dách các event từ lịch thi
	public static final List<GoogleEvent> getEventsFromSchedule(String studentId)
			throws IOException, ParseException, NoSuchAlgorithmException {
		ArrayList<String> examScheduleJson = getExamSchedule(studentId);

		if (examScheduleJson.size() > 0) {
			return toGoogleEvent(examScheduleJson);
		}

		return null;
	}

	// chuyển từ list json sang list GoogleEvent
	private static List<GoogleEvent> toGoogleEvent(ArrayList<String> examScheduleJson) throws ParseException {
		List<GoogleEvent> events = new ArrayList<>();
		Gson gson = new Gson();
		
		for (String json : examScheduleJson) {
			//convert json to array
			ArrayList item = gson.fromJson(json, ArrayList.class);
			
			String subjectCode = item.get(1).toString();
			String subjectName = item.get(2).toString();
			String group = item.get(3).toString();
			String team	= item.get(4).toString();
			String dateStr = item.get(6).toString();
			int startSlot = Integer.parseInt(item.get(7).toString());
			int endSlot = startSlot + Integer.parseInt(item.get(8).toString()) - 1;
			String location = item.get(9).toString();
			
			String summary = subjectName;
			String startTimeStr = DateTimeConstant.STARTTIME.get(startSlot);
			Date start = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dateStr + " " + startTimeStr);
			String endTimeStr = DateTimeConstant.STARTTIME.get(endSlot);
			Date end = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").parse(dateStr + " " + endTimeStr);
			String description = String.format(DESCRIPTION, subjectCode, group, team);

			GoogleEvent event = new GoogleEvent();
			event.setSummary(summary);
			event.setLocation(location);
			event.setStart(new GoogleDateTime(start, CalendarConstant.TIME_ZONE));
			event.setEnd(new GoogleDateTime(end, CalendarConstant.TIME_ZONE));
			//viet google event khac
		}
		
		return null;
	}

	// Lấy danh sách thời khóa biểu dạng json
	private static ArrayList<String> getExamSchedule(String studentId) throws IOException {
		// Open browser
		WebDriver driver = ScheduleUtils.openChrome();
		driver.manage().window().maximize();
		String url = String.format(ScheduleConstant.EXAM_SCHEDULE_URL, studentId);
		driver.get(url);

		// Get schedule
		WebDriverWait wait = new WebDriverWait(driver, 10);
		// Inject JQuery trong Selenium WebDriver
		ScheduleUtils.injectJQuery(driver, ScheduleConstant.JQUERY_FILE);
		JavascriptExecutor jse = ((JavascriptExecutor) driver);
		String code = ScheduleUtils.readFile(ScheduleConstant.GET_EXAM_SCHEDULE_JQUERY);
		
		ArrayList<String> examScheduleJson = (ArrayList<String>) jse.executeScript(code);
		
		driver.close();
		driver.quit();
		
		examScheduleHash = AppUtils.getMD5(examScheduleJson.toString());
		return examScheduleJson;
	}

}
