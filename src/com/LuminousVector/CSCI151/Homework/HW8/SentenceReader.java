package com.LuminousVector.CSCI151.Homework.HW8;

import java.util.ArrayList;

public class SentenceReader
{
	private ArrayList<Sentence> sentences = new ArrayList<>();

	public SentenceReader(String paragraph)
	{
		paragraph.replaceAll("\n", " ");
		String[] splitParagraph = paragraph.split("\\. ");
		for (String s: splitParagraph)
		{
			sentences.add(new Sentence(s));
		}
	}

	public SentenceReader AddSentence(Sentence sentence)
	{
		sentences.add(sentence);
		return this;
	}

	public SentenceReader AddSentence(String sentence)
	{
		sentences.add(new Sentence(sentence));
		return this;
	}

	public SentenceReader AddWord(int sentenceIndex, String word) throws NoSuchSentenceException
	{
		GetSentence(sentenceIndex).AddWord(word);
		return this;
	}

	public Sentence GetSentence(int index) throws NoSuchSentenceException
	{
		if(index < 0)
			throw new NoSuchSentenceException("Index cannot be negative.");
		if(index > sentences.size()-1)
			throw new NoSuchSentenceException("There is no sentence at that index");
		return sentences.get(index);
	}

	public String GetWord(int sentenceIndex, int wordIndex) throws NoSuchSentenceException, NoSuchWordException
	{
		return GetSentence(sentenceIndex).GetWord(wordIndex);
	}
}
