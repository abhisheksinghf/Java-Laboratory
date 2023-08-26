import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Grade_Calculator_GUI extends JFrame {
	private JTextField ia1field, ia2field, ia3field, ctafield, seefield;
	private JButton submitButton;
	private JLabel ia1label, ia2label, ia3label, ctalabel, seelabel;

	public Grade_Calculator_GUI() {
		JPanel panel = new JPanel();
		JPanel buttonpanel = new JPanel();

		ia1label = new JLabel("IA-1 : ");
		ia2label = new JLabel("IA-2 : ");
		ia3label = new JLabel("IA-3 : ");
		ctalabel = new JLabel("CTA : ");
		seelabel = new JLabel("SEE : ");

		ia1field = new JTextField();
		ia1field.setPreferredSize(new Dimension(100, 25));
		ia2field = new JTextField();
		ia2field.setPreferredSize(new Dimension(100, 25));
		ia3field = new JTextField();
		ia3field.setPreferredSize(new Dimension(100, 25));
		ctafield = new JTextField();
		ctafield.setPreferredSize(new Dimension(100, 25));
		seefield = new JTextField();
		seefield.setPreferredSize(new Dimension(100, 25));
		submitButton = new JButton("Calculate");

		panel.setLayout(new GridLayout(5, 2, 10, 10));
		panel.add(ia1label);
		panel.add(ia1field);
		panel.add(ia2label);
		panel.add(ia2field);
		panel.add(ia3label);
		panel.add(ia3field);
		panel.add(ctalabel);
		panel.add(ctafield);
		panel.add(seelabel);
		panel.add(seefield);
		panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Top, Left, Bottom, Right

		submitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calculateGrade();
			}
		});

		buttonpanel.add(submitButton, BorderLayout.CENTER);
		add(panel);
		add(buttonpanel, BorderLayout.SOUTH);
		setSize(300, 200);
		setTitle("Grade Calculator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	public void calculateGrade() {
		try {
			int ia1Marks, ia2Marks, ia3Marks, ctaMarks, seeMarks, cieMarks;

			ia1Marks = Integer.parseInt(ia1field.getText());
			ia2Marks = Integer.parseInt(ia2field.getText());
			ia3Marks = Integer.parseInt(ia3field.getText());
			ctaMarks = Integer.parseInt(ctafield.getText());
			seeMarks = Integer.parseInt(seefield.getText());

			if (ia1Marks > 20 || ia2Marks > 20 || ia3Marks > 20 || ctaMarks > 10 || seeMarks > 100) {
                JOptionPane.showMessageDialog(null, "Input marks exceed maximum values: IA (20), CTA (10), SEE (100)");
                return;
            }
			
			int sumOfBestTwo = bestOfTwoIA(ia1Marks,ia2Marks,ia3Marks);

			cieMarks = (sumOfBestTwo + ctaMarks) + ((seeMarks)/ 2);

			if (cieMarks < 20) {
				JOptionPane.showMessageDialog(null, "Student Detained");
				return;
			}

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

			JOptionPane.showMessageDialog(null, "Grade : " + grade);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Invalid Format!!");
		}
	}

	public static int bestOfTwoIA(int ia1Marks, int ia2Marks, int ia3Marks) {
	    int minMark = Math.min(ia1Marks, Math.min(ia2Marks, ia3Marks));
	    int bestTwoSum = ia1Marks + ia2Marks + ia3Marks - minMark;
	    return bestTwoSum;
	}
	
	public static void main(String[] args) {
		new Grade_Calculator_GUI();
	}
}
