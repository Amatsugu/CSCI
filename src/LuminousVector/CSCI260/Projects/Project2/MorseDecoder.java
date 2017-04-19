package LuminousVector.CSCI260.Projects.Project2;

public class MorseDecoder
{
	public static String Decode(MorseTree morseTree, String code)
	{
		String output = ""; //output string
		char[] cA = code.toCharArray();
		code = code.replaceAll("•", "."); //Convert dots(•) to periods (.) for consistency
		String[] codeWords = code.split(" "); //Split the incoming code at the spaces into separate coded words
		for(String cw : codeWords)
		{
			if(cw == null || cw.length() == 0) //Check for and ignore empty and null words
				continue;
			String[] chars = cw.split("_"); //Split the coded words into coded letters
			for (String c : chars)
			{
				if(c == null || c.length() == 0) //Check for and ignore empty letters
					continue;
				if(c.contains("#")) //check for the end symbol and remove it from the coded letter
					c = c.substring(0, c.length()-1);
				output += morseTree.getChar(c); //decode the letter and append it to the output string
			}
			output += " "; //Insert spaces between words
		}
		return output;
	}
}
