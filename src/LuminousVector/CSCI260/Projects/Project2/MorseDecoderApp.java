package LuminousVector.CSCI260.Projects.Project2;

import LuminousVector.Utils.Console;

import java.io.IOException;
import java.util.Scanner;

public class MorseDecoderApp
{
	public static void main(String[] args)
	{
		try
		{
			Scanner in = new Scanner(System.in);
			//Create the binary tree from a file containing all the more code definitions
			Console.log("Loading Morse Dictionary...");
			MorseTree morseTree = new MorseTree("src\\com\\LuminousVector\\CSCI260\\Projects\\Project2\\morseDictionary.txt");
			Console.log("Done!");
			//Display tutorial
			Console.log("Dot: .");
			Console.log("Dash: -");
			Console.log("Space: _");
			Console.log("Enter the morse code you wish to translate:");
			//Read user input
			String code = in.nextLine();
			Console.log("Decoding...");
			//Decode String
			Console.log(MorseDecoder.Decode(morseTree, code));
		} catch (InvalidMorseFormat e)
		{
			//Provide error feedback to user input
			Console.log("Format of the provided morse code is invalid:");
			Console.log(e.getMessage());
		}catch (IOException e)
		{
			//Failed to load file
			Console.log("Something went wrong while loading the morse dictionary");
		}
	}
}
