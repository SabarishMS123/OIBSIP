
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;




public class LoginOnlineReservation extends javax.swing.JFrame {

   
    public LoginOnlineReservation() {
        initComponents();
        getContentPane().setBackground(new java.awt.Color(204, 204, 255));
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Lucida Handwriting", 1, 24)); // NOI18N
        jLabel1.setText("ONLINE RESERVATION SYSTEM");

        jLabel2.setFont(new java.awt.Font("Lucida Handwriting", 0, 14)); // NOI18N
        jLabel2.setText("USER ID ");

        jLabel3.setFont(new java.awt.Font("Lucida Handwriting", 0, 14)); // NOI18N
        jLabel3.setText("PASSWORD");

        jButton1.setFont(new java.awt.Font("Lucida Handwriting", 0, 14)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Lucida Handwriting", 0, 14)); // NOI18N
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
                        .addGap(93, 93, 93)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(jPasswordField1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(252, 252, 252)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)))
                .addContainerGap(125, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton2)
                .addGap(1, 1, 1)
                .addComponent(jLabel1)
                .addGap(93, 93, 93)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(59, 59, 59)
                .addComponent(jButton1)
                .addContainerGap(90, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       
       FrontPage log = new FrontPage();
        log.setVisible(true);
 
        this.dispose();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
 
         String idText = jTextField1.getText();
   
    String password = new String(jPasswordField1.getPassword());

   
    if (idText.isEmpty() || password.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Error: Both User ID and Password are required.", "Input Error", JOptionPane.WARNING_MESSAGE);
        return;
    }

    int id;
    try {
        id = Integer.parseInt(idText); 
    } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(this, "Error: User ID must be a number.", "Input Error", JOptionPane.WARNING_MESSAGE);
        return; 
    }

   
    try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinereservation", "root", "1522");
         PreparedStatement checkStmt = con.prepareStatement("SELECT id FROM userinfo WHERE id = ? AND password = ?")) { // Corrected SQL query

        System.out.println("Connection created successfully.");

        checkStmt.setInt(1, id);
        checkStmt.setString(2, password); 

        ResultSet rs = checkStmt.executeQuery();

        if (rs.next()) { 
            JOptionPane.showMessageDialog(this, "Login successful!", "Success", JOptionPane.INFORMATION_MESSAGE);
            
        } else {
            
            JOptionPane.showMessageDialog(this, "Invalid User ID or Password.", "Login Error", JOptionPane.ERROR_MESSAGE);
        }

    }catch (java.sql.SQLException ex) {
        
        System.out.println("Database error: " + ex.getMessage());
        JOptionPane.showMessageDialog(this, "Database error: " + ex.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);
    }
        
         catch (Exception e) {
        // Catch any other unexpected exceptions
        System.out.println("An unexpected error occurred: " + e.getMessage());
        JOptionPane.showMessageDialog(this, "An unexpected error occurred: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginOnlineReservation().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
