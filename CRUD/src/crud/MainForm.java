package crud;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

public class MainForm extends javax.swing.JFrame {

    public MainForm() {
        initComponents();
        buttonGroup1.add(radiobutton_pria);
        buttonGroup1.add(radiobutton_wanita);
        try{
            database= "kantor";
            url = "jdbc:mysql://localhost:3306/"+database;
            Class.forName("com.mysql.jdbc.Driver");
            koneksi = DriverManager.getConnection(url, "root", "");            
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    private Connection koneksi;
    private ResultSet hasil;
    private Statement stat;
    private String query,url,database;
    private L_Pegawai pegawai;
    private List<L_Pegawai> list;
    private TableModel model;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        text_kodepegawai = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        text_namapegawai = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        radiobutton_pria = new javax.swing.JRadioButton();
        radiobutton_wanita = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_simpan = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_cari = new javax.swing.JButton();
        btn_bersih = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Java Connect Mysql");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Kode Pegawai");

        jLabel2.setText("Nama Pegawai");

        jLabel3.setText("Jenis Kelamin");

        radiobutton_pria.setText("Pria");

        radiobutton_wanita.setText("Wanita");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_delete.setText("Delete");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        btn_update.setText("Update");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_cari.setText("Cari");
        btn_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cariActionPerformed(evt);
            }
        });

        btn_bersih.setText("Bersih");
        btn_bersih.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bersihActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(radiobutton_pria)
                        .addGap(70, 70, 70)
                        .addComponent(radiobutton_wanita)
                        .addContainerGap())
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 441, Short.MAX_VALUE)
                            .addGap(52, 52, 52))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_simpan)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_update)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(btn_delete)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btn_bersih, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(21, 21, 21))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(18, 18, 18)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(text_namapegawai, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                                .addComponent(text_kodepegawai, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE))
                            .addGap(49, 49, 49)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(text_kodepegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(text_namapegawai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(3, 3, 3)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radiobutton_pria)
                    .addComponent(radiobutton_wanita)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_simpan)
                    .addComponent(btn_update)
                    .addComponent(btn_delete)
                    .addComponent(btn_cari)
                    .addComponent(btn_bersih))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-553)/2, (screenSize.height-379)/2, 553, 379);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try{
            query = "select * from pegawai";
            stat = koneksi.createStatement();
            hasil = stat.executeQuery(query);
            this._setModel(hasil);
            btn_simpan.setEnabled(true);
            btn_update.setEnabled(false);
            btn_delete.setEnabled(false);
            btn_bersih.setEnabled(false);
            btn_cari.setEnabled(true);
            text_kodepegawai.setText("");
            text_kodepegawai.setEnabled(true);
            text_kodepegawai.requestFocus();
            text_namapegawai.setText("");
            buttonGroup1.clearSelection();
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        
        try{
            String j_kelamin = "";
            if(radiobutton_pria.isSelected()){
                j_kelamin = "Pria";
            }else if(radiobutton_wanita.isSelected()){
                j_kelamin = "Wanita";
            }else{}

            if(text_kodepegawai.getText().equals("") && text_namapegawai.getText().equals("") || j_kelamin.equals("")){
                JOptionPane.showMessageDialog(null, "data Tidak lengkap");
            }else{
                query = "insert into pegawai values ('"+text_kodepegawai.getText()+"','"+text_namapegawai.getText()+"','"+j_kelamin+"')";
                stat = koneksi.createStatement();
                int res = stat.executeUpdate(query);
                if(res == 1){
                    JOptionPane.showMessageDialog(null, "Insert Data Sukses !");
                    formWindowOpened(null);
                }
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cariActionPerformed
        try{
            String j_kelamin = "";
            if(text_kodepegawai.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Tidak Ada data Yang Anda Pilih");
            }else{
                query = "select * from pegawai where kodepegawai = '"+text_kodepegawai.getText()+"'";
                stat = koneksi.createStatement();
                hasil = stat.executeQuery(query);                
                while(hasil.next()){
                    text_namapegawai.setText(hasil.getString("namapegawai"));
                    j_kelamin = hasil.getString("jeniskelamin");
                }

                if(j_kelamin.equals("")){
                    JOptionPane.showMessageDialog(null, "Data Yang Anda Pilih Tidak Ada di database");
                    formWindowOpened(null);
                }else{
                    if(j_kelamin.equals("Pria")){
                        radiobutton_pria.setSelected(true);
                    }else{
                        radiobutton_wanita.setSelected(true);
                    }
                    query = "select * from pegawai where kodepegawai = '"+text_kodepegawai.getText()+"'";
                    stat = koneksi.createStatement();
                    hasil = stat.executeQuery(query);
                    _setModel(hasil);
                    btn_simpan.setEnabled(false);
                    btn_update.setEnabled(true);
                    btn_delete.setEnabled(true);
                    btn_cari.setEnabled(false);
                    btn_bersih.setEnabled(true);
                    text_kodepegawai.setEnabled(false);
                }
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btn_cariActionPerformed

    private void btn_bersihActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bersihActionPerformed
        try{
            formWindowOpened(null);
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btn_bersihActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        try{
            String j_kelamin = "";
            if(radiobutton_pria.isSelected()){
                j_kelamin = "Pria";
            }else if(radiobutton_wanita.isSelected()){
                j_kelamin = "Wanita";
            }else{}
            query = "update pegawai set namapegawai = '"+text_namapegawai.getText()+"', jeniskelamin = '"+j_kelamin+"' where kodepegawai = '"+text_kodepegawai.getText()+"'";
            stat = koneksi.createStatement();
            int res = stat.executeUpdate(query);
            if(res == 1){
                JOptionPane.showMessageDialog(null, "Update Data Sukses !");
                formWindowOpened(null);
            }
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        try{
            if(JOptionPane.showConfirmDialog(null, "Anda Yakin menghapus Data ini ??","Warning",2) == JOptionPane.YES_OPTION){
                query = "delete from pegawai where kodepegawai = '"+text_kodepegawai.getText()+"'";
                stat = koneksi.createStatement();
                int res = stat.executeUpdate(query);
                if(res == 1){
                    JOptionPane.showMessageDialog(null, "Delete Data Sukses !");
                }
            }
            formWindowOpened(null);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void _setModel(ResultSet hasil)
    {
        try{
            list = new ArrayList<L_Pegawai>();
            while(hasil.next()){
                pegawai = new L_Pegawai();
                pegawai.setKodePegawai(hasil.getString("kodepegawai"));
                pegawai.setNamaPegawai(hasil.getString("namapegawai"));
                pegawai.setJenisKelamin(hasil.getString("jeniskelamin"));
                list.add(pegawai);
            }
            model = new TmodelPegawai(list);
            jTable1.setModel(model);
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_bersih;
    private javax.swing.JButton btn_cari;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_update;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JRadioButton radiobutton_pria;
    private javax.swing.JRadioButton radiobutton_wanita;
    private javax.swing.JTextField text_kodepegawai;
    private javax.swing.JTextField text_namapegawai;
    // End of variables declaration//GEN-END:variables

}
