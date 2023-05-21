import java.util.Scanner;

class Student 
{
	String name,usn ;
	int IA1,IA2,IA3 ;
}

public class SDMCET {
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);	
		Student s[] = new Student[3];
		for(int i=0;i<3;i++)
		{
			s[i] = new Student();
			System.out.println("Enter the students Name : ");
			s[i].name = sc.next();
			System.out.println("Enter the students USN : ");
			s[i].usn = sc.next();
			System.out.println("Enter IA1 Marks : ");
			s[i].IA1 = sc.nextInt();
		}
		System.out.println("Enter the SL no of whose details you want : ");
		int key = sc.nextInt();
		System.out.println("Details of Student SL no "+key+" is ");
		System.out.println("Name : "+s[key].name);
		System.out.println("USN : "+s[key].usn);
		System.out.println("Marks : "+s[key].IA1);
	}
}
