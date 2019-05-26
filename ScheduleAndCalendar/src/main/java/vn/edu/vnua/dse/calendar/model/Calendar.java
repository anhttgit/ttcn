package vn.edu.vnua.dse.calendar.model;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "calendar")
public class Calendar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "studentId", length = 6)
	private String studentId;

	@Column(name = "calendarId")
	private String calendarId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId", nullable = false)
	private User user;

	
	@OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<CalendarDetail> calendarDetails;

	
	
	public Calendar() {

	}

	public Calendar(User user, String studentId, String calendarId) {
		this.user = user;
		this.studentId = studentId;
		this.calendarId = calendarId;
	}
	
	public Calendar(User user, String studentId, String calendarId, CalendarDetail... calendarDetails) {
		this.user = user;
		this.studentId = studentId;
		this.calendarId = calendarId;
		for (CalendarDetail calendarDetail : calendarDetails)
			calendarDetail.setCalendar(this);
		this.calendarDetails = Stream.of(calendarDetails).collect(Collectors.toSet());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getCalendarId() {
		return calendarId;
	}

	public void setCalendarId(String calendarId) {
		this.calendarId = calendarId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CalendarDetail> getCalendarDetails() {
		return calendarDetails;
	}

	public void setCalendarDetails(Set<CalendarDetail> calendarDetails) {
		this.calendarDetails = calendarDetails;
	}
	
	public void addCalendarDetails(CalendarDetail calendarDetail) {
		calendarDetail.setCalendar(this);
		this.calendarDetails.add(calendarDetail);
	}

}
