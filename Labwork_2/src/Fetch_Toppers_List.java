import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Fetch_Toppers_List {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Select the exam:");
            System.out.println("1. IA1");
            System.out.println("2. IA2");
            System.out.println("3. IA3");
            System.out.println("4. Best of 2");
            System.out.println("5. CTA");
            System.out.println("6. CIE");
            System.out.println("7. Exit");
            int choice = scanner.nextInt();

            String selectedExam = null;
            switch (choice) {
                case 1:
                    selectedExam = "IA1";
                    break;
                case 2:
                    selectedExam = "IA2";
                    break;
                case 3:
                    selectedExam = "IA3";
                    break;
                case 4:
                    selectedExam = "Best of 2";
                    break;
                case 5:
                    selectedExam = "CTA";
                    break;
                case 6:
                    selectedExam = "CIE";
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice.");
                    continue;
            }

            if (!exit) {
                System.out.println("Enter the number of toppers required:");
                int topperCount = scanner.nextInt();

                viewTopperList(selectedExam, topperCount);
            }
        }
        

        scanner.close();
    }

    private static void viewTopperList(String selectedExam, int topperCount) {
        try {
            FileReader fileReader = new FileReader("Data.csv");
            BufferedReader reader = new BufferedReader(fileReader);
            String line;

            List<Student> students = new ArrayList<>();

            // Read each line from the CSV file
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length >= 11) { // Make sure there are enough columns
                    String marksStr = values[getColumnIndex(selectedExam)].trim();
                    if (!marksStr.isEmpty() && !marksStr.equalsIgnoreCase("AB")) {
                        try {
                            int marks = Integer.parseInt(marksStr);
                            students.add(new Student(values[0], values[1], marks));
                        } catch (NumberFormatException ignored) {
                            // Skip rows with invalid marks
                        }
                    }
                }
            }

            // Sort students based on marks in descending order
            students.sort(Comparator.comparing(Student::getMarks).reversed());

            // Display the topper list in the console
            System.out.println("Top " + topperCount + " in " + selectedExam + ":");
            for (int i = 0; i < Math.min(topperCount, students.size()); i++) {
                System.out.println((i + 1) + ". " + students.get(i));
            }

            reader.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static int getColumnIndex(String selectedExam) {
        switch (selectedExam) {
            case "IA1":
                return 5;
            case "IA2":
                return 6;
            case "IA3":
                return 7;
            case "Best of 2":
                return 8;
            case "CTA":
                return 9;
            case "CIE":
                return 10;
            default:
                throw new IllegalArgumentException("Invalid exam selection.");
        }
    }
}

class Student {
    private String name;
    private String usn;
    private int marks;

    public Student(String name, String usn, int marks) {
        this.name = name;
        this.usn = usn;
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + " (" + usn + ") - " + marks;
    }
}
