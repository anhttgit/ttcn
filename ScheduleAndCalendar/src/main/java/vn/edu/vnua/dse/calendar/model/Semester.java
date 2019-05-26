package vn.edu.vnua.dse.calendar.model;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "semester")
public class Semester {
	@Id
	@Column(name = "id")
	private String id;
	@Column(name = "name")
	private String name;
	@Column(name = "startDate")
	private Date startDate;

	@OneToMany(mappedBy = "semester", cascade = CascadeType.ALL)
    private Set<CalendarDetail> calendarDetails = new HashSet<>();

	public Semester(String name, Date startDate) {
		this.name = name;
		this.startDate = startDate;
	}
	
	public Semester() {
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Set<CalendarDetail> getCalendarDetails() {
		return calendarDetails;
	}

	public void setCalendarDetails(Set<CalendarDetail> calendarDetails) {
		this.calendarDetails = calendarDetails;
	}
	
	
	

	
}