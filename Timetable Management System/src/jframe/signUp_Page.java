/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Kusal Tharindu
 */
public class signUp_Page extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public signUp_Page() {
        initComponents();
    }
    
    //validate the signup details
    public boolean validateLogin(){
    
    String name = txt_username.getText();
    String pwd = txt_password.getText();
    String email = txt_Email.getText();
        
    //JOptionPane.showMessageDialog(this, "okgggg");
    
     if (name.equals("") ) {
         JOptionPane.showMessageDialog(this, "Please enter Username ");
            return false;
     }
     
     if (pwd.equals("")) {
         JOptionPane.showMessageDialog(this, "Please enter Password ");
            return false;
     }
     
     if (email.equals("") || !email.matches("^.+@.+\\..+$") ) {
         JOptionPane.showMessageDialog(this, "Please enter valid Email ID");
            return false;
     }
     
     
    return true;
 
    }
    
    public boolean checkpassword(){
        boolean chekpassword = false;
        
        final int numUpLetter = 1;
        final int numLowerLetter = 1;
        final int numOfDigit = 1;
        
        int upperCount = 0;
        int lowercount = 0;
        int digitcount = 0;
        int lettercount = 0;
        
        //Scanner in = new Scanner(System.in);
        String input = txt_password.getText();
        
        //grabing whole length of string 
        int inputlen = input.length();
        
        //going through entier word and identify it lcase or uppercase or digit
        
        for(int i=0; i<inputlen; i++){
            char ch = input.charAt(i);// char 0 idala check
            
            if(Character.isUpperCase(ch))
                upperCount++;
                
            else if(Character.isLowerCase(ch))
                lowercount++;
                
            else if(Character.isDigit(ch))
                digitcount++;    
        }
        
        if(upperCount>= numUpLetter && lowercount>= numLowerLetter &&   digitcount >= numOfDigit ){
            //JOptionPane.showMessageDialog(this, "Please enter valid Email ID");
            chekpassword = true;
        }
        else{
            JOptionPane.showMessageDialog(this, "Please enter valid Password. It not match with system condition");
            if(upperCount< numUpLetter){
                
                JOptionPane.showMessageDialog(this, "upperCount not match");
                chekpassword = false;
            }
            
            if(lowercount< numLowerLetter){
                
                JOptionPane.showMessageDialog(this, "lowercount not match");
                chekpassword = false;
            }
            
            if(digitcount < numOfDigit){
                 
                JOptionPane.showMessageDialog(this, "digitcount not match");
                chekpassword = false;
            }
        }
        
     return chekpassword;
    
}
    
  //cherck the duplicate username 
    public boolean checkduplicateusers(){
        String name = txt_username.getText();
        //String User_type = combo_UserType.getSelectedItem().toString();
        String email = txt_Email.getText();
        
        boolean isExist = false;
        
        try {
            Connection con =DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from userdetails where name = ?");
            
            pst.setString(1, name);
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){ //rs.next()  name & pwd database eke thiyenawa
                isExist = true;
            }
            
            else {
                isExist = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExist;
    }
    
    //cherck the duplicate username 
    public boolean checkduplicateeEail(){
        String name = txt_username.getText();
        String email = txt_Email.getText();
        
        boolean isExist = false;
        
        try {
            Connection con =DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement("select * from userdetails where Email = ? ");
            
            
            pst.setString(1, email);
            //pst.setString(3, User_type);
            
            
            ResultSet rs = pst.executeQuery();
            
            if(rs.next()){ //rs.next()  name & pwd database eke thiyenawa
                isExist = true;
            }
            
            else {
                isExist = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isExist;
    }
    
    
    //add signup details to details
    public void login() {
        String name = txt_username.getText();
        String pwd = txt_password.getText();
        String User_type = combo_UserType.getSelectedItem().toString();
        String email = txt_Email.getText();

        try {
            Connection con = DBConnection.getConnection();
            String sql = "insert into userdetails(name,password,userType,Email) values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
           

            pst.setString(1, name);
            pst.setString(2, pwd);
            pst.setString(3, User_type);
            pst.setString(4, email);

            //select quary - executeQuary() ,  non select quary-  executeUpdate() or executeMethod()   
             int updatedRowCount = pst.executeUpdate();

             if(updatedRowCount> 0){
                 JOptionPane.showMessageDialog(this, "Recode inserted Successfully");
                 login_Page page = new login_Page();
                 page.setVisible(true);
                 this.dispose();
             }
             
             else{
                 JOptionPane.showMessageDialog(this, "Recode inserted faied");
             }
             
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    
 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_username = new app.bolivia.swing.JCTextField();
        txt_password = new app.bolivia.swing.JCTextField();
        signup = new rojerusan.RSMaterialButtonCircle();
        login = new rojerusan.RSMaterialButtonCircle();
        jLabel5 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        combo_UserType = new javax.swing.JComboBox<>();
        txt_Email = new app.bolivia.swing.JCTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("User Name:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Password:");

        txt_username.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_usernameFocusLost(evt);
            }
        });

        signup.setText("Signup");
        signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupActionPerformed(evt);
            }
        });

        login.setText("login");
        login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(102, 102, 255));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 28)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("X");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel3.setText("SignUp page");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Email Address: ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("User Type:");

        combo_UserType.setBackground(new java.awt.Color(204, 255, 204));
        combo_UserType.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        combo_UserType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Student", "Lecturer", "Admin" }));

        txt_Email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_EmailFocusLost(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(73, 73, 73))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(57, 57, 57)
                                        .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txt_password, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_Email, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txt_username, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(combo_UserType, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel5))
                .addGap(71, 71, 71)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(txt_Email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(combo_UserType, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(51, 51, 51))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 0, 600, 700));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/SLIITl_ogo (1).png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 510, 110));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Signup page.png"))); // NOI18N
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 530, 450));

        jButton1.setFont(new java.awt.Font("Bahnschrift", 1, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/DTK.png"))); // NOI18N
        jButton1.setText("Developed By: dtk2gloacble.com");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 620, -1, -1));

        setSize(new java.awt.Dimension(1200, 700));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupActionPerformed
        if(validateLogin()== true ) {
            
          
            if (checkduplicateusers()==false  && checkduplicateeEail()== false) {
                if (checkpassword()== true) {
                    login();
                }
                
            }else{
                JOptionPane.showMessageDialog(this, "user name OR Email ID already exsit...");
            }
              
        }  
    }//GEN-LAST:event_signupActionPerformed

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel5MouseClicked

    private void txt_usernameFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_usernameFocusLost
        if (checkduplicateusers() == true) {
            JOptionPane.showMessageDialog(this, "user name already exsit...");   
        }
    }//GEN-LAST:event_txt_usernameFocusLost

    private void loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginActionPerformed
        login_Page page = new login_Page();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_loginActionPerformed

    private void txt_EmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_EmailFocusLost
        if(checkduplicateeEail()== true){
            JOptionPane.showMessageDialog(this, "email is alrady registerd");
                    
        }
    }//GEN-LAST:event_txt_EmailFocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            Desktop.getDesktop().browse(new URL("https://www.dtk2globle.com").toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(signUp_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signUp_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signUp_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signUp_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signUp_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_UserType;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private rojerusan.RSMaterialButtonCircle login;
    private rojerusan.RSMaterialButtonCircle signup;
    private app.bolivia.swing.JCTextField txt_Email;
    private app.bolivia.swing.JCTextField txt_password;
    private app.bolivia.swing.JCTextField txt_username;
    // End of variables declaration//GEN-END:variables
}
