  
package human.resource.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

public class RemoveEmployee extends JFrame implements ActionListener {
    
    Choice cEmmpid;
    JButton delete,back;
    
    RemoveEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        
        JLabel labelemmpid = new JLabel("Employee Id");
        labelemmpid.setBounds(50,50,100,30);
        add(labelemmpid);
        
        cEmmpid = new Choice();
        cEmmpid.setBounds(200,50,100,30);
        add(cEmmpid);
        
        try {
            Conn c = new Conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
              cEmmpid.add(rs.getString("emmpid"));
            }
        }catch (Exception e){
          e.printStackTrace();
        }
        
        
        JLabel labelname = new JLabel("Name");
        labelname.setBounds(50,100,100,30);
        add(labelname);
        
        JLabel lblname = new JLabel();
        lblname.setBounds(200,100,100,30);
        add(lblname);
        
        
        JLabel labelphone = new JLabel("Phone");
        labelphone.setBounds(50,150,100,30);
        add(labelphone);
        
        JLabel lblphone = new JLabel();
        lblphone.setBounds(200,150,100,30);
        add(lblphone);
        
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,200,100,30);
        add(labelemail);
        
        JLabel lblemail = new JLabel();
        lblemail.setBounds(200,200,100,30);
        add(lblemail); 
        
        try {
            Conn c = new Conn();
            String query = "select * from employee where emmpid = '"+cEmmpid.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()) {
                lblname.setText(rs.getString("name"));
                 lblphone.setText(rs.getString("phone"));
                  lblemail.setText(rs.getString("email"));
             }
        }catch (Exception e){
          e.printStackTrace();
        }
        
         cEmmpid.addItemListener(new ItemListener()  {
           public void itemStateChanged(ItemEvent ie) {
                try {
                    Conn c = new Conn();
                    String query = "select * from employee where emmpid = '"+cEmmpid.getSelectedItem()+"'";
                     ResultSet rs = c.s.executeQuery(query);
                     while(rs.next()) {
                        lblname.setText(rs.getString("name"));
                         lblphone.setText(rs.getString("phone"));
                         lblemail.setText(rs.getString("email"));
             }
        }catch (Exception e){
          e.printStackTrace();
           }
           } 
    });
        delete = new JButton("Delete");
        delete.setBounds(80,300,100,30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        
        back = new JButton("Back");
        back.setBounds(220,300,100,30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);
        
        setSize(1000,400);
        setLocation(300,150);
        setVisible(true);
}
 
      public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == delete) {
            try{
                Conn c = new Conn();
                String query = "delete from employee where emmpid = '"+cEmmpid.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                
                JOptionPane.showMessageDialog(null,"Employee Information Deleted Successfully");
                setVisible(false);
                new Home();
            }
            catch (Exception e){
                e.printStackTrace();
            }
            
        } else {
            setVisible(false);
            new Home();
        }
      }
     public static void main(String[] args){
         new RemoveEmployee();
     }
    
}
