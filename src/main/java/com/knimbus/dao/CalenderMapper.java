package com.knimbus.dao;

import java.io.Console;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import com.knimbus.*;
import com.knimbus.model.*;
import com.knimbus.util.config.MyBatisUtil;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository("calenderMapper")
public class CalenderMapper {
	public void addEvent(CalenderInfo calenderInfo) {
		System.out.println("-----------------------Inside Add Event-----------------");
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.insert("addEvent", calenderInfo);
		session.commit();
		session.close();
	}

	public List<EventInfo> getAllEvent() {
		List<EventInfo> eventInfoList = new ArrayList<EventInfo>();
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		System.out.println("-----------------------Inside All Event list-----------------");
		@SuppressWarnings("unchecked")
		List<CalenderInfo> eventList = session.selectList("getAllEvent");
		session.commit();
		session.close();
		System.out.println("Event Count" + eventList.size());

		for (CalenderInfo event : eventList) {
			if (event.getDate() != null) {
				System.out.println(event.getEvent_id());
				Calendar cal = Calendar.getInstance();
				cal.setTime(event.getDate());
				System.out.println("Date:" + cal.get(Calendar.DATE));
				System.out.println("Month:" + cal.get(Calendar.MONTH));
				System.out.println("Year:" + cal.get(Calendar.YEAR));
				String month = String.valueOf(cal.get(Calendar.MONTH) + 1);
//				if (month.length() <= 1)
//					month = "0" + month;
				String date = String.valueOf(cal.get(Calendar.DATE));
//				if (date.length() <= 1)
//					date = "0" + date;
				String formatedDate = (cal.get(Calendar.YEAR) + "-" + month + "-" + date);
				EventInfo eventInfo = new EventInfo(event.getEvent_id(), formatedDate, event.getTitle(),
						event.getLink());
				eventInfoList.add(eventInfo);
			}
		}

		return eventInfoList;
	}

	public CalenderInfo updateEvent(CalenderInfo calenderInfo) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		System.out.println("Input event:" + calenderInfo.toString());
		session.update("com.knimbus.dao.CalenderMapper.updateEvent", calenderInfo);
		CalenderInfo updatedEvent = (CalenderInfo) session.selectOne("com.knimbus.dao.CalenderMapper.getById",
				calenderInfo.getEvent_id());
		System.out.println("Details of the event after update operation");
		System.out.println(updatedEvent.toString());

		session.commit();
		session.close();

		return updatedEvent;
	}

	public void deleteEvent(Integer event_id) {
		SqlSession session = MyBatisUtil.getSqlSessionFactory().openSession();
		session.delete("deleteEvent", event_id);
		session.commit();
		session.close();
	}

}
