
public class Classwork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = addNumber(4, 5);
		System.out.println(num);
		int numA = addNumber(4, 5, 6);
		System.out.println(numA);

	}
	public static int addNumber(int a, int b)
	{ 
		int total = a + b;
		return total;
	}
	
	public static int addNumber(int c, int d, int e)
	{ 
		int total = c + d + e;
		return total; 
	}
}
