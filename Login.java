import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class Login extends JFrame{

    JLabel l1,l2,l3,imglabel;
    JButton btn;
    JTextField usrname;

    JPasswordField pass;

    JPanel jp;


    Login()
    {
        JPanel jp = new JPanel();
        setTitle("LoginIn");
        setVisible(true);
        setSize(1000,700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        //setResizable(false);

        l3 = new JLabel("Enter Credentials");

        l3.setFont(new Font("MV Boli", Font.PLAIN,40));

        l3.setBounds(600,100,400,40);

        l1 = new JLabel("UserName : ");
        usrname = new JTextField();

        l1.setFont(new Font("Consolas",Font.PLAIN,30));

        l1.setBounds(600,180,250,30);

        usrname.setPreferredSize(new Dimension(190,14));
        usrname.setBounds(780,180,160,30);

        l2 = new JLabel("Password : ");
        l2.setFont(new Font("Consolas",Font.PLAIN,30));
        l2.setBounds(600,230,250,30);

        pass = new JPasswordField();
        pass.setPreferredSize(new Dimension(190,14));
        pass.setBounds(780,230,160,30);

        btn = new JButton("Login");
        btn.setBounds(720,280,70,30);

        ActionListener submitListener = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String usr = usrname.getText();
                String password = pass.getText();
                try {
                    if(login(usr,password))
                    {
                        System.out.println("Succesfull Login");
                        setVisible(false);
                        new Home().setVisible(true);
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

        jp.setLayout(null);
        imglabel = new JLabel();
        imglabel.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Billing_System\\src\\logo.png").getImage().getScaledInstance(300,400, Image.SCALE_SMOOTH)));
        imglabel.setBounds(100,90,400,400);

        jp.setLayout(null);

        jp.setBounds(0,0,500,1000);
        jp.setBackground(new Color(255, 87, 51));

        btn.addActionListener(submitListener);
        this.add(l3);
        this.add(l1);
        this.add(usrname);
        this.add(l2);
        this.add(pass);
        this.add(btn);
        this.add(jp);
        jp.add(imglabel);

    }

    public static boolean login(String usrname,String Password) throws SQLException
    {
        String query = "select id from admin where username = ? and password = ?;";
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
