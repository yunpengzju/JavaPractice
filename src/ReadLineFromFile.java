import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadLineFromFile {
	private String[] array;
	private String fileName;
	private int size;
	public ReadLineFromFile(String file){
		array = new String[16];
		fileName = file;
	}
	public void readByLine() throws FileNotFoundException{
		File file = new File(fileName);
		Scanner input = new Scanner(file);
		if (size >= array.length){
			String[] temp = new String[array.length*2];
			System.arraycopy(array, 0, temp, 0, array.length);
			array = temp;
		}
		while(input.hasNext()){
			array[size++] = input.nextLine();
		}
		input.close();
	}
	public void displayList(){
		
		for(int i = 0; i < size; i++){
			System.out.println(array[i]);
		}
	}
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
}
