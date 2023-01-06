package com.knimbus.model;

import java.util.Date;

public class CalenderInfo {
	private Integer event_id;
	private Date date;
	private String title;
	private String link;

	

//	public Integer getEventId() {
//		return eventId;
//	}
//
//	public void setEventId(Integer eventId) {
//		this.eventId = eventId;
//	}

	public Integer getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Integer event_id) {
		this.event_id = event_id;
	}

	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
