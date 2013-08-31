import java.util.Scanner;
// 随机出一道10以内加减法题目，并判断回答的结果是否正确
public class CalculatorTest {
	public static void main(String[] args){
		boolean flag = true;
		Scanner input = new Scanner(System.in);
		int number1 = (int)(System.currentTimeMillis()%10);
		int number2 = (int)(System.currentTimeMillis()*7%10);
		
		while(flag)
		{
			System.out.println("What is "+number1 + "+" + number2 + "?");
			int answer = input.nextInt();
			System.out.println(answer==number1 + number2 );
			if(answer == number1 + number2)
			{
				break;
			}
			number1 = (int)(System.currentTimeMillis()%10);
			number2 = (int)(System.currentTimeMillis()*7%10);
		}

	}
}
