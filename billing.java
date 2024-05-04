import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




public class billing extends JFrame{
    JPanel panel;
    JLabel logo,total,paidamt,balamt,calculation,pdetails,pid,pname,qty,pprice;
    JSeparator line_1,line_2;
    JTextField pidbox,pnamebox,qtybox,ppricebox,totalbox,paidamtbox,balamtbox;
    JButton addbtn,closebtn,resetbtn,savebtn;
    JTable display;
    JScrollPane scrolldisplay;

    billing()
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






















    }





}
