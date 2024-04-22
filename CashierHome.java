


import javax.swing.*;

public class CashierHome extends JFrame{

    JLabel l1;
    CashierHome()
    {

        setTitle("Home Page");
        setSize(800,800);
        JLabel l1 = new JLabel("Home Page");
        setLayout(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        l1.setBounds(30,10,50,40);

        this.add(l1);

        setVisible(true);
    }
}

