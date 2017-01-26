package JDBC;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.xml.bind.ValidationEvent;

public class LoginFrame {
	private JFrame jf = new JFrame("�n�J");
	private JTextField userField = new JTextField(20);
	private JTextField passField = new JTextField(20);
	private JButton loginButton = new JButton("�n�J");
	ConnMySQL login = new ConnMySQL();
	public void init()throws Exception{
		login.initParam();
		Class.forName(login.driver);
		loginButton.addActionListener(e -> {
			if(validate(userField.getText(), passField.getText()))
				JOptionPane.showMessageDialog(jf, "�n�J���\");
			else
				JOptionPane.showMessageDialog(jf, "�n�J����");
		});
		jf.add(userField, BorderLayout.NORTH);
		jf.add(passField);
		jf.add(loginButton, BorderLayout.SOUTH);
		jf.pack();
		jf.setVisible(true);
	}
	private boolean validate(String userName, String userPass) {
		String sql = "select * from jdbc_test "
				+"where jdbc_name ='" + userName
				+"' and jdbc_desc='" + userPass + "'";
		System.out.println(sql);
		try(
			Connection conn = DriverManager.getConnection(login.url, login.user, login.pass);
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql)){
				if(rs.next()){
					return true;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return false;
	}
	public static void main(String[] args) throws Exception{
		new LoginFrame().init();
	}
}