/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package jframe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Instant;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kusal Tharindu
 */
public class locationSearch extends javax.swing.JFrame {

    /**
     * Creates new form locationSearch
     */
    DefaultTableModel model;
    public locationSearch() {
        initComponents();
        setAvailableHall();
        issuseLocationDetailsToTable();
    }
    
    //update the time with lecture hall
    
    public boolean setAvailableHall(){
        
        boolean isupdate = false;
//        long a2 = System.currentTimeMillis();
//        java.sql.Date Todaydate = (java.sql.Date) new Date(a2);
        
        java.util.Date utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        
        
        try {
            Connection con = DBConnection.getConnection();
            String sql = "update issue_time set status = ? where issue_date < ? and  status = ?";
            PreparedStatement pst = con.prepareStatement(sql);

            pst.setString(1, "available");
            pst.setDate(2, sqlDate);
            pst.setString(3, "issued");
            
            
            int rowcount= pst.executeUpdate();
            
            if (rowcount>0) {
                isupdate = true; 
            }
            else{
                isupdate = false;
        }
            
            //PreparedStatement pst = con.prepareStatement("update from issue_time set status = ? where issue_date < ? and 	issue_time= ? ");
          
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isupdate;
    
    }
    
    //set database data details into the aplication data-table
    public void issuseLocationDetailsToTable(){
        
        try {
            Connection con = DBConnection.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from issue_time order by issue_date");
            
            while(rs.next()){
                String lectureId = rs.getString("lecture_id");//coloum id is the database name
                String lectureName = rs.getString("lecture_name");
                String hallId = rs.getString("hall_id");
                String hallName = rs.getString("hall_name");
                String issuseDate = rs.getString("issue_date");
                String issuseTime = rs.getString("issue_time");
                String status = rs.getString("status");
                
                Object[] obj = {lectureId, lectureName, hallId, hallName, issuseDate, issuseTime, status}; 
                model = (DefaultTableModel) tb1_manageTable.getModel();
                model.addRow(obj);   
            }   
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
    
    //method to clear the application table
   public void clearTable(){
       DefaultTableModel model = (DefaultTableModel) tb1_manageTable.getModel();
       model.setRowCount(0);
   }
   
   //search data from database
   
   public void search(){
       Date startDate = search_date_start.getDatoFecha();
       Date endDate = search_date_end.getDatoFecha();
       boolean check = true ;
       

          long long2 = startDate.getTime(); //calander date and time code
          java.sql.Date sDate = new java.sql.Date(long2); //calander date and time code
          long long3 = endDate.getTime(); //calander date and time code
          java.sql.Date eDate = new java.sql.Date(long3); //calander date and time code
       
       try {
            Connection con = DBConnection.getConnection();
            
            String sql = "select *from issue_time where issue_date  BETWEEN ?  and ?  order by issue_date";
            PreparedStatement pst = con.prepareStatement(sql);
            
            pst.setDate(1, sDate);
            pst.setDate(2, eDate);
            
            
            
            ResultSet rs = pst.executeQuery();
            
           // if (rs.next()== true) {
                //JOptionPane.showMessageDialog(this, "Recoded not found");
                 while (rs.next()) {     
                    
                    String lectureId = rs.getString("lecture_id");//coloum id is the database name
                    String lectureName = rs.getString("lecture_name");
                    String hallId = rs.getString("hall_id");
                    String hallName = rs.getString("hall_name");
                    String issuseDate = rs.getString("issue_date");
                    String issuseTime = rs.getString("issue_time");
                    String status = rs.getString("status");

                    Object[] obj = {lectureId, lectureName, hallId, hallName, issuseDate, issuseTime, status}; 
                    model = (DefaultTableModel) tb1_manageTable.getModel();
                    model.addRow(obj);  
                    
                    check = false;
                }
               
           //}else{
             if (check== true) {
                JOptionPane.showMessageDialog(this, "Recoded not found"); 
             }
               
            //}   
            
       } catch (Exception e) {
           e.printStackTrace();
           //JOptionPane.showMessageDialog(this, "Select both Start date and end date");
           //issuseLocationDetailsToTable();
       }
       
   }
   
   // create a function to show data between to date
// this function take to parameters d1( first date ), d2( second date )


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        search_date_start = new rojeru_san.componentes.RSDateChooser();
        rSMaterialButtonCircle1 = new rojerusan.RSMaterialButtonCircle();
        jLabel2 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        search_date_end = new rojeru_san.componentes.RSDateChooser();
        jLabel16 = new javax.swing.JLabel();
        button_refesh = new rojerusan.RSMaterialButtonCircle();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb1_manageTable = new rojeru_san.complementos.RSTableMetro();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(102, 102, 255));

        jLabel9.setFont(new java.awt.Font("Yu Gothic UI Semibold", 0, 30)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/dashbord.png"))); // NOI18N
        jLabel9.setText("View all Location ");

        jLabel15.setFont(new java.awt.Font("Verdana", 1, 17)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("DATE Start :");

        search_date_start.setPlaceholder("Starting time");

        rSMaterialButtonCircle1.setText("Search");
        rSMaterialButtonCircle1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSMaterialButtonCircle1ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Microsoft YaHei", 1, 25)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

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
                .addGap(0, 1, Short.MAX_VALUE))
        );

        search_date_end.setPlaceholder("Starting time");

        jLabel16.setFont(new java.awt.Font("Verdana", 1, 17)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("DATE End :");

        button_refesh.setText("Refesh");
        button_refesh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_refeshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(364, 364, 364)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(search_date_end, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_date_start, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(185, 185, 185)
                        .addComponent(rSMaterialButtonCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addComponent(button_refesh, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 252, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rSMaterialButtonCircle1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_refesh, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(search_date_start, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(search_date_end, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 200));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tb1_manageTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "lecture_id", "	lecture_name", "hall_id", "hall_name", "issue_date", "issue_time", "status"
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

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 60, 952, 269));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/backlong.jpg"))); // NOI18N
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1200, 400));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 1200, 500));

        setSize(new java.awt.Dimension(1200, 600));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tb1_manageTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb1_manageTableMouseClicked
    
    }//GEN-LAST:event_tb1_manageTableMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MouseClicked
        if ("Admin".equals(userType.final_User_type)) {
            AdminHomePage page = new AdminHomePage();
            page.setVisible(true);
            this.dispose();
        }
        
        else if ("Student".equals(userType.final_User_type)) {
            studentHomePage page = new studentHomePage();
            page.setVisible(true);
            this.dispose();
        }
        
        else  {
            LecturerHomePage page = new LecturerHomePage();
            page.setVisible(true);
            this.dispose();
        }
    }//GEN-LAST:event_jLabel6MouseClicked

    private void rSMaterialButtonCircle1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSMaterialButtonCircle1ActionPerformed
        if(search_date_start.getDatoFecha() != null && search_date_end.getDatoFecha() != null){
            clearTable();
            setAvailableHall();
            search();
        
        }else{
            JOptionPane.showMessageDialog(this, "plese enter end and star date");
        }
    }//GEN-LAST:event_rSMaterialButtonCircle1ActionPerformed

    private void button_refeshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_refeshActionPerformed
        clearTable();
        setAvailableHall();
        issuseLocationDetailsToTable();
        
    }//GEN-LAST:event_button_refeshActionPerformed

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
            java.util.logging.Logger.getLogger(locationSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(locationSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(locationSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(locationSearch.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new locationSearch().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rojerusan.RSMaterialButtonCircle button_refesh;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private rojerusan.RSMaterialButtonCircle rSMaterialButtonCircle1;
    private rojeru_san.componentes.RSDateChooser search_date_end;
    private rojeru_san.componentes.RSDateChooser search_date_start;
    private rojeru_san.complementos.RSTableMetro tb1_manageTable;
    // End of variables declaration//GEN-END:variables
}
