package org.example;

import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            //c_create_account c = new c_create_account();
            //c_delete_account cd = new c_delete_account();
            // gui = new login();
           // CashierHome c1 = new CashierHome();
            //AdminHome a1 = new AdminHome();
            //loading_screen l1 = new loading_screen();
           //addproduct a1 = new addproduct();
            //updateCashier u1 = new updateCashier();
            //delprod d1 = new delprod();
            try {
                //billing b1 = new billing();
                //member m1 = new member();
               //restock r1 = new restock();
                analysisinterface a1 = new analysisinterface();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}

