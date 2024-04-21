import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.*;

public class Home extends JFrame{

    JLabel l1;
    Home()
    {

        setTitle("Home Page");
        setSize(800,800);
        JLabel l1 = new JLabel("Home Page");
        setLayout(null);

        l1.setBounds(30,10,50,40);

        this.add(l1);

        setVisible(true);
    }
}
