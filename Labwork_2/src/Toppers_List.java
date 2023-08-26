//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.Comparator;
//import java.util.List;
//import java.util.Scanner;
//
//public class Toppers_List{
//	public static void main(String[] args) {
//		boolean exit = false;
//		Scanner sc = new Scanner(System.in);
//		int numToppers = 0;
//		while(!exit)
//		{
//			System.out.println("Select the Exam : ");
//			System.out.println("1.IA-1");
//			System.out.println("2.IA-2");
//			System.out.println("3.IA-3");
//			System.out.println("4.Best of 2");
//			System.out.println("5.CTA");
//			System.out.println("6.CIE");
//
//			int choice = sc.nextInt();
//			String selectedExam = null;
//			
//			switch(choice)
//			{
//			case 1:
//				selectedExam = "IA-1";
//				break;
//			case 2:
//				selectedExam = "IA-2";
//				break;
//			case 3:
//				selectedExam = "IA-3";
//				break;
//			case 4:
//				selectedExam = "Best of 2";
//				break;
//			case 5:
//				selectedExam = "CTA";
//				break;
//			case 6:
//				selectedExam = "CIE";
//				break;
//			default:
//				System.out.println("Invalid choice!!");
//			}
//			if(!exit)
//			{
//				System.out.println("Enter the number of toppers required : ");
//				numToppers = sc.nextInt();
//			}
//			viewToppersList(numToppers,selectedExam);
//		}
//	}
//	private static void viewToppersList(int numToppers, String selectedExam) {
//		try {
//			FileReader filereader = new FileReader("Data.csv");
//			BufferedReader reader = new BufferedReader(filereader);
//			
//			String line = null;
//			
//			List<Student> students = new ArrayList<>();
//			while((line = reader.readLine())!=null)
//			{
//				String[] values = line.split(",");
////				int columnIndex = getColumnIndex(selectedExam);
//				if(values.length >= 11)
//				{
//					String marks_obtained = values[getColumnIndex(selectedExam)].trim();
//					
//					if(!marks_obtained.isEmpty() && !marks_obtained.equalsIgnoreCase("AB"))
//					{
//						try
//						{
//							int marks = Integer.parseInt(marks_obtained);
//							
//							students.add(new Student(values[0],values[1],marks));
//						}
//						catch(NumberFormatException ignored)
//						{
//							
//						}
//					}
//				}
//				
//			}
//			
//			students.sort(Comparator.comparing(Student::getMarks).reversed());
//			
//			System.out.println("Top"+ numToppers +"in"+selectedExam+":");
//			for (int i = 0; i < Math.min(numToppers, students.size()); i++) {
//				System.out.println((i+1)+"."+students.get(i));
//			}
//			reader.close();
//		} catch (IOException e) {
//			// TODO: handle exception
//		}
//	}
//	private static int getColumnIndex(String selectedExam)
//	{
//		switch(selectedExam)
//		{
//		case "IA-1":
//			return 5;
//		case "IA-2":
//			return 6;
//		case "IA-3":
//			return 7;
//		case "Best of 2":
//			return 8;
//		case "CTA":
//			return 9;
//		case "CIE":
//			return 10;
//		default:
//			throw new IllegalArgumentException("Invalid Choice");
//		}
//	}
//}
//class Student
//{
//	private String name;
//	private String usn;
//	private int marks;
//	
//	public Student(String name1,String usn1,int marks1)
//	{
//		name = name1;
//		usn = usn1;
//		marks = marks1;
//	}
//	
//	public int getMarks()
//	{
//		return marks;
//	}
//	
//	public String toString()
//	{
//		return name+" ("+usn+") "+marks;
//	}
//}