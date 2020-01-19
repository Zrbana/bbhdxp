package method;
import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class Ticket extends JFrame{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    JTable table=new JTable();
    private Connection conn;
    public Ticket(String user){
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new BorderLayout(0, 0));
        setContentPane(contentPane);
        this.setBounds(600,300,800,300);
        this.setTitle("已购车次");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        try{
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=火车售票系统","sa","w12621058");
            table=query(user);
        }   catch(Exception e){e.printStackTrace();}
        this.getContentPane().add(new JScrollPane(table));
        this.setVisible(true);
        try{conn.close();}catch(Exception e){e.printStackTrace();}
    }

    public JTable query(String user) throws SQLException{
        DefaultTableModel tbmode=new DefaultTableModel();
        String sql="SELECT * FROM "+user+"订购信息";
        try{
            Statement Stmt=conn.createStatement();
            ResultSet rs= Stmt.executeQuery(sql);
            ResultSetMetaData meta=rs.getMetaData();
            int colcount=4;
            for(int i=1;i<=colcount;i++)
                tbmode.addColumn(meta.getColumnName(i));
            Object[]col=new Object[colcount];
            while(rs.next()){
                for(int j=1;j<=col.length;j++)
                    col[j-1]=rs.getString(j);
                tbmode.addRow(col);
            }
            rs.close();
            Stmt.close();
        }catch(Exception e){e.printStackTrace();}
        return new JTable(tbmode);
    }
}
