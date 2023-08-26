import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class SortAndMerge {
    public static void main(String[] args) throws IOException, InterruptedException {
        int n = 10000; // Number of random integers
        Random r = new Random();
        int[] numbers = new int[n];

        // Create the file and fill it with random numbers
        PrintWriter writeInFile = new PrintWriter("integers.txt");
        long end,start,time;
        start=System.currentTimeMillis();
        for (int i = 0; i < n; i++) 
        {   
        	 int randomNumber = r.nextInt(n);
        	 writeInFile.println(randomNumber);
             numbers[i] = randomNumber;   
        }
        writeInFile.close();

        // Create three threads and distribute the numbers
        SortingRunnable runnable1 = new SortingRunnable(Arrays.copyOfRange(numbers, 0, n / 3));
        SortingRunnable runnable2 = new SortingRunnable(Arrays.copyOfRange(numbers, n / 3, (2 * n) / 3));
        SortingRunnable runnable3 = new SortingRunnable(Arrays.copyOfRange(numbers, (2 * n) / 3, n));

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);
        Thread thread3 = new Thread(runnable3);

        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        // Merge the sorted arrays
        int[] sortedNumbers = mergeArrays(runnable1.getNumbers(), runnable2.getNumbers(), runnable3.getNumbers());

        // Write the sorted numbers to the output file
        writeInFile = new PrintWriter("sorted_integers.txt");
        
        for (int number : sortedNumbers) 
        {
        	writeInFile.println(number);
        }
        writeInFile.close();
        end=System.currentTimeMillis();
        time=end-start;
        System.out.println("time taken="+time);
    }

    private static class SortingRunnable implements Runnable {
        private int[] numbers;

        public SortingRunnable(int[] numbers) {
            this.numbers = numbers;
        }

        @Override
        public void run() {
            Arrays.sort(numbers);
        }

        public int[] getNumbers() {
            return numbers;
        }
    }

    private static int[] mergeArrays(int[]... arrays) {
        if (arrays.length == 0) {
            return new int[0];  // Or throw an exception, depending on what you want to do in this case
        }

        int[] result = arrays[0];
        for (int i = 1; i < arrays.length; i++) {
            result = mergeAndSortTwoArrays(result, arrays[i]);
        }

        return result;
    }
    
    private static int[] mergeAndSortTwoArrays(int[] array1, int[] array2) {
        int[] merged = new int[array1.length + array2.length];

        for (int i = 0; i < array1.length; i++) {
            merged[i] = array1[i];
        }

        for (int i = 0; i < array2.length; i++) {
            merged[i + array1.length] = array2[i];
        }

        Arrays.sort(merged);
        return merged;
    }
}