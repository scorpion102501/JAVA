package AWT;

import java.awt.*; 
import java.awt.event.*; 

public class DrawArc extends Canvas { 
	public DrawArc() {
		//�]�wCanvas����j�p
		setSize(640,480);
	}
   
	public void paint(Graphics g) {
		//�e�@�ӹ�߶꩷,�q�y��(10,10)�}�l����45 �`����290
		g.setColor(Color.cyan);
		g.fillArc(10, 10, 80, 100, 45, 290);
		//�e�@�Ӷ꩷
		g.drawArc(100, 100, 200, 200, 45, 180);
	} 
 
	public static void main(String[] args) {
		Frame frame = new Frame("DrawLine");
		frame.add(new DrawArc());
 
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