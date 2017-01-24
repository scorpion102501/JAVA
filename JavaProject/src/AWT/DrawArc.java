package AWT;

import java.awt.*; 
import java.awt.event.*; 

public class DrawArc extends Canvas { 
	public DrawArc() {
		//設定Canvas元件大小
		setSize(640,480);
	}
   
	public void paint(Graphics g) {
		//畫一個實心圓弧,從座標(10,10)開始角度45 總角度290
		g.setColor(Color.cyan);
		g.fillArc(10, 10, 80, 100, 45, 290);
		//畫一個圓弧
		g.drawArc(100, 100, 200, 200, 45, 180);
	} 
 
	public static void main(String[] args) {
		Frame frame = new Frame("DrawLine");
		frame.add(new DrawArc());
 
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