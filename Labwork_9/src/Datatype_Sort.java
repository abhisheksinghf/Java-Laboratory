import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Datatype_Sort {

    private JFrame frame;
    private JComboBox<String> dataTypeComboBox;
    private JButton sortButton;
    private JTextArea outputArea;

    private static final int DATA_SIZE = 100000;

    public Datatype_Sort() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        frame = new JFrame("Sorting GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 400);

        JPanel topPanel = new JPanel();
        topPanel.setLayout(new FlowLayout());

        dataTypeComboBox = new JComboBox<>();
        dataTypeComboBox.addItem("Integer");
        dataTypeComboBox.addItem("Floating-Point");
        dataTypeComboBox.addItem("String");

        sortButton = new JButton("Sort");
        sortButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                sortData();
            }
        });

        topPanel.add(dataTypeComboBox);
        topPanel.add(sortButton);

        outputArea = new JTextArea(20, 40);
        outputArea.setEditable(false);

        frame.setLayout(new BorderLayout());
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(outputArea), BorderLayout.CENTER);

        frame.setVisible(true);
    }

    private void sortData() {
        String selectedDataType = (String) dataTypeComboBox.getSelectedItem();
        long startTime, endTime;

        if (selectedDataType.equals("Integer")) {
            Integer[] data = generateRandomIntegers(DATA_SIZE);
            startTime = System.currentTimeMillis();
            Arrays.sort(data);
            endTime = System.currentTimeMillis();
            outputResult("Integer", endTime - startTime);
        } else if (selectedDataType.equals("Floating-Point")) {
            Double[] data = generateRandomDoubles(DATA_SIZE);
            startTime = System.currentTimeMillis();
            Arrays.sort(data);
            endTime = System.currentTimeMillis();
            outputResult("Floating-Point", endTime - startTime);
        } else if (selectedDataType.equals("String")) {
            String[] data = generateRandomStrings(DATA_SIZE);
            startTime = System.currentTimeMillis();
            Arrays.sort(data);
            endTime = System.currentTimeMillis();
            outputResult("String", endTime - startTime);
        }
    }

    private Integer[] generateRandomIntegers(int size) {
        Integer[] data = new Integer[size];
        for (int i = 0; i < size; i++) {
            data[i] = ThreadLocalRandom.current().nextInt(0, 1000000);
        }
        return data;
    }

    private Double[] generateRandomDoubles(int size) {
        Double[] data = new Double[size];
        for (int i = 0; i < size; i++) {
            data[i] = ThreadLocalRandom.current().nextDouble(0.0, 1000000.0);
        }
        return data;
    }

    private String[] generateRandomStrings(int size) {
        String[] data = new String[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            byte[] bytes = new byte[random.nextInt(10) + 1];
            random.nextBytes(bytes);
            data[i] = new String(bytes);
        }
        return data;
    }

    private void outputResult(String dataType, long timeTaken) {
        outputArea.append("Data type: " + dataType + "\n");
        outputArea.append("Time taken to sort: " + timeTaken + " milliseconds\n\n");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Datatype_Sort();
            }
        });
    }
}
