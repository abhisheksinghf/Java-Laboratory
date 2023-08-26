import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ConstantsVowelsSeperator{
	public static void main(String[] args) {
		createFile();
		parseFile();
	}
	public static void createFile()
	{
		try
		{
			FileWriter contentFile = new FileWriter("alphabets.txt");
			contentFile.write("In the heart of the mystical forest, sunlight dappled through the leaves, creating a mosaic of dancing shadows on the ground. Birds chirped their melodious tunes, and a gentle breeze whispered secrets to the trees. The air was filled with the earthy scent of moss and the faint perfume of wildflowers. A babbling brook wound its way through the landscape, its crystal-clear waters reflecting the azure sky above. As I walked along the meandering path, I felt a sense of tranquility enveloping me, a connection to nature that soothed my weary soul.");
			BufferedWriter writer = new BufferedWriter(contentFile);
			
			System.out.println("alphabets.txt, File Created and Written Successfully!!");
			writer.close();
		}
		catch(IOException e)
		{
			System.out.println("Failed to create file!");
		}
	}
	public static void parseFile()
	{
		try
		{
			FileReader reader = new FileReader("alphabets.txt");
			FileWriter vowelsWriter = new FileWriter("vowels.txt");
			FileWriter constantsWriter = new FileWriter("constants.txt");
			
			int character;
			
			while((character = reader.read()) != -1)
			{
				if(Character.isDigit(character))
				{
					throw new NumberFormatException("Numbers Not Allowed");
				}
				
				else if("aeiou".contains(Character.toString((char)character)))
				{
					vowelsWriter.write(character);
				}
				
				else
				{
					constantsWriter.write(character);
				}
			}
			vowelsWriter.close();
			constantsWriter.close();
			reader.close();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(NumberFormatException e)
		{
			e.printStackTrace();
		}
	}
}
