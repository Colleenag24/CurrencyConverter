import java.util.Scanner;

public class arrays {

	public static void main(String[] args) {
		Scanner reader=new Scanner(System.in);
		System.out.println("How many items do you have for the list? ");
		int num=reader.nextInt();
		int[] list=new int[num];
		
		for(int i=0;i<list.length;i++)
		{
			System.out.println("Enter item number"+(i+1));
			list[i]=reader.nextInt();
		}
		
		System.out.println();
		for(int i=0;i<list.length;i++)
		{
			System.out.println(list[i]+" ");
		}
		
		int[] listA= {5, 7, 10, 12, 15};
		System.out.print(listA[1]);
		
		
		
		

	}

}