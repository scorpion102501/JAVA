package AWT;

import java.awt.*; 
import java.awt.event.*; 

public class DrawLine extends Canvas { 
	public DrawLine() {
		//�]�wCanvas����j�p
		setSize(640,480);
	}
   
	public void paint(Graphics g) {
		//�e�@�����u,�q�y��(100,100)��(150,150)
		g.drawLine(100,100,300,300);
	} 
 
	public static void main(String[] args) {
		Frame frame = new Frame("MyCanvasDemo_1");
		frame.add(new DrawLine());
 
		//�]�w������ܦb�ù��b����m
		frame.setLocation(100,100);
 
		//�������k�W����X�ϥܳQ���U����A�����|����
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
 
		frame.pack();
		frame.setVisible(true);
	}
 }