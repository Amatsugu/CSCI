package LuminousVector.CSCI151.Labs.Lab15;

import LuminousVector.Utils.MathV;

public class Clock
{
	private int hr;
	private int min;
	private int sec;
	
	public Clock()
	{
		this.hr = this.min = this.sec = 0;
	}
	
	public Clock(int hr, int min, int sec)
	{
		this.hr = hr;
		this.min = min;
		this.sec = sec;
	}
	
	public void setHour(int value)
	{
		hr = MathV.Clamp(value, 0, 23);
	}
	
	public int getHours()
	{
		return hr;
	}
	
	public void setMinutes(int value)
	{
		min = MathV.Clamp(value, 0, 59);
	}
	
	public int getMinutes()
	{
		return min;
	}
	
	public void setSeconds(int value)
	{
		sec = MathV.Clamp(value, 0, 59);
	}
	
	public int getSeconds()
	{
		return sec;
	}
	
	public String toString()
	{
		return MathV.FormatZeros(hr, 2) + ":" + MathV.FormatZeros(min, 2) + ":" + MathV.FormatZeros(sec, 2);
	}
	
	public boolean equals(Object obj)
	{
		if(obj == null)
			return false;
		else if(getClass() != obj.getClass())
			return false;
		else
		{
			Clock c = (Clock)obj;
			return (c.hr == hr) && (c.min == min) && (c.sec == sec);
		}
	}
}
