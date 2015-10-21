package com.LuminousVector.Homework.HW4;

import com.LuminousVector.Utils.MathV;

public class Time
{
	protected int hours;
	protected int minutes;
	
	public Time(String time)
	{
		String[] t = time.split(":");
		hours = Integer.parseInt(t[0]);
		minutes = Integer.parseInt(t[1]);
	}
	
	public Time(int hours, int minutes)
	{
		this.hours = hours;
		this.minutes = minutes;
	}

	public int getHours()
	{
		return hours;
	}

	public int getMinutes()
	{
		return minutes;
	}
	
	public String getTime()
	{
		return MathV.FormatZeros(hours, 2) + ":" + MathV.FormatZeros(minutes, 2);
	}
}
