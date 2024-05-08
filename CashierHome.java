package org.example;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
public class CashierHome extends JFrame{
    CashierHome()
    {
        setTitle("Cashier");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700,700);
        setVisible(true);
    }
}
