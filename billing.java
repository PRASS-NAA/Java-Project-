package org.example;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

class billing extends JFrame
{
    JPanel panel;
    JLabel logo,total,paidamt,balamt,calculation,pdetails,pid,pname,qty,pprice,date,time,batchid,cashierid,cashiername;
    JSeparator line_1,line_2;
    JTextField pidbox,pnamebox,qtybox,ppricebox,totalbox,paidamtbox,balamtbox,batchbox,cashiernamebox,cashieridbox;
    JButton addbtn,closebtn,resetbtn,savebtn,deleteButton,resetButton;
    JTable display;
    JScrollPane scrolldisplay;

    Object[][] purchase = new Object[50][6];
    int prod = 0;
    String cashname;

    int stransid = -1;
    billing() throws SQLException
    {
        setTitle("Billing Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);
        setBackground(new Color(255, 253, 208));

        panel = new JPanel();
        panel.setBounds(0,120,1920,980);
        panel.setLayout(null);
        panel.setBackground(new Color(251, 241, 152));
        add(panel);

        cashierid = new JLabel("CASHIER ID:" );
        panel.add(cashierid);
        cashierid.setBounds(850,2,200,40);
        cashierid.setFont(new Font("Tahoma", 1, 14));


        cashieridbox = new JTextField();
        panel.add(cashieridbox);
        cashieridbox.setBounds(1000,15,150,20);
        cashieridbox.setFont(new Font("Tahoma", 1, 14));

        cashiername = new JLabel("CASHIER NAME:" );
        panel.add(cashiername);
        cashiername.setBounds(850,35,200,40);
        cashiername.setFont(new Font("Tahoma", 1, 14));


        cashiernamebox = new JTextField();
        panel.add(cashiernamebox);
        cashiernamebox.setBounds(1000,45,150,20);
        cashiernamebox.setFont(new Font("Tahoma", 1, 14));

        date = new JLabel("DATE:     " + LocalDate.now());
        panel.add(date);
        date.setBounds(1250,0,200,40);
        date.setFont(new Font("Tahoma", 1, 14));

        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        time = new JLabel("TIME:    " + formattedTime);
        panel.add(time);
        time.setBounds(1250,40,200,40);
        time.setFont(new Font("Tahoma", 1, 14));

        line_1 = new JSeparator(SwingConstants.HORIZONTAL);
        panel.add(line_1);
        line_1.setBounds(0,125,1920,3);
        line_1.setBackground(new Color(12,12,12));



        pdetails = new JLabel("PRODUCT DETAILS");
        panel.add(pdetails);
        pdetails.setBounds(10,100,200,100);
        pdetails.setFont(new Font("Tahoma", 1, 18));

        batchid = new JLabel("BATCH ID");
        panel.add(batchid);
        batchid.setBounds(30,150,100,100);
        batchid.setFont(new Font("Tahoma", 1, 14));

        batchbox = new JTextField();
        panel.add(batchbox);
        batchbox.setBounds(110,190,100,20);
        batchbox.setFont(new Font("Tahoma", 1, 14));

        pid = new JLabel("PRODUCT ID");
        panel.add(pid);
        pid.setBounds(220,150,100,100);
        pid.setFont(new Font("Tahoma", 1, 14));


        pidbox = new JTextField();
        panel.add(pidbox);
        pidbox.setBounds(330,190,100,20);
        pidbox.setFont(new Font("Tahoma", 1, 14));

        pname = new JLabel("PRODUCT NAME");
        panel.add(pname);
        pname.setBounds(460,150,150,100);
        pname.setFont(new Font("Tahoma", 1, 14));


        pnamebox = new JTextField();
        panel.add(pnamebox);
        pnamebox.setBounds(580,190,200,20);
        pnamebox.setFont(new Font("Tahoma", 1, 14));

        qty = new JLabel("QTY");
        panel.add(qty);
        qty.setBounds(815,150,50,100);
        qty.setFont(new Font("Tahoma", 1, 14));


        qtybox = new JTextField();
        panel.add(qtybox);
        qtybox.setBounds(870,190,50,20);
        qtybox.setFont(new Font("Tahoma", 1, 14));

        pprice = new JLabel("PRICE");
        panel.add(pprice);
        pprice.setBounds(950,150,70,100);
        pprice.setFont(new Font("Tahoma", 1, 14));


        ppricebox = new JTextField();
        panel.add(ppricebox);
        ppricebox.setBounds(1010,190,80,20);
        ppricebox.setFont(new Font("Tahoma", 1, 14));

        addbtn = new JButton();
        panel.add(addbtn);
        addbtn.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\bms\\add.png"));
        addbtn.setText("ADD");
        addbtn.setBackground(new Color(148, 93, 243, 211));
        addbtn.setBounds(1150, 187, 83, 25);

        deleteButton = new JButton();
        panel.add(deleteButton);
        deleteButton.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\bms\\delete.png"));
        deleteButton.setText("DELETE");
        deleteButton.setBackground(new Color(148, 93, 243, 211));
        deleteButton.setBounds(1260, 187, 106, 25);

        resetButton = new JButton();
        panel.add(resetButton);
        resetButton.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\bms\\delete.png"));
        resetButton.setText("RESET");
        resetButton.setBackground(new Color(148, 93, 243, 211));
        resetButton.setBounds(1400, 187, 106, 25);


        line_2 = new JSeparator(SwingConstants.HORIZONTAL);
        panel.add(line_2);
        line_2.setBounds(0,245,1920,3);
        line_2.setBackground(new Color(12,12,12));


        String[] columns = {"BATCH ID","PRODUCT ID", "PRODUCT NAME", "QTY", "TOTAL MRP","UNIT PRICE"};
        Object[][] data = {};
        display = new JTable(data, columns);
        scrolldisplay = new JScrollPane(display);
        panel.add(scrolldisplay);
        scrolldisplay.setBounds(20, 270, 770, 400);


        calculation = new JLabel("CALCULATION");
        panel.add(calculation);
        calculation.setBounds(850,230,200,100);
        calculation.setFont(new Font("Tahoma", 1, 18));

        total = new JLabel("TOTAL");
        panel.add(total);
        total.setBounds(850,320,200,100);
        total.setFont(new Font("Tahoma", 1, 15));

        totalbox = new JTextField();
        panel.add(totalbox);
        totalbox.setBounds(1050,360,150,20);
        totalbox.setFont(new Font("Tahoma", 1, 14));


        paidamt = new JLabel("PAID AMOUNT");
        panel.add(paidamt);
        paidamt.setBounds(850,400,200,100);
        paidamt.setFont(new Font("Tahoma", 1, 15));

        paidamtbox = new JTextField();
        panel.add(paidamtbox);
        paidamtbox.setBounds(1050,440,150,20);
        paidamtbox.setFont(new Font("Tahoma", 1, 14));

        balamt = new JLabel("BALANCE AMOUNT");
        panel.add(balamt);
        balamt.setBounds(850,480,200,100);
        balamt.setFont(new Font("Tahoma", 1, 15));

        balamtbox = new JTextField();
        panel.add(balamtbox);
        balamtbox.setBounds(1050,520,150,20);
        balamtbox.setFont(new Font("Tahoma", 1, 14));


        savebtn = new JButton();
        panel.add(savebtn);
        savebtn.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\bms\\save.png"));
        savebtn.setText("SAVE");
        savebtn.setBackground(new Color(148, 93, 243, 211));
        savebtn.setBounds(1300, 355, 120, 25);
        savebtn.setFont(new Font("Tahoma", 1, 14));

        resetbtn = new JButton();
        panel.add(resetbtn);
        resetbtn.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\bms\\Reset.png"));
        resetbtn.setText("RESET");
        resetbtn.setBackground(new Color(148, 93, 243, 211));
        resetbtn.setBounds(1300, 435, 120, 25);
        resetbtn.setFont(new Font("Tahoma", 1, 14));


        closebtn = new JButton();
        panel.add(closebtn);
        closebtn.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\bms\\close Jframe.png"));
        closebtn.setText("CLOSE");
        closebtn.setBackground(new Color(148, 93, 243, 211));
        closebtn.setBounds(1300, 515, 120, 25);
        closebtn.setFont(new Font("Tahoma", 1, 14));

        pidbox.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                pidboxActionPerformed(e);
            }
        });

        cashieridbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(cashieridboxActionPerformed(e))
                    {
                        System.out.println("OK");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"INVALID CASHIER");
                    }
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        addbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addbtnActionPerformed(e);
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteSelectedRow();
            }
        });

        paidamtbox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateBalanceAmount();
            }
        });

        resetbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });


        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                batchbox.setText("");
                ppricebox.setText("");
                paidamtbox.setText("");
                pidbox.setText("");
                qtybox.setText("");
                pnamebox.setText("");
            }
        });

        savebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                savebtnActionPerformed();
            }
        });
    }

    public void savebtnActionPerformed() {
        String phoneNumber = JOptionPane.showInputDialog(null, "Enter Phone Number:", "Enter Details", JOptionPane.QUESTION_MESSAGE);

        // Check if the user clicked Cancel or closed the dialog
        if (phoneNumber != null) {
            // Handle the phone number, you can use it for further processing
            System.out.println("Phone Number entered: " + phoneNumber);
        }
        int totalmrp = Integer.parseInt(totalbox.getText());

        try
        {
            switch(exist(phoneNumber))
            {
                case 1: //number exist and member
                    JOptionPane.showMessageDialog(null,"member");
                    finishall(phoneNumber,totalmrp);
                    //salesdetails(stransid,purchase);
                    break;
                case 2: // number exist but not member
                    JOptionPane.showMessageDialog(null,"not a member");
                    int response1 = JOptionPane.showConfirmDialog(null, "Do you want membership?");
                    if (response1 == JOptionPane.YES_OPTION) {

                        try(Connection con = DbConnection.getConnection())
                        {
                            String query = "update customer set ismember = 'YES' where phone_no = ?;";

                            PreparedStatement pst = con.prepareStatement(query);
                            pst.setString(1,phoneNumber);

                            int rs = pst.executeUpdate();

                            if(rs > 0)
                            {
                                JOptionPane.showMessageDialog(null,"Membership Added ");
                                finishall(phoneNumber,totalmrp);
                                //salesdetails(stransid,purchase);
                            }
                            else {
                                JOptionPane.showMessageDialog(null,"Error");
                            }
                        }catch (SQLException E)
                        {
                            System.out.println(E.getMessage());
                        }

                    } else if (response1 == JOptionPane.NO_OPTION) {
                        finishall(phoneNumber,totalmrp);
                        //salesdetails(stransid,purchase);
                    }
                    break;
                case 3: // is not a member
                    JOptionPane.showMessageDialog(null,"not in db");
                    setVisible(false);
                    member memberFrame = new member(this);
                    memberFrame.setVisible(true);
                    break;

                default:
                    JOptionPane.showMessageDialog(null,
                            "Error",
                            "Inane error",
                            JOptionPane.ERROR_MESSAGE);

                    }
            } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    int exist(String number) throws SQLException
    {
        String query = "select cname from customer where phone_no = ?;";

        try(Connection con = DbConnection.getConnection())
        {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setString(1,number);

            ResultSet rs1 = pst.executeQuery();

            if(rs1.next())
            {
                String query2 = "select ismember from customer where phone_no = ? ;";
                PreparedStatement pst2 = con.prepareStatement(query2);
                pst2.setString(1,number);

                ResultSet rs = pst2.executeQuery();

                if(rs.next())
                {
                    String member = rs.getString(1);
                    System.out.println(member);
                    if(member.equals(new String("NO")))
                    {
                        return 2;
                    }
                    else
                    {
                        return 1;
                    }
                }
            }

        }
        return 3;
    }

    private boolean cashieridboxActionPerformed(ActionEvent e) throws SQLException
    {
        int id = Integer.parseInt(cashieridbox.getText());
        String query = "select cname from cashier where id = ?;";

        try(Connection con = DbConnection.getConnection())
        {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1,id);

            ResultSet rs = pst.executeQuery();

            while(rs.next())
            {
                cashname = rs.getString(1);
                cashiernamebox.setText(cashname);
                return true;
            }

        }catch (SQLException E)
        {
            System.out.println(E.getMessage());
        }
        return false;
    }

    private void pidboxActionPerformed(ActionEvent e) {
        int id = Integer.parseInt(pidbox.getText());
        String bid = batchbox.getText();
        try {
            Connection conn = DbConnection.getConnection();
            String query = "SELECT * FROM products WHERE product_id = ? and batch_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2,bid);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                pnamebox.setText(rs.getString("prodname"));
                ppricebox.setText(String.valueOf(rs.getInt("price")));
                //qtybox.setText(String.valueOf(rs.getInt("quantity")));
            } else {

                pnamebox.setText("");
                ppricebox.setText("");
                qtybox.setText("");
                JOptionPane.showMessageDialog(null, "Product not found!");
            }

            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {

            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    public void addbtnActionPerformed(ActionEvent e) {
        String bid = batchbox.getText();
        String id = pidbox.getText();
        String name = pnamebox.getText();
        int quantity = Integer.parseInt(qtybox.getText());
        int price = Integer.parseInt(ppricebox.getText());

        if(bid == "" || id == "")
        {
            JOptionPane.showMessageDialog(null,"Enter the ID");
        }



        TableModel model = display.getModel();
        DefaultTableModel newModel = new DefaultTableModel();


        try {
            boolean productExists = false;
            int updatedPrice = (price*quantity);
            //totalbox.setText(new String(String.valueOf(updatedPrice)));
            for (int i = 0; i < model.getRowCount(); i++) {
                if (id.equals(model.getValueAt(i, 1).toString()) && bid.equals(model.getValueAt(i, 0).toString())) {

                    int updatedQuantity = Integer.parseInt(model.getValueAt(i, 3).toString()) + quantity;
                    updatedPrice = (price*updatedQuantity); // Assuming the price remains the same
                    model.setValueAt(updatedQuantity, i, 3);
                    model.setValueAt(updatedPrice, i, 4);
                    productExists = true;

                    purchase[i][3] = updatedQuantity;
                    purchase[i][4] = updatedPrice;

                    break;
                }
            }

            // If the product does not exist, add a new row
            if (!productExists) {
                for (int i = 0; i < model.getColumnCount(); i++) {
                    newModel.addColumn(model.getColumnName(i));
                }

                for (int i = 0; i < model.getRowCount(); i++) {
                    Vector<Object> row = new Vector<>();
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        row.add(model.getValueAt(i, j));
                    }
                    newModel.addRow(row);
                }
                Object[] next = new Object[]{bid, id, name, quantity, updatedPrice ,price};
                newModel.addRow(next);


                for(int j =0;j<6;j++)
                {
                    purchase[prod][j] = next[j];
                }
                prod++;

                display.setModel(newModel);
            }

            System.out.println("---");
            for(int i =0;i<prod;i++)
            {
                for(int j =0;j<6;j++)
                {
                    System.out.print(purchase[i][j] + "\t");
                }
                System.out.println();
            }

            updateTotalAmount((DefaultTableModel) display.getModel());

        }catch (Exception E)
        {
            System.out.println(E.getMessage());
        }
    }


    public void deleteSelectedRow() {
        DefaultTableModel model = (DefaultTableModel) display.getModel();
        int selectedRowIndex = display.getSelectedRow();

        if (selectedRowIndex != -1) {
            model.removeRow(selectedRowIndex);
            removePurchaseEntry(selectedRowIndex);
            updateTotalAmount(model);
        } else {

            JOptionPane.showMessageDialog(null, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void removePurchaseEntry(int rowIndex) {

        for (int i = rowIndex; i < prod - 1; i++) {
            for (int j = 0; j < 6; j++) {
                purchase[i][j] = purchase[i + 1][j];
            }
        }
        prod--;
    }
    private void updateTotalAmount(DefaultTableModel model) {
        int totalAmount = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            totalAmount += Integer.parseInt(String.valueOf(model.getValueAt(i, 4)));
        }
        totalbox.setText(new String(String.valueOf(totalAmount)));
    }

    private void updateBalanceAmount() {
        try {
            int totalAmount = Integer.parseInt(totalbox.getText());
            int paidAmount = Integer.parseInt(paidamtbox.getText());
            int balanceAmount =   paidAmount - totalAmount;
            balamtbox.setText(String.valueOf(balanceAmount));
        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(null, "Invalid input for paid amount.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void resetFields() {
        // Clear all text fields
        pidbox.setText("");
        pnamebox.setText("");
        qtybox.setText("");
        ppricebox.setText("");
        totalbox.setText("");
        paidamtbox.setText("");
        balamtbox.setText("");

        // Clear table data
        DefaultTableModel model = (DefaultTableModel) display.getModel();
        model.setRowCount(0);
    }



    //boolean insertcustomer();
    void finishall(String phonenumber,int totalmrp) throws SQLException
    {
        //first add the customer
        int c_id = Integer.parseInt(cashieridbox.getText());
        try {
            Date currentDate = new Date(System.currentTimeMillis());
            java.sql.Date sqlDate = new java.sql.Date(currentDate.getTime());

            Connection con = DbConnection.getConnection();
            String query = "insert into salesmaster(phoneno,salesamt,stransdate,cashier_id) values (?,?,?,?);";
            PreparedStatement pst = con.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            pst.setString(1,phonenumber);
            pst.setInt(2,totalmrp);
            pst.setDate(3,sqlDate);
            pst.setInt(4,c_id);

            pst.executeUpdate();

            ResultSet rs = pst.getGeneratedKeys();
            if (rs.next()) {
                stransid = rs.getInt(1);
            }

            System.out.println(stransid);

            try{
                if(updateprodtb())
                {
                    salesdetails(stransid, purchase);
                }
                else {
                    JOptionPane.showMessageDialog(null,"ERROR !!!!!!");
                }

            }catch (SQLException E)
            {
                System.out.println(E.getMessage());
            }catch (Exception E)
            {
                System.out.println(E.getMessage());
            }


        }catch(SQLException E)
        {
            System.out.println(E.getMessage());
        }
    }

    void salesdetails(int starnsid,Object[][] purchase) throws SQLException
    {
        String query = "insert into salesdetails(stransid,batch_id,product_id,quantity) values (?,?,?,?);";
        String[][] purchaseStringArray = new String[purchase.length][purchase[0].length];

        for (int i = 0; i < prod; i++) {
            for (int j = 0; j < purchase[0].length; j++) {
                purchaseStringArray[i][j] = String.valueOf(purchase[i][j]);
            }
        }

        try(Connection con = DbConnection.getConnection())
        {
            PreparedStatement pst = con.prepareStatement(query);

            for(int i=0;i<prod;i++)
            {
                String batch_id = purchaseStringArray[i][0];
                int product_id = Integer.parseInt(purchaseStringArray[i][1]);
                int quantity = Integer.parseInt(purchaseStringArray[i][3]);

                // Set parameters in the PreparedStatement
                pst.setInt(1, stransid);
                pst.setString(2, batch_id);
                pst.setInt(3, product_id);
                pst.setInt(4, quantity);
                pst.executeUpdate();
            }
        }catch(SQLException E)
        {
            System.out.println(E.getMessage());
        }catch(Exception E)
        {
            System.out.println(E.getMessage());
        }
    }

    boolean updateprodtb() throws SQLException {
        String selectQuery = "SELECT quantity, sold_quantity FROM products WHERE product_id = ? AND batch_id = ?";
        String updateQuantityQuery = "UPDATE products SET quantity = ? WHERE product_id = ? AND batch_id = ?";
        String updateSoldQuantityQuery = "UPDATE products SET sold_quantity = ? WHERE product_id = ? AND batch_id = ?";

        String[][] purchaseStringArray = new String[purchase.length][purchase[0].length];
        for (int i = 0; i < prod; i++) {
            for (int j = 0; j < purchase[0].length; j++) {
                purchaseStringArray[i][j] = String.valueOf(purchase[i][j]);
            }
        }

        try (Connection con = DbConnection.getConnection();
             PreparedStatement selectStmt = con.prepareStatement(selectQuery);
             PreparedStatement updateQuantityStmt = con.prepareStatement(updateQuantityQuery);
             PreparedStatement updateSoldQuantityStmt = con.prepareStatement(updateSoldQuantityQuery)) {

            for (int i = 0; i < prod; i++) {
                selectStmt.setInt(1, Integer.parseInt(purchase[i][1].toString()));
                selectStmt.setString(2, purchase[i][0].toString());
                ResultSet rs = selectStmt.executeQuery();

                if (rs.next()) {
                    int quantity = rs.getInt("quantity");
                    int soldQuantity = rs.getInt("sold_quantity");

                    int purchasedQuantity = Integer.parseInt(purchase[i][3].toString());

                    if (quantity >= purchasedQuantity) {
                        int newQuantity = quantity - purchasedQuantity;
                        int newSoldQuantity = soldQuantity + purchasedQuantity;

                        updateQuantityStmt.setInt(1, newQuantity);
                        updateQuantityStmt.setInt(2, Integer.parseInt(purchase[i][1].toString()));
                        updateQuantityStmt.setString(3, purchase[i][0].toString());
                        updateQuantityStmt.executeUpdate();

                        updateSoldQuantityStmt.setInt(1, newSoldQuantity);
                        updateSoldQuantityStmt.setInt(2, Integer.parseInt(purchase[i][1].toString()));
                        updateSoldQuantityStmt.setString(3, purchase[i][0].toString());
                        updateSoldQuantityStmt.executeUpdate();
                    } else {
                        return false; // Quantity not sufficient
                    }
                } else {
                    return false; // Product not found
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true; // All updates successful
    }

}