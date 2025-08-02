
package ATMinterface;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import javax.swing.JOptionPane; 

public class ATMregister extends javax.swing.JFrame {
     

   
    public ATMregister() {
        initComponents();
         getContentPane().setBackground(new java.awt.Color(65,74,76));
         jTextField7.setEditable(false);
    }
private boolean isAccountNumberUnique(String accNo) {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    boolean unique = true;
    try {
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm_db", "root", "1522");
        // THIS IS THE CORRECTED LINE:
        String sql = "SELECT COUNT(*) FROM customers WHERE account_number = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, accNo);
        rs = pstmt.executeQuery();
        if (rs.next()) {
            if (rs.getInt(1) > 0) {
                unique = false; // Account number already exists
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(this, "Database error checking account uniqueness: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
        ex.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    return unique;
}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel15 = new javax.swing.JLabel();
        jTextField7 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Handwriting", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 51, 51));
        jLabel1.setText("BANK MANAGEMENT SYSTEM");

        jLabel2.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 255, 102));
        jLabel2.setText("NAME");

        jLabel3.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 255, 102));
        jLabel3.setText("PHONE NUMBER");

        jLabel4.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 255, 102));
        jLabel4.setText("PAN NO");

        jLabel5.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 255, 102));
        jLabel5.setText("AADHAAR NO");

        jLabel6.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 255, 102));
        jLabel6.setText("AGE");

        jLabel8.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 255, 102));
        jLabel8.setText("ADDRESS");

        jLabel9.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 255, 102));
        jLabel9.setText("OCCUPATION");

        jLabel10.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 255, 102));
        jLabel10.setText("MARITAL STATUS");

        jLabel11.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 255, 102));
        jLabel11.setText("ACCOUNT TYPE");

        jLabel12.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(102, 255, 102));
        jLabel12.setText("PASSWORD");

        jLabel13.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(102, 255, 102));
        jLabel13.setText("CONFIRM PASSWORD");

        jLabel14.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(102, 255, 102));
        jLabel14.setText("INITIAL AMOUNT");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Married", "UnMarried", " " }));

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CA", "SA" }));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jLabel15.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(102, 255, 102));
        jLabel15.setText("ACC NO:");

        jButton1.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jButton1.setText("GENERATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Lucida Handwriting", 1, 18)); // NOI18N
        jButton2.setText("SAVE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jButton3.setText("Back");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(399, 399, 399))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(133, 133, 133)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel14)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel11)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel13)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(65, 65, 65)
                                                .addComponent(jLabel15)))
                                        .addGap(42, 42, 42)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1))
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jTextField10, javax.swing.GroupLayout.DEFAULT_SIZE, 121, Short.MAX_VALUE)
                                                .addComponent(jTextField11)
                                                .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton3)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(49, 49, 49)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel10)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(24, 24, 24))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(jTextField10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)
                            .addComponent(jTextField11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 14, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(jTextField7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1))
                        .addGap(32, 32, 32)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String name = jTextField1.getText();
        String phoneNo = jTextField2.getText();
        String panNo = jTextField3.getText();
        String aadhaarNo = jTextField4.getText();
        int age = 0;
        try {
            age = Integer.parseInt(jTextField5.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid age.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String occupation = jTextField6.getText();
        String address = jTextArea1.getText();
        String maritalStatus = (String) jComboBox1.getSelectedItem();
        String accountType = (String) jComboBox2.getSelectedItem();
        String password = jTextField10.getText();
        String confirmPassword = jTextField11.getText();
        double initialAmount = 0.0;
        String accNo = jTextField7.getText(); 

        
        if (name.isEmpty() || phoneNo.isEmpty() || panNo.isEmpty() || aadhaarNo.isEmpty() ||
            occupation.isEmpty() || address.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || accNo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            
            String amountText = jTextField12.getText().replace("₹", "").trim();
            initialAmount = Double.parseDouble(amountText);
            if (initialAmount < 0) {
                 JOptionPane.showMessageDialog(this, "Initial amount cannot be negative.", "Input Error", JOptionPane.ERROR_MESSAGE);
                 return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter a valid initial amount.", "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }


        
        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
           
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/atm_db", "root", "1522");

            
            String sql = "INSERT INTO customers(name, phone_number, pan_no, aadhaar_no, age, occupation, address, marital_status, account_type, account_number, password, initial_amount) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pstmt = conn.prepareStatement(sql);

            
            pstmt.setString(1, name);
            pstmt.setString(2, phoneNo);
            pstmt.setString(3, panNo);
            pstmt.setString(4, aadhaarNo);
            pstmt.setInt(5, age);
            pstmt.setString(6, occupation);
            pstmt.setString(7, address);
            pstmt.setString(8, maritalStatus);
            pstmt.setString(9, accountType);
            pstmt.setString(10, accNo);
            pstmt.setString(11, password); 
            pstmt.setDouble(12, initialAmount);

           
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
                
                clearFormFields();
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace(); 
        } finally {
            
            try {
                if (pstmt != null) pstmt.close();
                if (conn != null) conn.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       
        Random random = new Random();
        String accountNumber = "ACC" + String.format("%07d", random.nextInt(10000000)); // ACC + 7 digits

        
        if (!isAccountNumberUnique(accountNumber)) {
            
            accountNumber = "ACC" + String.format("%07d", random.nextInt(10000000));
        }
        jTextField7.setText(accountNumber);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
         ATMFront front =new ATMFront();
        front.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton3ActionPerformed
 private void clearFormFields() {
        jTextField1.setText("");
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField6.setText("");
        jTextArea1.setText("");
        jComboBox1.setSelectedIndex(0);
        jComboBox2.setSelectedIndex(0);
        jTextField10.setText("");
        jTextField11.setText("");
        jTextField12.setText("₹");
        jTextField7.setText("");
    }
  
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ATMregister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    // End of variables declaration//GEN-END:variables
}
