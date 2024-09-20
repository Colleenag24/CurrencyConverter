import java.util.Scanner;

public class Converter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader = new Scanner(System.in); //Scanner for multiple inputs
		System.out.println("1 US Dollar");  //Currency options
		System.out.println("2 Euro");
		System.out.println("3 Pound");
		System.out.println("4 Yen");
		System.out.println("5 Australian Dollar");
		System.out.println("6 Canadian Dollar");
		String again = "Y";
		
		do
		{
		System.out.println("Enter the beginning currency: "); //Beginning currency 
		int begin = reader.nextInt();
		System.out.println("Enter the currecy to convert to: "); //Conversion currency
		int choice = reader.nextInt(); 
		System.out.println("Enter the amount: "); //Amount being converted
		double amount = reader.nextDouble();
		
		if (begin==1 && choice==2) //US Dollar to other currencies set up
			System.out.println("US Dollar to Euro");//print statement to make sure it works
		else if (begin==1 && choice==3)
			System.out.println("US Dollar to Pound");//print statement to make sure it works
		else if (begin==1 && choice==4)
			System.out.println("US Dollar to Yen");//print statement to make sure it works
		else if (begin==1 && choice==5)
			System.out.println("US Dollar to Australian Dollar");//print statement to make sure it works
		else if (begin==1 && choice==6)
		{
			System.out.println("US Dollar to Canadian Dollar");//print statement to make sure it works
			break;
		}
	System.out.println("Do you want to convert another currency (Y/N) ?");
		again = reader.next();
		
		
		}while (again.equals("Y"));
		
		
		
		

		

	}

}
