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


    public void login_interface() {



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
            imglabel.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\admin.png").getImage().getScaledInstance(275,300, Image.SCALE_SMOOTH)));
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
            c.add(user);

            password = new JPasswordField();

            password.setBounds(450,165,120,20);
            c.add(password);

            btn = new JButton("login");
        rightPanel.add(btn);
        btn.setBounds(145,210,70,20);
        btn.setBackground(new Color(236, 232, 229));
            btn.addActionListener(submitListener);

        btn2 = new JButton("chashier ? click here");
        rightPanel.add(btn2);
        btn2.setBounds(90,250,175,20);
        btn2.setBackground(customColor_2);
        btn2.setBorder(null);
        btn2.addActionListener(submitListener);








    }
    ActionListener submitListener = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            System.out.println(user.getText());
            System.out.println(password.getText());
        }
    };
}
