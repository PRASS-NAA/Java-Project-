package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class C_login extends JFrame {
    Container c;
    JLabel lable1, lable2, lable3, imglabel;
    JPanel leftPanel, rightPanel;
    JTextField user;
    JPasswordField password;
    JButton btn, btn2;

    String pass1;


     C_login(){
        setTitle("Cashier Login Form");
        setVisible(true);
        setSize(666, 350);
        setLocation(200, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        c = getContentPane();
        c.setLayout(null);

        Color customColor_1 = new Color(0, 102, 102);
        Color customColor_2 =  new Color(192, 192, 192);
        Color customColor_3 = new Color(54, 69, 79);
        Color customColor_4 = new Color(255, 253, 208);




        leftPanel = new JPanel();
        leftPanel.setBackground(customColor_3);
        leftPanel.setBounds(0, 0, 325, 350);
        c.add(leftPanel);

        rightPanel = new JPanel();
        rightPanel.setBackground(customColor_4);
        rightPanel.setBounds(325, 0, getWidth() / 2, getHeight());
        rightPanel.setLayout(null);
        c.add(rightPanel);

        imglabel = new JLabel();
        imglabel.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Main_System\\Billing_System\\src\\main\\java\\org\\example\\login.png").getImage().getScaledInstance(275, 300, Image.SCALE_SMOOTH)));
        imglabel.setBounds(0, 0, 250, 100);
        leftPanel.add(imglabel);


        lable3 = new JLabel("CASHIER ");
        rightPanel.add(lable3);
        lable3.setBounds(160, 60, 500, 20);
        //lable3.setForeground(new Color(13, 13, 13)); // Set font color to blue


        lable1 = new JLabel("username:");
        lable2 = new JLabel("password:");
        rightPanel.add(lable1);
        rightPanel.add(lable2);
        lable1.setBounds(50, 80, 100, 100);
        lable2.setBounds(50, 165, 100, 20);


        user = new JTextField();
        user.setBounds(450, 120, 120, 20);
        c.add(user);

        password = new JPasswordField();

        password.setBounds(450, 165, 120, 20);
        c.add(password);

        btn = new JButton("login");
        rightPanel.add(btn);
        btn.setBounds(145, 210, 70, 20);
        btn.setBackground(new Color(236, 232, 229));
        btn.addActionListener(pageChangeListener);

        btn2 = new JButton("Admin ? click here");
        rightPanel.add(btn2);
        btn2.setBounds(90, 250, 175, 20);
        btn2.setBackground(customColor_4);
        btn2.setBorder(null);
        btn2.addActionListener(submitListener);
    }
    ActionListener submitListener = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new login().setVisible(true);
        }
    };

    ActionListener pageChangeListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String usr = user.getText();
            char pass[] = password.getPassword();
            String passs = new String(pass);

            MessageDigest hashpass = null;
            try {
                hashpass = MessageDigest.getInstance("SHA-256");
            } catch (NoSuchAlgorithmException ex) {
                throw new RuntimeException(ex);
            }
            hashpass.update(passs.getBytes());
            byte[] hashvalue = hashpass.digest();
            StringBuilder res = new StringBuilder();
            for(int i = 0;i<hashvalue.length;i++){
                res.append(Integer.toHexString(0xFF & hashvalue[i]));
            }
            pass1 = new String(res);

            try {
                if(login(usr,pass1))
                {
                    System.out.println("Succesfull Login");
                    setVisible(false);
                    new billing().setVisible(true);
                }
                else {
                    JOptionPane.showMessageDialog(null,"INVALID CREDENTIALS !!");
                    System.out.println("Unsuccesfull Login");
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    };

    public static boolean login(String usrname,String Password) throws SQLException
    {
        String query = "select id from cashier where username = ? and password = ?;";
        try (Connection con = DbConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query)) {
            pst.setString(1, usrname);
            pst.setString(2, Password);

            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    return true;
                }
            }
        }
        return false;
    }
}
