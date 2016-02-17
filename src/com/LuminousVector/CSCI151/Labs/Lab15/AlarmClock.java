package com.LuminousVector.CSCI151.Labs.Lab15;

import com.LuminousVector.CSCI151.Homework.HW4.Time;

public class AlarmClock extends Clock
{
	private Time alarmTime;
	public AlarmClock()
	{
		super();
	}
	
	public AlarmClock(int hr, int min, int sec)
	{
		super(hr, min, sec);
		alarmTime = new Time(hr, min);
	}
	
	public AlarmClock(int hr, int min, int sec, Time alarm)
	{
		super(hr, min, sec);
		alarmTime = alarm;
	}
	
	public boolean equals(Object obj)
	{
		return super.equals(obj);
	}
	
	public String toString()
	{
		return super.toString() + " alarm: " + alarmTime.toString();
	}
}
