 package human.resource.management.system;

 import java.sql.*;
 
public class Conn  {
    
    Connection c;
    Statement s;
    
    public Conn () {
        try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    c = DriverManager.getConnection("jdbc:mysql:///humanresourcemanagementsystem","root","iamthankful@123");
    s = c.createStatement();
        }catch (Exception e){
            e.printStackTrace();
        }
    
}

}
