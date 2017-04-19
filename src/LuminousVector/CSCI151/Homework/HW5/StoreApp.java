package LuminousVector.CSCI151.Homework.HW5;

import java.util.Scanner;
import java.io.*;

import LuminousVector.Utils.Console;

public class StoreApp
{
	public static void main(String[] args)
	{
		Transaction t = new Transaction();
		Scanner in = new Scanner(System.in);
		while (t.IsActive())
		{
			Console.log("Enter '-END-' to finish.");
			Console.lognr("Enter item name: ");
			String itemName = in.next();
			if (itemName.equalsIgnoreCase("-END-"))
			{
				t.End();
				break;
			}
			Console.lognr("Enter item price: ");
			float itemPrice = in.nextFloat();
			Console.lognr("Enter item count: ");
			int itemCount = in.nextInt();
			t.AddItem(itemName, itemPrice, itemCount);
		}
		in.close();	
		String log = t.GetLog();
		File f = new File("output.txt");
		try
		{
			//if (!f.exists())
			//{
			//	f.createNewFile();
			//}
			FileWriter fw = new FileWriter("output.txt");
			fw.append(log);
			fw.flush();
			fw.close();
		} catch (Exception e)
		{
			Console.log(e.getMessage());
		}
		Console.log(log);
	}
}
