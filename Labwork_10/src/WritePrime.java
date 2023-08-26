import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class WritePrime{
	public static void main(String[] args)
	{
		String file = "test_prime.txt";
		int primeCount = 0;
		FileWriter writer;
		try {
			writer = new FileWriter(file);
			BufferedWriter bufferedwriter = new BufferedWriter(writer);
			
			for(int i=0;i<10000;i++)
			{
				int number = generateRandom();
				boolean checkPrime = isPrime(number);
				
				bufferedwriter.write(number+" "+checkPrime);
				bufferedwriter.newLine();
				if(checkPrime)
				{
					primeCount++;
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("File Generation Completed\nTotal Number of Prime Numbers are : "+primeCount);
	}
	
	public static int generateRandom()
	{
		return new Random().nextInt(10000);
	}
	public static boolean isPrime(int number)
	{
		if(number <= 1)
		{
			return false;
		}
		else{

			for(int i = 2; i < number/2; i++)
			{
				if(number%i == 0)
				{
					return false;
				}
			}
		}
		return true;
	}
}