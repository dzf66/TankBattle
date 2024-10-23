/*
 * Created by JFormDesigner on Thu Feb 15 10:34:38 CST 2024
 */

package com.Windows;

import java.awt.*;
import javax.swing.*;
import javax.swing.GroupLayout;

/**
 * @author 30433
 */
public class MenuFrame extends JFrame {
    public MenuFrame() {
        initComponents();
        MyListener myListener=new MyListener(this);
        btStart.addMouseListener(myListener);
        btCreate.addMouseListener(myListener);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(520,410);
        this.setVisible(true);
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents  @formatter:off
        panel1 = new JPanel();
        label1 = new JLabel();
        label2 = new JLabel();
        label3 = new JLabel();
        textname = new JTextField();
        textpassword = new JTextField();
        btStart = new JButton();
        btCreate = new JButton();
        idWarning = new JLabel();
        pwWarning = new JLabel();
        label4 = new JLabel();

        //======== this ========
        setTitle("\u5766\u514b\u5927\u6218(\u8d85\u7ea7\u7b80\u6613\u7248)");
        var contentPane = getContentPane();

        //======== panel1 ========
        {

            //---- label1 ----
            label1.setText("text");
            label1.setIcon(new ImageIcon(getClass().getResource("/menu.jpg")));

            //---- label2 ----
            label2.setText("\u7528\u6237\u540d");

            //---- label3 ----
            label3.setText("\u5bc6\u7801 ");

            //---- btStart ----
            btStart.setText("\u767b\u5f55\u5e76\u5f00\u59cb\u6e38\u620f");
            btStart.setForeground(Color.blue);
            btStart.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 18));

            //---- btCreate ----
            btCreate.setForeground(Color.blue);
            btCreate.setText("\u6ce8\u518c\u8d26\u53f7");
            btCreate.setFont(new Font("\u65b9\u6b63\u8212\u4f53", Font.PLAIN, 18));

            //---- idWarning ----
            idWarning.setText("id\u4e0d\u80fd\u4e3a\u7a7a\uff01");
            idWarning.setForeground(Color.red);
            idWarning.setVisible(false);

            //---- pwWarning ----
            pwWarning.setText("\u5bc6\u7801\u4e0d\u80fd\u4e3a\u7a7a");
            pwWarning.setForeground(Color.red);
            pwWarning.setVisible(false);

            GroupLayout panel1Layout = new GroupLayout(panel1);
            panel1.setLayout(panel1Layout);
            panel1Layout.setHorizontalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btStart, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btCreate, GroupLayout.PREFERRED_SIZE, 154, GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33))
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.TRAILING)
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label3, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(textpassword, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE))
                            .addGroup(panel1Layout.createSequentialGroup()
                                .addComponent(label2, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panel1Layout.createParallelGroup()
                                    .addComponent(textname, GroupLayout.PREFERRED_SIZE, 305, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(label1, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup()
                            .addComponent(pwWarning, GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE)
                            .addComponent(idWarning, GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
                        .addContainerGap())
            );
            panel1Layout.setVerticalGroup(
                panel1Layout.createParallelGroup()
                    .addGroup(panel1Layout.createSequentialGroup()
                        .addComponent(label1, GroupLayout.PREFERRED_SIZE, 203, GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label2, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textname, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(idWarning))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(label3, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
                            .addComponent(textpassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(pwWarning))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(btStart, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
                            .addComponent(btCreate, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)))
            );
        }

        //---- label4 ----
        label4.setText("     \u8fd9\u5c31\u662f\u4e00\u4e2a\u7b80\u5355\u7684\u5c04\u51fb\u6e38\u620f\uff0c\u6ca1\u6709\u5173\u5361\uff0c\u6ca1\u6709\u57fa\u5730\uff0c\u628a\u4eba\u673a\u5766\u514b\u6253\u5b8c\u5c31\u7ed3\u675f\u4e86\u3002");

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addComponent(panel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(GroupLayout.Alignment.TRAILING, contentPaneLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(label4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(label4, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)
                    .addComponent(panel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents  @formatter:on
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables  @formatter:off
    private JPanel panel1;
    private JLabel label1;
    private JLabel label2;
    private JLabel label3;
    private JTextField textname;
    private JTextField textpassword;
    private JButton btStart;
    private JButton btCreate;
    private JLabel idWarning;
    private JLabel pwWarning;
    private JLabel label4;
    // JFormDesigner - End of variables declaration  //GEN-END:variables  @formatter:on
    public JTextField getTextname() {
        return textname;
    }

    public JTextField getTextpassword() {
        return textpassword;
    }

    public JLabel getIdWarning() {
        return idWarning;
    }

    public JLabel getPwWarning() {
        return pwWarning;
    }

}
