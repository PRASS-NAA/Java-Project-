import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class billing extends JFrame {
    JPanel panel;
    JSeparator line1,line2;
    JLabel pdetails,pid,pname,pquan,pprice;
    JTextField pidbox,pnamebox,pquanbox,ppricebox;
    JButton addbut,savebut,resetbut,closebut;
    JTable display;
    JScrollPane scrolldisplay;
    JLabel totamt,paidamt,balamt,calc;
    JTextField totamtbox,paidamtbox,balamtbox;

    public billing() {
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setTitle("Billing");

        panel = new JPanel();
        add(panel);
        panel.setLayout(null);
        panel.setBounds(0,150,1920,980);
        panel.setBackground(new Color(251, 240, 132));

        line1 = new JSeparator();
        panel.add(line1);
        line1.setBounds(0,125,1920,3);
        line1.setBackground(Color.yellow);

        pdetails = new JLabel("Product Details");
        panel.add(pdetails);
        pdetails.setBounds(30,100,200,100);
        pdetails.setFont(new Font("Tahoma", 1, 18));

        pid = new JLabel("Product ID:");
        panel.add(pid);
        pid.setBounds(100,150,200,100);
        pid.setFont(new Font("Tahoma", 1, 14));

        pidbox = new JTextField();
        panel.add(pidbox);
        pidbox.setBounds(200,193,200,20);
        pidbox.setFont(new Font("Tahoma", 1, 14));

        pname = new JLabel("Product Name:");
        panel.add(pname);
        pname.setBounds(450,150,200,100);
        pname.setFont(new Font("Tahoma", 1, 14));

        pnamebox = new JTextField();
        panel.add(pnamebox);
        pnamebox.setBounds(580,193,200,20);
        pnamebox.setFont(new Font("Tahoma", 1, 14));

        pquan = new JLabel("Quantity: ");
        panel.add(pquan);
        pquan.setBounds(820,150,200,100);
        pquan.setFont(new Font("Tahoma", 1, 14));

        pquanbox = new JTextField();
        panel.add(pquanbox);
        pquanbox.setBounds(900,193,50,20);
        pquanbox.setFont(new Font("Tahoma", 1, 14));

        pprice = new JLabel("Price: ");
        panel.add(pprice);
        pprice.setBounds(1000,150,200,100);
        pprice.setFont(new Font("Tahoma", 1, 14));

        ppricebox = new JTextField();
        panel.add(ppricebox);
        ppricebox.setBounds(1060,193,80,20);
        ppricebox.setFont(new Font("Tahoma", 1, 14));

        addbut = new JButton();
        panel.add(addbut);
        addbut.setBounds(1250,191,100,25);
        addbut.setIcon(new ImageIcon("C:\\Users\\manoj\\OneDrive\\Documents\\Java\\intellij\\deptui\\src\\main\\java\\icons\\add.png"));
        addbut.setText("ADD");
        addbut.setFont(new Font("Tahoma", 1, 14));
        addbut.setBackground(new Color(241,171,212));

        line2 = new JSeparator();
        panel.add(line2);
        line2.setBounds(0,255,1920,3);

        String[] columns = {"ID", "PRODUCT NAME", "QTY", "PRICE"};
        Object[][] data = {};
        display = new JTable(data, columns);
        scrolldisplay = new JScrollPane(display);
        panel.add(scrolldisplay);
        scrolldisplay.setBounds(20, 270, 770, 350);

        calc = new JLabel("Calculation");
        panel.add(calc);
        calc.setBounds(850,250,200,100);
        calc.setFont(new Font("Tahoma", 1, 18));

        totamt = new JLabel("Total amount: ");
        panel.add(totamt);
        totamt.setBounds(870,310,200,100);
        totamt.setFont(new Font("Tahoma", 1, 14));

        totamtbox = new JTextField();
        panel.add(totamtbox);
        totamtbox.setBounds(1015,351,150,25);
        totamtbox.setFont(new Font("Tahoma", 1, 14));

        paidamt = new JLabel("Paid amount: ");
        panel.add(paidamt);
        paidamt.setBounds(870,380,200,100);
        paidamt.setFont(new Font("Tahoma", 1, 14));

        paidamtbox = new JTextField();
        panel.add(paidamtbox);
        paidamtbox.setBounds(1015,420,150,25);
        paidamtbox.setFont(new Font("Tahoma", 1, 14));

        balamt = new JLabel("Balance amount: ");
        panel.add(balamt);
        balamt.setBounds(870,450,200,100);
        balamt.setFont(new Font("Tahoma", 1, 14));

        balamtbox = new JTextField();
        panel.add(balamtbox);
        balamtbox.setBounds(1015,489,150,25);
        balamtbox.setFont(new Font("Tahoma", 1, 14));

        savebut = new JButton();
        panel.add(savebut);
        savebut.setBounds(1300,350,120,25);
        savebut.setIcon(new ImageIcon("C:\\Users\\manoj\\OneDrive\\Documents\\Java\\intellij\\deptui\\src\\main\\java\\icons\\save.png"));
        savebut.setText("SAVE");
        savebut.setFont(new Font("Tahoma", 1, 14));
        savebut.setBackground(new Color(241,171,212));

        resetbut = new JButton();
        panel.add(resetbut);
        resetbut.setBounds(1300,420,120,25);
        resetbut.setIcon(new ImageIcon("C:\\Users\\manoj\\OneDrive\\Documents\\Java\\intellij\\deptui\\src\\main\\java\\icons\\Reset.png"));
        resetbut.setText("RESET");
        resetbut.setFont(new Font("Tahoma", 1, 14));
        resetbut.setBackground(new Color(241,171,212));

        closebut = new JButton();
        panel.add(closebut);
        closebut.setBounds(1300,489,120,25);
        closebut.setIcon(new ImageIcon("C:\\Users\\manoj\\OneDrive\\Documents\\Java\\intellij\\deptui\\src\\main\\java\\icons\\close Jframe.png"));
        closebut.setText("Close");
        closebut.setFont(new Font("Tahoma", 1, 14));
        closebut.setBackground(new Color(241,171,212));

    }
    public static void main(String[] args){
        new billing();
    }

}
