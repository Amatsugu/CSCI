package LuminousVector.CSCI151.Labs.Lab18;

import LuminousVector.CSCI151.Homework.HW4.Time;
import LuminousVector.CSCI151.Labs.Lab15.AlarmClock;

public class WriterApp
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
