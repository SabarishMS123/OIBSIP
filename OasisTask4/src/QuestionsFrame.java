
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;
import javax.swing.Timer;



public class QuestionsFrame extends javax.swing.JFrame {
  private Timer timer;
  private String loggedInUsername = "testuser";
    private int secondsRemaining = 10;
    
     public QuestionsFrame(String username) {
       
        this.loggedInUsername = username; 
        initComponents();
        startTimer(); 
    }

    private QuestionsFrame() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
 private void evaluateAndSaveMarks() {
 
    if (timer != null && timer.isRunning()) {
        timer.stop();
    }

    int score = 0;

    
    if (jRadioButton2.isSelected()) {
        score++;
    }
    
   
    if (jRadioButton3.isSelected()) {
        score++;
    }
    
   
    System.out.println("Calculated score: " + score);
    System.out.println("User: " + loggedInUsername);

 
    updateMarksInDatabase(loggedInUsername, score);

   
    JOptionPane.showMessageDialog(this, "Exam finished! Your score is: " + score + " out of 2.", "Exam Result", JOptionPane.INFORMATION_MESSAGE);
    
  
    this.dispose();
}

private void updateMarksInDatabase(String username, int score) {
    String url = "jdbc:mysql://localhost:3306/onlineexam";
    String dbUser = "root"; // Your MySQL username
    String dbPassword = "1522"; // Your MySQL password

    try (Connection con = DriverManager.getConnection(url, dbUser, dbPassword)) {
        String sql = "UPDATE exam SET marks = ? WHERE username = ?";
        PreparedStatement ps = con.prepareStatement(sql);
        
       
        System.out.println("Updating database with score: " + score);
        System.out.println("Updating database for user: " + username);

        ps.setInt(1, score);
        ps.setString(2, username);

        int rowsAffected = ps.executeUpdate();
        if (rowsAffected > 0) {
            System.out.println("Marks updated successfully for user: " + username + ". Rows affected: " + rowsAffected);
        } else {
            
            System.out.println("No rows were updated. Check if the username exists or if the data is already the same.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(this, "Failed to update marks in the database.", "Database Error", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
    }
}
 private void startTimer() {
        
        timer = new Timer(1000, new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                secondsRemaining--;
                
                if (secondsRemaining >= 0) {
                    // Correctly update the label (using the EDT)
                    int minutes = secondsRemaining / 60;
                    int seconds = secondsRemaining % 60;
                    // Note: I have renamed your JLabel to lblTimer for clarity
                    Timeleft.setText(String.format("%02d:%02d", minutes, seconds));
                }
                
                if (secondsRemaining <= 0) {
                    // When time runs out, stop the timer
                    timer.stop();
                    JOptionPane.showMessageDialog(QuestionsFrame.this, "Time's up!", "Timer", JOptionPane.WARNING_MESSAGE);
                    
                    // You would call your exam submission method here
                    // e.g., btnSubmitActionPerformed(null);
                }
            }
        });
        
        timer.start(); 
       
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Timeleft = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Handwriting", 1, 24)); // NOI18N
        jLabel1.setText("ONLINE  EXAMINATION  SYSTEM");

        jLabel2.setFont(new java.awt.Font("Lucida Handwriting", 1, 14)); // NOI18N
        jLabel2.setText("Timer");

        Timeleft.setText("      00:00");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("Question 1: which Is the capital of India?");
        jScrollPane1.setViewportView(jTextArea1);

        buttonGroup1.add(jRadioButton1);
        jRadioButton1.setText("Delhi");

        buttonGroup1.add(jRadioButton2);
        jRadioButton2.setText("New Delhi");

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jTextArea2.setText("Question 2:Who is the PM of India?\n");
        jScrollPane2.setViewportView(jTextArea2);

        buttonGroup2.add(jRadioButton3);
        jRadioButton3.setText("Modi");

        buttonGroup2.add(jRadioButton4);
        jRadioButton4.setText("Rahul Gandhi");

        jButton1.setFont(new java.awt.Font("Lucida Handwriting", 1, 12)); // NOI18N
        jButton1.setText("Save");
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
                        .addGap(118, 118, 118)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(383, 383, 383)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(Timeleft, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton1)
                            .addComponent(jRadioButton3))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButton4)
                            .addComponent(jRadioButton2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(260, 260, 260)
                        .addComponent(jButton1)))
                .addGap(164, 164, 164))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Timeleft, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jRadioButton1)
                        .addComponent(jRadioButton2))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jRadioButton3)
                            .addComponent(jRadioButton4)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37)
                .addComponent(jButton1)
                .addContainerGap(170, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        evaluateAndSaveMarks();
    }//GEN-LAST:event_jButton1ActionPerformed

   
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuestionsFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Timeleft;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
