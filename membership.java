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

        setSize(1920, 1080);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();
        label.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\manoj\\OneDrive\\Documents\\Java\\intellij\\deptui\\src\\main\\java\\pexels-picturemechaniq-1749303.jpg").getImage().getScaledInstance(1550,900, Image.SCALE_SMOOTH)));

        setLayout(new BorderLayout());

        setContentPane(label);

        JLabel textLabel = new JLabel("Hello, JFrame!");
        textLabel.setForeground(Color.WHITE); // Set text color to white
        textLabel.setFont(new Font("Arial", Font.BOLD, 24)); // Set font
        textLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align text
        label.add(textLabel, BorderLayout.CENTER);
        getContentPane().add(new Shape ());

        setVisible(true);
    }
    public static void main(String[] args){
        new membership();
    }
}