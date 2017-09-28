package com.hy.ly.meeting;

import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMeeting {
	
	public static void main(String[] args) {
		MeetingPlaceImplAll m=new MeetingPlaceImplAll();
		m.singer("王菲");
		System.out.println("------------------------");
		m.football("中国男足");
		System.out.println("------------------------");
		m.party("阿里巴巴");
	}

	@Test
	public void testMeetingAOP(){
		AbstractApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-aop-meeting.xml");
		MeetingPlace m=(MeetingPlace) ctx.getBean("meetingPlaceImpl");
		m.singer("王菲");
		System.out.println("------------------------");
		m.football("中国男足");
		System.out.println("------------------------");
		m.party("阿里巴巴");
		ctx.close();
	}

}
