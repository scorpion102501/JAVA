package AWT;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawRectangle extends Canvas{
	public DrawRectangle() {
		//�]�wCanvas����j�p
		setSize(640,480);
	}
	
	public void paint(Graphics g) {
		//�e�@�ӹ�߯x��,�q�y��(50,50)���e��250,200
		g.setColor(Color.cyan);
		g.fillRect(50,50,250,200);
		//�e�@�ӪŤ߯x��
		g.drawRect(300, 300, 100, 100);
	}
	public static void main(String[] args){
		Frame frame = new Frame("DrawRectangle");
		frame.add(new DrawRectangle());
		frame.setLocation(100,100);
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		frame.pack();
		frame.setVisible(true);
	}
}