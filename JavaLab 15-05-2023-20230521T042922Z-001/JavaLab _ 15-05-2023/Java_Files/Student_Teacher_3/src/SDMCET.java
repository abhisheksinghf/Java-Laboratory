import java.util.Scanner;

class Student
{
	String name,usn;
	int IA1,IA2,IA3;
}

class Teacher
{
	String name,designation;
	
	void EnterMarks(Student who)
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the student name : ");
		who.name = sc.next();
		System.out.println("Enter the USN : ");
		who.usn = sc.next();
		System.out.println("Enter IA1 : ");
		who.IA1 = sc.nextInt();
	}
}
public class SDMCET {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Teacher T = new Teacher();
		T.name = "Jhon";
		T.designation = "AP";
		Student s[] = new Student[3];
		for (int i=0;i<3;i++)
		{
			s[i] = new Student();
			T.EnterMarks(s[i]);
		}
		System.out.println("Enter the USN whose details u want : ");
		String key = sc.next();
		for(int i=0;i<3;i++)
		{
			if(s[i].usn.equals(key))
			{
				System.out.println("Details of Student USN "+key+" is ");
				System.out.println("Name : "+s[i].name);
				System.out.println("USN : "+s[i].usn);
				System.out.println("Marks : "+s[i].IA1);
			}
		}
		sc.close();
	}
}
