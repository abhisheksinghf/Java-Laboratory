import java.util.Scanner;

public class AddNumUserInp {
	public static void main(String args[])
	{
		int n1,n2,sum;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Number 1 : ");
		n1 = sc.nextInt();
		System.out.println("Enter Number 2 : ");
		n2 = sc.nextInt();
		
		sum = n1 + n2 ;
		
		System.out.println("The Sum of "+n1+" and "+n2+" is "+sum);
		
		sc.close();
	}
}
