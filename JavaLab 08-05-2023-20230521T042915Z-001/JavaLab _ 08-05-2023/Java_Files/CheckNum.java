import java.util.Scanner;

public class CheckNum {

	public static void main(String args[])
	{
		int n1,n2,sum;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number 1 : ");
		n1 = sc.nextInt();
		System.out.println("Enter number 2 : ");
		n2 = sc.nextInt();
		
		sum = n1 + n2;
		
		System.out.println("The Sum is  "+sum);
		
		if(sum > 0)
		{
			System.out.println("The Sum is Postive!");
		}
		else if(sum < 0)
		{
			System.out.println("The Sum is Negative!");
		}
		else
		{
			System.out.println("The Sum is Zero!");
		}
		
		sc.close();
	}
}
