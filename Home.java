 
package human.resource.management.system;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import com.toedter.calendar.JDateChooser;
 
public class Home extends JFrame implements ActionListener {
     JButton view,add,update,remove,submit, cancel ;
     Choice cemployeeid, ctime;
     JDateChooser dcdate;
     
    Home(){
        setLayout(null);
        
        JLabel heading =new JLabel ("HUMAN RESOURCE MANAGEMENT SYSTEM");
         heading.setBounds(450,20,800,40);
        heading.setFont(new Font("TAHOMA",Font.BOLD,25));
        add(heading);
        
        JLabel leaveapplication  = new JLabel("Apply Leave");
        leaveapplication.setBounds(450,200,300,30);
        leaveapplication.setFont(new Font("TAHOMA",Font.BOLD,25));
        add(leaveapplication);
        
         add= new JButton("Add Employee");
        add.setBounds(450,80,150,40);
        add.addActionListener(this);
        add(add);
        
         view= new JButton("View Employees");
        view.setBounds(620,80,150,40);
        view.addActionListener(this);
        add(view);
        
         update= new JButton("Update Employee");
        update.setBounds(450,140,150,40);
        update.addActionListener(this);
        add(update);
        
         remove= new JButton("Remove Employee");
        remove.setBounds(620,140,150,40);
        remove.addActionListener(this);
        add(remove);
        
        JLabel lblemmpid = new JLabel("Search by employee id");
       lblemmpid.setBounds(450,250,200,20);
       lblemmpid.setFont(new Font("Tahoma", Font.PLAIN, 18));
       add(lblemmpid);
        
        cemployeeid = new Choice();
        cemployeeid.setBounds(700, 250, 200, 20);
        add(cemployeeid);
        
        try{
            Conn c =new Conn();
            ResultSet rs = c.s.executeQuery("select * from Employee");
            while(rs.next()) {
                cemployeeid.add(rs.getString("emmpid"));
            }
                
            }catch (Exception e){
                e.printStackTrace();
        }
        JLabel lbldate= new JLabel("Date");
       lbldate.setBounds(450,300,200,20);
       lbldate.setFont(new Font("Tahoma", Font.PLAIN, 18));
       add(lbldate);
         
        dcdate = new JDateChooser();
        dcdate.setBounds(700, 300, 200, 20);
        add(dcdate);
        
        JLabel lbltime= new JLabel("Time");
       lbltime.setBounds(450,350,200,20);
       lbltime.setFont(new Font("Tahoma", Font.PLAIN, 18));
       add(lbltime);
       
       ctime = new Choice();
       ctime.setBounds(700, 350,200,20);
       ctime.add("Fullday");
       ctime.add("Halfday");
       add(ctime);
       
       submit = new JButton("Submit");
       submit.setBounds(450,450,100,25);
       submit.setBackground(Color.BLACK);
       submit.setForeground(Color.WHITE);
       submit.addActionListener(this);
       submit.setFont(new Font("Tahoma", Font.BOLD, 15));
       add(submit);
       
       cancel = new JButton("Cancel");
       cancel.setBounds(700,450,100,25);
       cancel.setBackground(Color.BLACK);
       cancel.setForeground(Color.WHITE);
       cancel.addActionListener(this);
       cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
       add(cancel);
       
        setSize(1120,630);
        setLocation(250,100);
        setVisible(true);
        
         
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() ==add){ 
        setVisible(false);
        new AddEmployee();
    }else if (ae.getSource()==view){
        setVisible(false);
         new ViewEmployees();
    }  else if (ae.getSource()==update){
        
        setVisible(false);
         new ViewEmployees();
    }else  if (ae.getSource()==remove){
        
        setVisible(false);
        new RemoveEmployee();
    }
        else if (ae.getSource()==submit){
           String emmpid = cemployeeid.getSelectedItem();
           String date = ((JTextField) dcdate.getDateEditor().getUiComponent()).getText();
           String duration = ctime.getSelectedItem();
           
           String query = "insert into employeeleave values('"+emmpid+"','"+date+"', '"+duration+"')";
            
           
           try {
               Conn c = new Conn();
               c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
           }catch (Exception e) {
               e.printStackTrace();
           }
           
    }else{
        setVisible(false);
         
    }
        
    
     
    
    }   
public static void main(String[] args){
new Home();
         }
}