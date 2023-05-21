import java.util.Scanner;

class Student 
{
	String name,usn ;
	int IA1,IA2,IA3 ;
}
public class SDMCET {
	public static void main(String args[])
	{
		Student s1 = new Student();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the students name : ");
		s1.name = sc.nextLine();
		System.out.println("Enter the students USN : ");
		s1.usn = sc.nextLine();
		System.out.println("Enter IA1 Marks : ");
		s1.IA1 = sc.nextInt();
		sc.close();
		System.out.println(s1.name+"  "+ s1.usn+"  "+s1.IA1);
	}
}
