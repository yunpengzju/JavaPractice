import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;


public class ReadLineFromFile {
	public static void main(String[] args)
	{
		if (args.length != 1){
			System.out.println("Please input file name");
			System.exit(0);
		}
		String file = args[0];
		ReadLineFromFile reader = new ReadLineFromFile(file);
		try {
			reader.readByLine();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		reader.displayList();
	}
	public ReadLineFromFile(String file){
		list = new LinkedList<String>();
		fileName = file;
	}
	public void readByLine() throws FileNotFoundException{
		File file = new File(fileName);
		Scanner input = new Scanner(file);

		while(input.hasNext()){
			list.add(input.nextLine());
		}
		input.close();
	}
	public void displayList(){
		LinkedList<String> temp = list;
		while(!temp.isEmpty()){
			System.out.println(temp.pop());
		}
	}
	private LinkedList<String> list;
	private String fileName;
}
