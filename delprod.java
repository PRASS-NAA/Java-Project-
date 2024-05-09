package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class delprod extends JFrame {
    JFrame frame;
    JPanel panel,panel2;
    JLabel id,title,name,pid,quan,exp,title1,batchid,price;
    JLabel batch;
    JTextField p_id,batchbox;
    JButton search,back,refresh,delete;

    delprod()
    {
        frame = new JFrame("Delete Product");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Main_System\\Billing_System\\src\\main\\java\\org\\example\\bg.jpg").getImage().getScaledInstance(1550, 900, Image.SCALE_SMOOTH)));
        frame.setContentPane(label);
        title = new JLabel("DELETE PRODUCT");
        frame.add(title);
        title.setBounds(594,23, 400, 100);
        title.setForeground(new Color(55,55,55));
        title.setFont(new Font("Ariel", Font.BOLD, 28));

        panel = new JPanel();
        frame.add(panel);
        panel.setBounds(450,100,550,200);
        panel.setBackground(new Color(55,55,55));
        panel.setLayout(null);

        id = new JLabel("PRODUCT ID");
        panel.add(id);
        id.setBounds(80, 80, 500, 20);
        id.setForeground(new Color(182, 223, 248));


        batch = new JLabel("BATCH ID");
        panel.add(batch);
        batch.setBounds(80, 140, 500, 20);
        batch.setForeground(new Color(182, 223, 248));


        p_id = new JTextField();
        panel.add(p_id);
        p_id.setBounds(175, 80, 200, 20);
        p_id.setBackground(new Color(182, 223, 248));

        batchbox = new JTextField();
        panel.add(batchbox);
        batchbox.setBounds(175, 140, 200, 20);
        batchbox.setBackground(new Color(182, 223, 248));

        search = new JButton("SEARCH");
        panel.add(search);
        search.setBounds(425, 80, 85, 20);
        search.setBackground(new Color(182, 223, 248));
        search.addActionListener(submitListener);

        refresh = new JButton("CLEAR");
        panel.add(refresh);
        refresh.setBounds(425, 140, 85, 20);
        refresh.setBackground(new Color(182, 223, 248));
        refresh.addActionListener(refreshListener);

        back = new JButton("<<");
        panel.add(back);
        back.setBounds(5, 10, 70, 20);
        back.setBackground(new Color(182, 223, 248));
        back.addActionListener(goback);
    }

    ActionListener submitListener = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            if(p_id.getText().isEmpty() || batchbox.getText().isEmpty()){
                JOptionPane.showMessageDialog(null,"Provide ID");
            }
            else {
                int id = Integer.parseInt(p_id.getText());
                String b_id = batchbox.getText();
                try{
                    selectprod(id,b_id);
                }catch (SQLException E)
                {
                    System.out.println(E.getMessage());
                }
            }
        }
    };
    ActionListener goback = new ActionListener(){
        public void actionPerformed(ActionEvent e) {

            frame.setVisible(false);
            new AdminHome().setVisible(true);
        }
    };
    ActionListener refreshListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            p_id.setText("");
            batchbox.setText("");

            if (panel2 != null) {
                panel2.removeAll();
                remove(panel2);
                revalidate();
                repaint();
            }
        }
    };

    void selectprod(int id,String b_id) throws SQLException
    {
        String query = "select * from products where batch_id = ? and product_id = ?;";

        try(Connection con = DbConnection.getConnection())
        {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(2,id);
            pst.setString(1,b_id);

            ResultSet rs = pst.executeQuery();

            if(rs.next())
            {
                panel2 = new JPanel();
                frame.add(panel2);
                panel2.setLayout(null);
                panel2.setBounds(450, 310, 550, 430);
                panel2.setBackground(new Color(55, 55, 55));

                title1 = new JLabel("Product Details");
                title1.setForeground(new Color(182, 223, 248));
                panel2.add(title1);
                title1.setBounds(203, 25, 500, 20);
                title1.setFont(new Font("Ariel", Font.BOLD, 18));

                pid = new JLabel("Product ID:                         " + rs.getInt("product_id"));
                panel2.add(pid);
                pid.setFont(new Font("Ariel", Font.BOLD, 14));
                pid.setBounds(50,80,300,20);
                pid.setForeground(new Color(182, 223, 248));

                name = new JLabel("Product Name:                   " + rs.getString("prodname"));
                panel2.add(name);
                name.setFont(new Font("Ariel", Font.BOLD, 14));
                name.setBounds(50,130,300,20);
                name.setForeground(Color.black);
                name.setForeground(new Color(182, 223, 248));


                quan = new JLabel("Quantity:                             " + rs.getInt("quantity"));
                panel2.add(quan);
                quan.setFont(new Font("Ariel", Font.BOLD, 14));
                quan.setBounds(50,180,300,20);
                quan.setForeground(Color.black);
                quan.setForeground(new Color(182, 223, 248));


                price = new JLabel("Price:                                  " + rs.getInt("price"));
                panel2.add(price);
                price.setFont(new Font("Ariel", Font.BOLD, 14));
                price.setBounds(50,230,300,20);
                price.setForeground(Color.black);
                price.setForeground(new Color(182, 223, 248));


                batchid = new JLabel("Batch ID:                             " + rs.getString("batch_id"));
                panel2.add(batchid);
                batchid.setFont(new Font("Ariel", Font.BOLD, 14));
                batchid.setBounds(50,280,300,20);
                batchid.setForeground(new Color(182, 223, 248));


                exp = new JLabel("Expiry Date:                      " + rs.getDate("expiry"));
                panel2.add(exp);
                exp.setFont(new Font("Ariel", Font.BOLD, 14));
                exp.setBounds(50,330,300,20);
                exp.setForeground(new Color(182, 223, 248));


                delete = new JButton("DELETE");
                panel2.add(delete);
                delete.setBounds(235, 380, 83, 20);
                delete.setBackground(new Color(182, 223, 248));


                delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try(Connection con = DbConnection.getConnection();)
                        {
                            int jes = JOptionPane.showConfirmDialog(null, "DO U WANT TO PRODUCT ?", "u want to delete?", JOptionPane.YES_NO_OPTION);
                            if (jes == JOptionPane.YES_OPTION) {
                                String query = "delete from products where batch_id = ? and product_id = ?;";
                                PreparedStatement pst = con.prepareStatement(query);
                                pst.setString(1, b_id);
                                pst.setInt(2, Integer.parseInt(p_id.getText()));
                                int rs = pst.executeUpdate();
                                if (rs > 0) {
                                    JOptionPane.showMessageDialog(null, "PRODUCT DELETED SUCCESSFULLY");
                                } else {
                                    JOptionPane.showMessageDialog(null, "ERROR WHILE DELETING");

                                }
                                frame.setVisible(false);
                                new AdminHome().setVisible(true);
                            }
                        }catch (SQLException E)
                        {
                            System.out.println(E.getMessage());
                        }

                    }
                });
            }
            else
            {
                JOptionPane.showMessageDialog(null,"PRODUCT DOESN'T EXIST!!");
            }
        }
    }
}