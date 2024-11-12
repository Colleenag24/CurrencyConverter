
public class gbpConversions {
	private double cadConversionRate = 1.79; //Amount of Canadian Dollar per British Pound
	private double eurConversionRate = 1.20; //Amount of Euro per British Pound
	private double usdConversionRate = 1.29; //Amount of U.S Dollar per British Pound
	private double jpyConversionRate = 196.92; //Amount of Japanese Yen per British Pound
	private double audConversionRate = 1.96; //Amount of Australian Dollars per British Pound
	
	private double currencyAmount; //instance variable for amount
	private String currencySymbol; //instance variable that sets the type of currency for each conversion
	private String currencyName; //instance variable that adds the abbreviation for each currency 
	private double convertedAmount; //instance variable to hold the converted amount
	
	public double setCurrencyAmount(double amount)
	{
		currencyAmount = amount; //gets the user input and gives it to the currencyAmount variable
		return currencyAmount; //returns the currency amount variable
	}
	

	public double CAD() //Method for converting GBP into CAD
	{
		currencyName="CAD"; // Abbreviation for the Canadian Dollar
		currencySymbol ="C$"; //sets the currency symbol to the Canadian dollar symbol
		convertedAmount = currencyAmount * cadConversionRate; //Converts the amount of gbp to cad
		return convertedAmount; // returns the converted amount
	}
	
	public double EUR() //Method for converting GBP into EUR
	{
		currencyName="EUR"; //abbreviation for British Pound Sterling
		currencySymbol = "€"; //sets the currency symbol to the pound symbol
		convertedAmount = currencyAmount * eurConversionRate; //Converts the amount of gbp to eur
		return convertedAmount; // returns the converted amount
	}
	
	public double USD() //Method for converting GBP into USD
	{
		currencyName = "USD"; //abbreviation for US Dollar
		currencySymbol = "$"; //sets the currency symbol to the euro symbol
		convertedAmount = currencyAmount * usdConversionRate; //Converts the amount of eur to usd
		return convertedAmount; // returns the converted amount
		
	}
	
	public double JPY() //Method for converting GBP into JPY
	{
		currencyName = "JPY"; //abbreviation for Japanese Yen
		currencySymbol = "¥"; //sets the currency symbol to the yen symbol
		convertedAmount = currencyAmount * jpyConversionRate; //Converts the amount of eur to jpy
		return convertedAmount; // returns the converted amount
	}
	
	public double AUD() //Method for converting GBP into AUD
	{
		currencyName = "AUD"; //abbreviation for Australian Dollar
		currencySymbol = "A$";//sets the currency symbol to the Australian dollar symbol
		convertedAmount = currencyAmount * audConversionRate; //Converts the amount of eur to aud
		return convertedAmount; // returns the converted amount
	}
	
	public String toString() 
	{
		String conversionFormat = String.format("Converted Amount: %s %.2f %s", currencySymbol, convertedAmount, currencyName); //formats the objects for printing.
		return conversionFormat; //returns the conversionFormat variable to the output for toString in the main
	}

}