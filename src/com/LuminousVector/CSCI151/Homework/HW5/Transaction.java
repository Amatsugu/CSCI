package com.LuminousVector.CSCI151.Homework.HW5;

import java.util.ArrayList;

import com.LuminousVector.Utils.Debug;

public class Transaction
{
	private ArrayList<Item> items = new ArrayList<>();
	private boolean isActive = true;

	public void AddItem(String itemName, float itemPrice, int itemCount)
	{
		AddItem(new Item(itemName, itemPrice, itemCount));
	}

	public void AddItem(String itemName, float itemPrice)
	{
		AddItem(new Item(itemName, itemPrice, 1));
	}

	public void AddItem(Item item)
	{
		items.add(item);
		Debug.lognr(GetLine(item));
	}

	private String GetLine(Item i)
	{
		String out = "";
		float price = i.getItemPrice();
		int count = i.getItemCount();
		out += count + " ";
		out += i.getItemName() + " was purchased at $";
		out += price + " each, $";
		out += (count * price) + " in total.\n";
		return out;
	}

	public String GetLog()
	{
		String out = "---BEGIN TRANSACTION---\n";
		float total = 0;
		for (Item i : items)
		{
			out += GetLine(i);
			total += i.getItemPrice();
		}
		out += "The total is $" + total + "\n";
		out += "---END TRANSACRTION---\n";
		return out;
	}

	public void End()
	{
		isActive = false;
	}

	public boolean IsActive()
	{
		return isActive;
	}

}
