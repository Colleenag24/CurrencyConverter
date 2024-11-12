import java.awt.EventQueue;
import java.io.*;
import java.util.*;

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
	private JTextField textStarting; //Starting Value that the user inputs to select which currency they are starting with
	private JTextField textConversion; //Selection of currency the user would like to convert to
	private JTextField textConvertedAmt; //The converted amount after converting to the user's chosen currency
	private JTextField textCurrencyNum;  //Starting amount that the user would like to convert
	
	
	public static ArrayList<String> conversionHistory= new ArrayList<>(); //ArrayList to hold the conversions and write them to a file
	
	
	private usdConversions currency1= new usdConversions(); //Calling the usdConversions class to work the conversions with the GUI
	private eurConversions currency2= new eurConversions(); //Calling the eurConversions class to work the conversions with the GUI
	private gbpConversions currency3= new gbpConversions(); //Calling the gbpConversions class to work the conversions with the GUI
	private jpyConversions currency4= new jpyConversions(); //Calling the jpyConversions class to work the conversions with the GUI
	private audConversions currency5= new audConversions(); //Calling the audConversions class to work the conversions with the GUI
	private cadConversions currency6= new cadConversions(); //Calling the cadConversions class to work the conversions with the GUI
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIConversions window = new GUIConversions(); //Creating the GUI Window
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @return 
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
		areaConversions.setText("1 - US Dollar\t      4 - Japanese Yen\r\n2 - Euro\t      5 - Australian Dollar\r\n3 - Pound\t      6 - Canadian Dollar");
		areaConversions.setRows(6);
		areaConversions.setBounds(138, 42, 378, 74);
		frame.getContentPane().add(areaConversions);
		
		JLabel lblStarting = new JLabel("Enter the number of your currency:");//label to instruct the user to enter the starting currency number
		lblStarting.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblStarting.setHorizontalAlignment(SwingConstants.LEFT);
		lblStarting.setBounds(10, 144, 308, 27);
		frame.getContentPane().add(lblStarting);
		
		textStarting = new JTextField();// text field for user to enter starting currency number
		textStarting.setHorizontalAlignment(SwingConstants.CENTER);
		textStarting.setBounds(304, 146, 273, 20);
		frame.getContentPane().add(textStarting);
		textStarting.setColumns(10);
		
		JLabel lblConversion = new JLabel("Enter number of currency to convert to:"); //label for the user to enter the number of the currency they want to convert to.
		lblConversion.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblConversion.setHorizontalAlignment(SwingConstants.LEFT);
		lblConversion.setBounds(10, 196, 308, 27);
		frame.getContentPane().add(lblConversion);
		
		textConversion = new JTextField(); //text field for the user to enter the converting currency number
		textConversion.setHorizontalAlignment(SwingConstants.CENTER);
		textConversion.setBounds(318, 199, 255, 20);
		frame.getContentPane().add(textConversion);
		textConversion.setColumns(10);
		
		textConvertedAmt = new JTextField(); //text field to show the converted currency amt
		textConvertedAmt.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textConvertedAmt.setEditable(false);
		textConvertedAmt.setHorizontalAlignment(SwingConstants.CENTER);
		textConvertedAmt.setBackground(new Color(255, 255, 255));
		textConvertedAmt.setBounds(123, 341, 335, 45);
		frame.getContentPane().add(textConvertedAmt);
		textConvertedAmt.setColumns(10);
		
		JLabel lblCurrencyNum; //label to tell the user to input the starting currency amt
		lblCurrencyNum = new JLabel("Enter amount you want converted:");
		lblCurrencyNum.setHorizontalAlignment(SwingConstants.LEFT);
		lblCurrencyNum.setFont(new Font("Calibri", Font.PLAIN, 18));
		lblCurrencyNum.setBounds(10, 249, 284, 27);
		frame.getContentPane().add(lblCurrencyNum);
		
		textCurrencyNum = new JTextField(); //text field for the user to input the starting currency amt
		textCurrencyNum.setHorizontalAlignment(SwingConstants.CENTER);
		textCurrencyNum.setColumns(10);
		textCurrencyNum.setBounds(286, 252, 291, 20);
		frame.getContentPane().add(textCurrencyNum);
		
		JButton btnConvert = new JButton("Convert"); //Button the user clicks to convert their chosen currency
		btnConvert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int userCurrency=Integer.parseInt(textStarting.getText()); //Gets the text of the number that the user selects for their starting currency
					int convertCurrency=Integer.parseInt(textConversion.getText()); //Gets the text of the number the user  would like to convert to
					double amount1=Double.parseDouble(textCurrencyNum.getText()); //Gets the text and makes the double amount1 the user input
					String convertedResult=convertCurrency(userCurrency, convertCurrency, amount1); //Variable for holding the converted result. Calls convert method
					textConvertedAmt.setText(convertedResult);
					conversionHistory.add(convertedResult); //Adds each conversion result to the conversionHistory ArrayList
					writeToFile(); //calls the writeToFile method to store the previous conversions
				} catch (NumberFormatException ex) { //If the user does not put in a number, it will print Invalid input
	            System.out.println("Invalid input. Please enter a number for conversions.");
			} catch (IOException e1) { // Eclipse auto generated catch to handle any errors from the user not putting in a valid number
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	});
		btnConvert.setFont(new Font("Calibri", Font.BOLD, 18));
		btnConvert.setBounds(235, 307, 120, 23);
		frame.getContentPane().add(btnConvert);
		

	}
	private String convertCurrency(int userCurrency, int convertCurrency, double amount1) //Method for converting the currencies
	{
		String result= " ";
		if (userCurrency==1 && convertCurrency==2) //User selects US Dollar (1) and Euro (2)
		{
			currency1.setCurrencyAmount(amount1); //Sets the value of amount in the usdConversions class 
			currency1.EUR();  //converts the amount from USD to EUR
			result=currency1.toString(); //Sets the value of result to the toString method from the usdConversions class
		}
		else if (userCurrency==1 && convertCurrency==3) //User selects US Dollar (1) and British Pound (3)
		{
			currency1.setCurrencyAmount(amount1); //Sets the value of amount in the usdConversions class
			currency1.GBP(); //converts the amount from USD to GBP
			result=currency1.toString(); //Sets the value of result to the toString method from the usdConversions class
		}
		else if (userCurrency==1 && convertCurrency==4) //User selects US Dollar (1) and Japanese Yen (4)
		{
			currency1.setCurrencyAmount(amount1); //Sets the value of amount in the usdConversions class
			currency1.JPY(); //converts the amount from USD to JPY
			result=currency1.toString(); //Sets the value of result to the toString method from the usdConversions class
		}
		else if (userCurrency==1 && convertCurrency==5) //User selects US Dollar (1) and Australian Dollar (5)
		{
			currency1.setCurrencyAmount(amount1); //Sets the value of amount in the usdConversions class
			currency1.AUD(); //converts the amount from USD to AUD
			result=currency1.toString(); //Sets the value of result to the toString method from the usdConversions class
		}
		else if (userCurrency==1 && convertCurrency==6) //User selects US Dollar (1) and Canadian Dollar (6)
		{
			currency1.setCurrencyAmount(amount1); //Sets the value of amount in the usdConversions class
			currency1.CAD(); //converts the amount from USD to CAD
			result=currency1.toString(); //Sets the value of result to the toString method from the usdConversions class
		}
		else if (userCurrency==2 && convertCurrency==1) //User selects Euro (2) and US Dollar (1)
		{
			currency2.setCurrencyAmount(amount1); //Sets the value of amount in the eurConversions class
			currency2.USD(); //converts the amount from EUR to USD
			result=currency2.toString(); //Sets the value of result to the toString method from the eurConversions class
		}
		else if (userCurrency==2 && convertCurrency==3) //User selects Euro (2) and British Pound (3)
		{
			currency2.setCurrencyAmount(amount1); //Sets the value of amount in the eurConversions class
			currency2.GBP(); //converts the amount from EUR to GBP
			result=currency2.toString(); //Sets the value of result to the toString method from the eurConversions class
		}
		else if (userCurrency==2 && convertCurrency==4) //User selects Euro (2) and Japanese Yen (4)
		{
			currency2.setCurrencyAmount(amount1); //Sets the value of amount in the eurConversions class
			currency2.JPY(); //converts the amount from EUR to JPY
			result=currency2.toString(); //Sets the value of result to the toString method from the eurConversions class
		}
		else if (userCurrency==2 && convertCurrency==5) //User selects Euro (2) and Australian Dollar (5)
		{
			currency2.setCurrencyAmount(amount1); //Sets the value of amount in the eurConversions class
			currency2.AUD(); //converts the amount from EUR to AUD
			result=currency2.toString(); //Sets the value of result to the toString method from the eurConversions class
		}
		else if (userCurrency==2 && convertCurrency==6) //User selects Euro (2) and Canadian Dollar (6)
		{
			currency2.setCurrencyAmount(amount1); //Sets the value of amount in the eurConversions class
			currency2.CAD(); //converts the amount from EUR to CAD
			result=currency2.toString(); //Sets the value of result to the toString method from the eurConversions class
		}
		else if (userCurrency==3 && convertCurrency==1) //User selects British Pound (3) and US Dollar (1)
		{
			currency3.setCurrencyAmount(amount1); //Sets the value of amount in the gbpConversions class
			currency3.USD(); //converts the amount from GBP to USD
			result=currency3.toString(); //Sets the value of result to the toString method from the gbpConversions class
		}
		else if (userCurrency==3 && convertCurrency==2) //User selects British Pound (3) and Euro (2)
		{
			currency3.setCurrencyAmount(amount1); //Sets the value of amount in the gbpConversions class
			currency3.EUR(); //converts the amount from GBP to EUR
			result=currency3.toString(); //Sets the value of result to the toString method from the gbpConversions class
		}
		else if (userCurrency==3 && convertCurrency==4) //User selects British Pound (3) and Japanese Yen (4)
		{
			currency3.setCurrencyAmount(amount1); //Sets the value of amount in the gbpConversions class
			currency3.JPY(); //converts the amount from GBP to JPY
			result=currency3.toString(); //Sets the value of result to the toString method from the gbpConversions class
		}
		else if (userCurrency==3 && convertCurrency==5) //User selects British Pound (3) and Australian Dollar (5)
		{
			currency3.setCurrencyAmount(amount1); //Sets the value of amount in the gbpConversions class
			currency3.AUD(); //converts the amount from GBP to AUD
			result=currency3.toString(); //Sets the value of result to the toString method from the gbpConversions class
		}
		else if (userCurrency==3 && convertCurrency==6) //User selects British Pound (3) and Canadian Dollar (6)
		{
			currency3.setCurrencyAmount(amount1); //Sets the value of amount in the gbpConversions class
			currency3.CAD(); //converts the amount from GBP to CAD
			result=currency3.toString(); //Sets the value of result to the toString method from the gbpConversions class
		}
		else if (userCurrency==4 && convertCurrency==1) //User selects Japanese Yen (4) and US Dollar (1)
		{
			currency4.setCurrencyAmount(amount1); //Sets the value of amount in the jpyConversions class
			currency4.USD(); //converts the amount from JPY to USD
			result=currency4.toString(); //Sets the value of result to the toString method from the jpyConversions class
		}
		else if (userCurrency==4 && convertCurrency==2) //User selects Japanese Yen (4) and Euro (2)
		{
			currency4.setCurrencyAmount(amount1); //Sets the value of amount in the jpyConversions class
			currency4.EUR(); //converts the amount from JPY to EUR
			result=currency4.toString(); //Sets the value of result to the toString method from the jpyConversions class
		}
		else if (userCurrency==4 && convertCurrency==3) //User selects Japanese Yen (4) and British Pound (3)
		{
			currency4.setCurrencyAmount(amount1); //Sets the value of amount in the jpyConversions class
			currency4.GBP(); //converts the amount from JPY to GBP
			result=currency4.toString(); //Sets the value of result to the toString method from the jpyConversions class
		}
		else if (userCurrency==4 && convertCurrency==5) //User selects Japanese Yen (4) and Australian Dollar (5)
		{
			currency4.setCurrencyAmount(amount1); //Sets the value of amount in the jpyConversions class
			currency4.AUD(); //converts the amount from JPY to AUD
			result=currency4.toString(); //Sets the value of result to the toString method from the jpyConversions class
		}
		else if (userCurrency==4 && convertCurrency==6) //User selects Japanese Yen (4) and Canadian Dollar (6)
		{
			currency4.setCurrencyAmount(amount1); //Sets the value of amount in the jpyConversions class
			currency4.CAD(); //converts the amount from JPY to CAD
			result=currency4.toString(); //Sets the value of result to the toString method from the jpyConversions class
		}
		else if (userCurrency==5 && convertCurrency==1) //User selects Australian Dollar (5) and US Dollar (1)
		{
			currency5.setCurrencyAmount(amount1); //Sets the value of amount in the audConversions class
			currency5.USD(); //converts the amount from AUD to USD
			result=currency5.toString(); //Sets the value of result to the toString method from the cadConversions class
		}
		else if (userCurrency==5 && convertCurrency==2) //User selects Australian Dollar (5) and Euro (2)
		{
			currency5.setCurrencyAmount(amount1); //Sets the value of amount in the audConversions class
			currency5.EUR(); //converts the amount from AUD to EUR
			result=currency5.toString(); //Sets the value of result to the toString method from the cadConversions class
		}
		else if (userCurrency==5 && convertCurrency==3) //User selects Australian Dollar (5) and British Pound (3)
		{
			currency5.setCurrencyAmount(amount1); //Sets the value of amount in the audConversions class
			currency5.GBP(); //converts the amount from AUD to GBP
			result=currency5.toString(); //Sets the value of result to the toString method from the cadConversions class
		}
		else if (userCurrency==5 && convertCurrency==4) //User selects Australian Dollar (5) and Japanese Yen (4)
		{
			currency5.setCurrencyAmount(amount1); //Sets the value of amount in the audConversions class
			currency5.JPY();//converts the amount from AUD to JPY
			result=currency5.toString(); //Sets the value of result to the toString method from the audConversions class
		}
		else if (userCurrency==5 && convertCurrency==6) //User selects Australian Dollar (5) and Canadian Dollar (6)
		{
			currency5.setCurrencyAmount(amount1); //Sets the value of amount in the audConversions class
			currency5.CAD(); //converts the amount from AUD to CAD
			result=currency5.toString(); //Sets the value of result to the toString method from the audConversions class
		}
		else if (userCurrency==6 && convertCurrency==1) //User selects Canadian Dollar (6) and US Dollar (1)
		{
			currency6.setCurrencyAmount(amount1); //Sets the value of amount in the cadConversions class
			currency6.USD(); //converts the amount from CAD to USD
			result=currency6.toString(); //Sets the value of result to the toString method from the cadConversions class
		}
		else if (userCurrency==6 && convertCurrency==2) //User selects Canadian Dollar (6) and Euro (2)
		{
			currency6.setCurrencyAmount(amount1); //Sets the value of amount in the cadConversions class
			currency6.EUR(); //converts the amount from CAD to EUR
			result=currency6.toString(); //Sets the value of result to the toString method from the cadConversions class
		}
		else if (userCurrency==6 && convertCurrency==3) //User selects Canadian Dollar (6) and British Pound (3)
		{
			currency6.setCurrencyAmount(amount1); //Sets the value of amount in the cadConversions class
			currency6.GBP(); //converts the amount from CAD to GBP
			result=currency6.toString(); //Sets the value of result to the toString method from the cadConversions class
		}
		else if (userCurrency==6 && convertCurrency==4) //User selects Canadian Dollar (6) and Japanese Yen (4)
		{
			currency6.setCurrencyAmount(amount1); //Sets the value of amount in the cadConversions class
			currency6.JPY(); //converts the amount from CAD to JPY
			result=currency6.toString(); //Sets the value of result to the toString method from the cadConversions class
		}
		else if (userCurrency==6 && convertCurrency==5)  //User selects Canadian Dollar (6) and Australian Dollar (5)
		{
			currency6.setCurrencyAmount(amount1); //Sets the value of amount in the cadConversions class
			currency6.AUD(); //converts the amount from CAD to AUD
			result=currency6.toString(); //Sets the value of result to the toString method from the cadConversions class
		}
		else
			result="Invalid Input. Please try again.";

		return result;
	}
	
	public void writeToFile() throws IOException { //Method to write the conversion history from the ArrayList into a file 
		FileWriter writer=new FileWriter("ConversionHistory.txt", true); 
		//true makes it so that each conversion can continue to be added to the file without overwriting it. 
		
		for (String conversion: conversionHistory) 
		{
			writer.write(conversion + "\n"); //Writes the conversions into the text file
		}
		writer.close(); //closes the writer
		{
			
		}
	}
	
		//Links used for help: 
		// 1. https://stackoverflow.com/questions/7974154/how-do-i-print-messages-to-the-screen-in-my-java-gui
		// 2. https://sentry.io/answers/how-to-create-a-file-and-write-to-it-in-java/#:~:text=java%20file.,file%20will%20not%20be%20overwritten.
		// 3. https://www.geeksforgeeks.org/exceptions-in-java/
}
