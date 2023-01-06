package com.knimbus.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.knimbus.dao.CalenderMapper;
import com.knimbus.model.CalenderInfo;
import com.knimbus.model.EventInfo;

@Service
public class CalendarService {
	
	@Autowired
	CalenderMapper calenderMapper;
		
	public void addEvent(CalenderInfo calenderInfo) {
		calenderMapper.addEvent(calenderInfo);

	};
	
	public List<EventInfo> getAllEvent(){
		List<EventInfo> eventList = calenderMapper.getAllEvent();
		return eventList;
	};
	
	public CalenderInfo updateEvent(CalenderInfo calenderInfo){
		CalenderInfo UpdateEvent = calenderMapper.updateEvent(calenderInfo);

		return calenderInfo;

	};
	
	
	public void deleteEvent(Integer event_id) {
		calenderMapper.deleteEvent(event_id);

	};
}
