import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminHome extends JFrame {
    JButton addCashier,deleteCashier,addProduct,deleteProduct,updateProduct;
    JLabel addc,dltc,addp,dltp,uptp,header;
    JPanel cont;

    int labelX,labelY;
    Dimension labelSize;

    AdminHome()
    {
        setTitle("AdminPage");

        setVisible(true);

        setSize(1300,800);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(new Color(255, 87, 51));

        cont = new JPanel();

        this.setLayout(null);

        cont.setBackground(new Color(255,255,255));

        cont.setBounds(170,160,900,400);
        cont.setLayout(null);

        header = new JLabel();
        header.setText("SELECT OPERATION");
        header.setFont(new Font("Consolas",Font.PLAIN,45));
        header.setBounds(250,50,900,45);

        addCashier = new JButton();
        addCashier.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Billing_System\\src\\profile.png").getImage().getScaledInstance(200,100, Image.SCALE_SMOOTH)));
        addCashier.setBounds(150,150,100,80);
        addc = new JLabel();
        addc.setText("Add Cashier");
        addc.setFont(new Font("Consolas",Font.PLAIN,15));
        labelSize = addc.getPreferredSize();
        labelX = (addCashier.getWidth() - labelSize.width) / 2 + addCashier.getX();
        labelY = addCashier.getY() + addCashier.getHeight() + 5; //
        addc.setBounds(labelX, labelY, labelSize.width, labelSize.height);

        deleteCashier = new JButton();
        deleteCashier.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Billing_System\\src\\deleteuser.png").getImage().getScaledInstance(120,80, Image.SCALE_SMOOTH)));
        deleteCashier.setBounds(280,150,100,80);
        dltc = new JLabel();
        dltc.setText("Delete Cashier");
        dltc.setFont(new Font("Consolas",Font.PLAIN,15));
        labelSize = dltc.getPreferredSize();
        labelX = (deleteCashier.getWidth() - labelSize.width) / 2 + deleteCashier.getX();
        labelY = deleteCashier.getY() + deleteCashier.getHeight() + 5; //
        dltc.setBounds(labelX, labelY, labelSize.width, labelSize.height);

        addProduct = new JButton();
        addProduct.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Billing_System\\src\\addp.png").getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH)));
        addProduct.setBounds(410,150,100,80);
        addp = new JLabel();
        addp.setText("Add Product");
        addp.setFont(new Font("Consolas",Font.PLAIN,15));
        labelSize = addp.getPreferredSize();
        labelX = (addProduct.getWidth() - labelSize.width) / 2 + addProduct.getX();
        labelY = addProduct.getY() + addProduct.getHeight() + 5; //
        addp.setBounds(labelX, labelY, labelSize.width, labelSize.height);

        deleteProduct = new JButton();
        deleteProduct.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Billing_System\\src\\deleteprod.png").getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH)));
        deleteProduct.setBounds(540,150,100,80);
        dltp = new JLabel();
        dltp.setText("Delete Product");
        dltp.setFont(new Font("Consolas",Font.PLAIN,15));
        labelSize = dltp.getPreferredSize();
        labelX = (deleteProduct.getWidth() - labelSize.width) / 2 + deleteProduct.getX();
        labelY = deleteProduct.getY() + deleteProduct.getHeight() + 5; //
        dltp.setBounds(labelX, labelY, labelSize.width, labelSize.height);

        updateProduct = new JButton();
        updateProduct.setIcon(new ImageIcon(new ImageIcon("D:\\javaproject\\Billing_System\\src\\updateprod.png").getImage().getScaledInstance(70,70, Image.SCALE_SMOOTH)));
        updateProduct.setBounds(670,150,100,80);
        uptp = new JLabel();
        uptp.setText("Update Product");
        uptp.setFont(new Font("Consolas",Font.PLAIN,15));
        labelSize = uptp.getPreferredSize();
        labelX = (updateProduct.getWidth() - labelSize.width) / 2 + updateProduct.getX();
        labelY = updateProduct.getY() + updateProduct.getHeight() + 5; //
        uptp.setBounds(labelX, labelY, labelSize.width, labelSize.height);

        this.add(cont);
        cont.add(header);
        cont.add(addCashier);
        cont.add(addc);
        cont.add(deleteCashier);
        cont.add(dltc);
        cont.add(addProduct);
        cont.add(addp);
        cont.add(deleteProduct);
        cont.add(dltp);
        cont.add(updateProduct);
        cont.add(uptp);

    }
}
