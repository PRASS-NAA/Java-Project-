package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

class delprod extends JFrame {

    JPanel panel,panel2;
    JLabel id,title,name,pid,quan,exp,title1,batchid,price;
    JLabel batch;
    JTextField p_id,batchbox;
    JButton search,back,refresh,delete;

    delprod()
    {
        setTitle("Delete Product");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);
        getContentPane().setBackground(new Color(115, 93, 165));

        title = new JLabel("Delete Product");
        add(title);
        title.setBounds(633,23, 200, 100);
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

        /*back = new JButton("<<");
        panel.add(back);
        back.setBounds(5, 10, 70, 20);
        back.setBackground(new Color(146, 146, 146));*/

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
                add(panel2);
                panel2.setLayout(null);
                panel2.setBounds(450, 310, 550, 430);
                panel2.setBackground(new Color(211, 197, 229));

                title1 = new JLabel("Product Details");
                panel2.add(title1);
                title1.setBounds(203, 25, 500, 20);
                title1.setFont(new Font("Ariel", Font.BOLD, 18));

                pid = new JLabel("Product ID:                      " + rs.getInt("product_id"));
                panel2.add(pid);
                pid.setFont(new Font("Ariel", Font.BOLD, 14));
                pid.setBounds(50,80,300,20);
                pid.setForeground(Color.black);

                name = new JLabel("Product Name:                      " + rs.getString("prodname"));
                panel2.add(name);
                name.setFont(new Font("Ariel", Font.BOLD, 14));
                name.setBounds(50,130,300,20);
                name.setForeground(Color.black);

                quan = new JLabel("Quantity:                      " + rs.getInt("quantity"));
                panel2.add(quan);
                quan.setFont(new Font("Ariel", Font.BOLD, 14));
                quan.setBounds(50,180,300,20);
                quan.setForeground(Color.black);

                price = new JLabel("Price:                      " + rs.getInt("price"));
                panel2.add(price);
                price.setFont(new Font("Ariel", Font.BOLD, 14));
                price.setBounds(50,230,300,20);
                price.setForeground(Color.black);

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

                delete = new JButton("DELETE");
                panel2.add(delete);
                delete.setBounds(235, 380, 83, 20);
                delete.setBackground(new Color(115, 93, 165));


                delete.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String query = "delete from products where batch_id = ? and product_id = ?;";
                        try(Connection con = DbConnection.getConnection();)
                        {
                            PreparedStatement pst = con.prepareStatement(query);
                            pst.setString(1,b_id);
                            pst.setInt(2,Integer.parseInt(p_id.getText()));
                            int rs = pst.executeUpdate();
                            if(rs >0)
                            {
                                JOptionPane.showMessageDialog(null,"PRODUCT DELETED SUCESFULLY");
                            }
                            else {
                                JOptionPane.showMessageDialog(null,"Error while Deleting");

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