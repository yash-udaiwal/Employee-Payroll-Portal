import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class EmployeeList extends JFrame implements ActionListener{
  
    JTable j1;  JButton b1;
    String h[]={"Emp id","Name","Gender","Address","State","City","Email id","Phone"};
    String lst[][]=new String[20][8];  
    int i=0,j=0;
    
    EmployeeList()
    {
        super("Employees");
        
        setSize(1000,400);
        setLocation(450,200);

        try
        {
            String q="select * from employee";
            conn c1=new conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next())
            {
                lst[i][j++]=rs.getString("id");
                lst[i][j++]=rs.getString("name");
                lst[i][j++]=rs.getString("gender");
                lst[i][j++]=rs.getString("address");
                lst[i][j++]=rs.getString("state");
                lst[i][j++]=rs.getString("city");
                lst[i][j++]=rs.getString("email");
                lst[i][j++]=rs.getString("phone");
                i++;
                j=0;
            }
            j1=new JTable(lst,h); 

        }
        catch(Exception e){}
        
        b1=new JButton("Print");
        add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        
        b1.addActionListener(this);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        try
        {
           j1.print();
        }catch(Exception e){}
    }
     
    public static void main(String s[])
    {
        new EmployeeList().setVisible(true);
    }
}

