
public class eurConversions {
	private double cadConversionRate = 1.49; //Amount of Canadian Dollars per Euro
	private double gbpConversionRate = 0.83; //Amount of Pound per Euro
	private double usdConversionRate = 1.07; //Amount of U.S Dollar per Euro
	private double jpyConversionRate = 163.73; //Amount of Japanese Yen per Euro
	private double audConversionRate = 1.63; //Amount of Australian Dollars per Euro
	
	private double currencyAmount; //instance variable for amount
	private String currencySymbol; //instance variable that sets the type of currency for each conversion
	private String currencyName; //instance variable that adds the abbreviation for each currency //https://websparrow.org/java/java-heap-memory-vs-stack-memory-understanding-the-differences#:~:text=The%20heap%20memory%20is%20used%20for%20dynamic,memory%20stores%20method%20calls%20and%20local%20variables.
	private double convertedAmount; //instance variable to hold the converted amount
	
	public double setCurrencyAmount(double amount)
	{
		currencyAmount = amount; //gets the user input and gives it to the currencyAmount variable
		return currencyAmount; //returns the currency amount variable
	}
	

	public double CAD() //Method for converting EUR into USD
	{
		currencyName="CAD"; // Abbreviation for the Canadian Dollar
		currencySymbol ="C$"; //sets the currency symbol to the Canadian dollar symbol
		convertedAmount = currencyAmount * cadConversionRate; //Converts the amount of eur to cad
		return convertedAmount; // returns the converted amount
	}
	
	public double GBP() //Constructor for converting EUR into GBP
	{
		currencyName="GBP"; //abbreviation for British Pound Sterling
		currencySymbol = "£"; //sets the currency symbol to the pound symbol
		convertedAmount = currencyAmount * gbpConversionRate; //Converts the amount of eur to gbp
		return convertedAmount; // returns the converted amount
	}
	
	public double USD() //Constructor for converting EUR into USD
	{
		currencyName = "USD"; //abbreviation for US Dollar
		currencySymbol = "$"; //sets the currency symbol to the US Dollar symbol
		convertedAmount = currencyAmount * usdConversionRate; //Converts the amount of eur to usd
		return convertedAmount; // returns the converted amount
		
	}
	
	public double JPY() //Constructor for converting EUR into JPY
	{
		currencyName = "JPY"; //abbreviation for Japanese Yen
		currencySymbol = "¥"; //sets the currency symbol to the yen symbol
		convertedAmount = currencyAmount * jpyConversionRate; //Converts the amount of eur to jpy
		return convertedAmount; // returns the converted amount
	}
	
	public double AUD() //Constructor for converting EUR into AUD
	{
		currencyName = "AUD"; //abbreviation for Australian Dollar
		currencySymbol = "A$";//sets the currency symbol to the Australian dollar symbol
		convertedAmount = currencyAmount * audConversionRate; //Converts the amount of eur to aud
		return convertedAmount; // returns the converted amount
	}
	
	public String toString() //https://stackoverflow.com/questions/6431933/how-to-format-strings-in-java, //https://www.geeksforgeeks.org/java-string-format-method-with-examples/
	{
		String conversionFormat = String.format("Converted Amount: %s %.2f %s", currencySymbol, convertedAmount, currencyName); //formats the objects for printing.
		return conversionFormat; //returns the conversionFormat variable to the output for toString in the main
	}

}
