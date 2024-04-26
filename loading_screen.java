import javax.swing.*;
import java.awt.*;

public class loading_screen extends JFrame {

    private Container c;
    JLabel imglabel;
    private JProgressBar p_bar;

    loading_screen() {
        Color customColor_1 = new Color(0, 102, 102);
        Color customColor_2 = new Color(192, 192, 192);
        Color customColor_3 = new Color(54, 69, 79);
        Color customColor_4 = new Color(255, 253, 208);


        setTitle("Cashier Login Form");
        setVisible(true);
        setSize(666, 350);
        setLocation(450, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(customColor_3);

        c = getContentPane();
        c.setLayout(null);

        p_bar = new JProgressBar();
        p_bar.setMinimum(0);
        p_bar.setMaximum(100);
        p_bar.setStringPainted(true);
        p_bar.setForeground(customColor_1);
        p_bar.setBounds(0, 279, 666, 35);
        c.add(p_bar);
        ImageIcon gifIcon = new ImageIcon("C:\\Users\\hp\\Desktop\\javaproject\\login\\src\\grocery-cart.gif");
        imglabel = new JLabel(gifIcon);
        imglabel.setBounds(185, 25, 275, 200); // Adjust the size and position as needed
        c.add(imglabel);


        // Create and execute SwingWorker
        new ProgressTask().execute();
    }

    private class ProgressTask extends SwingWorker<Void, Integer> {
        @Override
        protected Void doInBackground() throws Exception {
            for (int i = 0; i < 100; i += 33) {
                Thread.sleep(2000); // Simulate a long-running task
                publish(i); // Send progress to process()
            }
            return null;
        }

        @Override
        protected void process(java.util.List<Integer> chunks) {
            for (Integer chunk : chunks) {
                p_bar.setValue(chunk);
                if (chunk > 30 && chunk < 70)
                    p_bar.setString("Wait for some time");
                else if (chunk > 70)
                    p_bar.setString("Almost finished loading");
                else
                    p_bar.setString("Loading started");
            }
        }

        @Override
        protected void done() {
            p_bar.setValue(100);
            p_bar.setString("Loading completed");
        }
    }


}
