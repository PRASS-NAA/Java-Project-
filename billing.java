import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class billing extends JFrame
{
    JPanel panel;
    JLabel logo,total,paidamt,balamt,calculation,pdetails,pid,pname,qty,pprice,date,time;
    JSeparator line_1,line_2;
    JTextField pidbox,pnamebox,qtybox,ppricebox,totalbox,paidamtbox,balamtbox;
    JButton addbtn,closebtn,resetbtn,savebtn,deleteButton;
    JTable display;
    JScrollPane scrolldisplay;



     static final String DB_URL = "jdbc:mysql://localhost:3306/billing_system";
     static final String USER = "root";
     static final String PASS = "ayubkhan";




    billing() throws SQLException
    {


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

        date = new JLabel("DATE:");
        panel.add(date);
        date.setBounds(1250,0,200,40);
        date.setFont(new Font("Tahoma", 1, 14));

        time = new JLabel("TIME:");
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

        pid = new JLabel("PRODUCT ID");
        panel.add(pid);
        pid.setBounds(90,150,200,100);
        pid.setFont(new Font("Tahoma", 1, 14));


        pidbox = new JTextField();
        panel.add(pidbox);
        pidbox.setBounds(200,190,200,20);
        pidbox.setFont(new Font("Tahoma", 1, 14));

        pname = new JLabel("PRODUCT NAME");
        panel.add(pname);
        pname.setBounds(450,150,200,100);
        pname.setFont(new Font("Tahoma", 1, 14));


        pnamebox = new JTextField();
        panel.add(pnamebox);
        pnamebox.setBounds(580,190,200,20);
        pnamebox.setFont(new Font("Tahoma", 1, 14));

        qty = new JLabel("QTY");
        panel.add(qty);
        qty.setBounds(830,150,200,100);
        qty.setFont(new Font("Tahoma", 1, 14));


        qtybox = new JTextField();
        panel.add(qtybox);
        qtybox.setBounds(880,190,50,20);
        qtybox.setFont(new Font("Tahoma", 1, 14));

        pprice = new JLabel("PRICE");
        panel.add(pprice);
        pprice.setBounds(980,150,200,100);
        pprice.setFont(new Font("Tahoma", 1, 14));


        ppricebox = new JTextField();
        panel.add(ppricebox);
        ppricebox.setBounds(1050,190,80,20);
        ppricebox.setFont(new Font("Tahoma", 1, 14));

        addbtn = new JButton();
        panel.add(addbtn);
        addbtn.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\bms\\add.png"));
        addbtn.setText("ADD");
        addbtn.setBackground(new Color(148, 93, 243, 211));
        addbtn.setBounds(1200, 187, 83, 25);

     deleteButton = new JButton();
     panel.add(deleteButton);
     deleteButton.setIcon(new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\bms\\delete.png"));
     deleteButton.setText("DELETE");
     deleteButton.setBackground(new Color(148, 93, 243, 211));
     deleteButton.setBounds(1350, 187, 106, 25);


        line_2 = new JSeparator(SwingConstants.HORIZONTAL);
        panel.add(line_2);
        line_2.setBounds(0,245,1920,3);
        line_2.setBackground(new Color(12,12,12));


        String[] columns = {"ID", "PRODUCT NAME", "QTY", "PRICE"};
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




    }


 private void pidboxActionPerformed(ActionEvent e) {
  String id = pidbox.getText();
  try {
   Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
   String query = "SELECT * FROM products WHERE pid = ?";
   PreparedStatement stmt = conn.prepareStatement(query);
   stmt.setString(1, id);
   ResultSet rs = stmt.executeQuery();

   if (rs.next()) {
    pnamebox.setText(rs.getString("pname"));
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
  String id = pidbox.getText();
  String name = pnamebox.getText();
  int quantity = Integer.parseInt(qtybox.getText());
  int price = Integer.parseInt(ppricebox.getText());



  TableModel model = display.getModel();
  DefaultTableModel newModel = new DefaultTableModel();

  // Flag to check if the product exists in the table
  boolean productExists = false;

  // Iterate through the rows to check if the product exists
  for (int i = 0; i < model.getRowCount(); i++) {
   if (id.equals(model.getValueAt(i, 0).toString())) { // Check if the product ID matches
    // Update the quantity and price of the existing row
    int updatedQuantity = Integer.parseInt(model.getValueAt(i, 2).toString()) + quantity;
    int updatedPrice = price; // Assuming the price remains the same
    model.setValueAt(updatedQuantity, i, 2);
    model.setValueAt(updatedPrice, i, 3);
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

   newModel.addRow(new Object[]{id, name, quantity, price});
   display.setModel(newModel);
  }

  // Update the total amount
  updateTotalAmount((DefaultTableModel) display.getModel());
 }


 public void deleteSelectedRow() {
  DefaultTableModel model = (DefaultTableModel) display.getModel();
  int selectedRowIndex = display.getSelectedRow();

  if (selectedRowIndex != -1) { // Check if a row is selected
   model.removeRow(selectedRowIndex); // Remove the selected row
   updateTotalAmount(model); // Update the total amount after removing the row
  } else {
   // Show a message indicating that no row is selected
   JOptionPane.showMessageDialog(null, "Please select a row to delete.", "No Row Selected", JOptionPane.WARNING_MESSAGE);
  }
 }
 private void updateTotalAmount(DefaultTableModel model) {
  int totalAmount = 0;
  for (int i = 0; i < model.getRowCount(); i++) {
   totalAmount += Integer.parseInt(model.getValueAt(i, 2).toString()) * Integer.parseInt(model.getValueAt(i, 3).toString());
  }
  totalbox.setText(String.valueOf(totalAmount));
 }



 private void updateBalanceAmount() {
  try {
   int totalAmount = Integer.parseInt(totalbox.getText());
   int paidAmount = Integer.parseInt(paidamtbox.getText());
   int balanceAmount =   paidAmount - totalAmount;
   balamtbox.setText(String.valueOf(balanceAmount));
  } catch (NumberFormatException ex) {
   // Handle invalid input (non-numeric values)
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




}






