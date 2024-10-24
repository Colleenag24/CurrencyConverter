import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUIConversions {

	private JFrame frame;
	private JTextField textStarting;
	private JTextField textConversion;
	private JTextField textConvertedAmt;
	private JTextField textCurrencyNum;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIConversions window = new GUIConversions();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIConversions() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(132, 132, 255)); //Background and layout
		frame.setBounds(100, 100, 597, 433);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblConversions = new JLabel("Currency Conversions"); //Title of GUI and formatting
		lblConversions.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversions.setFont(new Font("Calibri", Font.BOLD, 22));
		lblConversions.setBounds(0, 11, 581, 27);
		frame.getContentPane().add(lblConversions);
		
		JTextArea areaConversions = new JTextArea(); //Text area to set the options for the currency converter
		areaConversions.setToolTipText("");
		areaConversions.setBackground(new Color(132, 132, 255));
		areaConversions.setFont(new Font("Calibri", Font.BOLD, 18));
		areaConversions.setText("1 - US Dollar\t4 - Yen\r\n2 - Euro\t5 - Australian Dollar\r\n3 - Pound\t6 - Canadian Dollar");
		areaConversions.setRows(6);
		areaConversions.setBounds(168, 35, 284, 74);
		frame.getContentPane().add(areaConversions);
		
		JLabel lblStarting = new JLabel("Enter starting currency number:");//label to instruct the user to enter the starting currency number
		lblStarting.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblStarting.setHorizontalAlignment(SwingConstants.LEFT);
		lblStarting.setBounds(10, 144, 261, 27);
		frame.getContentPane().add(lblStarting);
		
		textStarting = new JTextField();// text field for user to enter starting currency number
		textStarting.setBounds(287, 146, 290, 20);
		frame.getContentPane().add(textStarting);
		textStarting.setColumns(10);
		
		JLabel lblConversion = new JLabel("Enter conversion currency number: "); //label to instruct the user to enter the converting currency number
		lblConversion.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblConversion.setHorizontalAlignment(SwingConstants.LEFT);
		lblConversion.setBounds(10, 249, 267, 27);
		frame.getContentPane().add(lblConversion);
		
		textConversion = new JTextField(); //text field for the user to enter the converting currency number
		textConversion.setBounds(287, 251, 290, 20);
		frame.getContentPane().add(textConversion);
		textConversion.setColumns(10);
		
		textConvertedAmt = new JTextField(); //text field to show the converted currency amt
		textConvertedAmt.setHorizontalAlignment(SwingConstants.CENTER);
		textConvertedAmt.setBackground(new Color(132, 132, 255));
		textConvertedAmt.setBounds(158, 341, 270, 20);
		frame.getContentPane().add(textConvertedAmt);
		textConvertedAmt.setColumns(10);
		
		JLabel lblCurrencyNum; //label to tell the user to input the starting currency amt
		lblCurrencyNum = new JLabel("Enter starting currency amount:");
		lblCurrencyNum.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrencyNum.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCurrencyNum.setBounds(10, 197, 261, 27);
		frame.getContentPane().add(lblCurrencyNum);
		
		textCurrencyNum = new JTextField(); //text field for the user to input the starting currency amt
		textCurrencyNum.setHorizontalAlignment(SwingConstants.CENTER);
		textCurrencyNum.setColumns(10);
		textCurrencyNum.setBounds(287, 199, 290, 20);
		frame.getContentPane().add(textCurrencyNum);
		
		JButton btnConvert = new JButton("Convert");
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String inputAmount = textCurrencyNum.getText();//Gets the text (User Input) from the textCurrencyNum instance variable
			double Amt = Double.parseDouble(inputAmount);//Creates the double Amt to hold the user input from earlier which is held in the textCurrencyNu, Instance variable
			textConvertedAmt.setText(String.valueOf(Amt));//Changes the double Amt into a string (https://www.quora.com/What-is-the-use-of-the-String-ValueOf-function-in-Java)
			}
		});
		btnConvert.setFont(new Font("Calibri", Font.BOLD, 18));
		btnConvert.setBounds(235, 307, 120, 23);
		frame.getContentPane().add(btnConvert);
		

	}
}
