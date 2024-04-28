import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class c_create_account extends JFrame {
    JFrame frame;
    JPanel panel,panel2;
    JLabel title, id,r_id;
    JLabel name,r_name;
    JLabel phone,r_phone;
    JLabel dob,r_dob;
    JLabel r_user ,username,password;
    JPasswordField t_password;


    String p_id,p_user,p_password;
    String p_name;
    String p_dob;
    String p_phone;
    JTextField t_id,t_name,t_phone,t_dob,t_user;
    JButton create,refresh,add,back;
    JSeparator separator;



    c_create_account()
    {

        frame=new JFrame("ADD CASHIER");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(145, 253, 208));

        panel = new JPanel();
        panel.setBounds(300,185,500,450);
        panel.setBackground(new Color(146, 146, 146));

        title = new JLabel("NEW CASHIER ");
        panel.setLayout(null);
        panel.add(title);
        title.setBounds(250, 25, 500, 20);

        username = new JLabel("USER NAME : ");
        panel.setLayout(null);
        panel.add(username);
        username.setBounds(80, 100, 500, 20);
        t_user = new JTextField();
        t_user.setBounds(200, 100, 200, 20);
        panel.add(t_user);

        password = new JLabel("PASSWORD : ");
        panel.setLayout(null);
        panel.add(password);
        password.setBounds(80, 150, 500, 20);
        t_password = new JPasswordField();
        t_password.setBounds(200,150,200,20);
         panel.add(t_password);





        name = new JLabel("NAME : ");
        panel.setLayout(null);
        panel.add(name);
        name.setBounds(80, 200, 500, 20);
        t_name = new JTextField();
        t_name.setBounds(200, 200, 200, 20);
        panel.add(t_name);




        dob = new JLabel("DOB : ");
        panel.setLayout(null);
        panel.add(dob);
        dob.setBounds(80, 250, 500, 20);
        t_dob = new JTextField();
        t_dob.setBounds(200, 250, 200, 20);
        panel.add(t_dob);




        phone = new JLabel("PHONE NO : ");
        panel.setLayout(null);
        panel.add(phone);
        phone.setBounds(80, 300, 500, 20);
        t_phone = new JTextField();
        t_phone.setBounds(200, 300, 200, 20);
        panel.add(t_phone);

        create = new JButton("CREATE");
        panel.add(create);
        create.setBounds(320, 400, 83, 20);
        create.setBackground(new Color(236, 232, 229));
        create.addActionListener(submitListener);

        refresh = new JButton("CLEAR");
        panel.add(refresh);
        refresh.setBounds(210, 400, 90, 20);
        refresh.setBackground(new Color(236, 232, 229));
        refresh.addActionListener(refreshListener);

        separator = new JSeparator(JSeparator.VERTICAL);
        separator.setBounds(775, 0, 1, 375);
        separator.setBackground(new Color(0,0,0));
        panel.add(separator);

        back = new JButton("<<");
        panel.add(back);
        back.setBounds(5, 10, 70, 20);
        back.setBackground(new Color(146, 146, 146));




        frame.add(panel);




    }
    ActionListener submitListener = new ActionListener(){
        public void actionPerformed(ActionEvent e) {

            panel2 = new JPanel();
            panel2.setLayout(null);
            panel2.setBounds(802,185,400,450);
            panel2.setBackground(new Color(146, 146, 146));
            frame.add(panel2);

            title = new JLabel(" CASHIER DETAIL ");
            panel2.setLayout(null);
            panel2.add(title);
            title.setBounds(150, 25, 500, 20);

            p_user = t_user.getText();
            //p_id = t_id.getText();
            p_name = t_name.getText();
            p_dob = t_dob.getText();
            p_phone = t_phone.getText();

            r_user = new JLabel("username :      " + p_user);
            panel2.add(r_user);
            r_user.setBounds(100, 100, 200, 20);

            /*r_id = new JLabel("ID :                    " + p_id);
            panel2.add(r_id);
            r_id.setBounds(100, 150, 200, 20);*/

            r_name = new JLabel("NAME :             " + p_name);
            panel2.add(r_name);
            r_name.setBounds(100, 150, 200, 20);

            r_dob = new JLabel("DOB :               " + p_dob);
            panel2.add(r_dob);
            r_dob.setBounds(100, 200, 200, 20);

            r_phone = new JLabel("PHONE NO :    " + p_phone);
            panel2.add(r_phone);
            r_phone.setBounds(100, 300, 200, 20);

            add = new JButton("ADD");
            panel2.add(add);
            add.setBounds(220, 400, 83, 20);
            add.setBackground(new Color(236, 232, 229));
            //add.addActionListener(submitListener);

            frame.revalidate();
            frame.repaint();





        }
    };

    ActionListener refreshListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            // Clear text fields
            t_user.setText("");
            t_password.setText("");
            //t_id.setText("");
            t_name.setText("");
            t_dob.setText("");
            t_phone.setText("");

            // Clear result labels
            if (panel2 != null) {
                panel2.removeAll();
                frame.remove(panel2);
                frame.revalidate();
                frame.repaint();
                // Refresh the panel to reflect the changes
            }
        }
    };
}
