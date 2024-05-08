package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminHome extends JFrame {
    JButton addCashier,deleteCashier,addProduct,deleteProduct,updateProduct,updateCashier;
    JLabel addc,dltc,addp,dltp,uptp,header,updtc;
    JPanel cont;

    int labelX,labelY;
    Dimension labelSize;

    AdminHome()
    {
        setTitle("AdminPage");

        setVisible(true);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(125, 152, 161));

        cont = new JPanel();

        this.setLayout(null);

        cont.setBackground(new Color(28,35,33,240));

        cont.setBounds(255,200,1000,400);
        cont.setLayout(null);

        header = new JLabel();
        header.setText("SELECT OPERATION");
        header.setForeground(new Color(238,241,239));
        header.setFont(new Font("Consolas",Font.PLAIN,45));
        header.setBounds(295,50,900,45);


        updateCashier = new JButton();
        updateCashier.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Main_System\\Billing_System\\src\\main\\java\\org\\example\\user-profile.png").getImage().getScaledInstance(200,100, Image.SCALE_SMOOTH)));
        updateCashier.setBounds(100,150,100,80);
        updtc = new JLabel();
        updtc.setText("Update Cashier");
        updtc.setFont(new Font("Consolas",Font.PLAIN,15));
        updtc.setForeground(new Color(238,241,239));
        labelSize = updtc.getPreferredSize();
        labelX = (updateCashier.getWidth() - labelSize.width) / 2 + updateCashier.getX();
        labelY = updateCashier.getY() + updateCashier.getHeight() + 5; //
        updtc.setBounds(labelX, labelY, labelSize.width, labelSize.height);

        addCashier = new JButton();
        addCashier.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Billing_System\\src\\profile.png").getImage().getScaledInstance(200,100, Image.SCALE_SMOOTH)));
        addCashier.setBounds(270,150,100,80);
        addc = new JLabel();
        addc.setText("Add Cashier");
        addc.setFont(new Font("Consolas",Font.PLAIN,15));
        addc.setForeground(new Color(238,241,239));
        labelSize = addc.getPreferredSize();
        labelX = (addCashier.getWidth() - labelSize.width) / 2 + addCashier.getX();
        labelY = addCashier.getY() + addCashier.getHeight() + 5; //
        addc.setBounds(labelX, labelY, labelSize.width, labelSize.height);

        deleteCashier = new JButton();
        deleteCashier.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Billing_System\\src\\deleteuser.png").getImage().getScaledInstance(120,80, Image.SCALE_SMOOTH)));
        deleteCashier.setBounds(440,150,100,80);
        dltc = new JLabel();
        dltc.setText("Delete Cashier");
        dltc.setForeground(new Color(238,241,239));
        dltc.setFont(new Font("Consolas",Font.PLAIN,15));
        labelSize = dltc.getPreferredSize();
        labelX = (deleteCashier.getWidth() - labelSize.width) / 2 + deleteCashier.getX();
        labelY = deleteCashier.getY() + deleteCashier.getHeight() + 5; //
        dltc.setBounds(labelX, labelY, labelSize.width, labelSize.height);

        addProduct = new JButton();
        addProduct.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Billing_System\\src\\addp.png").getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH)));
        addProduct.setBounds(610,150,100,80);
        addp = new JLabel();
        addp.setText("Add Product");
        addp.setForeground(new Color(238,241,239));;
        addp.setFont(new Font("Consolas",Font.PLAIN,15));
        labelSize = addp.getPreferredSize();
        labelX = (addProduct.getWidth() - labelSize.width) / 2 + addProduct.getX();
        labelY = addProduct.getY() + addProduct.getHeight() + 5; //
        addp.setBounds(labelX, labelY, labelSize.width, labelSize.height);

        deleteProduct = new JButton();
        deleteProduct.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Billing_System\\src\\deleteprod.png").getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH)));
        deleteProduct.setBounds(770,150,100,80);
        dltp = new JLabel();
        dltp.setText("Delete Product");
        dltp.setForeground(new Color(238,241,239));
        dltp.setFont(new Font("Consolas",Font.PLAIN,15));
        labelSize = dltp.getPreferredSize();
        labelX = (deleteProduct.getWidth() - labelSize.width) / 2 + deleteProduct.getX();
        labelY = deleteProduct.getY() + deleteProduct.getHeight() + 5; //
        dltp.setBounds(labelX, labelY, labelSize.width, labelSize.height);

        updateProduct = new JButton();
        updateProduct.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Billing_System\\src\\updateprod.png").getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH)));
        updateProduct.setBounds(920,150,100,80);
        uptp = new JLabel();
        uptp.setText("Update Product");
        uptp.setForeground(new Color(238,241,239));
        uptp.setFont(new Font("Consolas",Font.PLAIN,15));
        labelSize = uptp.getPreferredSize();
        labelX = (updateProduct.getWidth() - labelSize.width) / 2 + updateProduct.getX();
        labelY = updateProduct.getY() + updateProduct.getHeight() + 5; //
        uptp.setBounds(labelX, labelY, labelSize.width, labelSize.height);

        this.add(cont);
        cont.add(header);
        cont.add(updateCashier);
        cont.add(updtc);
        cont.add(addCashier);
        cont.add(addc);
        cont.add(deleteCashier);
        cont.add(dltc);
        cont.add(addProduct);
        cont.add(addp);
        cont.add(deleteProduct);
        cont.add(dltp);
        //cont.add(updateProduct);
        //cont.add(uptp);

        ActionListener addcl = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new c_create_account().setVisible(true);
            }
        };

        ActionListener dltc = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new c_delete_account().setVisible(true);
            }
        };

        ActionListener addpr = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new addproduct().setVisible(true);
            }
        };

        /*ActionListener updtca = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
               // new updateCashier().setVisible(true);
            }
        };*/

        addCashier.addActionListener(addcl);
        addProduct.addActionListener(addpr);
        deleteCashier.addActionListener(dltc);
        //updateCashier.addActionListener(updtca);

    }
}
