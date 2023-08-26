import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AlphaReader {
	public static void main(String[] args)
	{
		createFile();
		parseFile();
	}
	public static void createFile()
	{
		FileWriter writer;
		try {
			writer = new FileWriter("alphabets1.txt");
			writer.write("abcdefghijklmnopqrstuvwxyz");
			writer.close();
			System.out.println("File Has Been Created Successfully!!");
		} catch (IOException e) {
			System.out.println("ERROR!! While Creating File :( ");
			e.printStackTrace();
		}
	}
	public static void parseFile()
	{
		try {
			FileReader reader = new FileReader("alphabets1.txt");
			FileWriter writer1 = new FileWriter("constants1.txt");
			FileWriter writer2 = new FileWriter("vowels1.txt");
			
			int character;
			while((character = reader.read())!=-1)
			{
				if(Character.isDigit(character))
				{
					throw new NumberFormatException("Numbers Not allowed in File!");
				}
				else if("aeiou".contains(Character.toString((char)character)))
				{
					writer2.write(character);
				}
				else
				{
					writer1.write(character);
				}
			}
			writer1.close();
			writer2.close();
			reader.close();
			System.out.println("Parsed Successfully!");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
