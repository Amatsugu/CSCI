package com.LuminousVector.Homework.HW5;

public class Item
{
	private String itemName;
	private float itemPrice;
	private int itemCount;

	public Item(String itemName, float itemPrice, int itemCount)
	{
		this.itemCount = itemCount;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
	}

	public Item(String itemName, float itemPrice)
	{
		this(itemName, itemPrice, 1);
	}

	public String getItemName()
	{
		return itemName;
	}

	public float getItemPrice()
	{
		return itemPrice;
	}

	public int getItemCount()
	{
		return itemCount;
	}

}
