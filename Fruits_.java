package com.frameWork;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Fruits_ extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton back,removeButton, vegatables ,getBill,help;
    JLabel orderLabel, itemLabel, quantityLabel,title;
    static  Map<String, Double> fruitQuantities = new HashMap<>();
    static ArrayList<JLabel> displayLabels = new ArrayList<>();
    static Set<String> items_names=new HashSet<>();
    List<Long> fruitCosts= new ArrayList<>();
    GetDataDB g1= new GetDataDB();
    MyBil b1=new MyBil();
    public void getDataDb() {
    	g1.getdata();
    	fruitCosts=g1.cost;	
    }

    int y = 80;
    String name;
    String phone;
    String[] fruits = {
        "Apple", "Banana", "Orange", "Mango", "Pineapple", "Grapes",
        "Strawberry", "Watermelon", "Papaya", "Kiwi", "Peach", "Pear",
        "Plum", "Cherry", "Blueberry", "Blackberry", "Pomegranate",
        "Coconut", "Lemon", "Avocado"
    };

    String[] imagePaths = {
        "D:/workspace/advancejavaworkspace/New folder/fruits/apple.jpeg", "D:/workspace/advancejavaworkspace/New folder/fruits/Banana.jpeg", "D:/workspace/advancejavaworkspace/New folder/fruits/Orange.jpeg",
        "D:/workspace/advancejavaworkspace/New folder/fruits/mango.jpeg", "D:/workspace/advancejavaworkspace/New folder/fruits/Pineapple.jpeg", "D:/workspace/advancejavaworkspace/New folder/fruits/Grapes.jpeg",
        "D:/workspace/advancejavaworkspace/New folder/fruits/Strawberry.jpeg", "D:/workspace/advancejavaworkspace/New folder/fruits/Watermelon.jpeg", "D:/workspace/advancejavaworkspace/New folder/fruits/Papaya.jpeg",
        "D:/workspace/advancejavaworkspace/New folder/fruits/Kiwi.jpeg", "D:/workspace/advancejavaworkspace/New folder/fruits/Peach.jpeg", "D:/workspace/advancejavaworkspace/New folder/fruits/Pear.jpeg",
        "D:/workspace/advancejavaworkspace/New folder/fruits/Plum.jpeg", "D:/workspace/advancejavaworkspace/New folder/fruits/Cherry.jpeg", "D:/workspace/advancejavaworkspace/New folder/fruits/Blackberry.jpeg",
        "D:/workspace/advancejavaworkspace/New folder/fruits/Blueberry.jpeg", "D:/workspace/advancejavaworkspace/New folder/fruits/Pomegranate.jpeg", "D:/workspace/advancejavaworkspace/New folder/fruits/Coconut.jpeg",
        "D:/workspace/advancejavaworkspace/New folder/fruits/Lemon.jpeg", "D:/workspace/advancejavaworkspace/New folder/fruits/Avocado.jpeg"
    };

   
   public void setnandn(Pojo p) {
	  this. name =p.getName();
	  this.phone=p.getPhone();
	   
   }
    
    public void displayContent() {
    	setTitle("Fruits");
        setLayout(null);
        setSize(1500, 900);
       
        getContentPane().setBackground(Color.white);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize fruit quantities
        for (String fruit : fruits) {
            fruitQuantities.put(fruit, 0.0);
        }

        // Add vertical line at the left
        LinePanel linePanel = new LinePanel();
        linePanel.setBounds(200, 0, 50, 1000);
        add(linePanel);
        
        //title of the page
        title = new JLabel("!!FRUITS!!");
        title.setBounds(700,40,800,40);
        title.setFont(new Font("Osward", Font.BOLD, 50));
        add(title);
        
        
       // note point 
        JLabel note = new JLabel("*Note:!!the order limit is 5 at a time!!");
        note.setBounds(300,100,1000,20);
        note.setFont(new Font("Osward",Font.BOLD,15));
        note.setForeground(Color.red);
        add(note);

        // Add label to display the order
        orderLabel = new JLabel("Your Order");
        orderLabel.setFont(new Font("Osward", Font.BOLD, 20));
        orderLabel.setBounds(60, 10, 800, 30);
        orderLabel.setForeground(Color.RED);
        add(orderLabel);

        itemLabel = new JLabel("Items");
        itemLabel.setFont(new Font("Osward", Font.BOLD, 16));
        itemLabel.setBounds(50, 50, 800, 30);
        itemLabel.setForeground(Color.GREEN);
        add(itemLabel);

        quantityLabel = new JLabel("Quantity");
        quantityLabel.setFont(new Font("Osward", Font.BOLD, 16));
        quantityLabel.setBounds(130, 50, 800, 30);
        quantityLabel.setForeground(Color.GREEN);
        add(quantityLabel);

        // Add back button
        back = new JButton("Back");
        back.setFont(new Font("Osward", Font.BOLD, 14));
        back.setBounds(1400, 10, 80, 30);
        back.addActionListener(this);
        add(back);
        
        vegatables=new JButton("vegatables");
        vegatables.setBounds(30,600,150,30);
        vegatables.setFont(new Font("Osward",Font.BOLD,14));
        vegatables.addActionListener(this);
        add(vegatables);
        
        
        getBill=new JButton("Get-Bill");
        getBill.setBounds(30,650,150,30);
        getBill.setFont(new Font("Osward",Font.BOLD,14));
        getBill.addActionListener(this);
        add(getBill);
        
        help=new JButton("Help");
        help.setBounds(30,700,150,30);
        help.setFont(new Font("Osward",Font.BOLD,14));
        add(help);

        // Add images with buttons
        addImagesAndButtons();
       
        setVisible(true);
    }

    private void addImagesAndButtons() {
        int x = 300, y = 150;
        int imageWidth =80, imageHeight =80;
        int buttonWidth = 80, buttonHeight = 20;
        int horizontalSpacing = 40, verticalSpacing = 50;
        getDataDb();
        for (int i = 0; i < fruits.length; i++) {
        	
            // Add image
            ImageIcon icon = new ImageIcon(imagePaths[i]);
            Image img = icon.getImage().getScaledInstance(imageWidth, imageHeight, Image.SCALE_SMOOTH);
            JLabel imgLabel = new JLabel(new ImageIcon(img));
            imgLabel.setBounds(x, y, imageWidth, imageHeight);
            add(imgLabel);

            // Add "Add" button
            JButton addButton = new JButton("Add");
            addButton.setFont(new Font("Osward", Font.PLAIN, 10));
            addButton.setBounds(x, y + imageHeight + 5, buttonWidth, buttonHeight);
            addButton.setActionCommand("Add:" + fruits[i]); // Use "Add:fruitName" as the action command
            addButton.addActionListener(this);
            add(addButton);

            // Add "Remove" button
            removeButton = new JButton("Remove");
            removeButton.setFont(new Font("Osward", Font.PLAIN, 12));
            removeButton.setBounds(x + buttonWidth + 10, y + imageHeight + 5, buttonWidth, buttonHeight);
            removeButton.setActionCommand("Remove:" + fruits[i]); // Use "Remove:fruitName" as the action command
            removeButton.addActionListener(this);
            add(removeButton);

            // Add cost label
            JLabel costLabel = new JLabel("Cost: ₹" + fruitCosts.get(i));
            costLabel.setFont(new Font("Osward", Font.PLAIN, 12));
            costLabel.setBounds(x, y + imageHeight + 35, 150, 20);
            costLabel.setForeground(Color.BLUE);
            add(costLabel);

            // Adjust position for next image and buttons
            x += imageWidth + horizontalSpacing + buttonWidth + 10;
            if ((i + 1) % 5 == 0) { // Move to the next row after 5 images
                x = 300;
                y += imageHeight + buttonHeight + verticalSpacing + 20;
            }
        }
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    	
        if (e.getSource() == back) {
            new Login_info();
            setVisible(false);
        }else if(e.getSource()==getBill) {
    
        	 b1.displayData(); 
        	 b1.BilCal();
    		setVisible(false);
    		
    	}else if(e.getSource()==vegatables){
    		Vegatables_info v1= new Vegatables_info();
    		v1.displayContent();
    		setVisible(false);
    	}else{
        	
            String action = e.getActionCommand();
            String[] parts = action.split(":");
            String command = parts[0];
            String fruitName = parts[1];
            
            if (command.equals("Add")) {
            	if(items_names.size()<5) {
                double updatedQuantity = fruitQuantities.get(fruitName) + 0.5;
                fruitQuantities.put(fruitName, updatedQuantity);
                items_names.add(fruitName);
                // Check if the label for the fruit already exists
                boolean labelExists = false;
                for (JLabel label : displayLabels) {
                    if (label.getText().startsWith(fruitName)) {
                        label.setText(fruitName + "     -     " + updatedQuantity + " kg");
                        labelExists = true;
                        break;
                    }
                }

                // If the label doesn't exist, create a new one
                if (!labelExists) {
                    JLabel newLabel = new JLabel(fruitName + " - " + updatedQuantity + " kg");
                    newLabel.setFont(new Font("Osward", Font.BOLD, 14));
                    newLabel.setBounds(50, y, 800, 30);
                    newLabel.setForeground(Color.GREEN);
                    add(newLabel);
                    displayLabels.add(newLabel);
                    
                    y += 40; // Update y position for the next fruit
                    
                }
            }else {
            	JOptionPane.showMessageDialog(null, "your limit is upto 5 only!!");
            }
                
                
                

                // Refresh the UI to display the updated label
                revalidate();
                repaint();
            } else if (command.equals("Remove")) {
                fruitQuantities.put(fruitName, 0.0);
                items_names.remove(fruitName);

                // Remove the label for the fruit
                JLabel labelToRemove = null;
                for (JLabel label : displayLabels) {
                    if (label.getText().startsWith(fruitName)) {
                        labelToRemove = label;
                        break;
                    }
                }

                if (labelToRemove != null) {
                    displayLabels.remove(labelToRemove);
                    remove(labelToRemove);
                    
                    //update the spaces from the 
                    if(displayLabels.isEmpty()) {
                    	y=80;
                    removeButton.setEnabled(false);
                    	
                    }else {
                    	removeButton.setEnabled(true);
                    }

                    // Refresh the UI to reflect the removal
                    revalidate();
                    repaint();
                }
            }
        
        }
        System.out.println(fruitQuantities);
    }

    public static void main(String[] args) {
      
    	Fruits_ f1=new Fruits_();
    	f1.displayContent();
    	
        
    }
}

// Panel to draw a vertical line
class LinePanel extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.drawLine(25, 0, 25, getHeight());
    }
}
