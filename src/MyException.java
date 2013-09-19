import java.util.*;
public class MyException {
	public static void main(String[] args){
		Scanner input  = new Scanner(System.in);
		try{
			int a = input.nextInt();
			System.out.println( a + 1 );
		}
		catch (InputMismatchException ex){
			System.out.print("please enter an integer");
		}
		
	}
}
