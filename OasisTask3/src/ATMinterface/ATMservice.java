
package ATMinterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ATMservice extends javax.swing.JFrame {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/atm_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "1522"; 
   
    public ATMservice() {
        initComponents();jTextField1.setText(""); // Account Number
        jTextField2.setText("");
        getContentPane().setBackground(new java.awt.Color(65, 74, 76));
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();

        jTextField4.setText("jTextField4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Handwriting", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("BANK MANAGEMENT SYSTEM");

        jLabel2.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 255, 153));
        jLabel2.setText("ACC NO:");

        jLabel3.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 153));
        jLabel3.setText("PASSWORD");

        jLabel4.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 255, 153));
        jLabel4.setText("ACC TYPE:");

        jLabel5.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 255, 153));
        jLabel5.setText("SERVICE");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CA", "SA", " " }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "WITHDRAW", "DEPOSIT", "TRANSFER", " " }));

        jButton1.setText("PROCEED");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(167, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(151, 151, 151))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(150, 150, 150)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(83, 83, 83)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(80, 80, 80)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(222, 222, 222)
                        .addComponent(jButton1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addComponent(jButton1)
                .addContainerGap(123, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String accountNumber = jTextField1.getText().trim();
        
        String password = jTextField2.getText(); // Directly get text from JTextField
        String accountType = (String) jComboBox1.getSelectedItem();
        String service = (String) jComboBox2.getSelectedItem();

       
        if (accountNumber.isEmpty() || password.isEmpty() || accountType == null || service == null) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields and select options.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        try {
            
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            
            String sql = "SELECT * FROM customers WHERE account_number = ? AND password = ? AND account_type = ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, accountNumber);
            pst.setString(2, password); // Passwords should be hashed in a real app for security
            pst.setString(3, accountType);

            rs = pst.executeQuery();

            if (rs.next()) {
                
                JOptionPane.showMessageDialog(this, "Login successful! Proceeding to " + service + ".", "Success", JOptionPane.INFORMATION_MESSAGE);

                
                switch (service) {
                    case "WITHDRAW":
                        ATMWithdraw withdrawFrame = new ATMWithdraw(accountNumber);
                        withdrawFrame.setVisible(true);
                        break;
                    case "DEPOSIT":
                        ATMDeposit depositFrame = new ATMDeposit(accountNumber);
                        depositFrame.setVisible(true);
                        break;
                    case "TRANSFER":
                        ATMTransfer transferFrame = new ATMTransfer(accountNumber);
                        transferFrame.setVisible(true);
                        break;
                    default:
                        JOptionPane.showMessageDialog(this, "Selected service is not yet implemented.", "Error", JOptionPane.WARNING_MESSAGE);
                        break;
                }
                this.dispose(); // Close the current ATMService window
            } else {
                // Invalid credentials
                JOptionPane.showMessageDialog(this, "Invalid Account Number, Password, or Account Type.", "Login Failed", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        } catch (Exception ex) {
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
                new ATMservice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}
