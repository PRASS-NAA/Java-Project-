import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            login gui = new login();
            gui.login_interface();
        });
    }
}
