
package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


class c_create_account extends JFrame {
    JFrame frame;
    JPanel panel,panel2;
    JLabel title, id,r_id;
    JLabel name,r_name;
    JLabel phone,r_phone,mail;
    JLabel dob,r_dob;
    JLabel r_user ,username,password;
    JPasswordField t_password;

    String p_id;
    String p_user;
    static String encp;
    String p_name,p_password,p_mail;
    String p_dob;
    String p_phone;
    JTextField t_id,t_name,t_phone,t_dob,t_user,t_mail;
    JButton create,refresh,add,back;
    JSeparator separator;



    c_create_account()
    {

        frame=new JFrame("ADD CASHIER");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Main_System\\Billing_System\\src\\main\\java\\org\\example\\bg.jpg").getImage().getScaledInstance(1550, 900, Image.SCALE_SMOOTH)));
        frame.setContentPane(label);

        panel = new JPanel();
        panel.setBounds(212,185,500,450);
        panel.setBackground(new Color(55,55,55));

        title = new JLabel("NEW CASHIER ");
        panel.setLayout(null);
        panel.add(title);
        title.setForeground(new Color(182, 223, 248));
        title.setBounds(200, 13, 500, 20);
        title.setFont(new Font("ariel",Font.BOLD,20));


        username = new JLabel("USER NAME : ");
        panel.setLayout(null);
        panel.add(username);
        username.setForeground(new Color(182, 223, 248));
        username.setBounds(80, 100, 500, 20);

        t_user = new JTextField();
        t_user.setBounds(200, 100, 200, 20);
        panel.add(t_user);
        t_user.setBackground(new Color(182, 223, 248));


        password = new JLabel("PASSWORD : ");
        panel.setLayout(null);
        panel.add(password);
        password.setBounds(80, 150, 500, 20);
        password.setForeground(new Color(182, 223, 248));

        t_password = new JPasswordField();
        t_password.setBounds(200,150,200,20);
        panel.add(t_password);
        t_password.setBackground(new Color(182, 223, 248));

        name = new JLabel("NAME : ");
        panel.setLayout(null);
        panel.add(name);
        name.setBounds(80, 200, 500, 20);
        name.setForeground(new Color(182, 223, 248));

        t_name = new JTextField();
        t_name.setBounds(200, 200, 200, 20);
        panel.add(t_name);
        t_name.setBackground(new Color(182, 223, 248));


        mail = new JLabel("MAIL : ");
        panel.setLayout(null);
        panel.add(mail);
        mail.setBounds(80, 250, 500, 20);
        mail.setForeground(new Color(182, 223, 248));
        t_mail = new JTextField();
        t_mail.setBounds(200, 250, 200, 20);
        panel.add(t_mail);
        t_mail.setBackground(new Color(182, 223, 248));


        phone = new JLabel("PHONE NO : ");
        panel.setLayout(null);
        panel.add(phone);
        phone.setBounds(80, 300, 500, 20);
        phone.setForeground(new Color(182, 223, 248));
        t_phone = new JTextField();
        t_phone.setBounds(200, 300, 200, 20);
        panel.add(t_phone);
        t_phone.setBackground(new Color(182, 223, 248));

        create = new JButton("CREATE");
        panel.add(create);
        create.setBounds(320, 375, 83, 20);
        create.setBackground(new Color(182,223,248));
        create.addActionListener(submitListener);

        refresh = new JButton("CLEAR");
        panel.add(refresh);
        refresh.setBounds(200, 375, 90, 20);
        refresh.setBackground(new Color(182,223,248));
        refresh.addActionListener(refreshListener);

        separator = new JSeparator(JSeparator.VERTICAL);
        separator.setBounds(775, 0, 1, 375);
        separator.setBackground(new Color(182,223,248));
        panel.add(separator);

        back = new JButton("<<");
        panel.add(back);
        back.setBounds(5, 10, 70, 20);
        back.setBackground(new Color(182,223,248));
        back.addActionListener(backp);
        frame.add(panel);

    }


    ActionListener backp = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            setVisible(false);
            new AdminHome().setVisible(true);
        }
    };




    ActionListener submitListener = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            p_user = t_user.getText();
            p_name = t_name.getText();
            p_mail = t_mail.getText();
            p_phone = t_phone.getText();
            if(p_user.isEmpty() || p_name.isEmpty() || p_mail.isEmpty() || p_phone.isEmpty())
            {
                JOptionPane.showMessageDialog(null,"NOT ALL FIELDS ARE ENTERED","ERROR X",JOptionPane.ERROR_MESSAGE);
            }
            else{
                panel2 = new JPanel();
                panel2.setLayout(null);
                panel2.setBounds(850,185,400,450);
                panel2.setBackground(new Color(55, 55, 55));
                frame.add(panel2);

                title = new JLabel(" CASHIER DETAIL ");
                panel2.setLayout(null);
                panel2.add(title);
                title.setBounds(150, 25, 500, 20);
                title.setForeground(new Color(182, 223, 248));
                char[] pass = t_password.getPassword();
                p_password = new String(pass);


                MessageDigest hashpass = null;
                try {
                    hashpass = MessageDigest.getInstance("SHA-256");
                } catch (NoSuchAlgorithmException ex) {
                    throw new RuntimeException(ex);
                }
                hashpass.update(p_password.getBytes());
                byte[] hashvalue = hashpass.digest();
                StringBuilder res = new StringBuilder();
                for(int i = 0;i<hashvalue.length;i++){
                    res.append(Integer.toHexString(0xFF & hashvalue[i]));
                }
                encp = new String(res);

                r_user = new JLabel("USERNAME :      " + p_user);
                panel2.add(r_user);
                r_user.setBounds(100, 100, 200, 20);
                r_user.setFont(new Font("ariel",Font.BOLD,15));
                r_user.setForeground(new Color(182, 223, 248));
                r_name = new JLabel("NAME :             " + p_name);
                r_name.setFont(new Font("ariel",Font.BOLD,15));

                panel2.add(r_name);
                r_name.setBounds(100, 150, 200, 20);
                r_name.setForeground(new Color(182, 223, 248));
                mail = new JLabel("MAIL :               " + p_mail);
                panel2.add(mail);
                mail.setBounds(100, 200, 200, 20);
                mail.setFont(new Font("ariel",Font.BOLD,15));
                mail.setForeground(new Color(182, 223, 248));
                r_phone = new JLabel("PHONE NO :    " + p_phone);
                panel2.add(r_phone);
                r_phone.setBounds(100, 250,200,20);
                r_phone.setFont(new Font("ariel",Font.BOLD,15));
                r_phone.setForeground(new Color(182, 223, 248));
                add = new JButton("ADD");
                panel2.add(add);
                add.setBounds(160, 350, 83, 20);
                add.addActionListener(addsql);
                add.setBackground(new Color(182, 223, 248));

                frame.revalidate();
                frame.repaint();

            }}
    };

    ActionListener addsql = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try
            {
                int jes= JOptionPane.showConfirmDialog(null,"DO U WANT TO ADD CASHIER ?","?",JOptionPane.DEFAULT_OPTION);
                if(jes==0){
                    insertValue(p_user,p_password,p_name,p_mail,p_phone);
                    JOptionPane.showMessageDialog(null,"cashier added!","cashier",JOptionPane.INFORMATION_MESSAGE);
                    frame.setVisible(false);
                    new AdminHome().setVisible(true);
                }

            }catch (SQLException a)
            {
                System.out.println(a.getMessage());
            }

        }
    };

    ActionListener refreshListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Clear text fields
            t_user.setText("");
            t_password.setText("");
            //t_id.setText("");
            t_name.setText("");
            t_dob.setText("");
            t_phone.setText("");

            // Clear result labels
            if (panel2 != null) {
                panel2.removeAll();
                frame.remove(panel2);
                frame.revalidate();
                frame.repaint();
                // Refresh the panel to reflect the changes
            }
        }
    };

    static boolean insertValue(String p_user,String p_password,String p_name,String mail,String p_phone) throws SQLException
    {
        String query = "insert into cashier(username,cname,phoneno,password,mail) values (?,?,?,?,?);";

        try(Connection con = DbConnection.getConnection()){
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,p_user);
            pst.setString(4,encp);
            pst.setString(2,p_name);
            pst.setString(5, mail);
            pst.setString(3,p_phone);

            try
            {
                int rs = pst.executeUpdate();
                if(rs > 0)
                {
                    return true;
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}