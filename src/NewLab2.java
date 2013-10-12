import java.util.*;

public class NewLab2 {
	private HashMap<String,String> map;				// �����洢�ؼ���-��ֵ��
	public NewLab2(){
		map = new HashMap<String,String>();
		map.put("zju", "ZJU is a nice University!");  // �����趨�ؼ��ֶ�Ӧ�Ĵ𰸣��ڴ˽���������������������չ���������鴫ֵ����
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
		boolean flag = false;						// ��Ǹùؼ����Ƿ�������д�
		String[] keyword = question.split(" ");		// ���ո��������зִ�
		for (int i = 0; i < keyword.length; i++){	// ���������е�ÿ������Ѱ�Ҵ�
			if (null != map.get(keyword[i])){		// ������ִ�
				System.out.println(map.get(keyword[i]));	// ����趨�Ĵ�
				flag = true;	// ������ҵ���
				break;			// ����Ѱ�Ҵ�
			}
		}
		if (!flag) System.out.println("Sorry, I have no idea");	// û���ҵ�����ʾ�û�
	}
	public static void main(String[] args){
		String keys[] = {"zju","math"};
		String answer[] = {"ZJU is a nice University!","I hate math"};
		NewLab2 instance = new NewLab2(keys,answer);	
		Scanner input = new Scanner(System.in);
		String choice;
		do{
            //��������������
			System.out.println("what's your question?");
			String question = input.nextLine();		// ��������
			instance.answer(question);				// ���ú����ش�����
			System.out.println("Do you want to continue?(press any key. if not please input 0)");
			choice = input.next();				// ѯ���Ƿ����
		}while(!choice.equals("0"));						// ������0���˳�����
	}
}
