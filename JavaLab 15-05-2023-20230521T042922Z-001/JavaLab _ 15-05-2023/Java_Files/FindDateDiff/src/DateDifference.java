import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateDifference {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		
//		Get the first date from user 
		System.out.println("Enter the first date (DD-MM-YYYY) : ");
		String date1String = sc.next();
		LocalDate date1 = LocalDate.parse(date1String, formatter);
		
//		Get the second date from user
		System.out.println("Enter the second date (DD-MM-YYYY) : ");
		String date2String = sc.next();
		LocalDate date2 = LocalDate.parse(date2String, formatter);
		
//		Compute the difference in days between two dates 
		long daysBetween = ChronoUnit.DAYS.between(date1, date2);
		
//		Display the result
		System.out.println("The Number of Days Between "+date1String+ " and "+date2String+" is : "+ daysBetween);
	}
}
