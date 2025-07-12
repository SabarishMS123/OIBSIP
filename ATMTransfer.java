
package ATMinterface;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ATMTransfer extends javax.swing.JFrame {
private String fromAccountNumber; // To store the account number from ATMService
    private static final String DB_URL = "jdbc:mysql://localhost:3306/atm_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1522";
     
    public ATMTransfer() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(65, 74, 76));
        // Initialize text fields
        jTextField1.setText(""); // To Account Number
        jTextField2.setText("");
    }

    
    public ATMTransfer(String accountNumber) {
        this(); // Call the default constructor to initialize components
        this.fromAccountNumber = accountNumber;
    }

   
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Handwriting", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("BANK MANAGEMENT SYSTEM");

        jLabel2.setText("To account:");

        jLabel3.setText("Amount To Transfer");

        jButton1.setText("Transfer");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(78, 78, 78)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(257, 257, 257)
                        .addComponent(jButton1)))
                .addContainerGap(209, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(54, 54, 54)
                .addComponent(jButton1)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String toAccountNumber = jTextField1.getText().trim();
        String amountStr = jTextField2.getText().trim();

        
        if (toAccountNumber.isEmpty() || amountStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter both the recipient account number and the amount.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double transferAmount;
        try {
            transferAmount = Double.parseDouble(amountStr);
            if (transferAmount <= 0) {
                JOptionPane.showMessageDialog(this, "Transfer amount must be positive.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (fromAccountNumber == null || fromAccountNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Sender account not identified. Please log in again.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (fromAccountNumber.equals(toAccountNumber)) {
            JOptionPane.showMessageDialog(this, "Cannot transfer to the same account.", "Transfer Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            conn.setAutoCommit(false); // Start transaction for atomicity

            
            String checkSenderSql = "SELECT initial_amount FROM customers WHERE account_number = ?";
            pst = conn.prepareStatement(checkSenderSql);
            pst.setString(1, fromAccountNumber);
            rs = pst.executeQuery();

            double senderBalance = -1;
            if (rs.next()) {
                senderBalance = rs.getDouble("initial_amount");
            } else {
                JOptionPane.showMessageDialog(this, "Sender account not found.", "Transfer Failed", JOptionPane.ERROR_MESSAGE);
                conn.rollback(); // Rollback in case of an issue
                return;
            }
            rs.close();
            pst.close();

            if (senderBalance < transferAmount) {
                JOptionPane.showMessageDialog(this, "Insufficient balance for transfer. Your current balance is: " + senderBalance, "Transfer Failed", JOptionPane.ERROR_MESSAGE);
                conn.rollback();
                return;
            }

            
            String checkRecipientSql = "SELECT account_number FROM customers WHERE account_number = ?";
            pst = conn.prepareStatement(checkRecipientSql);
            pst.setString(1, toAccountNumber);
            rs = pst.executeQuery();
            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Recipient account not found.", "Transfer Failed", JOptionPane.ERROR_MESSAGE);
                conn.rollback();
                return;
            }
            rs.close();
            pst.close();


            
            String debitSql = "UPDATE customers SET initial_amount = initial_amount - ? WHERE account_number = ?";
            pst = conn.prepareStatement(debitSql);
            pst.setDouble(1, transferAmount);
            pst.setString(2, fromAccountNumber);
            int debitRows = pst.executeUpdate();
            pst.close();

            
            String creditSql = "UPDATE customers SET initial_amount = initial_amount + ? WHERE account_number = ?";
            pst = conn.prepareStatement(creditSql);
            pst.setDouble(1, transferAmount);
            pst.setString(2, toAccountNumber);
            int creditRows = pst.executeUpdate();
            pst.close();

            if (debitRows > 0 && creditRows > 0) {
                conn.commit(); // Commit the transaction if both updates are successful
                JOptionPane.showMessageDialog(this, "Transfer of " + transferAmount + " from " + fromAccountNumber + " to " + toAccountNumber + " successful!", "Transfer Success", JOptionPane.INFORMATION_MESSAGE);
                
                this.dispose(); 
                new ATMservice().setVisible(true); 
            } else {
                conn.rollback(); // Rollback if any update failed
                JOptionPane.showMessageDialog(this, "Transfer failed due to a database issue. Please try again.", "Transfer Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException rbex) {
                System.err.println("Rollback failed: " + rbex.getMessage());
            }
            JOptionPane.showMessageDialog(this, "Database error during transfer: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
            try {
                if (conn != null) conn.rollback();
            } catch (SQLException rbex) {
                System.err.println("Rollback failed: " + rbex.getMessage());
            }
            JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                System.err.println("Error closing database resources: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
    public static void main(String args[]) {
       
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ATMTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ATMTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ATMTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ATMTransfer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ATMTransfer().setVisible(true);
            }
        });
    }

   
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    
}
