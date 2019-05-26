package vn.edu.vnua.dse.calendar.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import vn.edu.vnua.dse.calendar.model.CalendarDetail;
import vn.edu.vnua.dse.calendar.model.Event;

@Repository("eventRepository")
public interface EventRepository extends JpaRepository<Event, Long> {
	Optional<Event> findByEventId(String eventId);

	Optional<Event> findByCalenDetail(CalendarDetail calenDetail);

	
	@Transactional
	Long deleteByCalenDetail(CalendarDetail calenDetail);
	
	@Query(value = "select * from event e where e.calenDetailId = ?1", nativeQuery = true)
	Optional<Event> findByCalenId(String calenDetailId);

	@Modifying
	@Transactional
	@Query("delete from Event e where e.calenDetail = ?1")
	void deleteByCalendarDetail(CalendarDetail calenDetail);

}
