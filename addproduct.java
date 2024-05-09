package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.border.Border;

class addproduct extends JFrame {
    JFrame frame;
    JLabel label;
    JPanel panel;
    JLabel head, usr, pass, quan,price,batchid,expdate;
    JTextField proid,proname,proquan,proprice,probatch,proexp;
    JButton but1, back, change, change1;
    Border border;

    LocalDate date;

    addproduct() {
        frame =new JFrame("add product");
        frame.setTitle("Add Product");

        frame.setExtendedState(MAXIMIZED_BOTH);

        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

        label = new JLabel();
        label.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Main_System\\Billing_System\\src\\main\\java\\org\\example\\bg.jpg").getImage().getScaledInstance(1550, 900, Image.SCALE_SMOOTH)));
        frame.setContentPane(label);
        frame.setLayout(null);
        frame.setVisible(true);

        head = new JLabel("ADD PRODUCT");
        frame.add(head);
        head.setBounds(657,20, 250, 100);
        head.setForeground(new Color(55,55,55));
        head.setFont(new Font("Ariel", Font.BOLD, 28));

        panel = new JPanel();
        frame.add(panel);
        panel.setBounds(585, 110, 340, 710);
        panel.setBackground(new Color(55,55,55));
        panel.setLayout(null);
        panel.setVisible(true);

        usr = new JLabel("Product ID");
        panel.add(usr);
        usr.setBounds(40, 0, 200, 100);
        usr.setFont(new Font("Ariel", Font.PLAIN, 14));
        usr.setForeground(new Color(182, 223, 248));


        border = BorderFactory.createLineBorder(new Color(55,55,55), 2);

        proid = new JTextField();
        panel.add(proid);
        proid.setBounds(35, 75, 250, 25);
        proid.setBackground(new Color(182, 223, 248));
        proid.setBorder(border);

        pass = new JLabel("Product name");
        panel.add(pass);
        pass.setBounds(40, 100, 200, 100);
        pass.setFont(new Font("Ariel", Font.PLAIN, 14));
        pass.setForeground(new Color(182, 223, 248));


        proname = new JTextField();
        panel.add(proname);
        proname.setBounds(35, 180, 250, 25);
        proname.setBackground(new Color(182, 223, 248));
        proname.setBorder(border);

        quan = new JLabel("Quantity");
        panel.add(quan);
        quan.setBounds(40, 200, 200, 100);
        quan.setFont(new Font("Ariel", Font.PLAIN, 14));
        quan.setForeground(new Color(182, 223, 248));


        proquan = new JTextField();
        panel.add(proquan);
        proquan.setBounds(35, 280, 250, 25);
        proquan.setBackground(new Color(182, 223, 248));
        proquan.setBorder(border);

        price = new JLabel("Price");
        panel.add(price);
        price.setBounds(40, 300, 200, 100);
        price.setForeground(new Color(182, 223, 248));
        price.setFont(new Font("Ariel", Font.PLAIN, 14));

        proprice = new JTextField();
        panel.add(proprice);
        proprice.setBounds(35, 380, 250, 25);
        proprice.setBackground(new Color(182, 223, 248));
        proprice.setBorder(border);

        batchid = new JLabel("Batch Id");
        panel.add(batchid);
        batchid.setBounds(40, 400, 200, 100);
        batchid.setForeground(new Color(182, 223, 248));
        batchid.setFont(new Font("Ariel", Font.PLAIN, 14));

        probatch = new JTextField();
        panel.add(probatch);
        probatch.setBounds(35, 480, 250, 25);
        probatch.setBackground(new Color(182, 223, 248));
        probatch.setBorder(border);

        expdate = new JLabel("Expiry Date");
        panel.add(expdate);
        expdate.setForeground(new Color(182, 223, 248));
        expdate.setBounds(40, 500, 200, 100);
        expdate.setFont(new Font("Ariel", Font.PLAIN, 14));

        proexp = new JTextField();
        panel.add(proexp);
        proexp.setBounds(35, 580, 250, 25);
        proexp.setBackground(new Color(182, 223, 248));
        proexp.setBorder(border);

        back = new JButton("<<");
        panel.add(back);
        back.setBounds(5, 10, 70, 20);
        back.setBackground(new Color(182, 223, 248));
        back.addActionListener(goback);


        but1 = new JButton("ADD");
        panel.add(but1);
        but1.setBounds(120, 650, 100, 40);
        but1.setBackground(new Color(182, 223, 248));

        but1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                int p_id = Integer.parseInt(proid.getText());
                String batch_id = probatch.getText();
                int p_quan = Integer.parseInt(proquan.getText());
                int p_price = Integer.parseInt(proprice.getText());
                String p_name = proname.getText();
                String p_exp = proexp.getText();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                date = LocalDate.parse(p_exp, formatter);

                System.out.println(p_id);
                System.out.println(batch_id);
                System.out.println(p_quan);
                System.out.println(p_price);
                System.out.println(p_name);
                System.out.println(p_exp);


                try
                {
                    if(proid.getText().isEmpty() || probatch.getText().isEmpty() || proquan.getText().isEmpty() || proprice.getText().isEmpty() || proname.getText().isEmpty() || proexp.getText().isEmpty())
                    {
                        JOptionPane.showMessageDialog(null,"NOT ALL FIELDS ARE ENTERED","ERROR X",JOptionPane.ERROR_MESSAGE);
                    }
                    else{
                        int jes= JOptionPane.showConfirmDialog(null,"DO U WANT TO ADD THE PRODUCT ?","YES",JOptionPane.DEFAULT_OPTION);
                        if(jes==0){
                            if(insertprod(p_id,batch_id,p_quan,p_price,p_name,date))
                            {
                                JOptionPane.showMessageDialog(null,"Product Added Successfully ! ");
                            }
                            else {
                                JOptionPane.showMessageDialog(null,"Error (check the batch and product id's) ! ");
                            }}}
                }catch (SQLException E)
                {
                    JOptionPane.showMessageDialog(null,"Error in adding the product to DataBase ! ");
                }
            }
        });
    }
    ActionListener goback = new ActionListener(){
        public void actionPerformed(ActionEvent e) {

            frame.setVisible(false);
            new AdminHome().setVisible(true);
        }
    };

    public boolean insertprod(int p_id,String batch_id,int p_quan,int p_price,String p_name,LocalDate date) throws SQLException
    {
        try(Connection con = DbConnection.getConnection();)
        {
            String query = "insert into products(batch_id,product_id,prodname,price,quantity,expiry) values(?,?,?,?,?,?);";

            PreparedStatement pst = con.prepareStatement(query);

            pst.setString(1,batch_id);
            pst.setInt(2,p_id);
            pst.setString(3,p_name);
            pst.setInt(4,p_price);
            pst.setInt(5,p_quan);
            pst.setDate(6, Date.valueOf(date));

            try
            {
                int rs = pst.executeUpdate();

                if(rs > 0)
                {
                    return true;
                }
            }catch (SQLException E)
            {
                System.out.println(E.getMessage());
            }
        }
        return false;
    }
}