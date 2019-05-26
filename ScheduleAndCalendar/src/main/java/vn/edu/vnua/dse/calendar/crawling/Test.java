package vn.edu.vnua.dse.calendar.crawling;

import java.io.IOException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import antlr.collections.List;
import vn.edu.vnua.dse.calendar.ggcalendar.jsonobj.GoogleCalendar;
import vn.edu.vnua.dse.calendar.ggcalendar.jsonobj.GoogleCalendarList;
import vn.edu.vnua.dse.calendar.ggcalendar.wrapperapi.APIWrapper;
import vn.edu.vnua.dse.calendar.repository.SemesterRepository;

public class Test {
	
	@Autowired
	public static Date findDay(Date startSemester, int week, int day) {
		//set date
		Calendar calen = Calendar.getInstance();
		calen.setTime(startSemester);
		//compute
		calen.set(Calendar.DAY_OF_MONTH, calen.get(Calendar.DAY_OF_MONTH) + (week - 1) * 7 + day);

		return calen.getTime();
	}

	public static void main(String[] args) throws ParseException, IOException {
		
		APIWrapper apiWrapper = new APIWrapper("1/Lq80hsrGV_GTB7CIHoC6UF3a5HQ0wJ29zUX_oKkZEZI");
//		List<	apiWrapper.getCalendarList("");
		Gson gson = new GsonBuilder().create();
		GoogleCalendar calendar = gson.fromJson("{\r\n" + 
				" \"error\": {\r\n" + 
				"  \"errors\": [\r\n" + 
				"   {\r\n" + 
				"    \"domain\": \"global\",\r\n" + 
				"    \"reason\": \"notFound\",\r\n" + 
				"    \"message\": \"Not Found\"\r\n" + 
				"   }\r\n" + 
				"  ],\r\n" + 
				"  \"code\": 404,\r\n" + 
				"  \"message\": \"Not Found\"\r\n" + 
				" }\r\n" + 
				"}\r\n" + 
				"", GoogleCalendar.class);
		if(calendar == null) {
			System.out.println("em bi rong");
			}
		System.out.println(calendar.getId());
	}
}
