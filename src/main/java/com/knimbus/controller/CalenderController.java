package com.knimbus.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.knimbus.dao.CalenderMapper;
import com.knimbus.model.CalenderInfo;
import com.knimbus.model.EventInfo;
import com.knimbus.model.User;
import com.knimbus.service.CalendarService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@Api(tags = "This is calender controller")
public class CalenderController {
	@Autowired
	CalendarService calendarService;
	

	@ApiOperation(value = "Saves user details in Database")
	@RequestMapping(value = "/calender", method = RequestMethod.POST)
	public ResponseEntity<?> addEvent(
			@ApiParam(value = "Please enter the calender event details", required = true) @RequestBody CalenderInfo calenderInfo) {
		System.out.println("--------------Inside Add Event-------------");
		
		calendarService.addEvent(calenderInfo);
		return new ResponseEntity<CalenderInfo>(calenderInfo, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Get event list")
	@RequestMapping(value = "/listOfEvent", method = RequestMethod.GET)
	public ResponseEntity<?> listOfEvent() {
		System.out.println("......Inside Event List........");
		List<EventInfo> eventList = calendarService.getAllEvent();
		return new ResponseEntity<List<EventInfo>>(eventList, HttpStatus.OK);
	}	
	
	@ApiOperation(value = "Update event")
	@RequestMapping(value = "/editEvent", method = RequestMethod.PUT)
	public ResponseEntity<?> editEvent(
			@ApiParam(value = "Please enter the event details to be update", required = true) @RequestBody CalenderInfo calenderInfo) {
		System.out.println("----------Inside updateEvent-------------");
		CalenderInfo UpdateEvent = calendarService.updateEvent(calenderInfo);
		return new ResponseEntity<CalenderInfo>(UpdateEvent, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Delete event")
	@RequestMapping(value = "/deleteEvent/{event_id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteEvent(
			@ApiParam(value = "Please enter the event date which to be delete", required = true) @PathVariable("event_id") Integer event_id) {
		System.out.println("------------Inside deleteEvent--------------");
		calendarService.deleteEvent(event_id);

		return new ResponseEntity<CalenderInfo>( HttpStatus.OK);
	}
	
	
}
