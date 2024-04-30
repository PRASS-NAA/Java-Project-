import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class c_delete_account extends JFrame {
    JFrame frame;
    JPanel panel,panel2;
    JLabel id,title,r_name,r_phone,r_dob;
    JTextField t_id,t_name,t_phone,t_dob;
    JButton search,back,refresh,delete;
    JLabel r_user;


    c_delete_account()
    {

        frame=new JFrame("DELETE CASHIER");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setBackground(new Color(145, 253, 208));

        panel = new JPanel();
        panel.setBounds(450,100,550,200);
        panel.setBackground(new Color(146, 146, 146));

        title = new JLabel("DELETE CASHIER ");
        panel.setLayout(null);
        panel.add(title);
        title.setBounds(225, 25, 500, 20);

        id = new JLabel("ID : ");
        panel.setLayout(null);
        panel.add(id);
        id.setBounds(80, 100, 500, 20);
        t_id = new JTextField();
        t_id.setBounds(175, 100, 200, 20);
        panel.add(t_id);

        search = new JButton("SEARCH");
        panel.add(search);
        search.setBounds(425, 100, 85, 20);
        search.setBackground(new Color(236, 232, 229));
        search.addActionListener(submitListener);

        refresh = new JButton("CLEAR");
        panel.add(refresh);
        refresh.setBounds(425, 150, 85, 20);
        refresh.setBackground(new Color(236, 232, 229));
        refresh.addActionListener(refreshListener);

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
            frame.add(panel2);
            panel2.setBounds(450,301,550,375);
            panel2.setBackground(new Color(146, 146, 146));


            title = new JLabel(" CASHIER DETAIL ");
            panel2.setLayout(null);
            panel2.add(title);
            title.setBounds(225, 25, 500, 20);

            r_user = new JLabel("username :      " );
            panel2.add(r_user);
            r_user.setBounds(100, 100, 200, 20);

            /*r_id = new JLabel("ID :                    " + p_id);
            panel2.add(r_id);
            r_id.setBounds(100, 150, 200, 20);*/

            r_name = new JLabel("NAME :             " );
            panel2.add(r_name);
            r_name.setBounds(100, 150, 200, 20);

            r_dob = new JLabel("DOB :               " );
            panel2.add(r_dob);
            r_dob.setBounds(100, 200, 200, 20);

            r_phone = new JLabel("PHONE NO :    " );
            panel2.add(r_phone);
            r_phone.setBounds(100, 250, 200, 20);

            delete = new JButton("DELETE");
            panel2.add(delete);
            delete.setBounds(235, 330, 83, 20);
            delete.setBackground(new Color(236, 232, 229));
            //add.addActionListener(submitListener);



        }
    };

    ActionListener refreshListener = new ActionListener() {
        public void actionPerformed(ActionEvent e) {

            t_id.setText("");

            if (panel2 != null) {
                panel2.removeAll();
                frame.remove(panel2);
                frame.revalidate();
                frame.repaint();

            }
        }
    };

}
