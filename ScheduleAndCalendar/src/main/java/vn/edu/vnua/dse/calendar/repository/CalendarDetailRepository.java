package vn.edu.vnua.dse.calendar.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.edu.vnua.dse.calendar.model.Calendar;
import vn.edu.vnua.dse.calendar.model.CalendarDetail;
import vn.edu.vnua.dse.calendar.model.Semester;

@Repository("calendarDetailRepository")
public interface CalendarDetailRepository extends JpaRepository<CalendarDetail, Long>{
	Optional<CalendarDetail> findByCalendarAndSemester(Calendar calendar, Semester semester);
	
	@Query(value = "Select * from calendar_detail c where c.calenId = ?1 and c.semesId = ?2", nativeQuery = true)
	Optional<CalendarDetail> findByCalenIdAndSemesId(String calendId, String semesId);
	
	

}
