package org.example;
import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class login extends JFrame {

    Container c;
    JLabel lable1,lable2,lable3,imglabel;
    JPanel leftPanel, rightPanel;
    JTextField user;
    JPasswordField password;
    JButton btn,btn2;


    login(){
        setTitle("login form");
        setVisible(true);
        setSize(666,350);
        setLocation(200,350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        c=getContentPane();
        c.setLayout(null);

        Color customColor_1 = new Color(221, 208, 200);
        Color customColor_2 = new Color(160, 174, 205);


        leftPanel = new JPanel();
        leftPanel.setBackground(customColor_1);
        leftPanel.setBounds(0, 0, 325, 350);
        c.add(leftPanel);

        rightPanel = new JPanel();
        rightPanel.setBackground(customColor_2);
        rightPanel.setBounds(325 , 0, getWidth() / 2, getHeight());
        rightPanel.setLayout(null);
        c.add(rightPanel);

        imglabel = new JLabel();
        imglabel.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Main_System\\Billing_System\\src\\main\\java\\org\\example\\login.png").getImage().getScaledInstance(275,300, Image.SCALE_SMOOTH)));
        imglabel.setBounds(0,0,250,100);
        leftPanel.add(imglabel);


        lable3 = new JLabel("ADMIN ");
        rightPanel.add(lable3);
        lable3.setBounds(160,60,500,20);
        //lable3.setForeground(new Color(13, 13, 13)); // Set font color to blue


        lable1=new JLabel("username:");
        lable2=new JLabel("password:");
        rightPanel.add(lable1);
        rightPanel.add(lable2);
        lable1.setBounds(50,80,100,100);
        lable2.setBounds(50,165,100,20);


        user= new JTextField();
        user.setBounds(450,120,120,20);


        password = new JPasswordField();

        password.setBounds(450,165,120,20);


        btn = new JButton("login");

        btn.setBounds(145,210,70,20);
        btn.setBackground(new Color(236, 232, 229));
        btn.addActionListener(submitListener);

        btn2 = new JButton("cashier ? click here");

        btn2.setBounds(90,250,175,20);
        btn2.setBackground(customColor_2);
        btn2.setBorder(null);
        btn2.addActionListener(pageChangeListener);

        c.add(user);
        c.add(password);
        rightPanel.add(btn);
        rightPanel.add(btn2);
    }
    ActionListener pageChangeListener = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new C_login().setVisible(true);
        }
    };

    ActionListener submitListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String usr = user.getText();
            String pass = password.getText();
            try {
                if(login(usr,pass))
                {
                    System.out.println("Succesfull Login");
                    setVisible(false);
                    new AdminHome().setVisible(true);
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
        String query = "select id from admin where username = ? and password = ?;";
        try (Connection con = DbConnection.getConnection(); PreparedStatement pst = con.prepareStatement(query)) {
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

