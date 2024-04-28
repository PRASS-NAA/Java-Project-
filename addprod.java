import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class addprod extends JFrame {

    JLabel label;
    JPanel panel;
    JPanel panel1;
    JLabel head, usr, pass, quan;
    JTextField proid,proname,proquan;
    JButton but1, but2, change, change1;
    Border border;

    public addprod() {
        setTitle("Add membership");

        setExtendedState(MAXIMIZED_BOTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        getContentPane().setBackground(new Color(115, 93, 165));
        //label = new JLabel();
        //label.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\manoj\\OneDrive\\Documents\\Java\\intellij\\deptui\\src\\main\\java\\pexels-picturemechaniq-1749303.jpg").getImage().getScaledInstance(1550,900, Image.SCALE_SMOOTH)));

        setLayout(null);
        //setContentPane(label);
        setVisible(true);

        head = new JLabel("Add Product");
        add(head);
        head.setBounds(657,120, 200, 100);
        head.setForeground(Color.BLACK);
        head.setFont(new Font("Ariel", Font.BOLD, 28));

        panel = new JPanel();
        add(panel);
        panel.setBounds(565, 200, 340, 400);
        panel.setBackground(new Color(211,197,229));
        panel.setLayout(null);
        panel.setVisible(true);

        usr = new JLabel("Product ID");
        panel.add(usr);
        usr.setBounds(40, 0, 200, 100);
        usr.setForeground(Color.BLACK);
        usr.setFont(new Font("Ariel", Font.PLAIN, 14));

        border = BorderFactory.createLineBorder(new Color(211,197,229), 2);

        proid = new JTextField();
        panel.add(proid);
        proid.setBounds(35, 75, 250, 25);
        proid.setBackground(new Color(115, 93, 165));
        proid.setForeground(Color.white);
        proid.setBorder(border);

        pass = new JLabel("Product name");
        panel.add(pass);
        pass.setBounds(40, 100, 200, 100);
        pass.setForeground(Color.BLACK);
        pass.setFont(new Font("Ariel", Font.PLAIN, 14));

        proname = new JTextField();
        panel.add(proname);
        proname.setBounds(35, 180, 250, 25);
        proname.setBackground(new Color(115, 93, 165));
        proname.setForeground(Color.white);
        proname.setBorder(border);

        quan = new JLabel("Quantity");
        panel.add(quan);
        quan.setBounds(40, 200, 200, 100);
        quan.setForeground(Color.BLACK);
        quan.setFont(new Font("Ariel", Font.PLAIN, 14));

        proquan = new JTextField();
        panel.add(proquan);
        proquan.setBounds(35, 280, 250, 25);
        proquan.setBackground(new Color(115, 93, 165));
        proquan.setForeground(Color.white);
        proquan.setBorder(border);

        but1 = new JButton("ADD");
        panel.add(but1);
        but1.setBounds(120, 330, 100, 40);
        but1.setBackground(new Color(115, 93, 165));

    }

    public static void main(String[] args) {
        new addprod();
    }
}
