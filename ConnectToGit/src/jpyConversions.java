
public class jpyConversions {
	private double cadConversionRate = 0.0091; //Amount of Canadian Dollar per Japanese Yen
	private double eurConversionRate = 0.0061; //Amount of Euro per Japanese Yen
	private double usdConversionRate = 0.0066; //Amount of U.S Dollar per Japanese Yen
	private double gbpConversionRate = 0.0051; //Amount of British Pound per Japanese Yen
	private double audConversionRate = 0.0099; //Amount of Australian Dollars per Japanese Yen
	
	private double currencyAmount; //instance variable for amount
	private String currencySymbol; //instance variable that sets the type of currency for each conversion
	private String currencyName; //instance variable that adds the abbreviation for each currency 
	private double convertedAmount; //instance variable to hold the converted amount
	
	public double setCurrencyAmount(double amount)
	{
		currencyAmount = amount; //gets the user input and gives it to the currencyAmount variable
		return currencyAmount; //returns the currency amount variable
	}
	

	public double CAD() //Method for converting JPY into CAD
	{
		currencyName="CAD"; // Abbreviation for the Canadian Dollar
		currencySymbol ="C$"; //sets the currency symbol to the Canadian dollar symbol
		convertedAmount = currencyAmount * cadConversionRate; //Converts the amount of jpy to cad
		return convertedAmount; // returns the converted amount
	}
	
	public double EUR() //Method for converting JPY into EUR
	{
		currencyName="EUR"; //abbreviation for British Pound Sterling
		currencySymbol = "€"; //sets the currency symbol to the pound symbol
		convertedAmount = currencyAmount * eurConversionRate; //Converts the amount of jpy to eur
		return convertedAmount; // returns the converted amount
	}
	
	public double USD() //Method for converting JPY into USD
	{
		currencyName = "USD"; //abbreviation for US Dollar
		currencySymbol = "$"; //sets the currency symbol to the euro symbol
		convertedAmount = currencyAmount * usdConversionRate; //Converts the amount of jpy to usd
		return convertedAmount; // returns the converted amount
		
	}
	
	public double GBP() //Method for converting JPY into GBP
	{
		currencyName = "GBP"; //abbreviation for Japanese Yen
		currencySymbol = "£"; //sets the currency symbol to the british pound symbol
		convertedAmount = currencyAmount * gbpConversionRate; //Converts the amount of jpy to gbp
		return convertedAmount; // returns the converted amount
	}
	
	public double AUD() //Method for converting JPY into AUD
	{
		currencyName = "AUD"; //abbreviation for Australian Dollar
		currencySymbol = "A$";//sets the currency symbol to the Australian dollar symbol
		convertedAmount = currencyAmount * audConversionRate; //Converts the amount of jpy to aud
		return convertedAmount; // returns the converted amount
	}
	
	public String toString() 
	{
		String conversionFormat = String.format("Converted Amount: %s %.2f %s", currencySymbol, convertedAmount, currencyName); //formats the objects for printing.
		return conversionFormat; //returns the conversionFormat variable to the output for toString in the main
	}

}