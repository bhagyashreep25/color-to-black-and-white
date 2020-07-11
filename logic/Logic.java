package logic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Logic extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main (String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logic frame = new Logic();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Logic() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 204, 153));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblEnterPath = new JLabel("Enter source path");
		lblEnterPath.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEnterPath.setBounds(13, 8, 143, 14);
		lblEnterPath.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(lblEnterPath);
		
		textField = new JTextField();
		textField.setBounds(150, 5, 412, 42);
		panel.add(textField);
		textField.setColumns(50);
		
		JLabel lblEnterDestinationPath = new JLabel("Enter destination path");
		lblEnterDestinationPath.setFont(new Font("Century Gothic", Font.PLAIN, 15));
		lblEnterDestinationPath.setBounds(10, 58, 174, 23);
		panel.add(lblEnterDestinationPath);
		
		textField_1 = new JTextField();
		textField_1.setBounds(178, 61, 384, 53);
		panel.add(textField_1);
		textField_1.setColumns(50);
		
		JButton btnDone = new JButton("Done");
		btnDone.setFont(new Font("Century Gothic", Font.BOLD, 15));
		btnDone.setBounds(221, 159, 83, 29);
		panel.add(btnDone);
		btnDone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{  
			String path = textField.getText();
			String dest = textField_1.getText();
			try {
				perf(path,dest);
			} catch (IIOException e1) {
				System.out.println(e);
			}
			JOptionPane.showMessageDialog(null, "Your image will be saved with name 'output'");
		}
		});
			
		}
	public static void perf(String path,String dest) throws IIOException
	{
		BufferedImage img = null;
        File f = null;
        int x=0,y=0,l=0;
        double threshold;
        //read image
        try{
            f = new File(path);
            img = ImageIO.read(f);
        }catch(IOException e){
            System.out.println(e);
        }
        Vector<Integer> v = new Vector<Integer>();
        //get image width and height
        int width = img.getWidth();
        int height = img.getHeight();
        //convert to grayscale
        for(y = 0; y < height; y++){
            for(x = 0; x < width; x++){
               // int p = img.getRGB(x,y);
               // int a = (p>>24)&0xff;
               // int r = (p>>16)&0xff;
               // int g = (p>>8)&0xff;
               // int b = p&0xff;

                Color mycolor = new Color(img.getRGB(x, y));
               int r = mycolor.getRed();
               int g = mycolor.getGreen();
               int b = mycolor.getBlue();
            
                //calculate average
                int avg = (r+g+b)/3;
                v.add(avg);                
                //replace RGB value with avg
                //p = (a<<24) | (avg<<16) | (avg<<8) | avg;
                
                //img.setRGB(x, y, p);
            }
        }
        
        int sum = 0;
        for(int k=0; k<v.size();k++)
        {
            sum+=(int)v.get(k);
        } 
        threshold = ((double)sum)/(v.size());
        for(y = 0; y < height; y++)
        {
            for(x = 0; x < width; x++)
            {
                int avg = (int)v.get(l);
                if(avg > (int)threshold)
                {
                    img.setRGB(x, y, new Color(255,255,255).getRGB());
                }
                else
                {
                    img.setRGB(x, y, new Color(0,0,0).getRGB());
                }
				l++;
            }
        }
        //write image
        try{
        	f = new File(dest+"output.png");
            ImageIO.write(img, "png", f);
        }catch(IOException e){
            System.out.println(e);
        }
	}
	}
