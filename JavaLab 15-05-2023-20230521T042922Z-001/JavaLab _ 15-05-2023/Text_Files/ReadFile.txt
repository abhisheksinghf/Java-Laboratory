import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFile {
	public static void main(String[] args) throws FileNotFoundException
	{
		File file = new File("input.txt");
		Scanner sc = new Scanner(file);
		
		String name = sc.next();
		int age = sc.nextInt();
		String branch = sc.next();
		String clg = sc.next();
		String nativeplace = sc.next();
		sc.close();
		System.out.println("Name : "+name);
		System.out.println("Age : "+age);
		System.out.println("Branch : "+branch);
		System.out.println("College : "+clg);
		System.out.println("Native City : "+nativeplace);
	}
}
	