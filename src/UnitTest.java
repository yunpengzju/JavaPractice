
public class UnitTest {
	protected String[] input;
	protected String[] output;
	
	protected UnitTest(){
		
	}
	protected void setTestCase(String[] input, String[] output){
		this.input = input;
		this.output = output;
	}
	protected boolean test(){           // 返回测试是否通过
		if(input.length != output.length){
			System.out.println("test case error");
			return false;
		}
		boolean flag = true,tempFlag;
		for (int i = 0; i < input.length; i++){
			System.out.println("test case "+(i+1)+":");
			try{
				tempFlag = testProgram(input[i],output[i]);
			}
			catch(Exception e){
				tempFlag = false;
				e.printStackTrace();
			}
			System.out.println("result for test case "+(i+1)+": "+tempFlag);
			if(false == tempFlag) flag = false;
		}
		return flag;
	}
	protected boolean testProgram(String input, String output){
		System.out.println("Please overload function testProgram(String input, String output");
		return true;
	}
}
