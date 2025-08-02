
package ATMinterface;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ATMWithdraw extends javax.swing.JFrame {
private String accountNumber; 

   
    private static final String DB_URL = "jdbc:mysql://localhost:3306/atm_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1522";
   
    public ATMWithdraw(String accNum) {
        this.accountNumber = accNum;
        initComponents();
        setTitle("ATM - Withdraw");
        getContentPane().setBackground(new java.awt.Color(65, 74, 76));
        setLocationRelativeTo(null); // Center the window
        loadCurrentBalance(); 
    }

private void loadCurrentBalance() {
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            String sql = "SELECT initial_amount FROM customers WHERE account_number = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, accountNumber);
            rs = pst.executeQuery();

            if (rs.next()) {
                double balance = rs.getDouble("initial_amount");
                // Using JOptionPane to display the current balance
                JOptionPane.showMessageDialog(this, "Current Balance: $" + String.format("%.2f", balance), "Account Balance", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Current Balance: N/A (Account not found)", "Account Balance", JOptionPane.WARNING_MESSAGE);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error loading balance: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
 
    

    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Handwriting", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("BANK MANAGEMENT SYSTEM");

        jTextField1.setFont(new java.awt.Font("Calibri", 1, 18)); // NOI18N
        jTextField1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentHidden(java.awt.event.ComponentEvent evt) {
                jTextField1ComponentHidden(evt);
            }
        });
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 102));
        jLabel2.setText("Enter   amount    to    withdraw");

        jButton1.setFont(new java.awt.Font("Lucida Handwriting", 1, 12)); // NOI18N
        jButton1.setText("Withdraw");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(51, 255, 51));
        jLabel4.setText("RS.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(94, 94, 94)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(233, 233, 233)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(jLabel3))))
                .addContainerGap(109, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(42, 42, 42)
                .addComponent(jLabel2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel4)))
                .addGap(57, 57, 57)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(83, 83, 83))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ComponentHidden(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jTextField1ComponentHidden
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ComponentHidden

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        String withdrawAmountStr = jTextField1.getText().replace("₹","").trim();
        double withdrawAmount;

        try {
            withdrawAmount = Double.parseDouble(withdrawAmountStr);
            if (withdrawAmount <= 0) {
                JOptionPane.showMessageDialog(this, "Withdrawal amount must be positive.", "Invalid Amount", JOptionPane.WARNING_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid numeric amount.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection conn = null;
        PreparedStatement selectPst = null;
        PreparedStatement updatePst = null;
        ResultSet rs = null;

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            conn.setAutoCommit(false); // Start transaction

            
            String selectSql = "SELECT initial_amount FROM customers WHERE account_number = ? FOR UPDATE"; // FOR UPDATE to lock the row
            selectPst = conn.prepareStatement(selectSql);
            selectPst.setString(1, accountNumber);
            rs = selectPst.executeQuery();

            if (rs.next()) {
                double currentBalance = rs.getDouble("initial_amount");

               
                if (currentBalance >= withdrawAmount) {
                    
                    double newBalance = currentBalance - withdrawAmount;

                   
                    String updateSql = "UPDATE customers SET initial_amount = ? WHERE account_number = ?";
                    updatePst = conn.prepareStatement(updateSql);
                    updatePst.setDouble(1, newBalance);
                    updatePst.setString(2, accountNumber);
                    int rowsAffected = updatePst.executeUpdate();

                    if (rowsAffected > 0) {
                        conn.commit(); // Commit the transaction
                        JOptionPane.showMessageDialog(this, 
                                "Withdrawal successful!\n" +
                                "Withdrawn: $" + String.format("%.2f", withdrawAmount) + "\n" +
                                "New Balance: $" + String.format("%.2f", newBalance), 
                                "Withdrawal Complete", JOptionPane.INFORMATION_MESSAGE);
                        
                        
                        jTextField1.setText("");
                       
                    } else {
                        conn.rollback(); 
                        JOptionPane.showMessageDialog(this, "Failed to update balance. Please try again.", "Withdrawal Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    conn.rollback(); 
                    JOptionPane.showMessageDialog(this, "Insufficient funds! Current balance: $" + String.format("%.2f", currentBalance), "Withdrawal Failed", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                conn.rollback(); 
                JOptionPane.showMessageDialog(this, "Account not found.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            try {
                if (conn != null) conn.rollback(); 
            } catch (SQLException rollbackEx) {
                rollbackEx.printStackTrace();
            }
            JOptionPane.showMessageDialog(this, "Database error during withdrawal: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (selectPst != null) selectPst.close();
                if (updatePst != null) updatePst.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
  
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ATMWithdraw("1234567890").setVisible(true);
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
