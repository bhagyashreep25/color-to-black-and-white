package login;
import javax.swing.*;

//import logic.Logic;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Registration extends JFrame implements ActionListener
{ 
JLabel l1, l2, l3, l4, l5, l6, l7, l8;
JTextField tf1, tf2, tf5, tf6, tf7;
JButton btn1, btn2;
JPasswordField p1, p2;

Registration()
{
getContentPane().setBackground(new Color(204, 204, 204));
setVisible(true);
setSize(700, 700);
getContentPane().setLayout(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setTitle("Registration Page");

l1 = new JLabel("Registration Page:");
l1.setForeground(new Color(0, 0, 0));
l1.setFont(new Font("NoirStd-Bold", Font.BOLD, 20));
	l2 = new JLabel("Name:");
	l2.setFont(new Font("NoirStd-Regular", Font.PLAIN, 11));
    l3 = new JLabel("Email-ID:");
    l3.setFont(new Font("NoirStd-Regular", Font.PLAIN, 11));
    l4 = new JLabel("Create Password:");
    l4.setFont(new Font("NoirStd-Regular", Font.PLAIN, 11));
    l5 = new JLabel("Confirm Password:");
    l5.setFont(new Font("NoirStd-Regular", Font.PLAIN, 11));
    l6 = new JLabel("Country:");
    l6.setFont(new Font("NoirStd-Regular", Font.PLAIN, 11));
    l7 = new JLabel("State:");
    l7.setFont(new Font("NoirStd-Regular", Font.PLAIN, 11));
    l8 = new JLabel("Phone No:"); 
    l8.setFont(new Font("NoirStd-Regular", Font.PLAIN, 11));
 tf1 = new JTextField();
    tf2 = new JTextField();
    p1 = new JPasswordField();
    p2 = new JPasswordField();
    tf5 = new JTextField();
    tf6 = new JTextField();
    tf7 = new JTextField();

    btn1 = new JButton("Submit");
    btn1.setFont(new Font("NoirStd-Regular", Font.PLAIN, 11));
    btn2 = new JButton("Clear");
    btn2.setFont(new Font("NoirStd-Regular", Font.PLAIN, 11));

btn1.addActionListener(this);
btn2.addActionListener(this);
l1.setBounds(100, 30, 400, 30);
l2.setBounds(80, 70, 200, 30);
l3.setBounds(80, 110, 200, 30);
l4.setBounds(80, 150, 200, 30);
l5.setBounds(80, 190, 200, 30);
l6.setBounds(80, 230, 200, 30);
l7.setBounds(80, 270, 200, 30);
l8.setBounds(80, 310, 200, 30);
tf1.setBounds(300, 70, 200, 30);
tf2.setBounds(300, 110, 200, 30);
p1.setBounds(300, 150, 200, 30);
p2.setBounds(300, 190, 200, 30);
tf5.setBounds(300, 230, 200, 30);
tf6.setBounds(300, 270, 200, 30);
tf7.setBounds(300, 310, 200, 30);
btn1.setBounds(50, 350, 100, 30);
btn2.setBounds(170, 350, 100, 30);
getContentPane().add(l1);
getContentPane().add(l2);
getContentPane().add(tf1);
getContentPane().add(l3);
getContentPane().add(tf2);
getContentPane().add(l4);
getContentPane().add(p1);
getContentPane().add(l5);
getContentPane().add(p2);
getContentPane().add(l6);
getContentPane().add(tf5);
getContentPane().add(l7);
getContentPane().add(tf6);
getContentPane().add(l8);
getContentPane().add(tf7);
getContentPane().add(btn1);
getContentPane().add(btn2);
    }

public void actionPerformed(ActionEvent e) 
     {
if (e.getSource() == btn1)
         {
int x = 0;
            String s1 = tf1.getText();
            String s2 = tf2.getText();

char[] s3 = p1.getPassword();
char[] s4 = p2.getPassword(); 
            String s8 = new String(s3);
            String s9 = new String(s4);
            String s5 = tf5.getText();
            String s6 = tf6.getText();
            String s7 = tf7.getText();

if (s8.equals(s9))
           {
try
               {
Class.forName("com.mysql.jdbc.Driver");
                    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/java1","root",""); 
PreparedStatement ps = con.prepareStatement("insert into java1 values(?,?,?,?,?,?)");
ps.setString(1, s1);
ps.setString(2, s2);
ps.setString(3, s8);
ps.setString(4, s5);
ps.setString(5, s6);
ps.setString(6, s7);
int rs = ps.executeUpdate();
x++;
if (x > 0)  {
JOptionPane.showMessageDialog(btn1, "Data Saved Successfully");
//Logic.main(null);
}
                }
catch (Exception ex) {
System.out.println(ex);
                }
            }
else
{
JOptionPane.showMessageDialog(btn1, "Password Does Not Match");
 } 
} 
else
{
tf1.setText("");
tf2.setText("");
p1.setText("");
p2.setText("");
tf5.setText("");
tf6.setText("");
tf7.setText("");
}
} 
public static void main(String args[])
{
new Registration();
}
}
