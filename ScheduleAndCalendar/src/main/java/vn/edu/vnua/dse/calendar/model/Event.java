package vn.edu.vnua.dse.calendar.model;

import javax.persistence.*;

@Entity
@Table(name = "event")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String eventId;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "calenDetailId", nullable = false)
	private CalendarDetail calenDetail;

	public Event() {

	}

	public Event(String eventId) {
		this.eventId = eventId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public CalendarDetail getCalenDetail() {
		return calenDetail;
	}

	public void setCalenDetail(CalendarDetail calenDetail) {
		this.calenDetail = calenDetail;
	}

}
