package vn.edu.vnua.dse.calendar.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.edu.vnua.dse.calendar.co.ScheduleCreate;
import vn.edu.vnua.dse.calendar.model.User;


@Controller
@RequestMapping("/schedule/")
public class ScheduleController {
	
	@RequestMapping(value = "create", method = RequestMethod.GET)
	public String Create(Model model) {
		Map< String, String > semesters = new HashMap<String, String>();
		semesters.put("20182", "Học kỳ 2 - Năm học 2018-2019");
		semesters.put("20183", "Học kỳ 3 - Năm học 2018-2019");
		semesters.put("20191", "Học kỳ 1 - Năm học 2019-2020");
      
		model.addAttribute("semesters", semesters);
		model.addAttribute("scheduleCreate", new ScheduleCreate());
		return "schedule/create";
	}
	
	@RequestMapping(value = "create", method = RequestMethod.POST)
	public String Create(@ModelAttribute("scheduleCreate") ScheduleCreate scheduleCreate, Model model) {
		
		return "schedule/create";
	}
	
	
}
