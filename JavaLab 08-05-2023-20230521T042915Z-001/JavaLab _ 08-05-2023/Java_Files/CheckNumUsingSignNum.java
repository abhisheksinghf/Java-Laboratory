import java.util.Scanner;

public class CheckNumUsingSignNum {

	public static void main(String args[])
	{
		int n1,n2,sum;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter number 1 : ");
		n1 = sc.nextInt();
		System.out.println("Enter number 2 : ");
		n2 = sc.nextInt();
		
		sum = n1 + n2;
		
		switch(Integer.signum(sum))
		{
		case -1:
			System.out.println("The Sum is Negative !");
			break;
		case 0:
			System.out.println("The Sum is Zero!");
			break;
		case 1:
			System.out.println("The Sum is Positive!");
			break;
			
		}
		sc.close();
	}
}