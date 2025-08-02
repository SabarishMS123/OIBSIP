
package ATMinterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; // Although not directly used for deposit, good to keep for consistency if needed later
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ATMDeposit extends javax.swing.JFrame {
String accountNumber;
   
   private static final String DB_URL = "jdbc:mysql://localhost:3306/atm_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1522";
    public ATMDeposit() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(65, 74, 76));
        jTextField1.setText(""); // Clear the default "₹" text, allowing user to type
    }
    public ATMDeposit(String accountNumber) {
        this(); // Call the default constructor to initialize components
        this.accountNumber = accountNumber; // Store the account number for deposit operations
    }

   

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jLabel3.setText("jLabel3");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Handwriting", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("BANK MANAGEMENT SYSTEM");

        jLabel4.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 51));
        jLabel4.setText("Enter amount to Deposit:");

        jTextField1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jTextField1.setText("₹");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jButton1.setText("Deposit");
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
                .addGap(277, 277, 277)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(186, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(184, 184, 184))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(333, 333, 333))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(240, 240, 240)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(240, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addGap(57, 57, 57)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(88, 88, 88))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(167, 167, 167)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(167, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String amountStr = jTextField1.getText().trim();

       
        if (amountStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter the amount to deposit.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double depositAmount;
        try {
            depositAmount = Double.parseDouble(amountStr);
            if (depositAmount <= 0) {
                JOptionPane.showMessageDialog(this, "Deposit amount must be positive.", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid amount. Please enter a numeric value.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

       
        if (this.accountNumber == null || this.accountNumber.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Account number not identified. Please log in again.", "Error", JOptionPane.ERROR_MESSAGE);
            // Optionally, return to login or ATMService
            this.dispose();
            new ATMservice().setVisible(true);
            return;
        }

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null; 

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            conn.setAutoCommit(false); // Start transaction for atomicity

            // Check if the account actually exists before depositing (good practice, though ATMService already logged in)
            String checkAccountSql = "SELECT initial_amount FROM customers WHERE account_number = ?";
            pst = conn.prepareStatement(checkAccountSql);
            pst.setString(1, accountNumber);
            rs = pst.executeQuery();

            if (!rs.next()) {
                JOptionPane.showMessageDialog(this, "Your account was not found in the system. Please contact support.", "Deposit Failed", JOptionPane.ERROR_MESSAGE);
                conn.rollback();
                return;
            }
          
            rs.close(); 
            pst.close(); 
          
            String depositSql = "UPDATE customers SET initial_amount = initial_amount+ ? WHERE account_number = ?";
            pst = conn.prepareStatement(depositSql);
            pst.setDouble(1, depositAmount);
            pst.setString(2, accountNumber);

            int rowsAffected = pst.executeUpdate();

            if (rowsAffected > 0) {
                conn.commit(); 
                JOptionPane.showMessageDialog(this, "Successfully deposited ₹" + String.format("%.2f", depositAmount) + " into your account!", "Deposit Success", JOptionPane.INFORMATION_MESSAGE);
                
                this.dispose(); 
                new ATMservice().setVisible(true); 
            } else {
                conn.rollback(); 
                JOptionPane.showMessageDialog(this, "Deposit failed due to a database issue. Please try again.", "Deposit Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            try {
                if (conn != null) conn.rollback(); // Rollback on SQL error
            } catch (SQLException rbex) {
                System.err.println("Rollback failed: " + rbex.getMessage());
            }
            JOptionPane.showMessageDialog(this, "Database error during deposit: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
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
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ATMDeposit().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
