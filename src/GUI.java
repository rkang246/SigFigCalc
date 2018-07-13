import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.MatteBorder;

/**
 * The GUI for the sig-fig calculator.
 * 
 * @author Robert Kang rkang246@gmail.com
 * @version 1.0 2018-08-13
 * 
 * @TODO:
 * 	Implement (-) negation sign
 * 	Implement operation based off the answer, supported by all 8 operations
 * 	Continuous Input, can continue w/o clicking equal sign
 * 	Error Messages (ex: overflow, divide by zero)
 *  Bug Fix
 * 
 */
public class GUI extends SigFigCalc {

	/**
	 * Variables
	 */
	private JFrame frmSignificantFigureCalculator;
	private JTextField textField;
	private JTextField operationField;
	private JTextField specialField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmSignificantFigureCalculator.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmSignificantFigureCalculator = new JFrame();
		frmSignificantFigureCalculator.getContentPane().setFont(new Font("Segoe UI", Font.PLAIN, 16));
		frmSignificantFigureCalculator.setTitle("Significant Figure Calculator");
		frmSignificantFigureCalculator.setBackground(Color.LIGHT_GRAY);
		frmSignificantFigureCalculator.getContentPane().setBackground(Color.DARK_GRAY);
		frmSignificantFigureCalculator.getContentPane().setLayout(null);
		
		/**
		 * Creates the small special field in the top left of the main display
		 */
		specialField = new JTextField();
		specialField.setEditable(false);
		specialField.setHorizontalAlignment(SwingConstants.LEFT);
		specialField.setForeground(Color.WHITE);
		specialField.setFont(new Font("Segoe UI", Font.PLAIN, 16));
		specialField.setColumns(10);
		specialField.setBorder(new MatteBorder(2, 0, 0, 0, (Color) Color.RED));
		specialField.setBackground(Color.GRAY);
		specialField.setBounds(12, 114, 25, 22);
		frmSignificantFigureCalculator.getContentPane().add(specialField);
		
		/**
		 * Creates the main display text field.
		 */
		textField = new JTextField();
		textField.setEditable(false);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setText("0");
		textField.setForeground(Color.WHITE);
		textField.setBackground(Color.GRAY);
		textField.setBorder(BorderFactory.createMatteBorder(4, 0, 0, 0, Color.RED));
		textField.setFont(new Font("Segoe UI", Font.PLAIN, 60));
		textField.setBounds(12, 13, 528, 101);
		frmSignificantFigureCalculator.getContentPane().add(textField);
		textField.setColumns(10);
		
		/**
		 * Creates the secondary display screen underneath.
		 */
		operationField = new JTextField();
		operationField.setEditable(false);
		operationField.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		operationField.setHorizontalAlignment(SwingConstants.RIGHT);
		operationField.setBorder(new MatteBorder(2, 0, 0, 0, (Color) Color.RED));
		operationField.setForeground(Color.WHITE);
		operationField.setBackground(Color.GRAY);
		operationField.setBounds(358, 114, 182, 22);
		frmSignificantFigureCalculator.getContentPane().add(operationField);
		operationField.setColumns(10);
		frmSignificantFigureCalculator.setBounds(100, 100, 570, 542);
		frmSignificantFigureCalculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/***************************************************************
		 * Defines the buttons.
		 * Code is a bit messy since Eclipse WindowBuilder malfunctioned.
		 */
		
		/**
		 * Typeable values, includes numbers and the decimal point
		 */
		JButton button_0 = new JButton("0");
		button_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				typeIn(button_0.getText());
			}
		});
		button_0.setBackground(Color.GRAY);
		button_0.setContentAreaFilled(false);
		button_0.setOpaque(true);
		button_0.setForeground(Color.WHITE);
		button_0.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		button_0.setBounds(164, 427, 182, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_0);
		
		JButton button_1 = new JButton("1");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				typeIn(button_1.getText());
			}
		});
		button_1.setBackground(Color.GRAY);
		button_1.setContentAreaFilled(false);
		button_1.setOpaque(true);
		button_1.setForeground(Color.WHITE);
		button_1.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		button_1.setBounds(164, 357, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("2");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				typeIn(button_2.getText());
			}
		});
		button_2.setBackground(Color.GRAY);
		button_2.setContentAreaFilled(false);
		button_2.setOpaque(true);
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		button_2.setBounds(261, 357, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("3");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				typeIn(button_3.getText());
			}
		});
		button_3.setBackground(Color.GRAY);
		button_3.setContentAreaFilled(false);
		button_3.setOpaque(true);
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		button_3.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		button_3.setBounds(358, 357, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_3);
		
		JButton button_4 = new JButton("4");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				typeIn(button_4.getText());
			}
		});
		button_4.setBackground(Color.GRAY);
		button_4.setContentAreaFilled(false);
		button_4.setOpaque(true);
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		button_4.setBounds(164, 287, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_4);
		
		JButton button_5 = new JButton("5");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				typeIn(button_5.getText());
			}
		});
		button_5.setBackground(Color.GRAY);
		button_5.setContentAreaFilled(false);
		button_5.setOpaque(true);
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		button_5.setBounds(261, 287, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_5);
		
		JButton button_6 = new JButton("6");
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				typeIn(button_6.getText());
			}
		});
		button_6.setBackground(Color.GRAY);
		button_6.setContentAreaFilled(false);
		button_6.setOpaque(true);
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		button_6.setBounds(358, 287, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_6);
		
		JButton button_7 = new JButton("7");
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				typeIn(button_7.getText());
			}
		});
		button_7.setBackground(Color.GRAY);
		button_7.setContentAreaFilled(false);
		button_7.setOpaque(true);
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		button_7.setBounds(164, 217, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_7);
		
		JButton button_8 = new JButton("8");
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				typeIn(button_8.getText());
			}
		});
		button_8.setBackground(Color.GRAY);
		button_8.setContentAreaFilled(false);
		button_8.setOpaque(true);
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		button_8.setBounds(261, 217, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_8);
		
		JButton button_9 = new JButton("9");
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				typeIn(button_9.getText());
			}
		});
		button_9.setBackground(Color.GRAY);
		button_9.setContentAreaFilled(false);
		button_9.setOpaque(true);
		button_9.setForeground(Color.WHITE);
		button_9.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		button_9.setBounds(358, 217, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_9);
		
		JButton button_decimal = new JButton(".");
		button_decimal.setToolTipText("Decimal Point");
		button_decimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				typeIn(button_decimal.getText());
			}
		});
		button_decimal.setBackground(Color.GRAY);
		button_decimal.setContentAreaFilled(false);
		button_decimal.setOpaque(true);
		button_decimal.setForeground(Color.WHITE);
		button_decimal.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		button_decimal.setBounds(358, 427, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_decimal);
		
		/********************************************
		 * Clear/Deletion Functions
		 */
		JButton button_c = new JButton("C");
		button_c.setToolTipText("Clear");
		button_c.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				textField.setText("0");
				operationField.setText("");
				specialField.setText("");
			}
		});
		button_c.setBackground(Color.GRAY);
		button_c.setContentAreaFilled(false);
		button_c.setOpaque(true);
		button_c.setForeground(Color.WHITE);
		button_c.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		button_c.setBounds(261, 147, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_c);
		
		JButton button_del = new JButton("DEL");
		button_del.setToolTipText("Delete far right value");
		button_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!operationField.getText().contains("sf")&& !operationField.getText().contains("=")) {
					if (textField.getText().length() == 1) {
						textField.setText("0");
					}
					else if (!textField.getText().equals("0")) {
						String entry = textField.getText();
						textField.setText(entry.substring(0, entry.length() - 1));
						specialField.setText("");
					}
				}
			}
		});
		button_del.setBackground(Color.GRAY);
		button_del.setContentAreaFilled(false);
		button_del.setOpaque(true);
		button_del.setForeground(Color.WHITE);
		button_del.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		button_del.setBounds(358, 147, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_del);
		
		JButton button_ce = new JButton("CE");
		button_ce.setToolTipText("Clear Entry");
		button_ce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!operationField.getText().contains("sf") && !operationField.getText().contains("=")) {
					textField.setText("0");
					specialField.setText("");
				}
			}
		});
		button_ce.setBackground(Color.GRAY);
		button_ce.setContentAreaFilled(false);
		button_ce.setOpaque(true);
		button_ce.setForeground(Color.WHITE);
		button_ce.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		button_ce.setBounds(164, 147, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_ce);
		
		/*****************************************
		 * Operations
		 */
		JButton button_subtract = new JButton("-");
		button_subtract.setToolTipText("Subtract");
		button_subtract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prepareOperation(button_subtract.getText());
			}
		});
		button_subtract.setBackground(Color.GRAY);
		button_subtract.setContentAreaFilled(false);
		button_subtract.setOpaque(true);
		button_subtract.setForeground(Color.WHITE);
		button_subtract.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		button_subtract.setBounds(455, 287, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_subtract);
		
		JButton button_add = new JButton("+");
		button_add.setToolTipText("Add");
		button_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prepareOperation(button_add.getText());
			}
		});
		button_add.setBackground(Color.GRAY);
		button_add.setContentAreaFilled(false);
		button_add.setOpaque(true);
		button_add.setForeground(Color.WHITE);
		button_add.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		button_add.setBounds(455, 357, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_add);
		
		
		JButton button_multiply = new JButton("x");
		button_multiply.setToolTipText("Multiply");
		button_multiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prepareOperation(button_multiply.getText());
			}
		});
		button_multiply.setBackground(Color.GRAY);
		button_multiply.setContentAreaFilled(false);
		button_multiply.setOpaque(true);
		button_multiply.setForeground(Color.WHITE);
		button_multiply.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		button_multiply.setBounds(455, 217, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_multiply);
		
		JButton button_divide = new JButton("/");
		button_divide.setToolTipText("Divide");
		button_divide.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prepareOperation(button_divide.getText());
			}
		});
		button_divide.setBackground(Color.GRAY);
		button_divide.setContentAreaFilled(false);
		button_divide.setOpaque(true);
		button_divide.setForeground(Color.WHITE);
		button_divide.setFont(new Font("Segoe UI", Font.PLAIN, 30));
		button_divide.setBounds(455, 147, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_divide);
		
		JButton btnX = new JButton("x^");
		btnX.setToolTipText("Exponent");
		btnX.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				prepareOperation("^");
			}
		});
		btnX.setForeground(Color.WHITE);
		btnX.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnX.setContentAreaFilled(false);
		btnX.setOpaque(true);
		btnX.setBackground(Color.GRAY);
		btnX.setBounds(12, 287, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(btnX);
		
		/**************************************************
		 * Special Special Operations ;)
		 * The instant change operations
		 */
		JButton btnx = new JButton("1/x");
		btnx.setToolTipText("Inverse");
		btnx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				instantOp("inv");
			}
		});
		btnx.setForeground(Color.WHITE);
		btnx.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		btnx.setContentAreaFilled(false);
		btnx.setOpaque(true);
		btnx.setBackground(Color.GRAY);
		btnx.setBounds(12, 427, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(btnx);
		
		JButton btnSqrt = new JButton("\u221A");
		btnSqrt.setToolTipText("Square Root");
		btnSqrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				instantOp("sqrt");
			}
		});
		btnSqrt.setForeground(Color.WHITE);
		btnSqrt.setFont(new Font("Segoe UI", Font.ITALIC, 20));
		btnSqrt.setContentAreaFilled(false);
		btnSqrt.setOpaque(true);
		btnSqrt.setBackground(Color.GRAY);
		btnSqrt.setBounds(12, 357, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(btnSqrt);
		
		
		/**
		 * Count Sig Figs
		 */
		JButton btnCountSf = new JButton("s.f.");
		btnCountSf.setToolTipText("Count Sig Figs");
		btnCountSf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (operationField.getText().equals("")) {
					operationField.setText(countSigFigs(textField.getText()) + " sf");
				}
			}
		});
		btnCountSf.setForeground(Color.WHITE);
		btnCountSf.setFont(new Font("Segoe UI", Font.ITALIC, 20));
		btnCountSf.setContentAreaFilled(false);
		btnCountSf.setOpaque(true);
		btnCountSf.setBackground(Color.GRAY);
		btnCountSf.setBounds(12, 147, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(btnCountSf);
		
		/**********************************
		 * Equals.
		 */
		JButton button_equal = new JButton("=");
		button_equal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (!operationField.getText().contains("=")) {
					String entry1 = operationField.getText().substring(0,  operationField.getText().length() - 1);
					String entry2 = textField.getText();
					String operation = operationField.getText().substring(operationField.getText().length() - 1);
					operationField.setText(entry1 + operation + entry2 + "=");
					
					if (operation.equals("+")) {
						textField.setText(add(entry1, entry2));
					}
					else if (operation.equals("-")) {
						textField.setText(subtract(entry1, entry2));
					}
					else if (operation.equals("x")) {
						textField.setText(multiply(entry1, entry2));
					}
					else if (operation.equals("/")) {
						textField.setText(divide(entry1, entry2));
					}
					else if (operation.equals("^")) {
						textField.setText(exp(entry1, entry2));
					}
				}
				
			}
		});
		button_equal.setBackground(Color.RED);
		button_equal.setContentAreaFilled(false);
		button_equal.setOpaque(true);
		button_equal.setForeground(Color.WHITE);
		button_equal.setFont(new Font("Segoe UI", Font.PLAIN, 36));
		button_equal.setBounds(455, 427, 85, 57);
		frmSignificantFigureCalculator.getContentPane().add(button_equal);
		
		
	}
	
	/**
	 * Backend for buttons that type a value.
	 * Includes numbers and the decimal point.
	 */
	public void typeIn(String value) {
		if (value.equals("0")) {
			if (!textField.getText().equals("0") && !operationField.getText().contains("sf") && !operationField.getText().contains("=")) {
				String enterNumber = textField.getText() + value;
				textField.setText(enterNumber);
			}
		}
		else {
			if (textField.getText().equals("0") && !value.equals(".") && !operationField.getText().contains("sf") && !operationField.getText().contains("=")) {
				textField.setText(null);
			}
			if (!operationField.getText().contains("sf") && !operationField.getText().contains("=")) {
				if ((value.equals(".") && !textField.getText().contains(".")) || !value.equals(".")) {
					String enterNumber = textField.getText() + value;
					textField.setText(enterNumber);
				}
			}
		}
	}
	
	/**
	 * Sets up operations.
	 * Is used by +, -, /, x, ^
	 */
	public void prepareOperation(String op) {
		if (operationField.getText().equals("")) {
			operationField.setText(textField.getText() + op);
			textField.setText("0");
			specialField.setText("");
		}
	}

	/**
	 * Instant Operations
	 */
	public void instantOp(String op) {
		if (op.equals("inv")) {
			specialField.setText("1/x");
			textField.setText(exp(textField.getText(), "-1"));
		}
		if (op.equals("sqrt")) {
			specialField.setText("\u221A");
			textField.setText(sqrt(textField.getText()));
		}
	}
}
