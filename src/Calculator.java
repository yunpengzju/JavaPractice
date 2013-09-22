import java.util.*;
public class Calculator extends UnitTest{
	private String str;
	private int[] number;
	private char[] operator;
	private int number_top;
	private int op_top;
	public Calculator(){
		number = new int[100];
		operator = new char[100];
		number_top = 0;
		op_top = 0;
	}
	public Calculator(String str){
		this.str = str;
		number = new int[100];
		operator = new char[100];
		number_top = 0;
		op_top = 0;
	}
	private void setStr(String str){
		this.str = str;
	}
	public void pushNum(int a){
		number[number_top++] = a;
	}
	public void pushOp(char a){
		operator[op_top++] = a;
	}
	public int popNum(){
		return number[--number_top];
	}
	public char popOp(){
		return operator[--op_top];
	}
	public char nextOp(){
		return operator[op_top-1];
	}
	public boolean hasNext(){
		return op_top > 0;
	}
	public boolean isNumber(char a){
		if(a >= '0' && a <= '9')  return true;
		else return false;
	}
	public void computeStep(){
		char op  = this.popOp();
		int  op2 = this.popNum();
		int  op1 = this.popNum();
		switch(op){
			case '+': this.pushNum(op1+op2);break;
			case '-': this.pushNum(op1-op2);break;
			case '*': this.pushNum(op1*op2);break;
			case '/': this.pushNum(op1/op2);
		}
	}
	public void computeSeveralStep(){
		while(this.nextOp() != '('){
			this.computeStep();
		}
		this.popOp();
	}
	public int compute(){
		boolean flag = false;
		String temp = "";
		for (int i = 0; i < str.length(); i++){
			if (this.isNumber(str.charAt(i))) {
				flag = true;
				temp += str.charAt(i);
			}
			else{
				if(flag){
					this.pushNum(Integer.parseInt(temp));
					temp = "";
				}
				flag = false;
				if(str.charAt(i) == '*' || str.charAt(i) == '/'|| str.charAt(i) == '(')
					pushOp(str.charAt(i));
				else if (str.charAt(i) == '+' || str.charAt(i) == '-'){
					if(this.hasNext()){
						if(this.nextOp() != '(')
						this.computeStep();
					}
					pushOp(str.charAt(i));
				}
				else{
					this.computeSeveralStep();
				}
			}
		}
		if(flag) this.pushNum(Integer.parseInt(temp));
		while(this.hasNext())
		{
			this.computeStep();
		}
		return this.popNum();
	}

	public void display(){
		for(int i = 0; i<number.length; i++)
			System.out.print(number[i]+" ");
		System.out.println();
		System.out.println(operator);
	}
	protected boolean testProgram(String input, String output){
		this.setStr(input);
		System.out.println("correct result: "+ output);
		System.out.println("present result: "+ this.compute());
		return String.valueOf(this.compute()).equals(output);
	}
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		//String str = input.next();
		Calculator c = new Calculator();
		String[] in = {"2+3","3+5"};
		String[] out = {"5","8"};
		c.setTestCase(in, out);
		System.out.println("Final result:" +c.test());	
	}
}



