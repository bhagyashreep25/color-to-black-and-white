import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

//import login.Login;
//import login.Registration;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import javax.swing.JButton;

public class Main implements ActionListener{

	private JFrame frame;
	JButton btnRegister, btnLogin;
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	public Main() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("NoirStd-Regular", Font.PLAIN, 20));
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.setBounds(100, 100, 698, 448);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Color to B/W");
		
		JLabel lblColorToBlack = new JLabel("BLACK");
		lblColorToBlack.setHorizontalAlignment(SwingConstants.CENTER);
		lblColorToBlack.setFont(new Font("NoirStd-Bold", Font.PLAIN, 40));
		lblColorToBlack.setBounds(275, 20, 142, 44);
		frame.getContentPane().add(lblColorToBlack);
		
		JLabel lblWelcomeToAabvs = new JLabel("Welcome to Color to Black & White App");
		lblWelcomeToAabvs.setFont(new Font("Century Gothic", Font.BOLD, 30));
		lblWelcomeToAabvs.setBounds(70, 55, 1000, 110);
		frame.getContentPane().add(lblWelcomeToAabvs);
		
		JLabel lblC = new JLabel("C");
		lblC.setForeground(new Color(153, 0, 0));
		lblC.setFont(new Font("NoirPro-Bold", Font.PLAIN, 40));
		lblC.setBounds(70, 20, 26, 44);
		frame.getContentPane().add(lblC);
		
		JLabel lblO = new JLabel("O");
		lblO.setForeground(new Color(204, 0, 0));
		lblO.setFont(new Font("NoirPro-Bold", Font.PLAIN, 40));
		lblO.setBounds(95, 20, 43, 44);
		frame.getContentPane().add(lblO);
		
		JLabel lblL = new JLabel("L");
		lblL.setForeground(new Color(255, 0, 0));
		lblL.setFont(new Font("NoirStd-Bold", Font.PLAIN, 40));
		lblL.setBounds(125, 20, 26, 44);
		frame.getContentPane().add(lblL);
		
		JLabel lblO_1 = new JLabel("O");
		lblO_1.setForeground(new Color(255, 102, 0));
		lblO_1.setFont(new Font("NoirStd-Bold", Font.PLAIN, 40));
		lblO_1.setBounds(145, 20, 43, 44);
		frame.getContentPane().add(lblO_1);
		
		JLabel lblR = new JLabel("R");
		lblR.setForeground(new Color(255, 102, 102));
		lblR.setFont(new Font("NoirStd-Bold", Font.PLAIN, 40));
		lblR.setBounds(177, 20, 46, 44);
		frame.getContentPane().add(lblR);
		
		JLabel lblTo = new JLabel("to");
		lblTo.setForeground(new Color(255, 255, 0));
		lblTo.setFont(new Font("NoirStd-Bold", Font.PLAIN, 40));
		lblTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTo.setBounds(210, 20, 69, 44);
		frame.getContentPane().add(lblTo);
		
		JLabel lblWhite = new JLabel("WHITE");
		lblWhite.setFont(new Font("NoirStd-Bold", Font.PLAIN, 40));
		lblWhite.setForeground(new Color(255, 255, 255));
		lblWhite.setBounds(515, 20, 148, 44);
		frame.getContentPane().add(lblWhite);
		
		JLabel lblAnd = new JLabel("and");
		lblAnd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAnd.setForeground(new Color(255, 255, 0));
		lblAnd.setFont(new Font("NoirStd-Bold", Font.PLAIN, 40));
		lblAnd.setBounds(420, 20, 80, 44);
		frame.getContentPane().add(lblAnd);
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnRegister.setBounds(111, 207, 116, 29);
		frame.getContentPane().add(btnRegister);
		btnRegister.addActionListener(this);
		
		JLabel lblNewToThe = new JLabel("New to the App");
		lblNewToThe.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblNewToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewToThe.setBounds(80, 165, 183, 29);
		frame.getContentPane().add(lblNewToThe);
		
		JLabel lblAlreadyWithUs = new JLabel("Already with us");
		lblAlreadyWithUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlreadyWithUs.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		lblAlreadyWithUs.setBounds(384, 165, 183, 29);
		frame.getContentPane().add(lblAlreadyWithUs);
		
		btnLogin = new JButton("Login");
		btnLogin.setVerticalAlignment(SwingConstants.BOTTOM);
		btnLogin.setFont(new Font("Century Gothic", Font.BOLD, 20));
		btnLogin.setBounds(437, 207, 90, 29);
		frame.getContentPane().add(btnLogin);
		btnLogin.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//if(e.getSource() == btnRegister)
			//Registration.main(null);
		//else
			//Login.main(null);
		
	}

}
