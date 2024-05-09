import javax.swing.*;
import java.awt.*;
import java.awt.Font;
import java.io.FileOutputStream;
import java.sql.*;
import java.awt.event.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ImageIcon;
import com.itextpdf.text.*;
import java.io.IOException;

import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;











class newbilling extends JFrame {
    JPanel panel;
    JLabel  total, paidamt, balamt, calculation, pdetails, pid, pname, qty, pprice, date, time, batchid, cashiername, cashierid;
    JSeparator line_1, line_2;
    JTextField pidbox, pnamebox, qtybox, ppricebox, totalbox, paidamtbox, balamtbox, cashiernamebox, batchbox, cashieridbox;
    JButton addbtn, closebtn, resetbtn, savebtn, deleteButton, resetButton, testbtn;
    JTable display;
    JScrollPane scrolldisplay;

    Object[][] purchase = new Object[50][6];

    private static final String URL = "jdbc:mysql://localhost:3306/billing_system";
    private static final String userName = "root";
    private static final String passWord = "ayubkhan";


    newbilling() throws SQLException {


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setVisible(true);
        setBackground(new Color(255, 253, 208));


        panel = new JPanel();
        panel.setBounds(0, 120, 1920, 980);
        panel.setLayout(null);
        panel.setBackground(new Color(251, 241, 152));
        add(panel);

        ImageIcon logoIcon = new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\bms\\billing.png");
        JLabel logo = new JLabel(logoIcon);
        panel.add(logo);
        logo.setBounds(25, 20, 60, 60);

        ImageIcon logogif = new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\bms\\Billing ani.gif");
        JLabel logoani = new JLabel(logogif);
        panel.add(logoani);
        logoani.setBounds(100, 5, 286, 108);

        date = new JLabel("DATE:     " + LocalDate.now());
        panel.add(date);
        date.setBounds(1250, 0, 200, 40);
        date.setFont(new Font("Tahoma", 1, 14));

        cashierid = new JLabel("CASHIER ID:");
        panel.add(cashierid);
        cashierid.setBounds(850, 2, 200, 40);
        cashierid.setFont(new Font("Tahoma", 1, 14));


        cashieridbox = new JTextField();
        panel.add(cashieridbox);
        cashieridbox.setBounds(1000, 15, 150, 20);
        cashieridbox.setFont(new Font("Tahoma", 1, 14));

        cashiername = new JLabel("CASHIER NAME:");
        panel.add(cashiername);
        cashiername.setBounds(850, 35, 200, 40);
        cashiername.setFont(new Font("Tahoma", 1, 14));


        cashiernamebox = new JTextField();
        panel.add(cashiernamebox);
        cashiernamebox.setBounds(1000, 45, 150, 20);
        cashiernamebox.setFont(new Font("Tahoma", 1, 14));


        LocalTime currentTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = currentTime.format(formatter);

        time = new JLabel("TIME:    " + formattedTime);
        panel.add(time);
        time.setBounds(1250, 40, 200, 40);
        time.setFont(new Font("Tahoma", 1, 14));

        line_1 = new JSeparator(SwingConstants.HORIZONTAL);
        panel.add(line_1);
        line_1.setBounds(0, 125, 1920, 3);
        line_1.setBackground(new Color(12, 12, 12));


        pdetails = new JLabel("PRODUCT DETAILS");
        panel.add(pdetails);
        pdetails.setBounds(10, 100, 200, 100);
        pdetails.setFont(new Font("Tahoma", 1, 18));

        batchid = new JLabel("BATCH ID");
        panel.add(batchid);
        batchid.setBounds(30, 150, 100, 100);
        batchid.setFont(new Font("Tahoma", 1, 14));

        batchbox = new JTextField();
        panel.add(batchbox);
        batchbox.setBounds(110, 190, 100, 20);
        batchbox.setFont(new Font("Tahoma", 1, 14));

        pid = new JLabel("PRODUCT ID");
        panel.add(pid);
        pid.setBounds(220, 150, 100, 100);
        pid.setFont(new Font("Tahoma", 1, 14));


        pidbox = new JTextField();
        panel.add(pidbox);
        pidbox.setBounds(330, 190, 100, 20);
        pidbox.setFont(new Font("Tahoma", 1, 14));

        pname = new JLabel("PRODUCT NAME");
        panel.add(pname);
        pname.setBounds(460, 150, 150, 100);
        pname.setFont(new Font("Tahoma", 1, 14));


        pnamebox = new JTextField();
        panel.add(pnamebox);
        pnamebox.setBounds(580, 190, 200, 20);
        pnamebox.setFont(new Font("Tahoma", 1, 14));

        qty = new JLabel("QTY");
        panel.add(qty);
        qty.setBounds(815, 150, 50, 100);
        qty.setFont(new Font("Tahoma", 1, 14));


        qtybox = new JTextField();
        panel.add(qtybox);
        qtybox.setBounds(870, 190, 50, 20);
        qtybox.setFont(new Font("Tahoma", 1, 14));

        pprice = new JLabel("PRICE");
        panel.add(pprice);
        pprice.setBounds(950, 150, 70, 100);
        pprice.setFont(new Font("Tahoma", 1, 14));


        ppricebox = new JTextField();
        panel.add(ppricebox);
        ppricebox.setBounds(1010, 190, 80, 20);
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
        resetButton.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\bms\\Reset.png"));
        resetButton.setText("RESET");
        resetButton.setBackground(new Color(148, 93, 243, 211));
        resetButton.setBounds(1400, 187, 106, 25);


        line_2 = new JSeparator(SwingConstants.HORIZONTAL);
        panel.add(line_2);
        line_2.setBounds(0, 245, 1920, 3);
        line_2.setBackground(new Color(12, 12, 12));


        String[] columns = {"BATCH ID", "PRODUCT ID", "PRODUCT NAME", "QTY", "TOTAL MRP", "UNIT PRICE"};
        Object[][] data = {};
        display = new JTable(data, columns);
        scrolldisplay = new JScrollPane(display);
        panel.add(scrolldisplay);
        scrolldisplay.setBounds(20, 270, 770, 400);
        


        calculation = new JLabel("CALCULATION");
        panel.add(calculation);
        calculation.setBounds(850, 230, 200, 100);
        calculation.setFont(new Font("Tahoma", 1, 18));

        total = new JLabel("TOTAL");
        panel.add(total);
        total.setBounds(850, 320, 200, 100);
        total.setFont(new Font("Tahoma", 1, 15));

        totalbox = new JTextField();
        panel.add(totalbox);
        totalbox.setBounds(1050, 360, 150, 20);
        totalbox.setFont(new Font("Tahoma", 1, 14));


        paidamt = new JLabel("PAID AMOUNT");
        panel.add(paidamt);
        paidamt.setBounds(850, 400, 200, 100);
        paidamt.setFont(new Font("Tahoma", 1, 15));

        paidamtbox = new JTextField();
        panel.add(paidamtbox);
        paidamtbox.setBounds(1050, 440, 150, 20);
        paidamtbox.setFont(new Font("Tahoma", 1, 14));

        balamt = new JLabel("BALANCE AMOUNT");
        panel.add(balamt);
        balamt.setBounds(850, 480, 200, 100);
        balamt.setFont(new Font("Tahoma", 1, 15));

        balamtbox = new JTextField();
        panel.add(balamtbox);
        balamtbox.setBounds(1050, 520, 150, 20);
        balamtbox.setFont(new Font("Tahoma", 1, 14));


        savebtn = new JButton();
        panel.add(savebtn);
        savebtn.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\bms\\save.png"));
        savebtn.setText("SAVE");
        savebtn.setBackground(new Color(148, 93, 243, 211));
        savebtn.setBounds(1300, 400, 120, 25);
        savebtn.setFont(new Font("Tahoma", 1, 14));

        testbtn = new JButton();
        panel.add(testbtn);
        testbtn.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\bms\\bill.png"));
        testbtn.setText("BILL");
        testbtn.setBackground(new Color(148, 93, 243, 211));
        testbtn.setBounds(1300, 330, 120, 25);
        testbtn.setFont(new Font("Tahoma", 1, 14));

        resetbtn = new JButton();
        panel.add(resetbtn);
        resetbtn.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\bms\\Reset.png"));
        resetbtn.setText("RESET");
        resetbtn.setBackground(new Color(148, 93, 243, 211));
        resetbtn.setBounds(1300, 470, 120, 25);
        resetbtn.setFont(new Font("Tahoma", 1, 14));


        closebtn = new JButton();
        panel.add(closebtn);
        closebtn.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\bms\\close Jframe.png"));
        closebtn.setText("CLOSE");
        closebtn.setBackground(new Color(148, 93, 243, 211));
        closebtn.setBounds(1300, 550, 120, 25);
        closebtn.setFont(new Font("Tahoma", 1, 14));

        pidbox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                pidboxActionPerformed(e);
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


         PDFGenerator pdfGenerator = new PDFGenerator();

        testbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get data from the table
                DefaultTableModel model = (DefaultTableModel) display.getModel();
                Object[][] tableData = new Object[model.getRowCount()][model.getColumnCount()];
                for (int i = 0; i < model.getRowCount(); i++) {
                    for (int j = 0; j < model.getColumnCount(); j++) {
                        tableData[i][j] = model.getValueAt(i, j);
                    }
                }

                // Get the total amount
                double totalAmount = Double.parseDouble(totalbox.getText());

                // Call generatePDF with table data and total amount
                pdfGenerator.generatePDF(tableData, new String[]{"BATCH ID", "PRODUCT ID", "PRODUCT NAME", "QTY", "TOTAL MRP", "UNIT PRICE"}, totalAmount);
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

        try {
            switch (exist(phoneNumber)) {
                case 1: //number exist and member
                    JOptionPane.showMessageDialog(null, "member");
                    break;
                case 2: // number exist but not member
                    JOptionPane.showMessageDialog(null, "not a member");
                    int response1 = JOptionPane.showConfirmDialog(null, "Do you want membership?");
                    if (response1 == JOptionPane.YES_OPTION) {

                        //new member().setVisible(true);

                    } else if (response1 == JOptionPane.NO_OPTION) {

                    }
                    break;
                case 3: // is not a member
                    JOptionPane.showMessageDialog(null, "not in db");
                    int response2 = JOptionPane.showConfirmDialog(null, "Do you want membership?");
                    if (response2 == JOptionPane.YES_OPTION) {

                        //new member().setVisible(true);

                    } else if (response2 == JOptionPane.NO_OPTION) {
                        // Handle No option
                        // For example:
                        // doSomethingElse();
                    }

                    break;
                default:
                    JOptionPane.showMessageDialog(null,
                            "Error",
                            "Inane error",
                            JOptionPane.ERROR_MESSAGE);

            }
        } catch (SQLException E) {
            System.out.println(E.getMessage());
        }
    }

    int exist(String number) throws SQLException {
        String query = "select cname from customer where phone_no = ?;";

        try {
            Connection conn = DriverManager.getConnection(URL, userName, passWord);

            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, number);

            ResultSet rs1 = pst.executeQuery();

            if (rs1.next()) {
                String query2 = "select ismember from customer where phone_no = ? ;";
                PreparedStatement pst2 = conn.prepareStatement(query2);
                pst2.setString(1, number);

                ResultSet rs = pst2.executeQuery();

                if (rs.next()) {
                    String member = rs.getString(1);
                    System.out.println(member);
                    if (member.equals(new String("NO"))) {
                        return 2;
                    } else {
                        return 1;
                    }
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 3;
    }


    private void pidboxActionPerformed(ActionEvent e) {
        int id = Integer.parseInt(pidbox.getText());
        String bid = batchbox.getText();
        try {
            Connection conn = DriverManager.getConnection(URL, userName, passWord);
            String query = "SELECT * FROM products WHERE product_id = ? and batch_id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.setString(2, bid);
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

        if (bid == "" || id == "") {
            JOptionPane.showMessageDialog(null, "Enter the ID");
        }


        TableModel model = display.getModel();
        DefaultTableModel newModel = new DefaultTableModel();


        try {
            boolean productExists = false;
            int updatedPrice = (price * quantity);
            //totalbox.setText(new String(String.valueOf(updatedPrice)));
            for (int i = 0; i < model.getRowCount(); i++) {
                if (id.equals(model.getValueAt(i, 1).toString()) && bid.equals(model.getValueAt(i, 0).toString())) {

                    int updatedQuantity = Integer.parseInt(model.getValueAt(i, 3).toString()) + quantity;
                    updatedPrice = (price * updatedQuantity); // Assuming the price remains the same
                    model.setValueAt(updatedQuantity, i, 3);
                    model.setValueAt(updatedPrice, i, 4);
                    productExists = true;

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
                int prod = 0;
                Object[] next = new Object[]{bid, id, name, quantity, updatedPrice, price};
                newModel.addRow(next);


                for (int j = 0; j < 6; j++) {
                    purchase[prod][j] = next[j];
                    prod++;
                }


                for (int i = 0; i < prod; i++) {
                    for (int j = 0; j < 5; j++) {
                        System.out.print(purchase[i][j] + "\t");
                    }
                    System.out.println();
                }


                display.setModel(newModel);
            }


            updateTotalAmount((DefaultTableModel) display.getModel());


        } catch (Exception E) {
            System.out.println(E.getMessage());
        }
    }


    public void deleteSelectedRow() {
        DefaultTableModel model = (DefaultTableModel) display.getModel();
        int selectedRowIndex = display.getSelectedRow();

        if (selectedRowIndex != -1) {
            model.removeRow(selectedRowIndex);
            updateTotalAmount(model);
        } else {

            JOptionPane.showMessageDialog(null, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
        }
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
            int balanceAmount = paidAmount - totalAmount;
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







    public class PDFGenerator {

        public void generatePDF(Object[][] data, String[] columnNames, double total) {
            // Check if data array is empty
            if (data.length == 0) {
                JOptionPane.showMessageDialog(null, "No data to generate PDF.");
                return;
            }

            com.itextpdf.text.Document document = new com.itextpdf.text.Document();

            try {
                // Generate a unique filename with timestamp
                String filename = "products_" + System.currentTimeMillis() + ".pdf";
                PdfWriter.getInstance(document, new FileOutputStream(filename));
                document.open();

                // Add date and time
                PdfPTable dateTimeTable = new PdfPTable(1);
                PdfPCell dateTimeCell = new PdfPCell();
                dateTimeCell.setBorder(Rectangle.NO_BORDER);
                dateTimeCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                dateTimeCell.setPaddingRight(10);
                DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

                String dateTimeText = "Date: " + LocalDate.now().format(dateFormatter) + "\nTime: " + LocalTime.now().format(timeFormatter);

                dateTimeCell.addElement(new Phrase(dateTimeText, new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 10)));
                dateTimeTable.addCell(dateTimeCell);
                document.add(dateTimeTable);

                // Add header
                Paragraph header = new Paragraph("TORA TORA\n\n", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 16, com.itextpdf.text.Font.BOLD));
                header.setAlignment(Element.ALIGN_CENTER);
                document.add(header);

                PdfPTable table = new PdfPTable(data[0].length - 1); // Exclude the last column: product ID
                table.setWidthPercentage(100);
                table.setHeaderRows(1);

// Add column headers skipping the product ID column
                for (int i = 1; i < columnNames.length; i++) { // Start from index 1
                    PdfPCell cell = new PdfPCell(new Phrase(columnNames[i], new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, com.itextpdf.text.Font.BOLD)));
                    cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                    table.addCell(cell);
                }

// Add table data skipping the product ID column
                for (Object[] row : data) {
                    for (int i = 1; i < row.length; i++) { // Start from index 1
                        PdfPCell cell = new PdfPCell(new Phrase(row[i] != null ? row[i].toString() : "", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 10)));
                        table.addCell(cell);
                    }
                }

// Add total row
                PdfPCell totalLabelCell = new PdfPCell(new Phrase("Total:", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12, com.itextpdf.text.Font.BOLD)));
                totalLabelCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                table.addCell(totalLabelCell);

                PdfPCell totalValueCell = new PdfPCell(new Phrase(String.valueOf(total), new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12)));
                totalValueCell.setHorizontalAlignment(Element.ALIGN_RIGHT);
                totalValueCell.setColspan(columnNames.length - 1); // Span all columns except the last one
                table.addCell(totalValueCell);

                // Add the table to the PDF document
                document.add(table);

                // Add footer
                Paragraph footer = new Paragraph("\n\nThank you for shopping with us!", new com.itextpdf.text.Font(com.itextpdf.text.Font.FontFamily.HELVETICA, 12));
                footer.setAlignment(Element.ALIGN_CENTER);
                document.add(footer);

                // Close the document
                document.close();

                // Display success message
                JOptionPane.showMessageDialog(null, "PDF generated successfully: " + filename);

            } catch (DocumentException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error creating PDF: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error writing PDF to file: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }












}









