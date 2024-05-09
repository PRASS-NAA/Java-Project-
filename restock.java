package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class restock extends JFrame {

    JPanel panel,panel2;
    JLabel id,title,name,pid,quan,exp,title1,batchid,price;
    JLabel batch;
    JTextField p_id,batchbox,p_quan,p_price;
    JButton search,back,refresh,update;

    int existing;

    restock()
    {
        setTitle("UPDATE PRODUCT PAGE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(new Color(115, 93, 165));

        title = new JLabel("Update Product");
        add(title);
        title.setBounds(633,23, 500, 100);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Ariel", Font.BOLD, 28));

        panel = new JPanel();
        add(panel);
        panel.setBounds(450,100,550,200);
        panel.setBackground(new Color(211,197,229));
        panel.setLayout(null);

        id = new JLabel("Product ID");
        panel.add(id);
        id.setBounds(80, 80, 500, 20);

        batch = new JLabel("Batch ID");
        panel.add(batch);
        batch.setBounds(80, 140, 500, 20);

        p_id = new JTextField();
        panel.add(p_id);
        p_id.setBounds(175, 80, 200, 20);

        batchbox = new JTextField();
        panel.add(batchbox);
        batchbox.setBounds(175, 140, 200, 20);

        search = new JButton("SEARCH");
        panel.add(search);
        search.setBounds(425, 80, 85, 20);
        search.setBackground(new Color(115, 93, 165));
        search.addActionListener(submitListener);

        refresh = new JButton("CLEAR");
        panel.add(refresh);
        refresh.setBounds(425, 140, 85, 20);
        refresh.setBackground(new Color(115, 93, 165));
        refresh.addActionListener(refreshListener);

        back = new JButton("<<");
        panel.add(back);
        back.setBounds(5, 10, 70, 20);
        back.setBackground(new Color(146, 146, 146));
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

    ActionListener goback = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new AdminHome().setVisible(true);
        }
    };



    void selectprod(int id,String b_id) throws SQLException
    {
        String query = "select * from products where batch_id = ? and product_id = ?;";

        try(Connection con = DbConnection.getConnection())
        {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,b_id);
            pst.setInt(2,id);

            ResultSet rs = pst.executeQuery();

            if(rs.next())
            {
                panel2 = new JPanel();
                add(panel2);
                panel2.setLayout(null);
                panel2.setBounds(450, 310, 550, 430);
                panel2.setBackground(new Color(211, 197, 229));

                title1 = new JLabel("Product Details");
                panel2.add(title1);
                title1.setBounds(203, 25, 500, 20);
                title1.setFont(new Font("Ariel", Font.BOLD, 18));

                pid = new JLabel("Product ID:                      " +  rs.getInt("product_id"));
                panel2.add(pid);
                pid.setFont(new Font("Ariel", Font.BOLD, 14));
                pid.setBounds(50,80,300,20);
                pid.setForeground(Color.black);

                name = new JLabel("Product Name:            " + rs.getString("prodname"));
                panel2.add(name);
                name.setFont(new Font("Ariel", Font.BOLD, 14));
                name.setBounds(50,130,600,20);
                name.setForeground(Color.black);

                quan = new JLabel("Quantity: " );
                panel2.add(quan);
                quan.setFont(new Font("Ariel", Font.BOLD, 14));
                quan.setBounds(50,180,100,20);
                quan.setForeground(Color.black);

                p_quan = new JTextField(new String(String.valueOf(rs.getInt("quantity"))));
                existing = Integer.parseInt(new String(String.valueOf(rs.getInt("quantity"))));
                panel2.add(p_quan);
                p_quan.setBounds(160,180,60,20);

                price = new JLabel("Price: ");
                panel2.add(price);
                price.setFont(new Font("Ariel", Font.BOLD, 14));
                price.setBounds(50,230,200,20);
                price.setForeground(Color.black);

                p_price = new JTextField(new String(String.valueOf(rs.getInt("Price"))));
                panel2.add(p_price);
                p_price.setBounds(160,230,60,20);

                batchid = new JLabel("Batch ID:                      " + rs.getString("batch_id"));
                panel2.add(batchid);
                batchid.setFont(new Font("Ariel", Font.BOLD, 14));
                batchid.setBounds(50,280,300,20);
                batchid.setForeground(Color.black);

                exp = new JLabel("Expiry Date:                      " + rs.getDate("expiry"));
                panel2.add(exp);
                exp.setFont(new Font("Ariel", Font.BOLD, 14));
                exp.setBounds(50,330,300,20);
                exp.setForeground(Color.black);

                update = new JButton("UPDATE");
                panel2.add(update);
                update.setBounds(235, 380, 83, 20);
                update.setBackground(new Color(115, 93, 165));


                update.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String query = " update products set quantity = ?,price = ? where batch_id = ? and product_id = ?;";
                        try(Connection con = DbConnection.getConnection();)
                        {
                            PreparedStatement pst = con.prepareStatement(query);
                            pst.setInt(1,Integer.parseInt(p_quan.getText()));
                            pst.setInt(2,Integer.parseInt(p_price.getText()));
                            pst.setString(3,batchbox.getText());
                            pst.setInt(4,Integer.parseInt(p_id.getText()));
                            int rs = pst.executeUpdate();
                            if(rs >0)
                            {
                                JOptionPane.showMessageDialog(null,"PRODUCT UPDATING SUCESFULLY");
                            }
                            else {
                                JOptionPane.showMessageDialog(null,"Error while Updating");

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