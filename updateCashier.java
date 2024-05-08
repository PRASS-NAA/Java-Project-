package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class updateCashier extends JFrame {
    JFrame frame;
    JPanel panel,panel2,panel3;
    JLabel id,title,r_name,r_phone,r_mail,delhead;
    JTextField t_id,t_name,t_phone,t_mail;
    JButton search,back,refresh,update;
    JLabel r_user;


    updateCashier()
    {

        frame=new JFrame("UPDATE CASHIER");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(145, 253, 208));

        panel = new JPanel();
        panel.setBounds(450,100,550,200);
        panel.setBackground(new Color(146, 146, 146));


        panel3 = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel3,BoxLayout.Y_AXIS);
        panel3.setLayout(boxLayout);
        panel3.setBackground(new Color(146, 146, 146));
        panel3.setBounds(1200, 100, 250, 200);
        frame.add(panel3);

        delhead = new JLabel("EXISTING CASHIER'S");
        panel3.add(delhead);
        delhead.setAlignmentX(Component.CENTER_ALIGNMENT);
        try
        {
            displaycahier();
        }catch(SQLException E)
        {
            System.out.println(E.getMessage());
        }

        title = new JLabel("UPDATE CASHIER ");
        panel.setLayout(null);
        panel.add(title);
        title.setBounds(225, 25, 500, 20);

        id = new JLabel("ID : ");
        panel.setLayout(null);
        panel.add(id);
        id.setBounds(80, 100, 500, 20);
        t_id = new JTextField();
        t_id.setBounds(175, 100, 200, 20);
        panel.add(t_id);

        search = new JButton("SEARCH");
        panel.add(search);
        search.setBounds(425, 100, 85, 20);
        search.setBackground(new Color(236, 232, 229));
        search.addActionListener(submitListener);

        refresh = new JButton("CLEAR");
        panel.add(refresh);
        refresh.setBounds(425, 150, 85, 20);
        refresh.setBackground(new Color(236, 232, 229));
        refresh.addActionListener(refreshListener);

        back = new JButton("<<");
        panel.add(back);
        back.setBounds(5, 10, 70, 20);
        back.setBackground(new Color(146, 146, 146));
        back.addActionListener(goback);

        frame.add(panel);

    }
    ActionListener submitListener = new ActionListener(){
        public void actionPerformed(ActionEvent e) {

            int id = Integer.parseInt(t_id.getText());

            try{
                selectemp(id);
            }catch (SQLException E)
            {
                System.out.println(E.getMessage());
            }
        }
    };
    ActionListener goback = new ActionListener(){
        public void actionPerformed(ActionEvent e) {

            frame.setVisible(false);
            new AdminHome().setVisible(true);
        }
    };
    void selectemp(int id) throws SQLException
    {
        String query = "select * from cashier where id = ? ;";

        try(Connection con = DbConnection.getConnection())
        {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,id);

            try(ResultSet rs = pst.executeQuery())
            {
                if(rs.next())
                {
                    panel2 = new JPanel();
                    panel2.setLayout(null);
                    frame.add(panel2);
                    panel2.setBounds(450,301,550,375);
                    panel2.setBackground(new Color(146, 146, 146));


                    title = new JLabel(" CASHIER DETAIL ");
                    panel2.setLayout(null);
                    panel2.add(title);
                    title.setBounds(225, 25, 500, 20);

                    r_user = new JLabel("username : " );
                    panel2.add(r_user);
                    r_user.setBounds(100, 100, 150, 20);

                    JTextField c_unm = new JTextField(rs.getString(1));
                    panel2.add(c_unm);
                    c_unm.setBounds(260,100,150,20);

                    r_mail = new JLabel("MAIL : ");
                    panel2.add(r_mail);
                    r_mail.setBounds(100, 150, 150, 20);

                    JTextField c_mail = new JTextField(rs.getString(6));
                    panel2.add(c_mail);
                    c_mail.setBounds(260,150,150,20);

                    r_phone = new JLabel("PHONE NO : " );
                    panel2.add(r_phone);
                    r_phone.setBounds(100, 250, 200, 20);

                    JTextField c_phn = new JTextField(rs.getString(3));
                    panel2.add(c_phn);
                    c_phn.setBounds(260,250,150,20);

                    update = new JButton("UPDATE");
                    panel2.add(update);
                    update.setBounds(235, 330, 83, 20);
                    update.setBackground(new Color(236, 232, 229));

                    update.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String query1 = "update cashier set username = ? where id = ?;";
                            String query2 = "update cashier set mail = ? where id = ?;";
                            String query3 = "update cashier set phoneno = ? where id = ?;";
                            try
                            {
                                Connection con2 = DbConnection.getConnection();
                                PreparedStatement pst = con2.prepareStatement(query1);
                                pst.setString(1,c_unm.getText());
                                pst.setInt(2,id);
                                pst.executeUpdate();

                                PreparedStatement pst2 = con2.prepareStatement(query2);
                                pst2.setString(1, c_mail.getText());
                                pst2.setInt(2,id);
                                pst2.executeUpdate();

                                PreparedStatement pst3 = con2.prepareStatement(query3);
                                pst3.setString(1, c_phn.getText());
                                pst3.setInt(2,id);
                                pst3.executeUpdate();


                            }catch (SQLException E)
                            {
                                System.out.println(E.getMessage());
                            }
                        }
                    });

                }
                else {
                    JOptionPane.showMessageDialog(null,"INVALID Cashier!!");
                }
            }catch (Exception E)
            {
                System.out.println(E.getMessage());
            }
        }
    }

    void displaycahier() throws SQLException {
        String query = "select id, cname from cashier;";

        try(Connection con = DbConnection.getConnection())
        {
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while(rs.next())
            {
                int id = rs.getInt(1);
                String cname = rs.getString(2);
                JLabel label = new JLabel(" ID : "+id +"     "+" NAME : "+ cname);
                panel3.add(label);
                label.setAlignmentX(Component.CENTER_ALIGNMENT);
            }
            panel3.revalidate();
            panel3.repaint();
        }catch (SQLException E)
        {
            System.out.println(E.getMessage());
        }
    }


    ActionListener refreshListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            t_id.setText("");

            if (panel2 != null) {
                panel2.removeAll();
                frame.remove(panel2);
                frame.revalidate();
                frame.repaint();

            }
        }
    };

}