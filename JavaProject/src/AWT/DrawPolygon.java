package AWT;

import java.awt.*; 
import java.awt.event.*; 

public class DrawPolygon extends Canvas { 
	public DrawPolygon() {
		//�]�wCanvas����j�p
		setSize(640,480);
	}
   
	public void paint(Graphics g) {
		//�e�@�Ӧh���
		g.setColor(Color.cyan);
		int[] xx={450,400,500,450,500},yy={200,225,225,175,200};
		g.fillPolygon(xx, yy, 5);
	} 
 
	public static void main(String[] args) {
		Frame frame = new Frame("DrawLine");
		frame.add(new DrawPolygon());
 
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