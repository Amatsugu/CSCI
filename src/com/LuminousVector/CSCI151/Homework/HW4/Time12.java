package com.LuminousVector.CSCI151.Homework.HW4;

import com.LuminousVector.Utils.MathV;

public class Time12 extends Time
{
	enum Period
	{
		AM, PM
	}
	
	private Period period;
	
	public Time12(Time time)
	{
		super(time.getHours(), time.getMinutes());
		period = (time.hours <= 12) ? Period.AM : Period.PM;
		hours = (time.hours > 12) ? time.hours - 12 : time.hours;
	}
	
	public Time12(int hours, int minutes, Period period)
	{
		super(hours, minutes);
		this.period = period;
	}
	
	public Time12(String time)
	{
		super(time);
		period = (hours <= 12) ?  Period.AM : Period.PM;
		hours = (hours > 12) ? hours - 12 : hours;
	}

	public Period getPeriod()
	{
		return period;
	}
	
	public String getTime()
	{
		return MathV.FormatZeros(hours, 2) + ":" + MathV.FormatZeros(minutes, 2) + period;
	}
}
