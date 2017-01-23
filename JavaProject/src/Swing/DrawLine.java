package Swing;

import javax.swing.*; 
import java.awt.*; 

public class DrawLine extends JComponent { 
	public DrawLine() {
 
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		//�e�@�����u,�q�y��(100,100)��(300,300)
		g.drawLine(100,100,300,300);
	}
	//�갵�ۭq����ɡA
	//�̦n�мg�ogetPreferredSize�BgetMaximumSize�BgetMinimumSize�T�Ӥ�k
	//�]���\�hLayoutManager���i��ѳo�T�Ӥ�k�ӨM�w�����󪺤j�p
	public Dimension getPreferredSize() {
		return new Dimension(640, 480);
	}
	public Dimension getMaximumSize() {
		return getPreferredSize();
	}
	public Dimension getMinimumSize() {
		return getPreferredSize();
	}
	public static void main(String[] args) {
		//�]�w�������~�[
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame("DrawLine");
		//�bSwing��JFrame���󤤡A
		//�n�W�[����άO�]�wLayoutManager���ʧ@�A
		//�n�����z�LgetContentPane()��k���oRootPane�A
		//�~��b�W���i��ʧ@�C
		frame.getContentPane().add(new DrawLine());
		frame.getContentPane().setBackground(Color.WHITE);
		//�]�w������ܦb�ù��b����m
		frame.setLocation(100,100);
		//�������k�W����X�ϥܳQ���U����A�����|����
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
 }