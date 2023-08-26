import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SetOperationsPractice
{
	public static void main(String[] args) {
		String s1,s2;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Set-1 : ");
		s1 = sc.nextLine();
		System.out.println("Enter Set-2 : ");
		s2 = sc.nextLine();

		String[] set1 = s1.split(" ");
		String[] set2 = s2.split(" ");

		Set<String> set1Elements = new HashSet<>(Arrays.asList(set1));
		Set<String> set2Elements = new HashSet<>(Arrays.asList(set2));

		while(true)
		{
			System.out.println("Select the Operation : \n1.Union\n2.Subset\n3.Difference\n4.Intersection\n5.Powerset\nEnter Choice: ");
			int choice = sc.nextInt();

			switch(choice)
			{
			case 1:
				performUnion(set1Elements,set2Elements);
				break;

			case 2:
				performSubset(set1Elements,set2Elements);
				break;

			case 3:
				performDifference(set1Elements,set2Elements);
				break;

			case 4:
				performIntersection(set1Elements,set2Elements);
				break;

			case 5:
				performPowerset(set1Elements);
				break;

			default:
				System.out.println("Enter a Valid Choice !!!");
			}
		}
	}
	public static void performUnion(Set<String> set1,Set<String> set2)
	{
		Set<String> union = new HashSet<>(set1);
		union.addAll(set2);

		System.out.println(union);
	}
	public static void performDifference(Set<String> set1,Set<String> set2)
	{
		Set<String> diff = new HashSet<>(set1);
		diff.removeAll(set2);

		System.out.println(diff);
	}
	public static void performIntersection(Set<String> set1,Set<String> set2)
	{
		Set<String> intersection = new HashSet<>(set1);
		intersection.retainAll(set2);

		System.out.println(intersection);
	}
	public static void performSubset(Set<String> set1,Set<String> set2)
	{
		Set<String> subset = new HashSet<>(set1);
		boolean isSubset = subset.containsAll(set2);

		System.out.println(isSubset);
	}
	public static void performPowerset(Set<String> set1)
	{
		Set<Set<String>> powerset = new HashSet<>();
		powerset.add(new HashSet<>());
		
		for(String element : set1)
		{
			Set<Set<String>> newsubsets = new HashSet<>();
			for(Set<String> subset : powerset)
			{
				Set<String> newsubset = new HashSet<>(subset);
				newsubset.add(element);
				newsubsets.add(newsubset);
			}
			powerset.addAll(newsubsets);
		}
		
			System.out.println(powerset);
	}
//	public static void performPowerSet(Set<String> set1,Set<String> set2)
//	{
//		Set<String> set1Elements = new HashSet<>(set1);
//		set1Elements.addAll(set2);
//		
//		double e = set1Elements.size();
//		double power = Math.pow(2, e);
//		 
//		Integer[] arr = new Integer[set1Elements.size()];
//		set1Elements.toArray(arr);
//		
//		for(int i=0;i<power-1;i++)
//		{
//			for(int j=0;j<e;j++)
//			{
//				if((i & (1 << j))>0)
//					System.out.println(arr[j]+" ");
//			}
//			System.out.println();
//		}
//		System.out.println("[ ]");
//		System.out.println(set1Elements);
//	}
}