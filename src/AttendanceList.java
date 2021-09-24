import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AttendanceList extends JFrame implements ActionListener{
  
    JTable j1; JButton b1;
    String h[]={"Emp id","Date Time","First Half","Second Half"};
    String lst[][]=new String[15][4];  
    int i=0,j=0;
    
    AttendanceList()
    {
        super("Employees Attendence");
        setSize(800,300);
        setLocation(450,150);

        try
        {
            String q="select * from attendence";
            conn c1=new conn();
            ResultSet rs=c1.s.executeQuery(q);
            while(rs.next())
            {
                lst[i][j++]=rs.getString("id");
                lst[i][j++]=rs.getString("date_tm");
                lst[i][j++]=rs.getString("f_half");
                lst[i][j++]=rs.getString("s_half");
                i++;
                j=0;
            }
        
            j1=new JTable(lst,h);

        }catch(Exception e){}
        
        b1=new JButton("Print");
        add(b1,"South");
        JScrollPane s1=new JScrollPane(j1);
        add(s1);
        
        b1.addActionListener(this);
    
    }
    public void actionPerformed(ActionEvent ae){
        try{
            j1.print();
        }catch(Exception e){}
    }
    
    public static void main(String[] args){
        new AttendanceList().setVisible(true);
    }
}
