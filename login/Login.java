package login;
//import logic.Logic;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Login implements ActionListener{

	private JFrame frame;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JLabel lblLoginPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(204, 204, 204));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Login Page");
		
		textField_1 = new JTextField();
		textField_1.setBounds(211, 86, 117, 29);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmailId = new JLabel("Password");
		lblEmailId.setFont(new Font("NoirStd-Regular", Font.PLAIN, 15));
		lblEmailId.setBounds(94, 163, 93, 26);
		frame.getContentPane().add(lblEmailId);
		
		JLabel label = new JLabel("Email ID");
		label.setFont(new Font("NoirStd-Regular", Font.PLAIN, 15));
		label.setBounds(94, 93, 67, 26);
		frame.getContentPane().add(label);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("NoirStd-Regular", Font.PLAIN, 15));
		btnLogin.setBounds(164, 229, 89, 23);
		frame.getContentPane().add(btnLogin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(211, 162, 117, 26);
		frame.getContentPane().add(passwordField);
		
		lblLoginPage = new JLabel("Login Page");
		lblLoginPage.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginPage.setFont(new Font("NoirStd-Bold", Font.PLAIN, 15));
		lblLoginPage.setBounds(165, 22, 101, 23);
		frame.getContentPane().add(lblLoginPage);
		btnLogin.addActionListener(this);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root","");
			String user=textField_1.getText();
			char[] p = passwordField.getPassword();
			String password = new String(p);
			String query="select Name from java1 where EmailID=? and Password=?";
			PreparedStatement stat=con.prepareStatement(query);
			stat.setString(1, user);
			stat.setString(2, password);
			ResultSet set=stat.executeQuery();
			if(set.next())
			{
				JOptionPane.showMessageDialog(null, "Login Successful");
				//Logic.main(null);
			}
			else
				JOptionPane.showMessageDialog(null, "Invalid Username or Password");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
