import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class SortAndMergePractice
{
	public static void main(String[] args) {
		int n = 1000;
		Random r = new Random();
		int[] numbers = new int[n];
		PrintWriter writer;
		try {
			writer = new PrintWriter("num.txt");

			for(int i=0;i<n;i++)
			{
				numbers[i] = r.nextInt(n);
				writer.println(numbers[i]);
			}
			writer.close();

			SortingRunnable runnable1 = new SortingRunnable(Arrays.copyOfRange(numbers, 0, n/3));
			SortingRunnable runnable2 = new SortingRunnable(Arrays.copyOfRange(numbers, n/3, (2*n)/3));
			SortingRunnable runnable3 = new SortingRunnable(Arrays.copyOfRange(numbers, (2*n)/3, n));

			Thread thread1 = new Thread(runnable1);
			Thread thread2 = new Thread(runnable2);
			Thread thread3 = new Thread(runnable3);

			thread1.start();
			thread2.start();
			thread3.start();

			thread1.join();
			thread2.join();
			thread3.join();

			int[] sortedNumbers = mergeArrays(runnable1.getNumbers(),runnable2.getNumbers(),runnable3.getNumbers());
		
			writer = new PrintWriter("sort.txt");
			
			for(int num : sortedNumbers)
			{
				writer.println(num);
			}
			writer.close();
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		
		
	} 		
	private static int[] mergeArrays(int[]... arrays)
	{
		int[] result = arrays[0];
		for(int i=1;i<arrays.length;i++)
		{
			result = mergeAndSortTwoArrays(result,arrays[i]);
		}
		
		return result;
	}
	private static int[] mergeAndSortTwoArrays(int[] array1,int[] array2)
	{
		int[] merged = new int[array1.length+array2.length];
		
		for(int i=0;i<array1.length;i++)
		{
			merged[i] = array1[i];
		}
		
		for(int i=0;i<array2.length;i++)
		{
			merged[i + array1.length] = array2[i];
		}
		
		Arrays.sort(merged);
		
		return merged;
	}
	private static class SortingRunnable implements Runnable {
		private int[] numbers;

		public SortingRunnable(int[] numbers)
		{
			this.numbers = numbers;
		}

		public void run()
		{
			Arrays.sort(numbers);
		}

		public int[] getNumbers()
		{
			return numbers;
		}
	}

}