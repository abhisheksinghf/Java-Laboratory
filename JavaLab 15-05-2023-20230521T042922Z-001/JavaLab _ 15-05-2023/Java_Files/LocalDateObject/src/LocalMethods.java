//import java.time.LocalDate;
//import java.util.Scanner;
//
//public class LocalMethods {
//	public static void main(String[] args)
//	{
//		Scanner sc = new Scanner(System.in);
//		System.out.println("Enter the Year : ");
//		String y = sc.next();
//		LocalDate d = LocalDate.parse(y);
//		
//		System.out.println(d.isLeapYear());
//		
//		
//	}
//}

// Program to illustrate the isLeapYear() method

import java.util.*;
import java.time.*;

public class LocalMethods {
	public static void main(String[] args)
	{
		// Parses the first date
		LocalDate dt1 = LocalDate.parse("2012-11-27");

		// Checks
		System.out.println(dt1.isLeapYear());
	}
}
