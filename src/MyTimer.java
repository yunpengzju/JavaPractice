import javax.swing.*;

import java.awt.Color;
import java.awt.Graphics;

public class MyTimer extends JFrame{
	public MyTimer(){
		add(new NewPanel());
	}
	
	public static void main(String[] args){
		MyTimer  frame = new MyTimer();
		frame.setTitle("timer");
		frame.setSize(200,100);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class NewPanel extends JPanel{
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		g.drawLine(0, 0, 50, 50);
		g.drawString("hello", 0, 40);
		this.setBackground(Color.BLUE);
	}
}