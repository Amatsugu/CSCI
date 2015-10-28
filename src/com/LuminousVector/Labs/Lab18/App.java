package com.LuminousVector.Labs.Lab18;

import com.LuminousVector.Homework.HW4.Time;
import com.LuminousVector.Labs.Lab15.AlarmClock;

public class App
{

	public static void main(String[] args)
	{
		Writer writer = new Writer("output.txt");
		writer.AppendNumberRange(1, 100, 1);
		writer.AppendNumberRange(101, 200, 1);
		writer.AppendObject(new AlarmClock(5,4,1,new Time(6,8)));
		writer.Close();
	}

}
