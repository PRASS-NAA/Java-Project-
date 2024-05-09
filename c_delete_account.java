package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class c_delete_account extends JFrame {
    JFrame frame;
    JPanel panel,panel2,panel3;
    JLabel id,title,r_name,r_phone,r_mail,delhead;
    JTextField t_id,t_name,t_phone,t_mail;
    JButton search,back,refresh,delete;
    JLabel r_user;


    c_delete_account()
    {

        frame=new JFrame("DELETE CASHIER");
        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Main_System\\Billing_System\\src\\main\\java\\org\\example\\bg.jpg").getImage().getScaledInstance(1550, 900, Image.SCALE_SMOOTH)));
        frame.setContentPane(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);

        panel = new JPanel();
        panel.setBounds(450,100,550,200);
        panel.setBackground(new Color(55,55,55));


        panel3 = new JPanel();
        BoxLayout boxLayout = new BoxLayout(panel3,BoxLayout.Y_AXIS);
        panel3.setLayout(boxLayout);
        panel3.setBackground(new Color(55,55,55));
        panel3.setBounds(1200, 100, 250, 200);
        frame.add(panel3);

        delhead = new JLabel("EXISTING CASHIER'S");
        panel3.add(delhead);
        delhead.setAlignmentX(Component.CENTER_ALIGNMENT);
        delhead.setForeground(new Color(182, 223, 248));
        try
        {
            displaycahier();
        }catch(SQLException E)
        {
            System.out.println(E.getMessage());
        }

        title = new JLabel("DELETE CASHIER ");
        panel.setLayout(null);
        panel.add(title);
        title.setBounds(225, 25, 500, 20);
        title.setForeground(new Color(182, 223, 248));

        id = new JLabel("ID : ");
        panel.setLayout(null);
        panel.add(id);
        id.setBounds(80, 100, 500, 20);
        id.setForeground(new Color(182, 223, 248));
        t_id = new JTextField();
        t_id.setBounds(175, 100, 200, 20);
        panel.add(t_id);
        t_id.setBackground(new Color(182, 223, 248));

        search = new JButton("SEARCH");
        panel.add(search);
        search.setBounds(425, 100, 85, 20);
        search.addActionListener(submitListener);
        search.setBackground(new Color(182, 223, 248));

        refresh = new JButton("CLEAR");
        panel.add(refresh);
        refresh.setBounds(425, 150, 85, 20);
        refresh.setBackground(new Color(182, 223, 248));
        refresh.addActionListener(refreshListener);

        back = new JButton("<<");
        panel.add(back);
        back.setBounds(5, 10, 70, 20);
        back.setBackground(new Color(182, 223, 248));
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
                    panel2.setBackground(new Color(55,55,55));


                    title = new JLabel(" CASHIER DETAIL ");
                    panel2.setLayout(null);
                    panel2.add(title);
                    title.setBounds(225, 25, 500, 20);
                    title.setForeground(new Color(182, 223, 248));


                    r_user = new JLabel("USERNAME :      "+rs.getString(1) );
                    panel2.add(r_user);
                    r_user.setBounds(100, 100, 200, 20);
                    r_user.setForeground(new Color(182, 223, 248));

                    r_name = new JLabel("NAME :             "+rs.getString(3));
                    panel2.add(r_name);
                    r_name.setBounds(100, 150, 200, 20);
                    r_name.setForeground(new Color(182, 223, 248));

                    r_mail = new JLabel("MAIL :               "+rs.getString(6));
                    panel2.add(r_mail);
                    r_mail.setBounds(100, 200, 200, 20);
                    r_mail.setForeground(new Color(182, 223, 248));

                    r_phone = new JLabel("PHONE NO :    " +rs.getString(4));
                    panel2.add(r_phone);
                    r_phone.setBounds(100, 250, 200, 20);
                    r_phone.setForeground(new Color(182, 223, 248));

                    delete = new JButton("DELETE");
                    panel2.add(delete);
                    delete.setBounds(235, 330, 83, 20);
                    delete.setBackground(new Color(182, 223, 248));

                    delete.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            String query = "delete from cashier where id = ?;";
                            try {
                                int jes = JOptionPane.showConfirmDialog(null, "DO U WANT TO DELETE CASHIER ?", "u want to delete?", JOptionPane.YES_NO_OPTION);
                                if (jes == JOptionPane.YES_OPTION) {
                                    Connection con2 = DbConnection.getConnection();
                                    PreparedStatement pst = con2.prepareStatement(query);
                                    pst.setInt(1, id);
                                    if (pst.executeUpdate() > 0) {
                                        JOptionPane.showMessageDialog(null, "Cashier Deleted Successfully");
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
                label.setForeground(new Color(182, 223, 248));
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