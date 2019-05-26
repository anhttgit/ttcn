package vn.edu.vnua.dse.calendar.service;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.util.List;
import java.util.Set;

import vn.edu.vnua.dse.calendar.co.ScheduleCreate;
import vn.edu.vnua.dse.calendar.ggcalendar.jsonobj.GoogleEvent;

public interface ScheduleService {
	public boolean isExist(ScheduleCreate scheduleCreate);
	
	public Set<String> insert(String calenId, ScheduleCreate scheduleCreate) throws IOException, ParseException, NoSuchAlgorithmException;
	
	public Set<String> insert(String calenId, List<GoogleEvent> events) throws IOException;
}
