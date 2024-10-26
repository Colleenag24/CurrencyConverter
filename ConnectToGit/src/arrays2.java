import java.util.Scanner;

public class arrays2 {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		String[] student={"Ann","Bob","Charlie"};
		int[] grade= {100, 98, 67};
		
		
		System.out.println("Whose grade do you need to look up? ");
		String studentLookUp=reader.nextLine();
		boolean foundStudent=false;
		
		for(int i=0;i<student.length;i++)
		{
			if (student[i].equals(studentLookUp))
			{
				System.out.println(grade[i]);
				foundStudent=true;
			}
				
		}
		
		if (foundStudent==false)
		{
			System.out.println("The student is not in the class.");
		}
		
		
		
		
		
		

	}

}
