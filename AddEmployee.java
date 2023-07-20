 
package human.resource.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;
 
public class AddEmployee extends JFrame implements ActionListener{
    
    Random ran = new Random();
    int number = ran.nextInt(999999);
    
    JTextField tfname,tfadress,tfemail,tfphone, tfdesignation,tfaadharnumber;
     JLabel lblemmpid;
    JButton add,back;
    AddEmployee(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);  
        
        JLabel heading = new JLabel("Add Employee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("SAN_SERIF",Font.ITALIC ,25));
        add(heading);
        
        JLabel labelname=new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelname);
        
          tfname =new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        
         
        JLabel labeladress=new JLabel("Adress");
        labeladress.setBounds(50,200,150,30);
        labeladress.setFont(new Font("serif",Font.PLAIN, 20));
        add(labeladress);
        
          tfadress =new JTextField();
        tfadress.setBounds(200,200,150,30);
        add(tfadress);
        
        JLabel labelphn=new JLabel("Phone");
        labelphn.setBounds(400,200,150,30);
        labelphn.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelphn);
        
         tfphone =new JTextField();
        tfphone.setBounds(600,200,150,30);
        add(tfphone); 
        
        JLabel labeldeg=new JLabel("Designation");
        labeldeg.setBounds(50,250,150,30);
        labeldeg.setFont(new Font("serif",Font.PLAIN, 20));
        add(labeldeg);
        
          tfdesignation =new JTextField();
        tfdesignation.setBounds(200,250,150,30);
        add(tfdesignation); 
        
        JLabel labelemail=new JLabel("Email");
        labelemail.setBounds(400,250,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelemail);
        
          tfemail =new JTextField();
        tfemail.setBounds(600,250,150,30);
        add(tfemail);
        
        JLabel labelaadhr=new JLabel("Aadhar Number");
        labelaadhr.setBounds(50,350,150,30);
        labelaadhr.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelaadhr);
        
          tfaadharnumber =new JTextField();
        tfaadharnumber.setBounds(200,350,150,30);
        add(tfaadharnumber); 
        
        JLabel labelemmpid=new JLabel("Employee ID");
        labelemmpid.setBounds(50,400,150,30);
        labelemmpid.setFont(new Font("serif",Font.PLAIN, 20));
        add(labelemmpid);
        
          lblemmpid =new JLabel("" + number);
        lblemmpid.setBounds(200,400,150,30);
        add(lblemmpid);
      
           add= new JButton("Add Details");
        add.setBounds(250,550,150,40);
        add.addActionListener(this);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);
        add(add);
        
        
          back= new JButton("Back");
        back.setBounds(450,550,150,40);
        back.addActionListener(this);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        add(back);
        
        
         
        
        
        
        setSize(900,700);
        setLocation(300,50);
        setVisible(true);
               
    
}
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== add){
            String name = tfname.getText();
            String adress = tfadress.getText();

            String email = tfemail.getText();

            String phone = tfphone.getText();

            String designation = tfdesignation.getText();

            String aadharnumber = tfaadharnumber.getText();
             String emmpid = lblemmpid.getText();
             
             try {
                 Conn conn = new Conn();
                 String query = "insert into employee values('"+name+"', '"+phone+"','"+email+"','"+adress+"','"+designation+"','"+emmpid+"' ,'"+aadharnumber+"')";
                 conn.s.executeUpdate(query);
                 JOptionPane.showMessageDialog(null,"Details added successfully");
                 setVisible(false);
                 new AddEmployee();
             } catch (Exception e) {
                 e.printStackTrace();
             }
                                    
            
        }else{
            setVisible(false);
            new Home();
        }
        
    }
            public static void main(String[] args){
new AddEmployee();
         }
}
