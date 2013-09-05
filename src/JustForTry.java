import java.util.Date;
public class JustForTry {
	public static void main(String[] args){
		A a = new A(5);
		System.out.println(a instanceof B);
	}
	public static void incre(){
		a++;
	}
	public static int a = 10;
}


class A{
	private int a;
	private final int i = 1;
	public A(){
		this(1);
	}
	public A(int a){
		this.a = a;
	}
	public void setA(int a){
		this.a = a;
	}
	public int getA(){
		return this.a;
	}
	
}

class B extends A{
	public B(){	
		super();
		setA(4);
	}
	public B(int a){
		super(a);
	}
	public int getA(){
		return super.getA()+1;
	}
}