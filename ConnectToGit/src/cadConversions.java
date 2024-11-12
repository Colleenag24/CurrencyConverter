
public class cadConversions {
	private double audConversionRate = 1.09; //Amount of Canadian Dollars per Australian Dollar
	private double gbpConversionRate = 0.56; //Amount of Pound per Australian Dollar
	private double eurConversionRate = 0.67; //Amount of Euro per Australian Dollar
	private double jpyConversionRate = 109.76; //Amount of Japanese Yen per Australian Dollar
	private double usdConversionRate = 0.72; //Amount of US Dollars per Australian Dollar
	
	private double currencyAmount; //instance variable for amount
	private String currencySymbol; //instance variable that sets the type of currency for each conversion
	private String currencyName; //instance variable that adds the abbreviation for each currency //https://websparrow.org/java/java-heap-memory-vs-stack-memory-understanding-the-differences#:~:text=The%20heap%20memory%20is%20used%20for%20dynamic,memory%20stores%20method%20calls%20and%20local%20variables.
	private double convertedAmount; //instance variable to hold the converted amount
	
	public double setCurrencyAmount(double amount)
	{
		currencyAmount = amount; //gets the user input and gives it to the currencyAmount variable
		return currencyAmount; //returns the currency amount variable
	}
	

	public double AUD() //Method for converting CAD into AUD
	{
		currencyName="AUD"; // Abbreviation for the canadian dollar
		currencySymbol ="A$"; //sets the currency symbol to the Canadian dollar symbol
		convertedAmount = currencyAmount * audConversionRate; //Converts the amount of cad to aud
		return convertedAmount; // returns the converted amount
	}
	
	public double GBP() //Method for converting CAD into GBP
	{
		currencyName="GBP"; //abbreviation for British Pound Sterling
		currencySymbol = "£"; //sets the currency symbol to the pound symbol
		convertedAmount = currencyAmount * gbpConversionRate; //Converts the amount of cad to gbp
		return convertedAmount; // returns the converted amount
	}
	
	public double EUR() //Method for converting CAD into EUR
	{
		currencyName = "EUR"; //abbreviation for Euro
		currencySymbol = "€"; //sets the currency symbol to the euro symbol
		convertedAmount = currencyAmount * eurConversionRate; //Converts the amount of cad to eur
		return convertedAmount; // returns the converted amount
		
	}
	
	public double JPY() //Method for converting CAD into JPY
	{
		currencyName = "JPY"; //abbreviation for Japanese Yen
		currencySymbol = "¥"; //sets the currency symbol to the yen symbol
		convertedAmount = currencyAmount * jpyConversionRate; //Converts the amount of cad to jpy
		return convertedAmount; // returns the converted amount
	}
	
	public double USD() //Method for converting CAD into USD
	{
		currencyName = "USD"; //abbreviation for Australian Dollar
		currencySymbol = "$";//sets the currency symbol to the Australian dollar symbol
		convertedAmount = currencyAmount * usdConversionRate; //Converts the amount of cad to usd
		return convertedAmount; // returns the converted amount
	}
	
	public String toString()
	{
		String conversionFormat = String.format("Converted Amount: %s %.2f %s", currencySymbol, convertedAmount, currencyName); //formats the objects for printing.
		return conversionFormat; //returns the conversionFormat variable to the output for toString in the main
	}
	

}