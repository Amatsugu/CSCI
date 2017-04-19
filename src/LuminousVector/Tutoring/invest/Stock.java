package LuminousVector.Tutoring.invest;

public class Stock implements Investment
{
	private String name;
	private int shares;
	private double shareValue;

	public Stock(String name, int shares, double shareValue)
	{
		this.name = name;
		this.shares = shares;
		this.shareValue = shareValue;
	}

	public  double value()
	{
		return shares * shareValue;
	}

	public String toString()
	{
		return name + ": $" + value();
	}
}
