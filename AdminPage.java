package com.frameWork;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.project.Database_connection;

public class AdminPage extends JFrame implements ActionListener {
	JTextField username,password,item_name,cost_,quantity,type,o_cost,from_date,to_date;
	JLabel name,password_1,addtext;
	JButton login, update1,back,showProfit,get;
	JLabel heading;
		public void loginpage() {
			
			
			
			
			name= new JLabel("Username:");
			name.setBounds(70,70,800,30);
			name.setFont(new Font("Osward",Font.BOLD,15));
			add(name);
			
			username= new JTextField(15);
			username.setBounds(170,70,200,30);
			username.setFont(new Font("Osward",Font.BOLD,15));
			username.addActionListener(this);
			add(username);
			
			
			password_1= new JLabel("Password:");
			password_1.setBounds(70,130,800,30);
			password_1.setFont(new Font("Osward",Font.BOLD,15));
			add(password_1);
			
			password= new JTextField(15);
			password.setBounds(170,130,200,30);
			password.setFont(new Font("Osward",Font.BOLD,15));
			password.addActionListener(this);
			add(password);
			
			login= new JButton("Login");
			login.setBounds(230,250,110,30);
			login.setFont(new Font("Osward",Font.BOLD,20));
			login.addActionListener(this);
			add(login);
			
			setTitle("login");
	        setLayout(null);
	        setSize(500, 500);
	        setVisible(true);
	        
		}
		void showdata() throws ClassNotFoundException, SQLException {
			
			
			Connection c1=Database_connection.main_1();
			String f_query="select * from fruits ";
			String v_query="select * from vegatables";
			heading= new JLabel("Welcome To Admin");
			heading.setBounds(600,30,800,30);
			heading.setFont(new Font("Osward",Font.BOLD,30));
			add(heading);
			
			back= new JButton("back");
			back.setBounds(1300,50,110,30);
			back.setFont(new Font("Osward",Font.BOLD,20));
			back.addActionListener(this);
			add(back);
			
			showProfit= new JButton("showProfit");
			showProfit.setBounds(700,650,150,30);
			showProfit.setFont(new Font("Osward",Font.BOLD,15));
			showProfit.addActionListener(this);
			add(showProfit);
			
			
			JLabel fru_head= new JLabel("Fruits");
			fru_head.setBounds(200,100,800,30);
			fru_head.setFont(new Font("Osward",Font.BOLD,25));
			add(fru_head);
			
			
			JLabel veg_head= new JLabel("Vegatabels");
			veg_head.setBounds(750,100,800,30);
			veg_head.setFont(new Font("Osward",Font.BOLD,25));
			add(veg_head);
			
			JLabel update= new JLabel("Update");
			update.setBounds(1200,100,800,30);
			update.setFont(new Font("Osward",Font.BOLD,25));
			add(update);
			
			
			
			JLabel item= new JLabel("Item name");
			item.setBounds(80,150,800,30);
			item.setFont(new Font("Osward",Font.BOLD,15));
			add(item);
			
			JLabel Quantity= new JLabel("Quantity");
			Quantity.setBounds(200,150,800,30);
			Quantity.setFont(new Font("Osward",Font.BOLD,15));
			add(Quantity);
			
			JLabel cost= new JLabel("selling");
			cost.setBounds(300,150,800,30);
			cost.setFont(new Font("Osward",Font.BOLD,15));
			add(cost);
			
			JLabel selling= new JLabel("cost");
			selling.setBounds(370,150,800,30);
			selling.setFont(new Font("Osward",Font.BOLD,15));
			add(selling);
			PreparedStatement f=c1.prepareStatement(f_query);
			PreparedStatement v=c1.prepareStatement(v_query);
			
			ResultSet f_data=f.executeQuery();
			ResultSet v_data=v.executeQuery();
			
			//print fruits data from database
			int top=190;
			while(f_data.next()) {
				
				JLabel data1= new JLabel(f_data.getString(1));
				data1.setBounds(80,top,800,30);
				data1.setFont(new Font("Osward",Font.BOLD,15));
				add(data1);
				
				JLabel data2= new JLabel(String.valueOf(f_data.getDouble(3)));
				data2.setBounds(200,top,800,30);
				data2.setFont(new Font("Osward",Font.BOLD,15));
				add(data2);
				
	
				JLabel data31= new JLabel(String.valueOf(f_data.getLong(2)));
				data31.setBounds(300,top,800,30);
				data31.setFont(new Font("Osward",Font.BOLD,15));
				add(data31);
				
				JLabel data41= new JLabel(String.valueOf(f_data.getInt(4)));
				data41.setBounds(370,top,800,30);
				data41.setFont(new Font("Osward",Font.BOLD,15));
				add(data41);
				top=top+20;
				
				
			
			}
			//vegatabel show data
			
			JLabel v_item= new JLabel("Item name");
			v_item.setBounds(570,150,800,30);
			v_item.setFont(new Font("Osward",Font.BOLD,15));
			add(v_item);
			
			JLabel v_Quantity= new JLabel("Quantity");
			v_Quantity.setBounds(690,150,800,30);
			v_Quantity.setFont(new Font("Osward",Font.BOLD,15));
			add(v_Quantity);
			
			JLabel v_cost= new JLabel("cost");
			v_cost.setBounds(790,150,800,30);
			v_cost.setFont(new Font("Osward",Font.BOLD,15));
			add(v_cost);
			
			JLabel v_selling= new JLabel("Selling price");
			v_selling.setBounds(860,150,800,30);
			v_selling.setFont(new Font("Osward",Font.BOLD,15));
			add(v_selling);
			int v_top=190;
			while(v_data.next()) {
				
				JLabel data1= new JLabel(v_data.getString(1));
				data1.setBounds(570,v_top,800,30);
				data1.setFont(new Font("Osward",Font.BOLD,15));
				add(data1);
				
				JLabel data2= new JLabel(String.valueOf(v_data.getDouble(3)));
				data2.setBounds(690,v_top,800,30);
				data2.setFont(new Font("Osward",Font.BOLD,15));
				add(data2);
				
	
				JLabel data31= new JLabel(String.valueOf(v_data.getLong(2)));
				data31.setBounds(790,v_top,800,30);
				data31.setFont(new Font("Osward",Font.BOLD,15));
				add(data31);
				
				JLabel data41= new JLabel(String.valueOf(v_data.getInt(4)));
				data41.setBounds(860,v_top,800,30);
				data41.setFont(new Font("Osward",Font.BOLD,15));
				add(data41);
				v_top=v_top+20;
			}
			
			//update section 
			
			JLabel item_= new JLabel("item_name:");
			item_.setBounds(1000,200,800,30);
			item_.setFont(new Font("Osward",Font.BOLD,20));
			add(item_);
			
			item_name= new JTextField(15);
			item_name.setBounds(1120,200,200,30);
			item_name.setFont(new Font("Osward",Font.BOLD,15));
			item_name.addActionListener(this);
			add(item_name);
			
			JLabel type1= new JLabel("Type:");
			type1.setBounds(1000,250,800,30);
			type1.setFont(new Font("Osward",Font.BOLD,20));
			add(type1);
			
			type= new JTextField(15);
			type.setBounds(1120,250,200,30);
			type.setFont(new Font("Osward",Font.BOLD,15));
			type.addActionListener(this);
			add(type);
			
			
			JLabel cost1= new JLabel("cost:");
			cost1.setBounds(1000,300,800,30);
			cost1.setFont(new Font("Osward",Font.BOLD,20));
			add(cost1);
			
			cost_= new JTextField(15);
			cost_.setBounds(1120,300,200,30);
			cost_.setFont(new Font("Osward",Font.BOLD,15));
			cost_.addActionListener(this);
			add(cost_);
			
			
			JLabel quantity1= new JLabel("quantity:");
			quantity1.setBounds(1000,350,800,30);
			quantity1.setFont(new Font("Osward",Font.BOLD,20));
			add(quantity1);
			
			quantity= new JTextField(15);
			quantity.setBounds(1120,350,200,30);
			quantity.setFont(new Font("Osward",Font.BOLD,15));
			quantity.addActionListener(this);
			add(quantity);
			
			JLabel _cost= new JLabel("O-cost:");
			_cost.setBounds(1000,400,800,30);
			_cost.setFont(new Font("Osward",Font.BOLD,20));
			add(_cost);
			
			o_cost= new JTextField(15);
			o_cost.setBounds(1120,400,200,30);
			o_cost.setFont(new Font("Osward",Font.BOLD,15));
			o_cost.addActionListener(this);
			add(o_cost);
			
			update1= new JButton("update");
			update1.setBounds(1350,500,110,30);
			update1.setFont(new Font("Osward",Font.BOLD,20));
			update1.addActionListener(this);
			add(update1);
			
			
			
			setTitle("showdata");
	        setLayout(null);
	        setSize(1500, 1000);
	        setVisible(true);
		}
			
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
		AdminPage p1=new AdminPage();
//		p1.loginpage();
		p1.showdata();
	
	}
	
	void pofitsCal() throws ClassNotFoundException, SQLException {
		
	
		
		JLabel from_date1= new JLabel("From-Date");
		from_date1.setBounds(50,50,800,30);
		from_date1.setFont(new Font("Osward",Font.BOLD,15));
		add(from_date1);
		
		JLabel to_date1= new JLabel("To-Date");
		to_date1.setBounds(50,100,800,30);
		to_date1.setFont(new Font("Osward",Font.BOLD,15));
		add(to_date1);
		
		from_date= new JTextField(15);
		from_date .setBounds(150,50,200,30);
		from_date.setFont(new Font("Osward",Font.BOLD,15));
		from_date.addActionListener(this);
		add(from_date);
		
		
		to_date= new JTextField(15);
		to_date .setBounds(150,100,200,30);
		to_date.setFont(new Font("Osward",Font.BOLD,15));
		to_date.addActionListener(this);
		add(to_date);
		

		get= new JButton("get");
		get.setBounds(250,160,110,30);
		get.setFont(new Font("Osward",Font.BOLD,20));
		get.addActionListener(this);
		add(get);
		
		
		
		setTitle("showdata");
        setLayout(null);
        setSize(500, 500);
        setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() == login) {
	        if (username.getText().equals("murali") && password.getText().equals("123456789")) {
	            setVisible(false); // Hide the current login window
	            AdminPage data = new AdminPage();
	            try {
	                data.showdata(); // Show the admin data page
	            } catch (ClassNotFoundException | SQLException e1) {
	                e1.printStackTrace();
	            }
	        } else {
	            JOptionPane.showMessageDialog(null, "Please enter valid admin username and password");
	        }
	    } else if (e.getSource() == update1) {
	        if (item_name.getText().equals("") || cost_.getText().equals("") || quantity.getText().equals("") ||
	                type.getText().equals("") || o_cost.getText().equals("")) {
	            JOptionPane.showMessageDialog(null, "Fill all the details");
	        } else {
	            Connection c2 = null;
	            try {
	                c2 = Database_connection.main_1();
	            } catch (ClassNotFoundException | SQLException e1) {
	                e1.printStackTrace();
	            }

	            String fruit_update = "UPDATE fruits SET cost=?, quantity=?,original_cost=? WHERE friut_name=?";
	            String veg_update = "UPDATE vegatables SET cost=?, quantity=?,original_cost=? WHERE veg_name=?";

	            try {
	                PreparedStatement ps;
	                if (type.getText().equalsIgnoreCase("fruits") ) {
	                    ps = c2.prepareStatement(fruit_update);
	                } else if (type.getText().equalsIgnoreCase("vegatabels")) {
	                    ps = c2.prepareStatement(veg_update);
	                } else {
	                    JOptionPane.showMessageDialog(null, "Invalid Type! Use 'fruits' or 'vegatabels'.");
	                    return;
	                }

	                ps.setString(1, cost_.getText());
	                ps.setString(2, quantity.getText());
	                ps.setString(3, o_cost.getText());
	                ps.setString(4, item_name.getText());

	                int rowsUpdated = ps.executeUpdate();

	                if (rowsUpdated > 0) {
	                    JOptionPane.showMessageDialog(null, "Item updated successfully!");

	                    // Refresh the window
	                    dispose();  // Close current window
	                    AdminPage newPage = new AdminPage();
	                    newPage.showdata(); // Reload the updated data
	                } else {
	                    JOptionPane.showMessageDialog(null, "Update failed! Item not found.");
	                }
	            } catch (SQLException e1) {
	                e1.printStackTrace();
	            } catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	        }
	    }else if(e.getSource()==back) {
	    	Login_info lo= new Login_info();
	    	lo.setdata();
	    	setVisible(false);
	    	
	    }else if(e.getSource()==showProfit) {
	    	
	    	AdminPage n1= new AdminPage();
	    	try {
				n1.pofitsCal();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    }else if(e.getSource()==get) {
	    	System.out.println("hello  this is get ");
	    	
			try {
				System.out.println("hello  this is get ");
				Connection c1 = Database_connection.main_1();
			
			String fruitsP="select  sum(b.cost-f.original_cost)  from bill as "
					+ "b inner join fruits as f on b.item=f.friut_name";
			String vegP="select  sum(b.cost-f.original_cost) "
					+ "from bill as b inner join vegatables as f on"
					+ " b.item=f.veg_name";
			int fru_pro=0,veg_pro=0;
			System.out.println("hello  this is get-3");
			PreparedStatement ps= c1.prepareStatement(fruitsP);
			ResultSet rs=ps.executeQuery();
			System.out.println("hello  this is get-4");
			while(rs.next()) {
				fru_pro=rs.getInt(1);
			}
			System.out.println("hello  this is get ");
			PreparedStatement ps1= c1.prepareStatement(vegP);
			ResultSet rs1=ps1.executeQuery();
			while(rs1.next()) {
				veg_pro=rs1.getInt(1);
				
			}
			System.out.println("hello  this is get ");
			System.out.println("veg-profit:"+veg_pro);
			
			JLabel addtext= new JLabel("hellooo");
			addtext.setBounds(300,100,800,30);
			addtext.setFont(new Font("Osward",Font.BOLD,20));
			add(addtext);
			
			}catch(Exception s) {
				
			}
	    }
	    	
	}


}
