/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.billing;

/**
 *
 * @author hp
 */
public class bill extends javax.swing.JFrame {

    /**
     * Creates new form bill
     */
    public bill() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        LOGO = new javax.swing.JLabel();
        FORM_NAME = new javax.swing.JLabel();
        LDATE = new javax.swing.JLabel();
        LTIME = new javax.swing.JLabel();
        DATE = new javax.swing.JLabel();
        TIME = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        LNAME = new javax.swing.JLabel();
        TNAME = new javax.swing.JTextField();
        LPHONE = new javax.swing.JLabel();
        TPHONE = new javax.swing.JTextField();
        LEMAIL = new javax.swing.JLabel();
        TEMAIL = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        LPRODUCT_ID = new javax.swing.JLabel();
        LPRODUCT_NAME = new javax.swing.JLabel();
        LRATE = new javax.swing.JLabel();
        LQTY = new javax.swing.JLabel();
        TQTY = new javax.swing.JTextField();
        TRATE = new javax.swing.JTextField();
        TPRODUCT_NAME = new javax.swing.JTextField();
        TPRODUCT_ID = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        DISPLAY_TABLE = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        LTOTAL = new javax.swing.JLabel();
        LP_AMOUNT = new javax.swing.JLabel();
        LR_AMOUNT = new javax.swing.JLabel();
        TTOTLA = new javax.swing.JTextField();
        TP_AMOUNT = new javax.swing.JTextField();
        TR_AMOUNT = new javax.swing.JTextField();
        ADD = new javax.swing.JButton();
        SAVE = new javax.swing.JButton();
        RESET = new javax.swing.JButton();
        CLOSE = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        LOGO.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Desktop\\ICON\\bms\\billing.png")); // NOI18N
        LOGO.setText("jLabel1");
        getContentPane().add(LOGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 30, 61, -1));

        FORM_NAME.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Desktop\\ICON\\bms\\Billing ani.gif")); // NOI18N
        FORM_NAME.setText("jLabel2");
        getContentPane().add(FORM_NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(81, 6, 274, -1));

        LDATE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LDATE.setText("date:");
        getContentPane().add(LDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(882, 20, -1, -1));

        LTIME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LTIME.setText("TIME:");
        getContentPane().add(LTIME, new org.netbeans.lib.awtextra.AbsoluteConstraints(882, 67, -1, -1));

        DATE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DATE.setText("jLabel5");
        getContentPane().add(DATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(969, 20, -1, -1));

        TIME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TIME.setText("jLabel6");
        getContentPane().add(TIME, new org.netbeans.lib.awtextra.AbsoluteConstraints(969, 67, -1, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 1164, 10));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("CUSTOMER DETAILS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 136, -1, -1));

        LNAME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LNAME.setText("NAME");
        getContentPane().add(LNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 179, 43, -1));

        TNAME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(TNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 176, 150, -1));

        LPHONE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LPHONE.setText("PHONE NO");
        getContentPane().add(LPHONE, new org.netbeans.lib.awtextra.AbsoluteConstraints(248, 179, -1, -1));

        TPHONE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(TPHONE, new org.netbeans.lib.awtextra.AbsoluteConstraints(344, 176, 150, -1));

        LEMAIL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LEMAIL.setText("EMAIL");
        getContentPane().add(LEMAIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(512, 179, -1, -1));

        TEMAIL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        TEMAIL.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TEMAILActionPerformed(evt);
            }
        });
        getContentPane().add(TEMAIL, new org.netbeans.lib.awtextra.AbsoluteConstraints(576, 176, 230, -1));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 211, 1164, 10));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setText("PRODUCT DETAILS");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 227, -1, -1));

        LPRODUCT_ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LPRODUCT_ID.setText("PRODUCT ID");
        getContentPane().add(LPRODUCT_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 271, -1, -1));

        LPRODUCT_NAME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LPRODUCT_NAME.setText("PRODUCT NAME");
        getContentPane().add(LPRODUCT_NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(302, 271, -1, -1));

        LRATE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LRATE.setText("RATE");
        getContentPane().add(LRATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(606, 271, 43, -1));

        LQTY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LQTY.setText("QTY");
        getContentPane().add(LQTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(802, 271, 43, -1));

        TQTY.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(TQTY, new org.netbeans.lib.awtextra.AbsoluteConstraints(863, 268, 71, -1));

        TRATE.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(TRATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(667, 268, -1, -1));

        TPRODUCT_NAME.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(TPRODUCT_NAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(438, 268, 150, -1));

        TPRODUCT_ID.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(TPRODUCT_ID, new org.netbeans.lib.awtextra.AbsoluteConstraints(134, 268, 150, -1));
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 312, 1164, 10));

        DISPLAY_TABLE.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "NAME", "ID", "QTY", "TOTAL"
            }
        ));
        jScrollPane1.setViewportView(DISPLAY_TABLE);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 328, 584, 210));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("CALCULATION");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(608, 328, -1, -1));

        LTOTAL.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LTOTAL.setText("TOTAL ");
        getContentPane().add(LTOTAL, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 392, -1, -1));

        LP_AMOUNT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LP_AMOUNT.setText("PAID AMOUNT");
        getContentPane().add(LP_AMOUNT, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 447, -1, -1));

        LR_AMOUNT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        LR_AMOUNT.setText("RETURN AMOUNT");
        getContentPane().add(LR_AMOUNT, new org.netbeans.lib.awtextra.AbsoluteConstraints(618, 504, -1, -1));

        TTOTLA.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(TTOTLA, new org.netbeans.lib.awtextra.AbsoluteConstraints(769, 389, 150, -1));

        TP_AMOUNT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(TP_AMOUNT, new org.netbeans.lib.awtextra.AbsoluteConstraints(769, 444, 150, -1));

        TR_AMOUNT.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        getContentPane().add(TR_AMOUNT, new org.netbeans.lib.awtextra.AbsoluteConstraints(769, 501, 150, -1));

        ADD.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Desktop\\ICON\\bms\\add.png")); // NOI18N
        ADD.setText("ADD");
        getContentPane().add(ADD, new org.netbeans.lib.awtextra.AbsoluteConstraints(1004, 267, -1, -1));

        SAVE.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Desktop\\ICON\\bms\\save.png")); // NOI18N
        SAVE.setText("SAVE");
        getContentPane().add(SAVE, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 388, 88, -1));

        RESET.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Desktop\\ICON\\bms\\Reset.png")); // NOI18N
        RESET.setText("RESET");
        RESET.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RESETActionPerformed(evt);
            }
        });
        getContentPane().add(RESET, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 443, 88, -1));

        CLOSE.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Desktop\\ICON\\bms\\close Jframe.png")); // NOI18N
        CLOSE.setText("CLOSE");
        getContentPane().add(CLOSE, new org.netbeans.lib.awtextra.AbsoluteConstraints(1002, 502, -1, 23));

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\hp\\Desktop\\ICON\\bms\\billing background.png")); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1160, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TEMAILActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TEMAILActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TEMAILActionPerformed

    private void RESETActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RESETActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_RESETActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(bill.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new bill().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ADD;
    private javax.swing.JButton CLOSE;
    private javax.swing.JLabel DATE;
    private javax.swing.JTable DISPLAY_TABLE;
    private javax.swing.JLabel FORM_NAME;
    private javax.swing.JLabel LDATE;
    private javax.swing.JLabel LEMAIL;
    private javax.swing.JLabel LNAME;
    private javax.swing.JLabel LOGO;
    private javax.swing.JLabel LPHONE;
    private javax.swing.JLabel LPRODUCT_ID;
    private javax.swing.JLabel LPRODUCT_NAME;
    private javax.swing.JLabel LP_AMOUNT;
    private javax.swing.JLabel LQTY;
    private javax.swing.JLabel LRATE;
    private javax.swing.JLabel LR_AMOUNT;
    private javax.swing.JLabel LTIME;
    private javax.swing.JLabel LTOTAL;
    private javax.swing.JButton RESET;
    private javax.swing.JButton SAVE;
    private javax.swing.JTextField TEMAIL;
    private javax.swing.JLabel TIME;
    private javax.swing.JTextField TNAME;
    private javax.swing.JTextField TPHONE;
    private javax.swing.JTextField TPRODUCT_ID;
    private javax.swing.JTextField TPRODUCT_NAME;
    private javax.swing.JTextField TP_AMOUNT;
    private javax.swing.JTextField TQTY;
    private javax.swing.JTextField TRATE;
    private javax.swing.JTextField TR_AMOUNT;
    private javax.swing.JTextField TTOTLA;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables
}
