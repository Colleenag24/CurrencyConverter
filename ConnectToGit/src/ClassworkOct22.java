import java.util.Scanner;

public class ClassworkOct22 {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String[] seat= new String[10];
		System.out.println("There are 10 seats, How many you would like to reserve?");
		int numSeats=reader.nextInt();
		
		for(int i=0;i<numSeats;i++)
		{
			System.out.println("What seat would you like to reserve (1-10)? ");
			int reservedSeats=reader.nextInt();
			seat[reservedSeats]="R";
		
			if (seat[reservedSeats]=="R")
				System.out.println("This seat is already reserved. Please choose another");
		}
		
		for(int i=0;i<seat.length;i++)
		{
			System.out.println(seat[i]+ " ");
		}
	}
}