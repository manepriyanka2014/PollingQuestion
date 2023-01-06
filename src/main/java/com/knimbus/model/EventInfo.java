package com.knimbus.model;

import java.util.Date;

public class EventInfo {
	private Integer event_id;
    private String date;
	private String title;
	private String link;
	
	public EventInfo(Integer event_id, String date, String title, String link) {
		super();
		this.event_id=event_id;
		this.date = date;
		this.title = title;
		this.link = link;
	}
//	
//	public Integer getEventId() {
//		return event_id;
//	}
//	public void setEventId(Integer eventId) {
//		this.event_id = eventId;
//	}
	
	public Integer getEvent_id() {
		return event_id;
	}

	public void setEvent_id(Integer event_id) {
		this.event_id = event_id;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
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
	
	
}
