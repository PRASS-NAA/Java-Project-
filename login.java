import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class login extends JFrame {

    Container c;
    JLabel lable1,lable2,lable3,imglabel;
    JPanel leftPanel, rightPanel;
    JTextField user;
    JPasswordField password;
    JButton btn;


    public void login_interface() {



            setTitle("login form");
            setVisible(true);
            setSize(666,350);
            setLocation(100,100);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
            c=getContentPane();
            c.setLayout(null);

            Color customColor_1 = new Color(190, 126, 227);
            Color customColor_2 = new Color(236, 232, 229);


            leftPanel = new JPanel();
            leftPanel.setBackground(customColor_1);
            leftPanel.setBounds(0, 0, 325, 400);
            c.add(leftPanel);

            rightPanel = new JPanel();
            rightPanel.setBackground(customColor_2);
            rightPanel.setBounds(400 , 400, getWidth() / 2, getHeight());
            c.add(rightPanel);

            imglabel = new JLabel();
            imglabel.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\shopping-cart.png").getImage().getScaledInstance(275,300, Image.SCALE_SMOOTH)));
            imglabel.setBounds(0,0,250,100);
            leftPanel.add(imglabel);


            lable3 = new JLabel("Enter Credentials");
            lable3.setFont(new Font("Monospace", Font.PLAIN,20));
            lable3.setBounds(430,10,500,20);
            lable3.setForeground(new Color(13, 13, 13)); // Set font color to blue
            rightPanel.add(lable3);
            c.add(lable3);

            lable1=new JLabel("username:");
            lable2=new JLabel("password:");

            lable1.setBounds(350,75,100,20);
            lable2.setBounds(350,125,100,20);

            c.add(lable1);
            c.add(lable2);

            user= new JTextField();
            user.setBounds(450,75,120,20);
            c.add(user);

            password = new JPasswordField();
            password.setBounds(450,125,120,20);
            c.add(password);

            btn = new JButton("login");
            btn.setBounds(475,175,70,20);
            c.add(btn);
            btn.addActionListener(submitListener);








    }
    ActionListener submitListener = new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            System.out.println(user.getText());
            System.out.println(password.getText());
        }
    };
}
