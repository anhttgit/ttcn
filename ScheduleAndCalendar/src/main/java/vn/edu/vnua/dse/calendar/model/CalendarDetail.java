package vn.edu.vnua.dse.calendar.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "calendar_detail")
public class CalendarDetail implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
    
	@ManyToOne
	@JoinColumn(name = "calenId")
	private Calendar calendar;

	@ManyToOne
	@JoinColumn(name="semesId")
	private Semester semester;

	private String scheduleHash;
	
	@OneToMany(mappedBy = "calenDetail", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Event> events;
	

	public CalendarDetail(Semester semester, String scheduleHash, Set<Event> events) {//them events vao, vs moi event set calendarDetail = this
		this.semester = semester;
		this.scheduleHash = scheduleHash;
		
		for (Event event : events) {
			event.setCalenDetail(this);
		}
		this.events = events;
	}

	public CalendarDetail() {

	}

//	public boolean equal(Object o) {
//		if (this == o)
//			return true;
//		if (!(o instanceof CalendarDetail))
//			return false;
//		CalendarDetail that = (CalendarDetail) o;
//		return Objects.equals(calendar.getCalendarId(), that.calendar.getCalendarId())
//				&& Objects.equals(semester.getId(), that.semester.getId())
//				&& Objects.equals(scheduleHash, that.scheduleHash);
//	}
//
//	@Override
//	public int hashCode() {
//		return Objects.hash(calendar.getCalendarId(), semester.getId(), scheduleHash);
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Calendar getCalendar() {
		return calendar;
	}

	public void setCalendar(Calendar calendar) {
		this.calendar = calendar;
	}

	public Semester getSemester() {
		return semester;
	}

	public void setSemester(Semester semester) {
		this.semester = semester;
	}

	public String getScheduleHash() {
		return scheduleHash;
	}

	public void setScheduleHash(String scheduleHash) {
		this.scheduleHash = scheduleHash;
	}

	public Set<Event> getEvents() {
		return events;
	}

	public void setEvents(Set<Event> events) {
		this.events = events;
	}

}
