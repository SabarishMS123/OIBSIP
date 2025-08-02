
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException; 
import javax.swing.JOptionPane;

public class Registerform extends javax.swing.JFrame {


    public Registerform() {
        initComponents();getContentPane().setBackground(new java.awt.Color(204, 204, 255));
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
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextField6 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Handwriting", 1, 24)); // NOI18N
        jLabel1.setText("ONLINE RESERVATION SYSTEM");

        jLabel3.setFont(new java.awt.Font("Lucida Handwriting", 1, 12)); // NOI18N
        jLabel3.setText("ID");

        jLabel4.setFont(new java.awt.Font("Lucida Handwriting", 1, 12)); // NOI18N
        jLabel4.setText("PASSWORD");

        jLabel5.setFont(new java.awt.Font("Lucida Handwriting", 1, 12)); // NOI18N
        jLabel5.setText("CONFIRM PASSWORD");

        jLabel6.setFont(new java.awt.Font("Lucida Handwriting", 1, 12)); // NOI18N
        jLabel6.setText("ADDRESS");

        jLabel9.setFont(new java.awt.Font("Lucida Handwriting", 1, 12)); // NOI18N
        jLabel9.setText("START PLACE");

        jLabel10.setFont(new java.awt.Font("Lucida Handwriting", 1, 12)); // NOI18N
        jLabel10.setText("END PLACE");

        jButton1.setText("REGISTER ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Lucida Handwriting", 0, 12)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel9))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(151, 151, 151)
                                .addComponent(jLabel10)))
                        .addGap(91, 91, 91)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                            .addComponent(jTextField2)
                            .addComponent(jTextField3)
                            .addComponent(jTextField4)
                            .addComponent(jTextField5)
                            .addComponent(jTextField6)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jButton1))
                    .addComponent(jButton2))
                .addContainerGap(71, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel7)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
        String idText = jTextField1.getText();
        String password = jTextField2.getText();
        String confirmPassword = jTextField3.getText();
        String address = jTextField4.getText();
        String startPlace = jTextField5.getText();
        String endPlace = jTextField6.getText();

       
        if (idText.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() ||
            address.isEmpty() || startPlace.isEmpty() || endPlace.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required. Please fill them.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return; 
        }

      
        int id;
        try {
            id = Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "User ID must be a valid number.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return; 
        }

     
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Password and Confirm Password do not match.", "Input Error", JOptionPane.WARNING_MESSAGE);
            return; 
        }

     
        if (password.length() < 6) {
             JOptionPane.showMessageDialog(this, "Password should be at least 6 characters long.", "Input Error", JOptionPane.WARNING_MESSAGE);
             return;
        }
        
 
        Connection con = null;
        PreparedStatement pstmt = null;

        try {
       
            Class.forName("com.mysql.cj.jdbc.Driver"); 
            
         
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinereservation", "root", "1522");
            System.out.println("Connection to database established successfully.");

            
            String insertSql = "INSERT INTO userinfo (id, password, address, start_place, end_place) VALUES (?, ?, ?, ?, ?)";
            
            pstmt = con.prepareStatement(insertSql);
            
      
            pstmt.setInt(1, id);

            pstmt.setString(2, password); 
            pstmt.setString(3, address);
            pstmt.setString(4, startPlace);
            pstmt.setString(5, endPlace);

          
            int rowsAffected = pstmt.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(this, "Registration successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
              
                jTextField1.setText("");
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jTextField6.setText("");
                
            
            } else {
                JOptionPane.showMessageDialog(this, "Registration failed. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException ex) {
           
            System.err.println("Database Error: " + ex.getMessage());
          
            if (ex.getErrorCode() == 1062) { // MySQL error code for duplicate entry
                 JOptionPane.showMessageDialog(this, "User ID already exists. Please choose a different ID.", "Registration Error", JOptionPane.ERROR_MESSAGE);
            } else {
                 JOptionPane.showMessageDialog(this, "A database error occurred during registration: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (ClassNotFoundException ex) {
            
            System.err.println("JDBC Driver Error: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "MySQL JDBC Driver not found. Please ensure it's in your classpath.", "Driver Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
           
            System.err.println("An unexpected error occurred: " + ex.getMessage());
            JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            
            try {
                if (pstmt != null) pstmt.close();
                if (con != null) con.close();
            } catch (SQLException ex) {
                System.err.println("Error closing database resources: " + ex.getMessage());
            }
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         FrontPage log = new FrontPage();
        log.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

   
    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registerform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
