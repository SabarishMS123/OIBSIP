
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class LoginExam extends javax.swing.JFrame {

  
    
    public LoginExam() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Handwriting", 1, 24)); // NOI18N
        jLabel1.setText("ONLINE EXAMINATION  SYSTEM");

        jLabel2.setFont(new java.awt.Font("Lucida Handwriting", 1, 18)); // NOI18N
        jLabel2.setText("Front   form  ");

        jLabel3.setFont(new java.awt.Font("Lucida Handwriting", 1, 18)); // NOI18N
        jLabel3.setText("Username ");

        jLabel4.setFont(new java.awt.Font("Lucida Handwriting", 1, 18)); // NOI18N
        jLabel4.setText("Password");

        jButton1.setFont(new java.awt.Font("Lucida Handwriting", 1, 12)); // NOI18N
        jButton1.setText("LOGIN");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Lucida Handwriting", 1, 12)); // NOI18N
        jButton2.setText("UPDATE");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(133, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(112, 112, 112))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(160, 160, 160)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextField1)
                            .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(264, 264, 264)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(288, 288, 288)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel1)
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(91, 91, 91)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2)
                .addContainerGap(54, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String username = jTextField1.getText();
    String password = new String(jPasswordField1.getPassword());

    
    String url = "jdbc:mysql://localhost:3306/onlineexam";
    String dbUser = "root";
    String dbPassword = "1522";

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
       
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        
        con = DriverManager.getConnection(url, dbUser, dbPassword);

       
        String sql = "SELECT * FROM exam WHERE username = ? AND password = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, username);
        ps.setString(2, password);

        rs = ps.executeQuery();

        if (rs.next()) {
            
            JOptionPane.showMessageDialog(this, "Login Successful!");
            
            
             QuestionsFrame examFrame = new QuestionsFrame(username);
             examFrame.setVisible(true);
             this.dispose(); 
            
           
        } else {
            
            JOptionPane.showMessageDialog(this, "Invalid Username or Password.", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }

    } catch (ClassNotFoundException e) {
        JOptionPane.showMessageDialog(this, "MySQL JDBC Driver not found.", "Driver Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Database connection failed.", "Database Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    } finally {
    
        try {
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }       
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

       String username = jTextField1.getText();

       
        if (username.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a username to update.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Stop execution
        }
        
      
        UPDATEEXam updateFrame = new UPDATEEXam(username);
        updateFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginExam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
