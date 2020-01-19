package Frame;

import Access.Purchase;

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

public class PurchaseFrame extends JFrame {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;

    /**
     * Create the frame.
     */
    public PurchaseFrame(String user) {
        setTitle("\u8D2D\u4E70");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(650, 300, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        JLabel label = new JLabel("\u8F93\u5165\u60A8\u8981\u8D2D\u4E70\u7684\u8F66\u6B21\u53F7");
        label.setForeground(Color.BLUE);
        label.setFont(new Font("微软雅黑", Font.BOLD, 30));

        textField = new JTextField();
        textField.setColumns(10);

        JButton button = new JButton("\u8D2D\u7968");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String a=textField.getText();
                new Purchase(a,user);
            }
        });
        button.setForeground(Color.BLUE);
        button.setFont(new Font("微软雅黑", Font.BOLD, 15));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(176)
                                                .addComponent(button))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(104)
                                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, 205, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_contentPane.createSequentialGroup()
                                                .addGap(61)
                                                .addComponent(label)))
                                .addContainerGap(61, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(32)
                                .addComponent(label)
                                .addGap(52)
                                .addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                                .addComponent(button)
                                .addContainerGap())
        );
        contentPane.setLayout(gl_contentPane);
    }
}
