package com.frameWork;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.project.Database_connection;

public class GetDataDB {
	Connection c;	
	Map<String,Long> item_cost= new HashMap<>();
	Map<String,Integer> item_qunatity= new HashMap<>();
	List<Long>cost=new ArrayList<>();
	
	int orderid;
	
	
	
	public void getdata() {

		
		String queru1="select * from fruits";
		try {
			
			c=Database_connection.main_1();
			PreparedStatement statment=c.prepareStatement(queru1);
			ResultSet rs= statment.executeQuery();
			SetData s1= new SetData();
			while(rs.next()) {
				item_cost.put(rs.getString(1),rs.getLong(2));
				item_qunatity.put(rs.getString(1), rs.getInt(3));
				cost.add(rs.getLong(2));
			}
	
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public void getvegdata() {

		
		String queru1="select * from vegatables";
		try {
			
			c=Database_connection.main_1();
			PreparedStatement statment=c.prepareStatement(queru1);
			ResultSet rs= statment.executeQuery();
			SetData s1= new SetData();
			while(rs.next()) {
				System.out.println(rs.getString(1)+" "+rs.getLong(2)+" "+rs.getInt(3));
				item_cost.put(rs.getString(1),rs.getLong(2));
				item_qunatity.put(rs.getString(1), rs.getInt(3));
				cost.add(rs.getLong(2));
				
			}	
			System.out.println(item_cost.size());
			System.out.println(item_qunatity.size());
			System.out.println();
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public int insertDataDb(String name, String number, List<String> item, List<Double> quantity, List<Long> costList) 
        throws SQLException, ClassNotFoundException {
    int orderid = 0;
    long total = 0;
    int n = 0;

    String query1 = "INSERT INTO bill VALUES (?, ?, ?, ?, ?)";
    String query2 = "INSERT INTO custmoer_info(cname, cphone_number) VALUES(?, ?)";
    String query3 = "SELECT order_id FROM custmoer_info WHERE cname = ? AND cphone_number = ?";
    String query4 = "UPDATE fruits SET quantity = ? WHERE friut_name = ?";
    String query5 = "INSERT INTO finally_bill VALUES(?, ?, ?, ?)";

    c = Database_connection.main_1();

    // Insert customer info
    PreparedStatement p = c.prepareStatement(query2);
    p.setString(1, name);
    p.setString(2, number);
    int b = p.executeUpdate();

    if (b == 1) {
        PreparedStatement p2 = c.prepareStatement(query3);
        p2.setString(1, name);
        p2.setString(2, number);
        ResultSet rs = p2.executeQuery();
        while (rs.next()) {
            orderid = rs.getInt(1);
        }
    }

    // Get current date
    java.sql.Date currentDate = new java.sql.Date(System.currentTimeMillis());

    for (int i = 0; i < item.size(); i++) {
        // Insert into bill table
        PreparedStatement insert = c.prepareStatement(query1);
        insert.setInt(1, orderid);
        insert.setString(2, item.get(i));
        insert.setString(3, String.valueOf(quantity.get(i)));
        insert.setString(4, String.valueOf(costList.get(i)));
        insert.setDate(5, currentDate);  // Insert current date

        total += costList.get(i);
        n = insert.executeUpdate();

        // Update fruit quantity
        PreparedStatement data = c.prepareStatement("SELECT quantity FROM fruits WHERE friut_name = ?");
        data.setString(1, item.get(i));
        ResultSet update_data = data.executeQuery();

        while (update_data.next()) {
            PreparedStatement update = c.prepareStatement("UPDATE fruits SET quantity = ? WHERE friut_name = ?");
            update.setLong(1, (long) (update_data.getLong(1) - quantity.get(i)));
            update.setString(2, item.get(i));
            update.executeUpdate();
        }
    }

    // Insert into final bill with date
    if (n >= 1) {
        PreparedStatement insertdata = c.prepareStatement(query5);
        insertdata.setInt(1, orderid);
        insertdata.setString(2, name);
        insertdata.setLong(3, total);
        insertdata.setDate(4, currentDate);  // Insert current date
        insertdata.executeUpdate();
    }

    return n;
}

	
	public void admindata() throws ClassNotFoundException, SQLException {
		c=Database_connection.main_1();
		String fruitslist="select * from fruits";
		String vegList="select * from vegatables";
		
		PreparedStatement ps=c.prepareStatement(fruitslist);
		PreparedStatement update_rs=c.prepareStatement(vegList);
		ResultSet rs= ps.executeQuery();
		while(rs.next()) {
			
			
		}
		ResultSet rs2 = ps.executeQuery();
		while (rs2.next()) {
			System.out.println(rs2.getString(1)+" " +rs2.getLong(2)+" "+rs2.getDouble(3)+" "+rs2.getInt(4));
			
		}	
	}
	
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		GetDataDB g= new GetDataDB();
//		g.getdata();
//		g.getvegdata();
		g.admindata();
		
		
	}

}
