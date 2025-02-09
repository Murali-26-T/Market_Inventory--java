package com.frameWork;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class MyBil extends JFrame implements ActionListener {
	JLabel title,c_name,c_phnumber,showname,shownumber,textname,textQuantity,textcost;
	JButton back,conform;
	String name,number;
	JTextField c_name1,phone;
	List<String>item= new ArrayList<>();
	List<Double>quantity=new ArrayList<>();
	List<Long> costList= new ArrayList<>();
	Map <String,Double> f_items= new HashMap<>();
	
	private Object JLabel;
	GetDataDB g1= new GetDataDB();
	
	
	public void BilCal() {
		Fruits_ f1= new Fruits_();
		Vegatables_info  v1= new Vegatables_info();
		
		GetDataDB g1= new GetDataDB();
		g1.getdata();
		g1.getvegdata();
		
		f_items.putAll(Fruits_.fruitQuantities);
		System.out.println("fruits:"+Fruits_.fruitQuantities);
		System.out.println("vegs:"+Vegatables_info.vegQuantities);
		f_items.putAll(Vegatables_info.vegQuantities);
		System.out.println("total:"+f_items.size());
		
		int total=0;
		int textn=180;
		int i=1;
			for (Map.Entry<String, Double> entry : f_items.entrySet()) {
			Long cost=0l;
            String key = entry.getKey();
            double value = entry.getValue();
            this.textname= new JLabel(key);
            if(value>0.0) {
            	item.add(key);
            	quantity.add(value);
            	
            textname.setBounds(40,textn,800,30);
            textname.setFont(new Font("Osward",Font.BOLD,14));
            add(textname);
            
            textQuantity= new JLabel(String.valueOf(value));
            textQuantity.setBounds(140,textn,800,30);
            textQuantity.setFont(new Font("Osward",Font.BOLD,14));
            add(textQuantity);
            
            cost=g1.item_cost.get(key);
            textcost= new JLabel(String.valueOf(cost*value));
            textcost.setBounds(250,textn,800,30);
            textcost.setFont(new Font("Osward",Font.BOLD,14));
            add(textcost);
            costList.add((long) (cost*value));
            total=(int) (total+(cost*value));
            textn+=40;
            i++;
            }
            
        }
			 if(i<f_items.size()) {
	            	JLabel show= new JLabel("---------------");
	            	show.setBounds(230,textn-20,800,30);
	            	show.setFont(new Font("Osward",Font.BOLD,14));
	            	add(show);
	            	textn=textn+20;
	            	JLabel showTotal= new JLabel("total:"+String.valueOf(total));
	            	showTotal.setBounds(215,textn-20,800,30);
	            	showTotal.setFont(new Font("Osward",Font.BOLD,14));
	            	add(showTotal);
			 }
		}
		
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyBil b1 = new MyBil();
		b1.displayData();

	}
	
	void displayData() {
		title = new JLabel("Bill");
		title.setBounds(200,20,1000,30);
		title.setFont(new Font("Osward",Font.BOLD,30));
		add(title);
		
		c_name = new JLabel("customer name:");
		c_name.setBounds(40,70,800,30);
		c_name.setFont(new Font("Osward",Font.BOLD,15));
		add(c_name);
		
		c_name1= new JTextField(15);
		c_name1.setBounds(170,78,200,20);
		c_name1.setFont(new Font("Osward",Font.BOLD,15));
		add(c_name1);
		
		
		
		
		c_phnumber = new JLabel("customer PhNo:");
		c_phnumber.setBounds(40,100,800,30);
		c_phnumber.setFont(new Font("Osward",Font.BOLD,15));
		add(c_phnumber);
		
		
		phone= new JTextField(15);
		phone.setBounds(170,105,200,20);
		phone.setFont(new Font("Osward",Font.BOLD,15));
		add(phone);
		
		back= new JButton("Back");
		back.setBounds(300, 10, 100, 20);
		back.setFont(new Font("Osward", Font.BOLD,15));
		back.addActionListener(this);
		add(back);
		
		JLabel item= new JLabel("Items");
		item.setBounds(40,140,800,30);
		item.setFont(new Font("Osward",Font.BOLD,14));
		add(item);
		
		JLabel quantity= new JLabel("Quantity");
		quantity.setBounds(140,140,800,30);
		quantity.setFont(new Font("Osward",Font.BOLD,14));
		add(quantity);
		
		JLabel cost= new JLabel("Cost");
		cost.setBounds(260,140,800,30);
		cost.setFont(new Font("Osward",Font.BOLD,14));
		add(cost);
		
		
		conform= new JButton("Conform&payment");
		conform.setBounds(20, 600, 200, 30);
		conform.setFont(new Font("Osward", Font.BOLD,15));
		conform.addActionListener(this);
		add(conform);
		
			
		
		  setTitle("bill");
	      setLayout(null);
	      setSize(450, 700);
	      setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==back) {
			new Fruits_();
			setVisible(false);
			
			
		}else if(e.getSource()==conform) {
			String name=c_name1.getText();
			String number=phone.getText();
			if(name.equals("") && number.equals("")) {
				JOptionPane.showMessageDialog(null, "please fill the above details!! its");
				
			}
			
			
			else {
			
			
			try {
				int n=g1.insertDataDb(name,number,item,quantity,costList);
				if (n==1){
					JOptionPane.showMessageDialog(null, "thank you ");
					setVisible(false);
					Login_info l1 = new Login_info();
					l1.setdata();
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (ClassNotFoundException e1) {      
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		}
	}

}
