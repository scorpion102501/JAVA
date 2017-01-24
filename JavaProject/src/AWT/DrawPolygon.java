package AWT;

import java.awt.*; 
import java.awt.event.*; 

public class DrawPolygon extends Canvas { 
	public DrawPolygon() {
		//設定Canvas元件大小
		setSize(640,480);
	}
   
	public void paint(Graphics g) {
		//畫一個多邊形
		g.setColor(Color.cyan);
		int[] xx={450,400,500,450,500},yy={200,225,225,175,200};
		g.fillPolygon(xx, yy, 5);
	} 
 
	public static void main(String[] args) {
		Frame frame = new Frame("DrawLine");
		frame.add(new DrawPolygon());
 
		//設定視窗顯示在螢幕在的位置
		frame.setLocation(100,100);
 
		//讓視窗右上角的X圖示被按下之後，視窗會關閉
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
 
		frame.pack();
		frame.setVisible(true);
	}
 }