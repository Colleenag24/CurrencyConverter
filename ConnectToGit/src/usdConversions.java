public class usdConversions { //Conversions for the U.S Dollar
	private double cadConversionRate = 1.36; //Amount of Canadian Dollars per U.S Dollar
	private double gbpConversionRate = 0.76; //Amount of Pound per U.S Dollar
	private double eurConversionRate = 0.91; //Amount of Euro per U.S Dollar
	private double jpyConversionRate = 146.22; //Amount of Japanese Yen per U.S Dollar
	private double audConversionRate = 1.46; //Amount of Australian Dollars per U.S Dollar
	
	private double currencyAmount; //instance variable for amount
	private String currencySymbol; //instance variable that sets the type of currency for each conversion
	private String currencyName; //instance variable that adds the abbreviation for each currency
	private double convertedAmount; //instance variable to hold the converted amount
	
	public double setCurrencyAmount(double amount)
	{
		currencyAmount = amount; //gets the user input and gives it to the currencyAmount variable
		return currencyAmount; //returns the currency amount variable
	}
	

	public double CAD() //Constructor for converting USD into CAD
	{
		currencyName="CAD";
		currencySymbol ="C$";
		convertedAmount = currencyAmount * cadConversionRate; //Converts the amount of usd to cad
		return convertedAmount; // returns the converted amount
	}
	
	public double GBP() //Constructor for converting USD into CAD
	{
		currencyName="GBP";
		currencySymbol = "£";
		convertedAmount = currencyAmount * gbpConversionRate; //Converts the amount of usd to gbp
		return convertedAmount; // returns the converted amount
	}
	
	public double EUR() //Constructor for converting USD into CAD
	{
		currencyName = "EUR";
		currencySymbol = "€";
		convertedAmount = currencyAmount * eurConversionRate; //Converts the amount of usd to eur
		return convertedAmount; // returns the converted amount
		
	}
	
	public double JPY() //Constructor for converting USD into JPY
	{
		currencyName = "JPY";
		currencySymbol = "¥";
		convertedAmount = currencyAmount * jpyConversionRate; //Converts the amount of usd to jpy
		return convertedAmount; // returns the converted amount
	}
	
	public double AUD() //Constructor for converting USD into AUD
	{
		currencyName = "AUD";
		currencySymbol = "A$";
		convertedAmount = currencyAmount * audConversionRate; //Converts the amount of usd to aud
		return convertedAmount; // returns the converted amount
	}
	
	public String toString()
	{
		String conversionFormat = String.format("Converted Amount: %s %.2f %s", currencySymbol, convertedAmount, currencyName);
		return conversionFormat;
	}

}