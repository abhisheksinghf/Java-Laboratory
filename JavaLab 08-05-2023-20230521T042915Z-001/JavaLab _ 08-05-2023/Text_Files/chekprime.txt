import java.util.Iterator;
import java.util.Scanner;

public class CheckPrime {
	public static void main(String args[])
	{
		int num;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number : ");
		num = sc.nextInt();
		boolean isPrime = true;
		
		if(num < 2)
		{
			isPrime = false;
		}
		else
		{
			for(int i=2;i<=num/2;i++)
			{
				if(num%i == 0)
				{
					isPrime = false;
					break;
				}
			}
		}
		if(isPrime)
		{
			System.out.println(num+" is a Prime Number !!");
		}
		else
		{
			System.out.println(num+" is not a Prime Number !!");
		}
		
		sc.close();
	}
}
