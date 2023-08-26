import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetOperations extends JFrame {

    private JTextArea resultArea;
    private JComboBox<String> operationComboBox;
    private JTextField set1Field;
    private JTextField set2Field;
    private JButton performButton;

    public SetOperations() {
        setTitle("Set Operations");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        resultArea = new JTextArea();
        resultArea.setEditable(false);

        String[] operations = {"Powerset", "Union", "Intersection", "Difference"};
        operationComboBox = new JComboBox<>(operations);

        JLabel set1Label = new JLabel("Set 1 (space-separated):");
        set1Field = new JTextField();

        JLabel set2Label = new JLabel("Set 2 (space-separated):");
        set2Field = new JTextField();

        performButton = new JButton("Perform Operation");
        performButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performSetOperation();
            }
        });

        JPanel inputPanel = new JPanel(new GridLayout(5, 1));
        inputPanel.add(set1Label);
        inputPanel.add(set1Field);
        inputPanel.add(set2Label);
        inputPanel.add(set2Field);

        JPanel controlPanel = new JPanel(new GridLayout(3, 1));
        controlPanel.add(operationComboBox);
        controlPanel.add(performButton);

        add(inputPanel, BorderLayout.NORTH);
        add(new JScrollPane(resultArea), BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    private void performSetOperation() {
        String set1Text = set1Field.getText();
        String set2Text = set2Field.getText();

        String[] set1Elements = set1Text.split(" ");
        String[] set2Elements = set2Text.split(" ");

        Set<String> set1 = new HashSet<>(Arrays.asList(set1Elements));
        Set<String> set2 = new HashSet<>(Arrays.asList(set2Elements));

        String operation = (String) operationComboBox.getSelectedItem();

        switch (operation) {
            case "Powerset":
                performPowerset(set1);
                break;
            case "Union":
                performUnion(set1, set2);
                break;
            case "Intersection":
                performIntersection(set1, set2);
                break;
            case "Difference":
                performDifference(set1, set2);
                break;
            default:
                System.out.println("Invalid operation!");
                break;
        }
    }


    private void performPowerset(Set<String> set1) {
        Set<Set<String>> powerset = new HashSet<>();
        powerset.add(new HashSet<>()); // Add the empty set

        for (String element : set1) {
            Set<Set<String>> newSubsets = new HashSet<>();
            for (Set<String> subset : powerset) {
                Set<String> newSubset = new HashSet<>(subset);
                newSubset.add(element);
                newSubsets.add(newSubset);
            }
            powerset.addAll(newSubsets);
        }

        StringBuilder result = new StringBuilder("Powerset of the set:\n");
        for (Set<String> subset : powerset) {
            result.append(subset.toString()).append("\n");
        }
        resultArea.setText(result.toString());
    }
    
    private void performUnion(Set<String> set1, Set<String> set2) {
        Set<String> unionSet = new HashSet<>(set1);
        unionSet.addAll(set2);

        resultArea.setText("Union of the sets: " + unionSet);
    }

    private void performIntersection(Set<String> set1, Set<String> set2) {
        Set<String> intersectionSet = new HashSet<>(set1);
        intersectionSet.retainAll(set2);

        resultArea.setText("Intersection of the sets: " + intersectionSet);
    }

    private void performDifference(Set<String> set1, Set<String> set2) {
        Set<String> differenceSet = new HashSet<>(set1);
        differenceSet.removeAll(set2);

        resultArea.setText("Difference of the sets (Set1 - Set2): " + differenceSet);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                SetOperations gui = new SetOperations();
                gui.setVisible(true);
            }
        });
    }
}
