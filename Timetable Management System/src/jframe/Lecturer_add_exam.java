/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Kusal Tharindu
 */
public class Lecturer_add_exam extends javax.swing.JFrame {

    /**
     * Creates new form ManageSubject
     */
    
    String Ass_name, deadline, acc_year;
    int Ass_no;
    DefaultTableModel model;
    
    public Lecturer_add_exam() {
        initComponents();
        setAssessmentDetails();
    }
    
    //set database Assessment Details into the aplication table
    public void setAssessmentDetails(){
        
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from exam_details");
            
            while(rs.next()){
                String S_id = rs.getString("ID");//coloum id is the database name
                String S_name = rs.getString("name");
                String L_name = rs.getString("year");
                String S_hrs = rs.getString("date");
                
                Object[] obj = {S_id,S_name,L_name,S_hrs  }; 
                model = (DefaultTableModel) tb1_manageTable.getModel();
                model.addRow(obj);
                
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
    
    //to add subject detais to database
   public boolean addAssessment(){
       boolean isAdd = false;
       
       Ass_no = Integer.parseInt(txt_AssNo.getText()); //s_no int nisa get text weda karanne string walata. eka nisa intteger use karanawa
       Ass_name = txt_assementName.getText();
       acc_year = combo_accYear.getSelectedItem().toString();
       deadline = txt_Deadline.getText();
       
       try {
           
            Connection con = DBConnection.getConnection();
            String sql = "insert into exam_details values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, Ass_no);
            pst.setString(2, Ass_name);
            pst.setString(3, acc_year);
            pst.setString(4, deadline);
            
            int rowcount = pst.executeUpdate();
            
            if (rowcount>0) {
               isAdd = true; 
               
           }else{
                isAdd =false;
            }
            
       } catch (Exception e) {
       }
       
       return isAdd;
   }
   
   
   //to update book details into database
   public boolean updateAssessment(){
       boolean isUpdated = false;
       
       Ass_no = Integer.parseInt(txt_AssNo.getText()); 
       Ass_name = txt_assementName.getText();
       acc_year = combo_accYear.getSelectedItem().toString();
       deadline = txt_Deadline.getText();
       
       try {  
            Connection con = DBConnection.getConnection();
            String sql = "update exam_details set name =?, year = ?, date = ? where ID = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            
            // uda sql qury eke piliwelata 1 2 3 4 danna one
            
            pst.setString(1, Ass_name);
            pst.setString(2, acc_year);
            pst.setString(3, deadline);
            pst.setInt(4, Ass_no);
            
            int rowcount = pst.executeUpdate();
            
            if (rowcount>0) {
               isUpdated = true; 
               
           }else{
                isUpdated =false;
            }
            
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       return isUpdated;
       
   }
   
   //to delele subject database recodes
   public boolean deleteAssessment(){
       
       boolean isDeleted = false;
       Ass_no = Integer.parseInt(txt_AssNo.getText());
       
       try { 
           Connection con = DBConnection.getConnection();
           String sql = "delete from exam_details where ID = ?  ";
           PreparedStatement pst = con.prepareStatement(sql);
           
           pst.setInt(1, Ass_no);
           
           int rowcount = pst.executeUpdate();
            
            if (rowcount>0) {
               isDeleted = true; 
               
           }else{
                isDeleted =false;
            }
           
           
       } catch (Exception e) {
           e.printStackTrace();
       }
       
       return isDeleted;
   }
   
   //method to clear the application table
   public void clearTable(){
       DefaultTableModel model = (DefaultTableModel) tb1_manageTable.getModel();
       model.setRowCount(0);
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1_manageTable = new rojeru_san.complementos.RSTableMetro();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_AssNo = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_assementName = new app.bolivia.swing.JCTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_Deadline = new app.bolivia.swing.JCTextField();
        jLabel13 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        combo_accYear = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb1_manageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Exam No", "Exam name", "Year", "Date"
            }
        ));
        tb1_manageTable.setColorSelBackgound(new java.awt.Color(255, 51, 51));
        tb1_manageTable.setFont(new java.awt.Font("Yu Gothic Light", 0, 25)); // NOI18N
        tb1_manageTable.setFuenteFilas(new java.awt.Font("Yu Gothic UI Semibold", 1, 18)); // NOI18N
        tb1_manageTable.setFuenteFilasSelect(new java.awt.Font("Yu Gothic UI", 1, 20)); // NOI18N
        tb1_manageTable.setFuenteHead(new java.awt.Font("Yu Gothic UI Semilight", 1, 20)); // NOI18N
        tb1_manageTable.setRowHeight(30);
        tb1_manageTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb1_manageTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb1_manageTable);

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 530, 280));

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));

        jLabel9.setBackground(new java.awt.Color(0, 153, 153));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/administration (1).png"))); // NOI18N
        jLabel9.setText("Add exams");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(97, Short.MAX_VALUE)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel9)
                .addGap(14, 14, 14))
        );

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 50, 360, 80));

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei", 1, 25)); // NOI18N
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2))
        );

        jPanel7.add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 0, 30, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/background (1).jpg"))); // NOI18N
        jPanel7.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 650, 600));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 650, 600));

        jPanel5.setBackground(new java.awt.Color(102, 102, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(255, 51, 51));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/icons8_Rewind_48px.png"))); // NOI18N
        jLabel6.setText("Back");
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel6MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(33, 33, 33))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 110, 40));

        jLabel11.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Enter Exam Number:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 270, 30));

        txt_AssNo.setBackground(new java.awt.Color(102, 102, 255));
        txt_AssNo.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_AssNo.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        txt_AssNo.setPlaceholder("Enter Subject name");
        txt_AssNo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_AssNoActionPerformed(evt);
            }
        });
        jPanel5.add(txt_AssNo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 280, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Enter Exam name:");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 240, 30));

        txt_assementName.setBackground(new java.awt.Color(102, 102, 255));
        txt_assementName.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_assementName.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        txt_assementName.setPlaceholder("Enter Subject name");
        txt_assementName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_assementNameActionPerformed(evt);
            }
        });
        jPanel5.add(txt_assementName, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 290, -1));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Enter Acadamic year:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 300, 260, 30));

        txt_Deadline.setBackground(new java.awt.Color(102, 102, 255));
        txt_Deadline.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_Deadline.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        txt_Deadline.setPlaceholder("Enter Subject name");
        txt_Deadline.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_DeadlineActionPerformed(evt);
            }
        });
        jPanel5.add(txt_Deadline, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 440, 290, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Enter Assessment Date:");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 280, 30));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("Delete");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel5.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 90, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("ADD");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel5.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 90, 60));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("UPdate");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel5.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 510, 90, 60));

        combo_accYear.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_accYear.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Year 1", "Year 2", "Year 3", "Year 4" }));
        jPanel5.add(combo_accYear, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 350, 290, 27));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Exam.png"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 50, 50));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/check.png"))); // NOI18N
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 30, 40));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/clock (1) (1).png"))); // NOI18N
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 30, 40));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/time.png"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 40, 50));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 610));

        setSize(new java.awt.Dimension(1200, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_DeadlineActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_DeadlineActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_DeadlineActionPerformed

    private void txt_assementNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_assementNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_assementNameActionPerformed

    private void txt_AssNoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_AssNoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_AssNoActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        studentHomePage page = new studentHomePage();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void tb1_manageTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1_manageTableMouseClicked
        int rowNo = tb1_manageTable.getSelectedRow();
        TableModel model = tb1_manageTable.getModel();
        
        txt_AssNo.setText(model.getValueAt(rowNo, 0).toString());
        txt_assementName.setText(model.getValueAt(rowNo, 1).toString());
        combo_accYear.setSelectedItem(model.getValueAt(rowNo, 2));
        txt_Deadline.setText(model.getValueAt(rowNo, 3).toString());
    }//GEN-LAST:event_tb1_manageTableMouseClicked

    private void rSMaterialButtonCircle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle2ActionPerformed
        if (addAssessment()== true) {
            JOptionPane.showMessageDialog(this, "Subject add succfully");
            clearTable();
            setAssessmentDetails();
            
        }else{
            JOptionPane.showMessageDialog(this, "Error... please try again!!!!");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle2ActionPerformed

    private void rSMaterialButtonCircle3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle3ActionPerformed
        if (updateAssessment()== true) {
            JOptionPane.showMessageDialog(this, "Subject updated succfully");
            clearTable();
            setAssessmentDetails();
            
        }else{
            JOptionPane.showMessageDialog(this, "!!!ERROR!!! You can change subject ID...");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle3ActionPerformed

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if (deleteAssessment()== true) {
            JOptionPane.showMessageDialog(this, "Subject deleted succfully");
            clearTable();
            setAssessmentDetails();
            
        }else{
            JOptionPane.showMessageDialog(this, "!!!ERROR!!! ");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

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
            java.util.logging.Logger.getLogger(Lecturer_add_exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Lecturer_add_exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Lecturer_add_exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Lecturer_add_exam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Lecturer_add_exam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_accYear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle2;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle3;
    private rojeru_san.complementos.RSTableMetro tb1_manageTable;
    private app.bolivia.swing.JCTextField txt_AssNo;
    private app.bolivia.swing.JCTextField txt_Deadline;
    private app.bolivia.swing.JCTextField txt_assementName;
    // End of variables declaration//GEN-END:variables
}
