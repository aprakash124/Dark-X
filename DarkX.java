
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;

public class DarkX
{	
	static JFrame create_steg;
	static JFrame recover_img;
	static File cover_image;
	static File secret_image;
	static File steg_image;
	static boolean cover_exists;
	static boolean secret_exists;
	static boolean steg_exists;
	
	public static void main(String[] args)
	{
		JFrame application = new JFrame();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.getContentPane().setBackground(new Color(0,0,0));
		application.setSize(600,600);
		application.setVisible(true);
		application.setLayout(null);
		
		JButton create_button = new JButton("Create Steg Image");
		create_button.setBackground(new Color(255,0,0));
		create_button.setForeground(new Color(255,255,255));
		create_button.setBounds(100,125,400,150);
		
		JButton recover_button = new JButton("Recover Secret Image");
		recover_button.setBackground(new Color(255,0,0));
		recover_button.setForeground(new Color(255,255,255));
		recover_button.setBounds(100,325,400,150);
		
		application.getContentPane().add(create_button);
		application.getContentPane().add(recover_button);
		
		create_button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                application.setVisible(false);
                create_steg = new JFrame();
                create_steg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			create_steg.setSize(600,600);
    			create_steg.setVisible(true);
        		create_steg.setLayout(null);
        		
        		JButton button1 = new JButton("Import Cover Image");
        		button1.setBackground(new Color(255,0,0));
        		button1.setForeground(new Color(255,255,255));
        		button1.setBounds(25,25,525,75);
        		
        		JButton button2 = new JButton("Import Secret Image");
        		button2.setBackground(new Color(255,0,0));
        		button2.setForeground(new Color(255,255,255));
        		button2.setBounds(25,125,525,75);
        		
        		JTextArea text_area = new JTextArea(225,275);
        		
        		create_steg.getContentPane().add(button1);
        		create_steg.getContentPane().add(button2);
        		create_steg.getContentPane().add(text_area);
        		
        		button1.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    	JFileChooser fileChooser = new JFileChooser();
                    	fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                    	int result = fileChooser.showOpenDialog(null);
                    	if (result == JFileChooser.APPROVE_OPTION) 
                    	{
                    	    cover_image = fileChooser.getSelectedFile();
                    	    cover_exists = true;
                    	    System.out.println(cover_image.getAbsolutePath());
                    	}
                    	else
                    	{
                    		cover_exists = false;
                    	}
                    	
                    	if (cover_exists && secret_exists)
                    	{
                    		try
                    		{
                    			String key = JOptionPane.showInputDialog("Please enter the key");
                    			FileWriter outfile = new FileWriter(new File("steg.txt"));
                    			outfile.write(cover_image.getAbsolutePath() + "\n");
                    			outfile.write(secret_image.getAbsolutePath() + "\n");
                    			outfile.write(key + "\n");
                    			outfile.close();
                    			create_steg.setVisible(false);
                    			System.exit(0);
                    		}
                    		catch (Exception e)
                    		{
                    			e.printStackTrace();
                    		}
                    	}
                    }
                }
                );
        		
        		button2.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    	JFileChooser fileChooser = new JFileChooser();
                    	fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                    	int result = fileChooser.showOpenDialog(null);
                    	if (result == JFileChooser.APPROVE_OPTION) 
                    	{
                    	    secret_image = fileChooser.getSelectedFile();
                    	    secret_exists = true;
                    	}
                    	else
                    	{
                    		secret_exists = false;
                    	}
                    	
                    	if (cover_exists && secret_exists)
                    	{
                    		try
                    		{
                    			String key = JOptionPane.showInputDialog("Please enter the key");
                    			FileWriter outfile = new FileWriter(new File("steg.txt"));
                    			outfile.write(cover_image.getAbsolutePath() + "\n");
                    			outfile.write(secret_image.getAbsolutePath() + "\n");
                    			outfile.write(key + "\n");
                    			outfile.close();
                    			create_steg.setVisible(false);
                    			System.exit(0);
                    		}
                    		catch (Exception e)
                    		{
                    			e.printStackTrace();
                    		}
                    	}
                    }
                }
                );
            }
        }
        );
		
		recover_button.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae)
            {
                application.setVisible(false);
                recover_img = new JFrame();
                recover_img.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    			recover_img.setSize(600,600);
    			recover_img.setVisible(true);
        		recover_img.setLayout(null);
        		
        		JButton button = new JButton("Import Steg Image");
        		button.setBackground(new Color(255,0,0));
        		button.setForeground(new Color(255,255,255));
        		button.setBounds(25,25,525,75);
        		
        		JTextArea text_area = new JTextArea(225,275);
        		
        		recover_img.getContentPane().add(button);
        		recover_img.getContentPane().add(text_area);
        		
        		button.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent ae)
                    {
                    	JFileChooser fileChooser = new JFileChooser();
                    	fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
                    	int result = fileChooser.showOpenDialog(null);
                    	if (result == JFileChooser.APPROVE_OPTION) 
                    	{
                    	    steg_image = fileChooser.getSelectedFile();
                    	    steg_exists = true;
                    	}
                    	else
                    	{
                    		steg_exists = false;
                    	}
                    	
                    	if (steg_exists)
                    	{
                    		try
                    		{
                    			String key = JOptionPane.showInputDialog("Please enter the key");
                    			FileWriter outfile = new FileWriter(new File("secret.txt"));
                    			outfile.write(steg_image.getAbsolutePath() + "\n");
                    			outfile.write(key + "\n");
                    			outfile.close();
                    			recover_img.setVisible(false);
                    			System.exit(0);
                    		}
                    		catch (Exception e)
                    		{
                    			e.printStackTrace();
                    		}
                    	}
                    }
                }
                );
            }
        }
        );
	}
}
