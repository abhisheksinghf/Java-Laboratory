import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Calci {

    private JFrame frame;
    private JTextField field1;
    private JTextField field2;
    private JLabel label1;
    private JLabel label2;
    private JLabel resultLabel;

    private void createAndShowGUI() {
        frame = new JFrame("Calculator");
        frame.setSize(500, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        label1 = new JLabel("Operand 1:");
        label2 = new JLabel("Operand 2:");
        field1 = new JTextField();
        field2 = new JTextField();

        inputPanel.add(label1);
        inputPanel.add(field1);
        inputPanel.add(label2);
        inputPanel.add(field2);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(2, 2));

        JButton addButton = new JButton("ADD");
        JButton subButton = new JButton("SUBTRACT");
        JButton mulButton = new JButton("MULTIPLY");
        JButton divButton = new JButton("DIVIDE");

        buttonPanel.add(addButton);
        buttonPanel.add(subButton);
        buttonPanel.add(mulButton);
        buttonPanel.add(divButton);

        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout());

        resultLabel = new JLabel("Result: ");
        resultPanel.add(resultLabel);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(resultPanel, BorderLayout.SOUTH);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	try{
                addOperation();
                }
            	catch(Exception e1)
            	{
        		JOptionPane.showMessageDialog(frame, "Invalid Input");

            	}
            }
        });

        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                	subOperation();
                	    }
                	catch(Exception e1)
                	{
            		JOptionPane.showMessageDialog(frame, "Invalid Input");

                	}
            }
        });

        mulButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                	mulOperation();
                	    }
                	catch(Exception e1)
                	{
            		JOptionPane.showMessageDialog(frame, "Invalid Input");

                	}
            }
        });

        divButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                	divOperation();
                	    }
                	catch(Exception e1)
                	{
            		JOptionPane.showMessageDialog(frame, "Invalid Input");

                	}
            }
        });

        frame.setVisible(true);
    }

	private void addOperation() {
		String num1 = field1.getText();
		String num2 = field2.getText();
		int op1 = Integer.parseInt(num1);
		int op2 = Integer.parseInt(num2);
		int result = op1 + op2;
		resultLabel.setText("Result: " + result);
	}

	private void subOperation() {
		String num1 = field1.getText();
		String num2 = field2.getText();
		int op1 = Integer.parseInt(num1);
		int op2 = Integer.parseInt(num2);
		int result = op1 - op2;
		resultLabel.setText("Result: " + result);
	}

	private void mulOperation() {
		String num1 = field1.getText();
		String num2 = field2.getText();
		int op1 = Integer.parseInt(num1);
		int op2 = Integer.parseInt(num2);
		int result = op1 * op2;
		resultLabel.setText("Result: " + result);
	}

	private void divOperation() {
		try
		{
		String num1 = field1.getText();
		String num2 = field2.getText();
		int op1 = Integer.parseInt(num1);
		int op2 = Integer.parseInt(num2);
		int result = op1 / op2;
		resultLabel.setText("Result: " + result);
		
		}
		catch(ArithmeticException e)
		{
			JOptionPane.showMessageDialog(frame, "Cannot Divide By Zero");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Calci calc = new Calci();
				calc.createAndShowGUI();
			}
		});
	}
}
