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

    JLabel label;
    JPanel panel;
    JPanel panel1;
    JLabel head, usr, pass, quan,price,batchid,expdate;
    JTextField proid,proname,proquan,proprice,probatch,proexp;
    JButton but1, but2, change, change1;
    Border border;

    LocalDate date;

    addproduct() {
        setTitle("Add Product");

        setExtendedState(MAXIMIZED_BOTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(115, 93, 165));
        //label = new JLabel();
        //label.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\manoj\\OneDrive\\Documents\\Java\\intellij\\deptui\\src\\main\\java\\pexels-picturemechaniq-1749303.jpg").getImage().getScaledInstance(1550,900, Image.SCALE_SMOOTH)));

        setLayout(null);
        //setContentPane(label);
        setVisible(true);

        head = new JLabel("Add Product");
        add(head);
        head.setBounds(657,20, 200, 100);
        head.setForeground(Color.BLACK);
        head.setFont(new Font("Ariel", Font.BOLD, 28));

        panel = new JPanel();
        add(panel);
        panel.setBounds(565, 110, 340, 710);
        panel.setBackground(new Color(211,197,229));
        panel.setLayout(null);
        panel.setVisible(true);

        usr = new JLabel("Product ID");
        panel.add(usr);
        usr.setBounds(40, 0, 200, 100);
        usr.setForeground(Color.BLACK);
        usr.setFont(new Font("Ariel", Font.PLAIN, 14));

        border = BorderFactory.createLineBorder(new Color(211,197,229), 2);

        proid = new JTextField();
        panel.add(proid);
        proid.setBounds(35, 75, 250, 25);
        proid.setBackground(new Color(115, 93, 165));
        proid.setForeground(Color.white);
        proid.setBorder(border);

        pass = new JLabel("Product name");
        panel.add(pass);
        pass.setBounds(40, 100, 200, 100);
        pass.setForeground(Color.BLACK);
        pass.setFont(new Font("Ariel", Font.PLAIN, 14));

        proname = new JTextField();
        panel.add(proname);
        proname.setBounds(35, 180, 250, 25);
        proname.setBackground(new Color(115, 93, 165));
        proname.setForeground(Color.white);
        proname.setBorder(border);

        quan = new JLabel("Quantity");
        panel.add(quan);
        quan.setBounds(40, 200, 200, 100);
        quan.setForeground(Color.BLACK);
        quan.setFont(new Font("Ariel", Font.PLAIN, 14));

        proquan = new JTextField();
        panel.add(proquan);
        proquan.setBounds(35, 280, 250, 25);
        proquan.setBackground(new Color(115, 93, 165));
        proquan.setForeground(Color.white);
        proquan.setBorder(border);

        price = new JLabel("Price");
        panel.add(price);
        price.setBounds(40, 300, 200, 100);
        price.setForeground(Color.BLACK);
        price.setFont(new Font("Ariel", Font.PLAIN, 14));

        proprice = new JTextField();
        panel.add(proprice);
        proprice.setBounds(35, 380, 250, 25);
        proprice.setBackground(new Color(115, 93, 165));
        proprice.setForeground(Color.white);
        proprice.setBorder(border);

        batchid = new JLabel("Batch Id");
        panel.add(batchid);
        batchid.setBounds(40, 400, 200, 100);
        batchid.setForeground(Color.BLACK);
        batchid.setFont(new Font("Ariel", Font.PLAIN, 14));

        probatch = new JTextField();
        panel.add(probatch);
        probatch.setBounds(35, 480, 250, 25);
        probatch.setBackground(new Color(115, 93, 165));
        probatch.setForeground(Color.white);
        probatch.setBorder(border);

        expdate = new JLabel("Expiry Date");
        panel.add(expdate);
        expdate.setBounds(40, 500, 200, 100);
        expdate.setForeground(Color.BLACK);
        expdate.setFont(new Font("Ariel", Font.PLAIN, 14));

        proexp = new JTextField();
        panel.add(proexp);
        proexp.setBounds(35, 580, 250, 25);
        proexp.setBackground(new Color(115, 93, 165));
        proexp.setForeground(Color.white);
        proexp.setBorder(border);

        but1 = new JButton("ADD");
        panel.add(but1);
        but1.setBounds(120, 650, 100, 40);
        but1.setBackground(new Color(115, 93, 165));

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
                    if(insertprod(p_id,batch_id,p_quan,p_price,p_name,date))
                    {
                        JOptionPane.showMessageDialog(null,"Product Added Sucessfully ! ");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Error (check the batch and product id's) ! ");
                    }
                }catch (SQLException E)
                {
                    JOptionPane.showMessageDialog(null,"Error adding product to DB ! ");
                }
            }
        });
    }

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