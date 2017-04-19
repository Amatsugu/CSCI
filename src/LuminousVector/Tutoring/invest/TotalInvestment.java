package LuminousVector.Tutoring.invest;

import LuminousVector.Utils.Console;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class TotalInvestment
{
	private ArrayList<Investment> investments;

	public  TotalInvestment(String filename) throws Exception
	{
		investments = new ArrayList<>();
		BufferedReader reader = new BufferedReader(new FileReader(filename));
		String curLine;
		do
		{
			curLine = reader.readLine();
			String[] data = curLine.split(":");
			switch (data[0].toLowerCase())
			{
				case "cash":
					double value = Double.parseDouble(data[1]);
					investments.add(new Cash(value));
					break;
				case "stock":
					String[] stockData = data[1].split(",");
					int shares = Integer.parseInt(stockData[1]);
					double shareValue = Double.parseDouble(stockData[2]);
					investments.add(new Stock(stockData[0], shares, shareValue));
					break;
				default:
					throw new Exception("Unable to read line");
			}
		}while (curLine != null);
		System.out.println("Grand Total: $" + GetTotal());
	}

	private double GetTotal()
	{
		return CalculateTotal(0, investments);
	}

	private  double CalculateTotal(int n, ArrayList<Investment> list)
	{
		double curTotal;
		if(n >= list.size())
			return  0;
		else
		{
			curTotal = list.get(n).value()+ CalculateTotal(n+1, list);
			Console.log(list.get(n).toString());
			System.out.println("Current Total: $" + curTotal);
		}
		return curTotal;
	}


}
