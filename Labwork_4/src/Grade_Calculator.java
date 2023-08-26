import java.util.InputMismatchException;
import java.util.Scanner;

public class Grade_Calculator {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int ia1Marks, ia2Marks, ia3Marks, ctaMarks, seeMarks;
		try
		{
		do {
			System.out.print("Enter IA-1 marks (max 20): ");
			ia1Marks = sc.nextInt();
		} while (ia1Marks < 0 || ia1Marks > 20);

		do {
			System.out.print("Enter IA-2 marks (max 20): ");
			ia2Marks = sc.nextInt();
		} while (ia2Marks < 0 || ia2Marks > 20);

		do {
			System.out.print("Enter IA-3 marks (max 20): ");
			ia3Marks = sc.nextInt();
		} while (ia3Marks < 0 || ia3Marks > 20);

		do {
			System.out.print("Enter CTA marks (max 10): ");
			ctaMarks = sc.nextInt();
		} while (ctaMarks < 0 || ctaMarks > 10);

		int sumOfBestTwo = bestOfTwoIA(ia1Marks, ia2Marks, ia3Marks);

		int totalMarks = (sumOfBestTwo+ctaMarks);
		if (totalMarks < 20) {
			System.out.println("Student Detained");
			return;
		} 
		do {
			System.out.print("Enter SEE marks (max 100): ");
			seeMarks = sc.nextInt();
		} while (seeMarks < 0 || seeMarks > 100);


		int cieMarks = (sumOfBestTwo + ctaMarks) + ((seeMarks) / 2);

		String grade;
		if (cieMarks >= 90) {
			grade = "S";
		} else if (cieMarks >= 80) {
			grade = "A";
		} else if (cieMarks >= 70) {
			grade = "B";
		} else if (cieMarks >= 60) {
			grade = "C";
		} else if (cieMarks >= 50) {
			grade = "D";
		} else if (cieMarks >= 40) {
			grade = "E";
		} else {
			grade = "F";
		}
		System.out.println("Grade : " + grade);
		}
		catch(InputMismatchException e)
		{
			
		}
		sc.close();
	}

	public static int bestOfTwoIA(int ia1Marks, int ia2Marks, int ia3Marks) {
		int minMark = Math.min(ia1Marks, Math.min(ia2Marks, ia3Marks));
		int bestTwoSum = ia1Marks + ia2Marks + ia3Marks - minMark;
		return bestTwoSum;
	}
}
