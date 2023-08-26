import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SGPA_Practice {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int numCourses = 0;
		
		while(true)
		{
			System.out.println("Enter the Number of Courses : ");
			if(sc.hasNextInt())
			{
				numCourses = sc.nextInt();
				
				if(numCourses>=5 && numCourses<=8)
				{
					break;
				}
				else
				{
					System.out.println("Number of courses must be between 5 and 8");
				}
			}
			else
			{
				System.out.println("Enter a valid number!");
				sc.nextLine();
			}
		}
		double totalCredits = 0.0 ;
		double totalGradePoints = 0.0;
		
		Map<Character, Integer> gradePointsMap = new HashMap<>();
		gradePointsMap.put('S', 10);
		gradePointsMap.put('A', 9);
		gradePointsMap.put('B', 8);
		gradePointsMap.put('C', 7);
		gradePointsMap.put('D', 6);
		gradePointsMap.put('E', 4);
		gradePointsMap.put('F', 0);
		
		for(int i=1; i<= numCourses; i++)
		{
			System.out.println("Enter the Grade for Course "+i+": ");
			char grade = sc.next().toUpperCase().charAt(0);
			
			if(!gradePointsMap.containsKey(grade))
			{
				System.out.println("Invalid Grade Entered for Course "+i+":");
				i--;
				continue;
			}
			
			System.out.println("Enter the credits for Course "+i+":");
			if(!sc.hasNextDouble())
			{
				System.out.println("Invalid Input. Please Enter valid number");
				sc.nextLine();
				i--;
				continue;
			}
			
			double credits = sc.nextDouble();
			
			if(credits <= 0)
			{
				System.out.println("Invalid Credits Entered for course "+i+".");
				i--;
				continue;
			}
			
			totalGradePoints += gradePointsMap.get(grade)*credits;
			totalCredits += credits;
		}
		
		if(totalCredits == 0)
		{
			System.out.println("Credits cannot be zero!!");
			sc.close();
			return ;
		}
		
		double sgpa = totalGradePoints/totalCredits;
		
		System.out.println("SGPA : "+sgpa);

		sc.close();
	}
}
