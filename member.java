import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.text.ParseException;
import javax.swing.text.MaskFormatter;



class member extends JFrame{
    JFrame frame;
    JLabel img,head,name,dob,phoneno,info;
    JPanel panel;
    JTextField namebox,dobbox,numberbox;
    JButton submitbutton;
    JRadioButton yesradioButton,noradioButton;
    ButtonGroup btngroup;

    String DB_URL = "jdbc:mysql://localhost:3306/billingsystem";
    String USER = "root";
    String PASS = "idk";

    member() {

        frame = new JFrame();
        img = new JLabel();
        img.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\manoj\\OneDrive\\Documents\\Java\\intellij\\deptui\\src\\main\\java\\1686249416_en-idei-club-p-light-blue-color-background-dizain-krasivo-6.jpg").getImage().getScaledInstance(1800, 900, Image.SCALE_SMOOTH)));
        frame.setContentPane(img);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel =new JPanel();
        panel.setBounds(490, 170, 550, 500);
        panel.setBackground(new Color(251, 241, 152));
        frame.add(panel);
        panel.setLayout(null);

        head = new JLabel("ADD MEMBERSHIP");
        panel.add(head);
        head.setBounds(190,20,400,25);
        head.setFont(new Font("Tahoma", 1, 18));
        head.setForeground(Color.BLACK);

        name = new JLabel("NAME:");
        panel.add(name);
        name.setFont(new Font("Tahoma", 1, 14));
        name.setForeground(Color.BLACK);
        name.setBounds(50,100,100,25);

        namebox = new JTextField();
        panel.add(namebox);
        namebox.setBounds(200,100,200,20);
        namebox.setBackground(Color.WHITE);
        namebox.setForeground(Color.black);
        namebox.setFont(new Font("Tahoma", 1, 14));


        dob = new JLabel("DOB:");
        panel.add(dob);
        dob.setFont(new Font("Tahoma", 1, 14));
        dob.setForeground(Color.BLACK);
        dob.setBounds(50,180,100,25);

        dobbox = new JTextField();
        dobbox.setBounds(200, 180, 200, 20);
        panel.add(dobbox);
        dobbox.setFont(new Font("Tahoma", 1, 14));


        phoneno = new JLabel();
        panel.add(phoneno);
        phoneno.setText("PHONE NUMBER:");
        phoneno.setForeground(Color.BLACK);
        phoneno.setBounds(50,260,150,25);
        phoneno.setFont(new Font("Tahoma", 1, 14));

        /*final String n= "+91";
        JTextField numb = new JTextField(n,3);
        panel.add(numb);
        numb.setFont(new Font("ariel",Font.BOLD,20));
        numb.setBounds(170,260,40,25);*/

        numberbox = new JTextField();
        panel.add(numberbox);
        numberbox.setBounds(200,260,200,20);
        numberbox.setFont(new Font("Tahoma", 1, 14));

        submitbutton = new JButton("SUBMIT");
        panel.add(submitbutton);
        submitbutton.setBounds(210,420,120,35);
        submitbutton.addActionListener(insertdb);

        info = new JLabel();
        panel.add(info);
        info.setText("Would you like to become a member?");
        info.setForeground(Color.BLACK);
        info.setBounds(50,340,245,25);
        info.setFont(new Font("Tahoma", 1, 13));

        yesradioButton = new JRadioButton("YES");
        noradioButton = new JRadioButton("NO");


        yesradioButton.setForeground(Color.BLACK);
        noradioButton.setForeground(Color.BLACK);

        btngroup = new ButtonGroup();
        btngroup.add(yesradioButton);
        btngroup.add(noradioButton);

        panel.add(yesradioButton);
        panel.add(noradioButton);

        yesradioButton.setBounds(320, 340, 60, 25);
        yesradioButton.setBackground(new Color(251, 241, 152));
        noradioButton.setBounds(390, 340, 60, 25);
        noradioButton.setBackground(new Color(251, 241, 152));





        /*panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change the border color to simulate glowing effect
                panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Remove the border when mouse exits to revert to normal appearance
                panel.setBorder(null);
            }
        });*/
        submitbutton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change the border color to simulate glowing effect
                submitbutton.setBorder(BorderFactory.createLineBorder(Color.cyan, 3));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Remove the border when mouse exits to revert to normal appearance
                submitbutton.setBorder(null);
            }
        });
        namebox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change the border color to simulate glowing effect
                namebox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Remove the border when mouse exits to revert to normal appearance
                namebox.setBorder(null);
            }
        });

        dobbox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change the border color to simulate glowing effect
                dobbox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Remove the border when mouse exits to revert to normal appearance
                dobbox.setBorder(null);
            }
        });

        numberbox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                // Change the border color to simulate glowing effect
                numberbox.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

            }

            @Override
            public void mouseExited(MouseEvent e) {
                // Remove the border when mouse exits to revert to normal appearance
                numberbox.setBorder(null);
            }
        });

    }
    ActionListener insertdb = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            String cuname = namebox.getText();
            String cdob = dobbox.getText();
            String cphn = numberbox.getText();
            try{

                if (yesradioButton.isSelected()) {
                    String query = "insert into customer(phone_no,cname,ismember,dob) values(?,?,?,?);";

                    try(Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {
                        PreparedStatement pst = con.prepareStatement(query);
                        pst.setString(1, cphn);
                        pst.setString(2,cuname);
                        pst.setString(3,"YES");
                        pst.setString(4,cdob);
                        pst.executeUpdate();
                    }
                }
                else{
                    String query = "insert into customer(phone_no,cname,ismember,dob) values(?,?,?,?);";

                    try(Connection con = DriverManager.getConnection(DB_URL, USER, PASS)) {
                        PreparedStatement pst = con.prepareStatement(query);
                        pst.setString(1, cphn);
                        pst.setString(2,cuname);
                        pst.setString(3,"NO");
                        pst.setString(4,cdob);
                        pst.executeUpdate();
                    }
                }
            }
            catch(SQLException E)
            {
                System.out.println(E.getMessage());
            }
            frame.dispose();
        }

    };
    public static void main(String[] args){
        new member();
    }

}