package Access;

import Frame.RegisterFrame;
import method.FindMain;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class Access extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Access frame = new Access();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public Access() {
        setTitle("\u6B22\u8FCE\u4F7F\u7528\u706B\u8F66\u552E\u7968\u7CFB\u7EDF\uFF01");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(600, 300, 450, 340);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel label = new JLabel("\u7528\u6237\u767B\u5F55");
        label.setFont(new Font("微软雅黑", Font.BOLD, 30));

        JLabel lblNewLabel = new JLabel("\u7528\u6237\u540D");

        JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801");

        textField = new JTextField();
        textField.setColumns(10);

        passwordField = new JPasswordField();


        JButton btnNewButton = new JButton("\u767B\u9646");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String user=textField.getText();
                String pass=new String(passwordField.getPassword());
                try{
                    boolean com=compareWithSql(user,pass);
                    if(com){
                        JOptionPane.showMessageDialog(null, "登录成功！");
                        FindMain t1=new FindMain(user);
                        t1.setVisible(true);
                        dispose();
                    }
                    else{JOptionPane.showMessageDialog(null, "登录失败！");}
                }
                catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 15));

        JButton button = new JButton("\u6CE8\u518C");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                RegisterFrame r=new RegisterFrame();
                r.setVisible(true);
            }
        });
        button.setFont(new Font("微软雅黑", Font.BOLD, 15));


        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(54)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(lblNewLabel)
                                                        .addComponent(lblNewLabel_1))
                                                .addGap(23)
                                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
                                                        .addComponent(passwordField)
                                                        .addComponent(textField, GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                                        .addComponent(btnNewButton)
                                                        .addComponent(button, Alignment.TRAILING)))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(143)
                                                .addComponent(label)))
                                .addContainerGap(135, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(25)
                                .addComponent(label)
                                .addGap(26)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel)
                                        .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(55)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(lblNewLabel_1)
                                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(47)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(btnNewButton)
                                        .addComponent(button))
                                .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }
    boolean compareWithSql(String accountT,String namesT) throws Exception{
        String sql;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        Connection conn=DriverManager.getConnection("jdbc:sqlserver://127.0.0.1:1433;DatabaseName=火车售票系统","sa","w12621058");
        Statement stmt = conn.createStatement();
        sql = "select * from 用户信息";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            String acc = rs.getString(1);
            String names = rs.getString(2);
            if(acc.equals(accountT) && names.equals(namesT)){
                return true;
            }
        }
        return false;
    }
}
