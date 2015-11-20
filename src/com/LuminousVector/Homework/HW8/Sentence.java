package com.LuminousVector.Homework.HW8;

import com.LuminousVector.Utils.Debug;

import java.util.ArrayList;
import java.util.Arrays;

public class Sentence
{
	private ArrayList<String> words = new ArrayList<>();

	public Sentence(String sentence)
	{
		AddSentence(sentence);
	}

	public Sentence AddWord(String word)
	{
		if(word.contains(" "))
			AddSentence(word);
		else
			words.add(word);
		return this;
	}

	public Sentence AddSentence(String sentence)
	{
		String[] splitSentence = sentence.split("\\s+");
		words.addAll(Arrays.asList(splitSentence));
		return this;
	}

	public String GetWord(int index) throws NoSuchWordException
	{
		if(index < 0)
			throw new NoSuchWordException("Index cannot be negative.");
		if(index > words.size()-1)
			throw new NoSuchWordException("There is no word at that index");
		return words.get(index);
	}
}
