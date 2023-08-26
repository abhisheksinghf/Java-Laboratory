import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.UUID;

public class Sort_Practice {
	static int size = 100000;
	public static void main(String[] args)
	
	{
		long start, end, totalTime;
		Random r = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("Select the DataType : ");
		System.out.println("1.Integer\n2.Float\n3.String");
		int choice = sc.nextInt();
		
		switch(choice)
		{
		case 1:
			int[] randomInt = new int[size];
			
			for(int i=0; i < randomInt.length; i++)
			{
				randomInt[i] = r.nextInt(size);
			}
			start = System.currentTimeMillis();
			Arrays.sort(randomInt);
			end = System.currentTimeMillis();
			
			totalTime = end - start;
			
			System.out.println("Total Time Taken is "+totalTime);
			break;
		case 2:
			float[] randomFloat = new float[size];
			
			for(int i=0; i < randomFloat.length; i++)
			{
				randomFloat[i] = r.nextFloat();
			}
			start = System.currentTimeMillis();
			Arrays.sort(randomFloat);
			end = System.currentTimeMillis();
	
			totalTime = end - start;
			
			System.out.println("Total Time Taken is "+totalTime);
			break;
			
		case 3:
			String[] randomString = new String[size];
			
			for(int i=0;i<randomString.length;i++)
			{
				randomString[i] = UUID.randomUUID().toString();
			}
			start = System.currentTimeMillis();
			Arrays.sort(randomString);
			end = System.currentTimeMillis();
	
			totalTime = end - start;
			
			System.out.println("Total Time Taken is "+totalTime);
			break;
			
			
		}
	}
}
