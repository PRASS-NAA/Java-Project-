package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class analysisinterface extends JFrame {
    JButton sales_month,high_sell_prod,low_sell_prod,spcprod;
    JLabel sm,header,highsellprod,lowsellprod,specificmonth;
    JPanel cont;

    int labelX,labelY;
    Dimension labelSize;

    analysisinterface()
    {
        setTitle("AdminPage");

        setVisible(true);

        setExtendedState(JFrame.MAXIMIZED_BOTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(125, 152, 161));

        cont = new JPanel();

        this.setLayout(null);

        cont.setBackground(new Color(28,35,33,240));

        cont.setBounds(255,200,1100,400);
        cont.setLayout(null);

        header = new JLabel();
        header.setText("ANALYSIS");
        header.setForeground(new Color(238,241,239));
        header.setFont(new Font("Consolas",Font.PLAIN,45));
        header.setBounds(450,50,900,45);


        sales_month = new JButton();
        sales_month.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Main_System\\Billing_System\\src\\main\\bms\\anmonth.png").getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH)));
        sales_month.setBounds(200,150,100,80);
        sm = new JLabel();
        sm.setText("Total Sales For a Month");
        sm.setFont(new Font("Consolas",Font.PLAIN,15));
        sm.setForeground(new Color(238,241,239));
        labelSize = sm.getPreferredSize();
        labelX = (sales_month.getWidth() - labelSize.width) / 2 + sales_month.getX();
        labelY = sales_month.getY() + sales_month.getHeight() + 5; //
        sm.setBounds(labelX, labelY, labelSize.width, labelSize.height);

        high_sell_prod = new JButton();
        high_sell_prod.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Main_System\\Billing_System\\src\\main\\bms\\annhigh.png").getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH)));
        high_sell_prod.setBounds(400,150,100,80);
        highsellprod = new JLabel();
        highsellprod.setText("Most Selling Product");
        highsellprod.setFont(new Font("Consolas",Font.PLAIN,15));
        highsellprod.setForeground(new Color(238,241,239));
        labelSize = highsellprod.getPreferredSize();
        labelX = (high_sell_prod.getWidth() - labelSize.width) / 2 + high_sell_prod.getX();
        labelY = high_sell_prod.getY() + high_sell_prod.getHeight() + 5; //
        highsellprod.setBounds(labelX, labelY, labelSize.width, labelSize.height);

        low_sell_prod = new JButton();
        low_sell_prod.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Main_System\\Billing_System\\src\\main\\bms\\anleast.png").getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH)));
        low_sell_prod.setBounds(600,150,100,80);
        lowsellprod = new JLabel();
        lowsellprod.setText("Least Selling Product");
        lowsellprod.setForeground(new Color(238,241,239));
        lowsellprod.setFont(new Font("Consolas",Font.PLAIN,15));
        labelSize = lowsellprod.getPreferredSize();
        labelX = (low_sell_prod.getWidth() - labelSize.width) / 2 + low_sell_prod.getX();
        labelY = low_sell_prod.getY() + low_sell_prod.getHeight() + 5; //
        lowsellprod.setBounds(labelX, labelY, labelSize.width, labelSize.height);

        spcprod = new JButton();
        spcprod.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Main_System\\Billing_System\\src\\main\\bms\\anprod.png").getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH)));
        spcprod.setBounds(800,150,100,80);
        specificmonth = new JLabel();
        specificmonth.setText("Product Analysis");
        specificmonth.setForeground(new Color(238,241,239));;
        specificmonth.setFont(new Font("Consolas",Font.PLAIN,15));
        labelSize = specificmonth.getPreferredSize();
        labelX = (spcprod.getWidth() - labelSize.width) / 2 + spcprod.getX();
        labelY = spcprod.getY() + spcprod.getHeight() + 5; //
        specificmonth.setBounds(labelX, labelY, labelSize.width, labelSize.height);

        /*deleteProduct = new JButton();
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
        updateProduct.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Main_System\\Billing_System\\src\\main\\bms\\replacement.png").getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH)));
        updateProduct.setBounds(920,150,100,80);
        uptp = new JLabel();
        uptp.setText("Update Product");
        uptp.setForeground(new Color(238,241,239));
        uptp.setFont(new Font("Consolas",Font.PLAIN,15));
        labelSize = uptp.getPreferredSize();
        labelX = (updateProduct.getWidth() - labelSize.width) / 2 + updateProduct.getX();
        labelY = updateProduct.getY() + updateProduct.getHeight() + 5; //
        uptp.setBounds(labelX, labelY, labelSize.width, labelSize.height);*/

        this.add(cont);
        cont.add(header);
        cont.add(sales_month);
        cont.add(sm);
        cont.add(high_sell_prod);
        cont.add(highsellprod);
        cont.add(low_sell_prod);
        cont.add(lowsellprod);
        cont.add(spcprod);
        cont.add(specificmonth);




        ActionListener sales_montha = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int monthno;
                String month = JOptionPane.showInputDialog(null,"Enter the Month","Month");
                String syear = JOptionPane.showInputDialog(null,"Enter the Year","Year");
                int year = Integer.parseInt(String.valueOf(syear));
                monthno = getmonth(month);
                if (monthno != -1) {

                    String queryTotalSales = "SELECT SUM(salesamt) AS total_sales FROM salesmaster WHERE MONTH(stransdate) = ? AND YEAR(stransdate) = ?";
                    try (Connection conn = DbConnection.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(queryTotalSales)) {
                        pstmt.setInt(1, monthno); // Month (e.g., May)
                        pstmt.setInt(2,year ); // Year
                        ResultSet rs = pstmt.executeQuery();
                        if (rs.next()) {
                            double totalSales = rs.getDouble("total_sales");
                            JOptionPane.showMessageDialog(null, "Total Sales Amount For The Month  "+ month +" is " + totalSales);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                }else {
                    //
                }
            }
        };

        ActionListener spcmonth = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int monthno;
                String month = JOptionPane.showInputDialog(null, "Enter the Month");
                String syear = JOptionPane.showInputDialog(null, "Enter the Year");
                String batchid = JOptionPane.showInputDialog(null, "Enter the Batch_ID");
                String prodid = JOptionPane.showInputDialog(null, "Enter the Product_ID");
                int year = Integer.parseInt(String.valueOf(syear));
                int prodId = Integer.parseInt(String.valueOf(prodid));
                monthno = getmonth(month);
                if (monthno != -1) {

                    String queryTotalSales = "SELECT SUM(sd.quantity) AS total_quantity_sold, SUM(sm.salesamt) AS total_sales_amount FROM salesmaster sm JOIN salesdetails sd ON sm.stransid = sd.stransid JOIN products p ON sd.product_id = p.product_id WHERE MONTH(sm.stransdate) = ? AND YEAR(sm.stransdate) = ? AND p.product_id = ? AND p.batch_id = ?\n";
                    try (Connection conn = DbConnection.getConnection();
                         PreparedStatement pstmt = conn.prepareStatement(queryTotalSales)) {
                        pstmt.setInt(1, monthno); // Month (e.g., May)
                        pstmt.setInt(2, year); // Year
                        pstmt.setInt(3,prodId);
                        pstmt.setString(4,batchid);
                        ResultSet rs = pstmt.executeQuery();
                        if (rs.next()) {
                            double totalSales = rs.getDouble("total_quantity_sold");
                            double totalAmount = rs.getDouble("total_sales_amount");
                            JOptionPane.showMessageDialog(null, "Total Quanity Sold Is " + totalSales + "Total Sales Amount Is " + totalAmount );
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                } else {
                    //
                }
            }
        };

        sales_month.addActionListener(sales_montha);
        high_sell_prod.addActionListener(hsp);
        low_sell_prod.addActionListener(lsp);
        spcprod.addActionListener(spcmonth);
    }


    ActionListener hsp = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int monthno ;
            String month = JOptionPane.showInputDialog(null,"Enter the Month","Month");
            String syear = JOptionPane.showInputDialog(null,"Enter the Year","Year");
            int year = Integer.parseInt(String.valueOf(syear));
            monthno = getmonth(month);
            if (monthno != -1)
            {

                String queryHighestSelling = "SELECT p.prodname, SUM(sd.quantity) AS total_quantity_sold " +
                        "FROM salesdetails sd " +
                        "JOIN products p ON sd.product_id = p.product_id " +
                        "JOIN salesmaster sm ON sd.stransid = sm.stransid " +
                        "WHERE MONTH(sm.stransdate) = ? AND YEAR(sm.stransdate) = ? " +
                        "GROUP BY p.prodname ORDER BY total_quantity_sold DESC LIMIT 1";
                try (Connection conn = DbConnection.getConnection();
                     PreparedStatement pstmt = conn.prepareStatement(queryHighestSelling)) {
                    pstmt.setInt(1, monthno); // Month (e.g., May)
                    pstmt.setInt(2, year); // Year
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        String productName = rs.getString("prodname");
                        int totalQuantitySold = rs.getInt("total_quantity_sold");
                        JOptionPane.showMessageDialog(null,  "Highest Selling Product: " + productName + " (Total Quantity Sold: " + totalQuantitySold + ")");

                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }else {
                //
            }
        }
    };

    ActionListener lsp = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int monthno = 0;
            String month = JOptionPane.showInputDialog(null,"Enter the Month","Month");
            String syear = JOptionPane.showInputDialog(null,"Enter the Year","Year");
            int year = Integer.parseInt(String.valueOf(syear));
            monthno = getmonth(month);
            if (monthno != -1)
            {
                String queryLowestSelling = "SELECT p.prodname, SUM(sd.quantity) AS total_quantity_sold " +
                        "FROM salesdetails sd " +
                        "JOIN products p ON sd.product_id = p.product_id " +
                        "JOIN salesmaster sm ON sd.stransid = sm.stransid " +
                        "WHERE MONTH(sm.stransdate) = ? AND YEAR(sm.stransdate) = ? " +
                        "GROUP BY p.prodname ORDER BY total_quantity_sold ASC LIMIT 1";
                try (Connection conn = DbConnection.getConnection();
                     PreparedStatement pstmt = conn.prepareStatement(queryLowestSelling)) {
                    pstmt.setInt(1, monthno); // Month (e.g., May)
                    pstmt.setInt(2, year); // Year
                    ResultSet rs = pstmt.executeQuery();
                    if (rs.next()) {
                        String productName = rs.getString("prodname");
                        int totalQuantitySold = rs.getInt("total_quantity_sold");
                        JOptionPane.showMessageDialog(null,  "Lowest Selling Product: " + productName + " (Total Quantity Sold: " + totalQuantitySold + ")");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        }
    };

    int getmonth(String month)
    {
        int monthno;

        switch (month.toLowerCase()) {
            case "january":
                monthno = 1;
                break;
            case "february":
                monthno = 2;
                break;
            case "march":
                monthno = 3;
                break;
            case "april":
                monthno = 4;
                break;
            case "may":
                monthno = 5;
                break;
            case "june":
                monthno = 6;
                break;
            case "july":
                monthno = 7;
                break;
            case "august":
                monthno = 8;
                break;
            case "september":
                monthno = 9;
                break;
            case "october":
                monthno = 10;
                break;
            case "november":
                monthno = 11;
                break;
            case "december":
                monthno = 12;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid month name entered.");
                return -1;
        }
        return monthno;
    }
}
