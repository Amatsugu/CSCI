package com.LuminousVector.CSCI260.Projects.Project2;

import com.LuminousVector.CSCI260.Excercies.BTNode;
import com.LuminousVector.Utils.FileV;

import java.io.IOException;

public class MorseTree
{
	BTNode<Character> root;

	public MorseTree(String morseDictionaryPath) throws IOException
	{
		root = new BTNode<>(null); //Create the root node with it's contents being null
		FileV file = new FileV(morseDictionaryPath).OpenReader(); //Load the file containing the morse definitions
		String[] lines = file.ReadAllLines().split("\n"); //Read all the lines from the file and split them into an array
		file.Close(); //Close the file reader
		for (String l: lines)
		{
			if(l == null) //Check for an ignore empty lines
				continue;
			String[] code = l.split(":"); //Split the lines into the letters and their code
			if(code.length != 2) // check for and ignore empty definitions
				continue;
			addCode(code[1], code[0].charAt(0)); //Add the code to the tree
		}
	}

	//Adds a coded letter to the tree based on it's code, overwriting existing letters if any
	public MorseTree addCode(String code, char character)
	{
		BTNode<Character> curNode = root; //Set the current node to the root node
		character = Character.toUpperCase(character); //Convert the letter to upper case
		for (int i = 0; i < code.length() ; i++)
		{
			switch (code.charAt(i))
			{
				case '.': //Create a left node and/or set the current node to the left node
					if(curNode.left == null)
						curNode = curNode.left = new BTNode<>(null);
					else
						curNode = curNode.left;
					break;
				case '-': //Create a right node and/or set the current node to the right node
					if(curNode.right == null)
						curNode = curNode.right = new BTNode<>(null);
					else
						curNode = curNode.right;
					break;
				default: //Throw an error if an invalid character is found in the code
					throw new InvalidMorseFormat("Invalid Character found: " + code.charAt(i) + "(" + i + ")");
			}
		}

		curNode.info = new Character(character); //Set the info of the final node to the letter
		return this; //Return this instance allowing for changed mutations
	}

	//Get a character based on it's code
	public char getChar(String code) throws InvalidMorseFormat
	{
		BTNode<Character> curNode = root;
		for(int i = 0; i < code.length(); i++)
		{
			//Traverse the tree selecting nodes
			switch (code.charAt(i))
			{
				case '.':
					curNode = curNode.left;
					break;
				case '-':
					curNode = curNode.right;
					break;
				default:
					throw new InvalidMorseFormat("Invalid Character found: " + code.charAt(i) + "(" + i + ")");
			}
			if(curNode == null) //Check if a selected node is null
			{
				throw new CharacterNotFoundException("Character not found at: (" + i + ") in " + code);
			}
		}
		//Return the info of the last selected node
		return curNode.info;
	}

}
