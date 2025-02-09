package com.frameWork;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.project.Main;

public class Login_info extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	JButton f_b,v_b,a_b;
	public void setdata(){
		String path="D:/workspace/advancejavaworkspace/New folder/vegetables-7357585_1280 (1).png";
		String f_path="D:/workspace/advancejavaworkspace/New folder/f1.jpg";
		String v_path="D:/workspace/advancejavaworkspace/New folder/vectvegatablesjpg.jpg";
		String admin_path="D:/workspace/advancejavaworkspace/New folder/admin.jpg";
		
		ImageIcon i=new ImageIcon(path);
		Image i1=i.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		ImageIcon i2=new ImageIcon(i1); 
		JLabel l= new JLabel(i2);
		l.setBounds(200,10, 100, 100);
		add(l);
		getContentPane().setBackground(Color.white);
		JLabel text= new JLabel(" Welcome to Market!!");
		text.setFont(new Font("Osward",Font.BOLD,30));
		text.setBounds(300, 40, 400, 40);
		add(text);
		//fruits image
		ImageIcon f_i=new ImageIcon(f_path);
		Image f_i1=f_i.getImage().getScaledInstance(100, 100,Image.SCALE_DEFAULT);
		ImageIcon f_i2=new ImageIcon(f_i1); 
		JLabel f_label= new JLabel(f_i2);
		f_label.setBounds(250,250, 100, 100);
		add(f_label);
		
		f_b= new JButton("Fruits");
		f_b.setFont(new Font("Osward",Font.BOLD,20));
		f_b.setBounds(260, 350, 100, 30);
		add(f_b);
		
		// vegatables image 
		ImageIcon v_i=new ImageIcon(v_path);
		Image v_i1=v_i.getImage().getScaledInstance(130, 130,Image.SCALE_DEFAULT);
		ImageIcon v_i2=new ImageIcon(v_i1); 
		JLabel v_label= new JLabel(v_i2);
		v_label.setBounds(480,250, 100, 100);
		add(v_label);
		
		this.v_b= new JButton("Vegatables");
		this.v_b.setFont(new Font("Osward",Font.BOLD,20));
		this.v_b.setBounds(460, 350, 150, 30);
		add(this.v_b);
		
		//admin
		
		ImageIcon a_i=new ImageIcon(admin_path);
		Image a_i1=a_i.getImage().getScaledInstance(130, 130,Image.SCALE_DEFAULT);
		ImageIcon a_i2=new ImageIcon(a_i1); 
		JLabel a_label= new JLabel(a_i2);
		a_label.setBounds(360,130, 100, 100);
		add(a_label);
		
		a_b= new JButton("Admin");
		a_b.setBounds(360,230,110,30);
		a_b.setFont(new Font("Osward",Font.BOLD,20));
		a_b.addActionListener(this);
		add(a_b);
		
		
		
		setTitle("My Market");
		setLayout(null); 
		setSize(850,500);
		setVisible(true);
		f_b.addActionListener(this);		
	}
	public static void main(String[] args) {
		Login_info l1= new Login_info();
		l1.setdata();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==f_b) {
			Fruits_ f= new Fruits_();
			f.displayContent();
			setVisible(false);
		}else if(e.getSource()==v_b) {
			Vegatables_info v1= new Vegatables_info();
			v1.displayContent();
			setVisible(false);
			
		}else if(e.getSource()==a_b){
			System.out.println("hello ");
			AdminPage a1= new AdminPage();
			a1.loginpage();
			setVisible(false);
		}
		
		
	}
			
}
