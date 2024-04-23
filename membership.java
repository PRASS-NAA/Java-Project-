import javax.swing.*;
import java.awt.*;

class Shape extends JComponent {
    public void paint(Graphics g){
        Graphics2D g1 = (Graphics2D) g;
        g1.drawRect(100,150,60,200);
    }
}

public class membership extends JFrame {
    public membership(){
        setTitle("Add membership");

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\manoj\\OneDrive\\Documents\\Java\\intellij\\deptui\\src\\main\\java\\pexels-picturemechaniq-1749303.jpg").getImage().getScaledInstance(1550,900, Image.SCALE_SMOOTH)));

        setLayout(null);

        setContentPane(label);

        setVisible(true);
        JPanel panel = new JPanel();
        panel.setBounds(100,143,450,500);
        panel.setBackground(new Color(37, 37, 37));
        panel.setLayout(null);

        add(panel);

        JLabel head = new JLabel("Admin");
        panel.add(head);
        head.setBounds(190,10,100,100);
        head.setForeground(Color.WHITE);
        head.setFont(new Font("Ariel",Font.BOLD,28));

        JLabel usr = new JLabel("User Name:");
        usr.setBounds(17,20,200,300);
        usr.setForeground(Color.WHITE);
        usr.setFont(new Font("Ariel",Font.PLAIN,20));
        panel.add(usr);

        JTextField usrbox = new JTextField();
        usrbox.setBounds(150,163,250,20);
        usrbox.setBackground(Color.WHITE);
        panel.add(usrbox);

        JLabel pass = new JLabel("Password:");
        panel.add(pass);
        pass.setBounds(17,105,200,300);
        pass.setForeground(Color.WHITE);
        pass.setFont(new Font("Ariel",Font.PLAIN,20));

        JPasswordField passbox = new JPasswordField();
        panel.add(passbox);
        passbox.setBounds(150,247,250,20);
        passbox.setBackground(Color.WHITE);

        JButton but1 = new JButton("Login");
        panel.add(but1);
        but1.setBounds(175,340,100,40);
        but1.setBackground(Color.cyan);

        JLabel change = new JLabel("To log into cashier click here");
        panel.add(change);
        change.setBounds(140,300,200,300);
        change.setForeground(Color.WHITE);
        //change.setFont(new Font("Ariel",Font.PLAIN,20));

    }
    public static void main(String[] args){
        new membership();
    }
}