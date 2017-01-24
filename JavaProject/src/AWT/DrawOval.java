package AWT;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class DrawOval extends Canvas{
	public DrawOval() {
		//設定Canvas元件大小
		setSize(640,480);
	}
	
	public void paint(Graphics g) {
		//畫一個實心橢圓,從座標(50,50)長寬為250,200
		g.setColor(Color.cyan);
		g.fillOval(50,50,250,200);
		//畫一個空心圓
		g.drawOval(300, 300, 100, 100);
	}
	public static void main(String[] args){
		Frame frame = new Frame("DrawRectangle");
		frame.add(new DrawOval());
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
