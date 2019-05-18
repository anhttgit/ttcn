package vn.edu.vnua.dse.calendar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import vn.edu.vnua.dse.calendar.model.Calendar;
import vn.edu.vnua.dse.calendar.model.Semester;

@Repository("calendarRepository")
public interface CalendarRepository extends JpaRepository<Calendar, Long>{
	Calendar findByStudentId(String studentId);
	
	Calendar findByCalendarId(String calendarId);
	
	Calendar findBySemester(Semester semester);
}
