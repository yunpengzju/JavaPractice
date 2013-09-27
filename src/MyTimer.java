import javax.swing.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

public class MyTimer extends JFrame{
	public MyTimer(){
		add(new NewPanel());
		JPanel p1 = new JPanel();
		p1.add(new JButton("test1"),BorderLayout.WEST);
		JLabel message = new JLabel("test");
		p1.add(message, BorderLayout.EAST);
		add(p1, BorderLayout.SOUTH);
	}
	
	public static void main(String[] args){
		MyTimer  frame = new MyTimer();
		frame.setTitle("timer");
		frame.setSize(200,240);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class NewPanel extends JPanel{
	protected void paintComponent(Graphics g){
		super.paintComponent(g);
		int xCenter = this.getWidth()/2;
		int yCenter = this.getHeight()/2;
		int radius = (int)(Math.min(this.getWidth(), this.getHeight()) * 0.8 * 0.5);
		g.setColor(Color.BLACK);
		g.drawOval(xCenter - radius, yCenter - radius, 2 * radius, 2 * radius);
	}
	public Dimension getPreferredSize(){
		return new Dimension(200,200);
	}
}