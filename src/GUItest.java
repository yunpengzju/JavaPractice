import java.awt.*;

import javax.swing.*;
public class GUItest extends JFrame {
	public GUItest(){
		add(new JLabel("first"),BorderLayout.CENTER);
		add(new JTextField(8),BorderLayout.EAST);
		add(new JLabel("second"));
		add(new JTextField(4));
		add(new JLabel("third"));
		add(new JTextField(12));		
		setLayout(new GridLayout(3,2));
	}
	public static void main(String[] args){
		GUItest frame = new GUItest();
		frame.setName("test");
		frame.setSize(400,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
