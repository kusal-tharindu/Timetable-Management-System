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
public class Admin_leacute_hall extends javax.swing.JFrame {

    /**
     * Creates new form ManageSubject
     */
    
    String dept_name, location;
    int hall_no, seat_no;
    DefaultTableModel model;
    
    public Admin_leacute_hall() {
        initComponents();
        setAssessmentDetails();
    }
    
    public Admin_leacute_hall(String login_name) { 
        initComponents();
        setAssessmentDetails(); 
    }
    
    //set database Assessment Details into the aplication table
    public void setAssessmentDetails(){
        
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from location");
             
            
            while(rs.next()){
                String S_id = rs.getString("location_ID");//coloum id is the database name
                String h_seat = rs.getString("No_seat");
                String d_name = rs.getString("Department");
                String location_name = rs.getString("location_name");
                
                Object[] obj = {S_id, h_seat, d_name, location_name  }; 
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
       
       hall_no = Integer.parseInt(txt_Hall_no.getText()); //s_no int nisa get text weda karanne string walata. eka nisa intteger use karanawa
       seat_no = Integer.parseInt(txt_seat_no.getText());
       dept_name = combo_department.getSelectedItem().toString();
       location = combo_Location.getSelectedItem().toString();
       
       try {
           
            Connection con = DBConnection.getConnection();
            String sql = "insert into location values(?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setInt(1, hall_no);
            pst.setString(2, location);
            pst.setString(3, dept_name);
            pst.setInt(4, seat_no);
            
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
       
       hall_no = Integer.parseInt(txt_Hall_no.getText()); //s_no int nisa get text weda karanne string walata. eka nisa intteger use karanawa
       seat_no = Integer.parseInt(txt_seat_no.getText());
       dept_name = combo_department.getSelectedItem().toString();
       location = combo_Location.getSelectedItem().toString();
       
       try {  
            Connection con = DBConnection.getConnection();
            String sql = "update location set location_name =?, Department = ?, No_seat = ? where location_ID  = ? ";
            PreparedStatement pst = con.prepareStatement(sql);
            
            // uda sql qury eke piliwelata 1 2 3 4 danna one
            
            pst.setString(1, location);
            pst.setString(2, dept_name);
            pst.setInt(3, seat_no);
            pst.setInt(4, hall_no);
            
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
       hall_no = Integer.parseInt(txt_Hall_no.getText()); 
       
       try {
           Connection con = DBConnection.getConnection();
           String sql = "delete from location where location_ID = ?  ";
           PreparedStatement pst = con.prepareStatement(sql);
           
           pst.setInt(1, hall_no);
           
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

        jLabel2 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1_manageTable = new rojeru_san.complementos.RSTableMetro();
        jPanel8 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_Hall_no = new app.bolivia.swing.JCTextField();
        jLabel12 = new javax.swing.JLabel();
        txt_seat_no = new app.bolivia.swing.JCTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle2 = new rojerusan.RSMaterialButtonCircle();
        rSMaterialButtonCircle3 = new rojerusan.RSMaterialButtonCircle();
        combo_Location = new javax.swing.JComboBox<>();
        combo_department = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Microsoft YaHei", 1, 25)); // NOI18N
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1180, 0, -1, -1));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb1_manageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Hall No", "NO of Seats", "Department", "Location"
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

        jPanel7.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 520, 310));

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));

        jLabel9.setBackground(new java.awt.Color(0, 153, 153));
        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/administration (1).png"))); // NOI18N
        jLabel9.setText("Manage Your Lecture hall");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(41, Short.MAX_VALUE))
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

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
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
        jLabel11.setText("Hall Number:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 270, 30));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/conference (1).png"))); // NOI18N
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 40, 50));

        txt_Hall_no.setBackground(new java.awt.Color(102, 102, 255));
        txt_Hall_no.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_Hall_no.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        txt_Hall_no.setPlaceholder("Enter Subject name");
        txt_Hall_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_Hall_noActionPerformed(evt);
            }
        });
        jPanel5.add(txt_Hall_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 320, -1));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Seat No.");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 240, 30));

        txt_seat_no.setBackground(new java.awt.Color(102, 102, 255));
        txt_seat_no.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        txt_seat_no.setFont(new java.awt.Font("Segoe UI Emoji", 1, 12)); // NOI18N
        txt_seat_no.setPlaceholder("Enter Subject name");
        txt_seat_no.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_seat_noActionPerformed(evt);
            }
        });
        jPanel5.add(txt_seat_no, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 220, 320, -1));

        jLabel8.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/car-chair (1).png"))); // NOI18N
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 40, 50));

        jLabel10.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Department:");
        jPanel5.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 260, 30));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dashbord.png"))); // NOI18N
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 40, -1));

        jLabel13.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Location: ");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 280, 30));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Location.png"))); // NOI18N
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, 40, 40));

        rSMaterialButtonCircle1.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle1.setText("Delete");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });
        jPanel5.add(rSMaterialButtonCircle1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 510, 90, 60));

        rSMaterialButtonCircle2.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle2.setText("ADD");
        rSMaterialButtonCircle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle2ActionPerformed(evt);
            }
        });
        jPanel5.add(rSMaterialButtonCircle2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 510, 90, 60));

        rSMaterialButtonCircle3.setBackground(new java.awt.Color(255, 51, 51));
        rSMaterialButtonCircle3.setText("UPdate");
        rSMaterialButtonCircle3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle3ActionPerformed(evt);
            }
        });
        jPanel5.add(rSMaterialButtonCircle3, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 90, 60));

        combo_Location.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_Location.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Main building", "New building", "Eng building", "business building" }));
        jPanel5.add(combo_Location, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 430, 320, 27));

        combo_department.setFont(new java.awt.Font("Verdana", 0, 17)); // NOI18N
        combo_department.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IT", "Engineering", "Business" }));
        jPanel5.add(combo_department, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 330, 320, 27));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 600));

        setSize(new java.awt.Dimension(1200, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void txt_seat_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_seat_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_seat_noActionPerformed

    private void txt_Hall_noActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_Hall_noActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_Hall_noActionPerformed

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        AdminHomePage page = new AdminHomePage();
        page.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel6MouseClicked

    private void tb1_manageTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1_manageTableMouseClicked
        int rowNo = tb1_manageTable.getSelectedRow();
        TableModel model = tb1_manageTable.getModel();
        
        txt_Hall_no.setText(model.getValueAt(rowNo, 0).toString());
        txt_seat_no.setText(model.getValueAt(rowNo, 1).toString());
        combo_department.setSelectedItem(model.getValueAt(rowNo, 2));
        combo_Location.setSelectedItem(model.getValueAt(rowNo, 3));
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
            java.util.logging.Logger.getLogger(Admin_leacute_hall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin_leacute_hall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin_leacute_hall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin_leacute_hall.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin_leacute_hall().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_Location;
    private javax.swing.JComboBox<String> combo_department;
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
    private app.bolivia.swing.JCTextField txt_Hall_no;
    private app.bolivia.swing.JCTextField txt_seat_no;
    // End of variables declaration//GEN-END:variables
}
