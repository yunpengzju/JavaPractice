import java.util.*;

public class NewLab2 {
	private HashMap<String,String> map;				// 用来存储关键词-答案值对
	public NewLab2(){
		map = new HashMap<String,String>();
		map.put("zju", "ZJU is a nice University!");  // 事先设定关键字对应的答案，在此仅输入少数用例，如需扩展，可用数组传值导入
	}
	public NewLab2(String[] key, String[] answer){
		map = new HashMap<String,String>();
		if (key.length <= answer.length)
		{
			for (int i = 0; i < key.length; i++){
				map.put(key[i], answer[i]);
			}
		}
		else System.out.println("Initialize error");
	}
	public void answer(String question){					
		boolean flag = false;						// 标记该关键词是否存在已有答案
		String[] keyword = question.split(" ");		// 按空格对问题进行分词
		for (int i = 0; i < keyword.length; i++){	// 遍历问题中的每个词语寻找答案
			if (null != map.get(keyword[i])){		// 如果发现答案
				System.out.println(map.get(keyword[i]));	// 输出设定的答案
				flag = true;	// 标记已找到答案
				break;			// 不再寻找答案
			}
		}
		if (!flag) System.out.println("Sorry, I have no idea");	// 没有找到答案提示用户
	}
	public static void main(String[] args){
		String keys[] = {"zju","math"};
		String answer[] = {"ZJU is a nice University!","I hate math"};
		NewLab2 instance = new NewLab2(keys,answer);	
		Scanner input = new Scanner(System.in);
		String choice;
		do{
            //请输入您的问题
			System.out.println("what's your question?");
			String question = input.nextLine();		// 输入问题
			instance.answer(question);				// 调用函数回答问题
			System.out.println("Do you want to continue?(press any key. if not please input 0)");
			choice = input.next();				// 询问是否继续
		}while(!choice.equals("0"));						// 若输入0，退出程序
	}
}
