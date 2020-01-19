package Frame;

import method.Delete;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DeleteFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    public DeleteFrame(String user) {
        setTitle("\u9000\u7968\u7CFB\u7EDF");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(650, 300, 450, 300);
        contentPane = new JPanel();
        contentPane.setForeground(Color.BLUE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel label = new JLabel("\u8F93\u5165\u60A8\u8981\u9000\u7968\u7684\u8F66\u6B21\u53F7");
        label.setForeground(Color.BLUE);
        label.setFont(new Font("微软雅黑", Font.BOLD, 30));

        textField = new JTextField();
        textField.setColumns(10);

        JButton btnNewButton = new JButton("\u9000\u7968");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a=textField.getText();
                new Delete(a,user);
            }
        });
        btnNewButton.setFont(new Font("微软雅黑", Font.BOLD, 15));
        btnNewButton.setForeground(Color.BLUE);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
                                .addContainerGap(109, Short.MAX_VALUE)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 211, GroupLayout.PREFERRED_SIZE)
                                .addGap(102))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(177)
                                .addComponent(btnNewButton)
                                .addContainerGap(182, Short.MAX_VALUE))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(61)
                                .addComponent(label)
                                .addContainerGap(61, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(29)
                                .addComponent(label)
                                .addGap(55)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(btnNewButton)
                                .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }

}
