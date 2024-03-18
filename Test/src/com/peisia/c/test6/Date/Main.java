package com.peisia.c.test6.Date;

import java.util.Date;

import com.peisia.c.util.Cw;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Main {
	public static void main(String[] args) {
//		java.util.Date now = new java.util.Date();
		Date now = new Date();
		String strNow1 = now.toString();
		Cw.wn(strNow1);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분 ss초");
		String strNow2 = sdf.format(now);
		Cw.wn(strNow2);
		
		Calendar n = Calendar.getInstance(); // 한개만 있어도 충분하기 때문에
		// Calender n = new Calendar를 안하는 이유는 싱글톤 만들어서 받아먹는 서비스만 생성해 전달만 받는다.
		// 싱글톤 : 프로그램 내에서 해당 클래스로 부터 만들어지는 객체가 딱 한개만 생성되도록 보장하는 장치.
		int y = n.get(Calendar.YEAR);
		int m = n.get(Calendar.MONTH) + 1;
		int day = n.get(Calendar.DAY_OF_MONTH);
		int week = n.get(Calendar.DAY_OF_WEEK);
		
		String strWeek = null;
		switch(week) {
		case Calendar.MONDAY:
			strWeek = "월";
		case Calendar.TUESDAY:
			strWeek = "화";
		case Calendar.WEDNESDAY:
			strWeek = "수";
		case Calendar.THURSDAY:
			strWeek = "목";
		case Calendar.FRIDAY:
			strWeek = "금";
		case Calendar.SATURDAY:
			strWeek = "토";
		case Calendar.SUNDAY:
			strWeek = "일";
		}
		
		int amPm = n.get(Calendar.AM_PM);
		String strAmPm = null;
		if(amPm == Calendar.AM) {
			strAmPm = "오전";
		} else {
			strAmPm = "오후";
		}
		
		int hour = n.get(Calendar.HOUR);
		int minute = n.get(Calendar.MINUTE);
		int second = n.get(Calendar.SECOND);
		
		System.out.print(y + "년 ");
		System.out.print(m + "월 ");
		System.out.println(day + "일");
		System.out.println(strWeek + "요일");
		System.out.print(strAmPm + " ");
		System.out.print(hour + "시 ");
		System.out.print(minute + "분 ");
		System.out.println(second + "초");
	}
}
