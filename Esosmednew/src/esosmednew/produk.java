/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esosmednew;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Scanner;
import java.awt.*;
/**
 *
 * @author 
 */
public class produk extends javax.swing.JFrame {
    DefaultTableModel tabModel;// menampilkan UI tabel
    ResultSet RsSosmed=null;// menampilkan UI hasil data
    /**
     * Creates new form produk
     */
    public produk() {
        initComponents();
        
        Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize=this.getSize();
        if(frameSize.height > screenSize.height){
        frameSize.height=screenSize.height;
        }
        if(frameSize.width > screenSize.width){
        frameSize.width=screenSize.width;
        }
        this.setLocation((screenSize.width - frameSize.width) / 2,
        (screenSize.height = screenSize.height) / 20); 
        
        //fungsi Tampil data dan set edit off dijalankan saat aplikasi di run
        tampilData();
        SetEditOff();
    }
    
    //fungsi untuk menampilkan data user ke dalam tabel
    private void tampilData(){
        try{
            Object[] judul_kolom = {"Username", "Password", "Satuan", "Media", "Device", "Create Date"};
            tabModel=new DefaultTableModel(null,judul_kolom);
            TabelProduk.setModel(tabModel);
            
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            tabModel.getDataVector().removeAllElements();
            
            RsSosmed=stt.executeQuery("SELECT * from produk ");  // inisiasi tabel produk
            while(RsSosmed.next()){// inisiasi object pada tabel
                Object[] data={
                    RsSosmed.getString("Username"),
                    RsSosmed.getString("Password"),
                    RsSosmed.getString("Media"),
                    RsSosmed.getString("Pin"),
                    RsSosmed.getString("Device"),
                    RsSosmed.getString("CreateDate")         
                };
               tabModel.addRow(data);
            }                
        } catch (Exception ex) {
        System.err.println(ex.getMessage());
        }
        // disable button
        jButtonSave.setEnabled(false);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        jButtonCancel.setEnabled(false);
    }
   
    //menampilkan data ke form saat data pada tabel di klik 
   void tblKeForm(){
        jTextUsername.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),0)+"");
        jTextPassword.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),1)+"");
        jComboBoxMedia.setSelectedItem(tabModel.getValueAt(TabelProduk.getSelectedRow(),2)+"");
        jTextPin.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),3)+"");
        jTextDevice.setText(tabModel.getValueAt(TabelProduk.getSelectedRow(),4)+"");
        
        jButtonUpdate.setEnabled(true);
        jButtonDelete.setEnabled(true);
        jButtonCancel.setEnabled(true);
        jButtonSave.setEnabled(false);
    }
   
   //membersihkan form
   private void BersihData(){
        jTextUsername.setText("");
        jTextPassword.setText("");
        jComboBoxMedia.setSelectedIndex(0);
        jTextPin.setText(""); 
        jTextDevice.setText("");
    } 
   
   //disable form
   private void SetEditOff(){
        jTextUsername.setEnabled(false);
        jTextPassword.setEnabled(false);
        jComboBoxMedia.setEnabled(false);
        jTextPin.setEnabled(false);
        jTextDevice.setEnabled(false);
   }
   
   
   private void seteditOn(){
        jTextUsername.setEnabled(true);
        jTextPassword.setEnabled(true);
        jComboBoxMedia.setEnabled(true);
        jTextPin.setEnabled(true);
        jTextDevice.setEnabled(true);
   }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelHeader = new javax.swing.JLabel();
        jLabelUsername = new javax.swing.JLabel();
        jTextUsername = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jTextPassword = new javax.swing.JTextField();
        jLabelMedia = new javax.swing.JLabel();
        jComboBoxMedia = new javax.swing.JComboBox();
        jLabelPin = new javax.swing.JLabel();
        jTextPin = new javax.swing.JTextField();
        jLabelDevice = new javax.swing.JLabel();
        jTextDevice = new javax.swing.JTextField();
        jButtonAdd = new javax.swing.JButton();
        jButtonSave = new javax.swing.JButton();
        jButtonUpdate = new javax.swing.JButton();
        jButtonDelete = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelProduk = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelHeader.setBackground(new java.awt.Color(255, 255, 102));
        jLabelHeader.setFont(new java.awt.Font("SansSerif", 3, 24)); // NOI18N
        jLabelHeader.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelHeader.setText("E-Sosmed");
        jLabelHeader.setOpaque(true);

        jLabelUsername.setText("Username");

        jLabelPassword.setText("Password");

        jLabelMedia.setText("Media");

        jComboBoxMedia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Instagram", "Gmail", "tiktok" }));

        jLabelPin.setText("Pin");

        jLabelDevice.setText("Device");

        jButtonAdd.setText("AddNew");
        jButtonAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddActionPerformed(evt);
            }
        });

        jButtonSave.setText("Save");
        jButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveActionPerformed(evt);
            }
        });

        jButtonUpdate.setText("Update");
        jButtonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUpdateActionPerformed(evt);
            }
        });

        jButtonDelete.setText("Delete");
        jButtonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteActionPerformed(evt);
            }
        });

        jButtonCancel.setText("Cancel");
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });

        TabelProduk.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        TabelProduk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelProdukMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TabelProduk);

        jLabel1.setBackground(new java.awt.Color(255, 255, 153));
        jLabel1.setText("Dyah Ayu Purboningtyas");

        jLabel2.setBackground(new java.awt.Color(255, 255, 153));
        jLabel2.setText("v 1.0");

        jLabel3.setText("2022");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPassword)
                    .addComponent(jLabelMedia)
                    .addComponent(jLabelPin)
                    .addComponent(jLabelDevice)
                    .addComponent(jLabelUsername))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextPin)
                                    .addComponent(jTextPassword, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jComboBoxMedia, 0, 259, Short.MAX_VALUE)
                                    .addComponent(jTextUsername, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextDevice)))
                            .addComponent(jButtonAdd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(75, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(130, 130, 130))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSave)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonUpdate)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonDelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(46, 46, 46))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabelHeader, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelUsername))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPassword))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboBoxMedia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelMedia))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextPin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelPin))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextDevice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelDevice))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonSave)
                            .addComponent(jButtonUpdate)
                            .addComponent(jButtonDelete)
                            .addComponent(jButtonCancel)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)))
                .addGap(8, 8, 8))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //menangani proses saat button add di klik
    private void jButtonAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddActionPerformed
        // TODO add your handling code here:
        BersihData();
        jTextUsername.requestFocus();
        jButtonSave.setEnabled(true);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        seteditOn();
    }//GEN-LAST:event_jButtonAddActionPerformed

    //menangani proses saat button save di klik
    private void jButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveActionPerformed
        // TODO add your handling code here:
        String Username=jTextUsername.getText();
        String Password=jTextPassword.getText();
        String Media=jComboBoxMedia.getSelectedItem().toString();
        String Pin=jTextPin.getText();
        String Device=jTextDevice.getText();

        java.util.Date tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateDate=TanggalFormat.format(tanggal);

        if (Username.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Username tidak boleh kosong");
            jTextUsername.requestFocus();
        }else if (Password.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Password tidak boleh kosong");
            jTextPassword.requestFocus();
        }else if (Media.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Media tidak boleh kosong");
            jComboBoxMedia.requestFocus();
        }else if (Pin.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Pin  tidak boleh kosong");
            jTextPin.requestFocus();
        }else if (Device.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Device  tidak boleh kosong");
            jTextDevice.requestFocus();
        }
        else if (!(new Scanner(Pin).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Pin harus angka");
            jTextPin.requestFocus();
        }else if (!(new Scanner(Device).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Jumlah device  harus angka");
            jTextDevice.requestFocus();
        }else{
            try{
                Connection conn=(Connection)koneksi.koneksiDB();// koneksi ke databse mysql
                Statement stt=conn.createStatement();
                stt.executeUpdate("insert into produk(Username,Password,Media,Pin,Device,CreateDate)"+
                    "VALUES('"+Username+"','"+Password+"','"+Media+"','"+Pin+"','"+Device+"','"+CreateDate+"')");
                BersihData();
                tampilData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil disimpan","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Simpan data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButtonSaveActionPerformed

    //menangani proses saat button Update di klik
    private void jButtonUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUpdateActionPerformed
        // TODO add your handling code here:
        String Username=jTextUsername.getText();
        String Password=jTextPassword.getText();
        String Media=jComboBoxMedia.getSelectedItem().toString();
        String Pin=jTextPin.getText();
        String Device=jTextDevice.getText();

        java.util.Date tanggal = new java.util.Date();
        java.text.SimpleDateFormat TanggalFormat= new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String CreateDate=TanggalFormat.format(tanggal);

        if (Username.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Username tidak boleh kosong");
            jTextUsername.requestFocus();
        }else if (Password.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Password tidak boleh kosong");
            jTextPassword.requestFocus();
        }else if (Media.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Media tidak boleh kosong");
            jComboBoxMedia.requestFocus();
        }else if (Pin.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Pin  tidak boleh kosong");
            jTextPin.requestFocus();
        }else if (Device.isEmpty()) {
            JOptionPane.showMessageDialog(null,"Jumlah Device  tidak boleh kosong");
            jTextDevice.requestFocus();
        }
        else if (!(new Scanner(Pin).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Pin  harus angka");
            jTextPin.requestFocus();
        }else if (!(new Scanner(Device).hasNextInt())) {
            JOptionPane.showMessageDialog(null,"Jumlah Device  harus angka");
            jTextDevice.requestFocus();
        }else{
            try{
                Connection conn=(Connection)koneksi.koneksiDB();
                Statement stt=conn.createStatement();
                stt.executeUpdate("UPDATE produk SET Password='"+Password+"', Media='"+Media+"', Pin='"+Pin+"',"+
                    "Device='"+Device+"' WHERE Username='"+Username+"'");
                BersihData();
                tampilData();
                SetEditOff();
                JOptionPane.showMessageDialog(this,"Data berhasil diubah","Success",JOptionPane.INFORMATION_MESSAGE);
            } catch(SQLException e){
                JOptionPane.showMessageDialog(this,"Ubah data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jButtonUpdateActionPerformed

    //menangani proses saat button delete di klik
    private void jButtonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteActionPerformed
        // TODO add your handling code here:
        String Username=jTextUsername.getText();

        if (Username.isEmpty() ) {
            JOptionPane.showMessageDialog(null,"Username tidak boleh kosong");
            jTextUsername.requestFocus();
        }else if(JOptionPane.showConfirmDialog(null,"Apakah anda yakin akan menghapus data ini?",
            "Informasi",JOptionPane.OK_CANCEL_OPTION,JOptionPane.INFORMATION_MESSAGE)==JOptionPane.OK_OPTION){
        try{
            Connection conn=(Connection)koneksi.koneksiDB();
            Statement stt=conn.createStatement();
            stt.executeUpdate("DELETE FROM produk WHERE Username='"+Username+"'");
            BersihData();
            tampilData();
            SetEditOff();
            JOptionPane.showMessageDialog(this,"Data berhasil di hapus","Success",JOptionPane.INFORMATION_MESSAGE);
        } catch(SQLException e){
            JOptionPane.showMessageDialog(this,"Delete data gagal\n"+e.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        }
    }//GEN-LAST:event_jButtonDeleteActionPerformed

    //menangani proses saat button cancel di klik
    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelActionPerformed
        // TODO add your handling code here:
        BersihData();
        jButtonSave.setEnabled(false);
        jButtonUpdate.setEnabled(false);
        jButtonDelete.setEnabled(false);
        SetEditOff();
    }//GEN-LAST:event_jButtonCancelActionPerformed

    //menangani proses saat tabel produk di klik
    private void TabelProdukMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelProdukMouseClicked
        // TODO add your handling code here:
        seteditOn();
        jTextUsername.setEnabled(false);
        tblKeForm();
    }//GEN-LAST:event_TabelProdukMouseClicked

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
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(produk.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new produk().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TabelProduk;
    private javax.swing.JButton jButtonAdd;
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonDelete;
    private javax.swing.JButton jButtonSave;
    private javax.swing.JButton jButtonUpdate;
    private javax.swing.JComboBox jComboBoxMedia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelDevice;
    private javax.swing.JLabel jLabelHeader;
    private javax.swing.JLabel jLabelMedia;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelPin;
    private javax.swing.JLabel jLabelUsername;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextDevice;
    private javax.swing.JTextField jTextPassword;
    private javax.swing.JTextField jTextPin;
    private javax.swing.JTextField jTextUsername;
    // End of variables declaration//GEN-END:variables
}