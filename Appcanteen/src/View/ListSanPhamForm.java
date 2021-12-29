/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.Clock;
import Controller.NCC_Con;
import Controller.ProType_con;
import Controller.Sanpham_Con;
import Model.GetNV;
import Model.LoaiSP;
import Model.NCC;
import Model.SanPham;
import java.awt.Color;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Administrator
 */
public class ListSanPhamForm extends javax.swing.JFrame {

 
      GetNV   detail;
   private DefaultTableModel model;
  
   private ArrayList<SanPham> lstsp;
   NCC_Con nccon = new NCC_Con();
   private ArrayList<NCC> lstncc; 
   private String [] cloumnHeader = new String[] {"Mã sản phẩm","Tên","Đơn vị","Giá","Nhà cung cấp","Số lượng"};
   private int selecIndex;
    Sanpham_Con spCon = new Sanpham_Con();
    ProType_con tycon = new ProType_con();
    private ArrayList<LoaiSP> lsttype; 
    
    public ListSanPhamForm(GetNV d) {
 
        initComponents();
        setLocationRelativeTo(null);
        lstsp = spCon.getListSanPham();
       lstncc  = nccon.getListNCC() ;
       lsttype = tycon.getListLoaiSP();
        initTable();
        setResizable(false);
        detail= new GetNV(d);
 

        initcbxNCC();
       // initcbxLoai();
        initClock();
        initUnit();
       
    }

    private void initClock() {
        Clock cl = new Clock(lblClock);
        cl.start();
    }

    private void initTable() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(cloumnHeader);
        tblListSP.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListSP = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        lblClock = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtProID = new javax.swing.JTextField();
        cbxUnit = new javax.swing.JComboBox<>();
        txtNameSP = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtquantity = new javax.swing.JTextField();
        cbxncc = new javax.swing.JComboBox<>();
        btnBack = new javax.swing.JButton();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(153, 255, 204));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 15))); // NOI18N

        tblListSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã sản phẩm", "Tên sản phẩm", "Đơn vị", "Giá", "Nhà cung cấp", "Số lượng"
            }
        ));
        tblListSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblListSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblListSP);
        if (tblListSP.getColumnModel().getColumnCount() > 0) {
            tblListSP.getColumnModel().getColumn(0).setHeaderValue("Mã sản phẩm");
            tblListSP.getColumnModel().getColumn(1).setHeaderValue("Tên sản phẩm");
            tblListSP.getColumnModel().getColumn(2).setHeaderValue("Đơn vị");
            tblListSP.getColumnModel().getColumn(3).setHeaderValue("Giá");
            tblListSP.getColumnModel().getColumn(4).setHeaderValue("Nhà cung cấp");
            tblListSP.getColumnModel().getColumn(5).setHeaderValue("Số lượng");
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnAdd.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ảnh/add.png"))); // NOI18N
        btnAdd.setText("Thêm");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ảnh/maintenance.png"))); // NOI18N
        btnEdit.setText("Sửa");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnDelete.setBackground(new java.awt.Color(255, 51, 51));
        btnDelete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ảnh/trash.png"))); // NOI18N
        btnDelete.setText("Xóa");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        btnClear.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnClear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ảnh/loading.png"))); // NOI18N
        btnClear.setText("Clear");
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(btnClear)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 479, Short.MAX_VALUE)
                .addComponent(btnDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDelete)
                    .addComponent(btnEdit)
                    .addComponent(btnAdd)
                    .addComponent(btnClear))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        lblClock.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblClock.setForeground(new java.awt.Color(255, 0, 255));
        lblClock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblClock.setText("8:8:8 AM");
        lblClock.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "DANH SÁCH SẢN PHẨM", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 18))); // NOI18N

        jLabel2.setText("MÃ SẢN PHẨM:");

        jLabel3.setText("TÊN SẢN PHẨM:");

        jLabel4.setText("NHÀ CUNG CẤP:");

        jLabel5.setText("GIÁ:");

        jLabel6.setText("ĐƠN VỊ:");

        jLabel7.setText("SỐ LƯỢNG:");

        cbxUnit.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtPrice.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPriceKeyReleased(evt);
            }
        });

        txtquantity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtquantityKeyReleased(evt);
            }
        });

        cbxncc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNameSP, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtProID, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 336, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(138, 138, 138))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtProID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxUnit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtNameSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtquantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxncc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        btnBack.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ảnh/arrow.png"))); // NOI18N
        btnBack.setText("QUAY LẠI");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnBack)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblClock, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30))
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnBack, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblClock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed

        //form nhap san pham cu
        StringBuilder sb = new StringBuilder();
        if (txtProID.getText().equals("")) {
            sb.append("Chưa nhập mã sản phẩm!!!\n");
            txtProID.setBackground(Color.yellow);
            txtProID.requestFocus();
        } else {
            txtProID.setBackground(Color.white);
        }

        if (txtNameSP.getText().equals("")) {
            sb.append("Chưa nhập tên sản phẩm!!!\n");
            txtNameSP.setBackground(Color.yellow);
            txtNameSP.requestFocus();
        } else {
            txtNameSP.setBackground(Color.white);
        }
        if (sb.length() > 0) {
            JOptionPane.showMessageDialog(this, sb.toString(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
 
       
 

 
        SanPham s = new SanPham();
       
        
        s.setProductID(txtProID.getText());
        s.setNameSP(txtNameSP.getText());
        s.setUnit((String) cbxUnit.getSelectedItem());
        s.setPrice(txtPrice.getText()+" "+"VND");
        s.setNCC((String) cbxncc.getSelectedItem());
        s.setSoluong(Integer.parseInt(txtquantity.getText()));
 
 
        if (spCon.addSP(s)) {
            JOptionPane.showMessageDialog(rootPane, "thêm thành công");
            lstsp.add(s);
        } else {
            JOptionPane.showMessageDialog(rootPane, "thất bại");
        }
        showResult();
        
    }//GEN-LAST:event_btnAddActionPerformed
 
       
    private void initUnit(){
        String [] unit = new String[]{
          "Chai","Cái","Kg","Lon"    
 
        };
        DefaultComboBoxModel<String> cbxModel = new DefaultComboBoxModel<>(unit);
        cbxUnit.setModel(cbxModel);
    }
  
    
    
    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:

        selecIndex = tblListSP.getSelectedRow();
        if (lstsp.size() == 0) {
            JOptionPane.showMessageDialog(rootPane, "chưa có sản phẩm");
        } else if (selecIndex == -1) {
            JOptionPane.showMessageDialog(rootPane, "chọn 1 sản phẩm để sửa");
        } else {
            // String id_pro =  (String) model.getValueAt(selecIndex, 0);

            SanPham s = new SanPham();
          
         
            s.setProductID(txtProID.getText());
            s.setNameSP(txtNameSP.getText());
            s.setUnit(cbxUnit.getSelectedItem().toString());
            s.setPrice(txtPrice.getText()+" "+"VND");
            s.setNCC(cbxncc.getSelectedItem().toString());
            s.setSoluong(Integer.parseInt(txtquantity.getText()));
 
            
            
        if (spCon.EditSP(s)) {
            JOptionPane.showMessageDialog(rootPane, "Cập nhật thành công");
            this.dispose();
            new ListSanPhamForm(detail).setVisible(true);
            
        } }                          
 

       
 
    }//GEN-LAST:event_btnEditActionPerformed
   private double convertedToNumbers(String s){
        String number="";
        String []array=s.replace(","," ").split("\\s");
        for(String i:array){
            number=number.concat(i);
        }
        return Double.parseDouble(number);
    }
    
    private String cutChar(String arry){
        return arry.replaceAll("\\D+","");
    }
    
    
    
    private void tblListSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblListSPMouseClicked
        // TODO add your handling code here:
        selecIndex = tblListSP.getSelectedRow();
        String masp = (String) model.getValueAt(selecIndex, 0);
 
        
     //   for (SanPham s : lstsp) {
            if (selecIndex>=0) {
          //     SanPham sp = spCon.detailSP(masp);
               txtProID.setText(masp);
               txtProID.setEnabled(false);
        //    if (sp!=null) {
       //     txtNameSP.setText(sp.getNameSP());
//            cbxUnit.setSelectedItem(sp.getUnit());
   //txtPrice.setText(sp.getPrice()+"");
//            txtNCC.setText(sp.getNCC());
//            txtquantity.setText(sp.getSoluong()+""); 
           // break;
           
           txtNameSP.setText((String) model.getValueAt(selecIndex, 1));
          
           cbxUnit.setSelectedItem((String) model.getValueAt(selecIndex, 2));
           
           
            String []s1=model.getValueAt(selecIndex,3).toString().split("\\s");
            txtPrice.setText(s1[0]);
       
             
           // txtNCC.setText((String) model.getValueAt(selecIndex, 4));
            cbxncc.setSelectedItem(model.getValueAt(selecIndex,4 ));
            
            String []s=model.getValueAt(selecIndex,5).toString().trim().split("\\s");
            txtquantity.setText(s[0]); 
            
            
           // }
 

       
 
        

        // }
    }//GEN-LAST:event_tblListSPMouseClicked

    }
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        showList();

    }//GEN-LAST:event_formWindowOpened

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
        // TODO add your handling code here:
        txtProID.setText("");
        txtProID.setEnabled(true);
        txtNameSP.setText("");
        //  cbxUnit.setSelectedItem(sp.getUnit());
        txtPrice.setText("");
       
        txtquantity.setText("");


//        for(SanPham s : lstsp)
//        {
//            System.out.println(s.getNameSP());

//        }



    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (JOptionPane.showConfirmDialog(rootPane, "Bạn có chắc chắn muốn xóa không !") == JOptionPane.YES_OPTION) {

 
                    selecIndex = tblListSP.getSelectedRow();
                    String masp = ""+ tblListSP.getValueAt(selecIndex, 0);
                    boolean isXoa = spCon.XoaSP(masp);
                     if (isXoa) {
                        JOptionPane.showMessageDialog(rootPane, "xóa thành công");
                        this.dispose();
                        new ListSanPhamForm(detail).setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(rootPane, "xóa thất bại");
                        }
 
            
 

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        new menu0(detail).setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnBackActionPerformed

    private void txtPriceKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPriceKeyReleased
        // TODO add your handling code here:
         DecimalFormat formatter = new DecimalFormat("###,###,###");
        
        txtPrice.setText(cutChar(txtPrice.getText()));
        if(txtPrice.getText().equals("")){
            return;
        }
        else{
            txtPrice.setText(formatter.format(convertedToNumbers(txtPrice.getText())));
        }
    }//GEN-LAST:event_txtPriceKeyReleased

    private void txtquantityKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtquantityKeyReleased
        // TODO add your handling code here:
         txtquantity.setText(cutChar(txtquantity.getText()));
    }//GEN-LAST:event_txtquantityKeyReleased
    
    
    // list san pham
    public void showList(){
         for(SanPham s : lstsp)
        {
            model.addRow(new Object[]{
                s.getProductID(),s.getNameSP(),s.getUnit(),s.getPrice(),s.getNCC(),s.getSoluong()
        });

        }
    }                                         

   public void initcbxNCC(){
       cbxncc.removeAllItems();
       for(NCC s : lstncc)
        {
                cbxncc.addItem(s.getName());
            
        }
         
    }     
//     public void initcbxLoai(){
//       cbxLoai.removeAllItems();
//       for(LoaiSP s : lsttype)
//        {
//                cbxLoai.addItem(s.getId()+":"+s.getName());
//            
//        }
//         
//    }     

    // +1 them san pham moi
    public void showResult() {
        SanPham s = lstsp.get(lstsp.size() - 1);

        model.addRow(new Object[]{
            s.getProductID(), s.getNameSP(), s.getUnit(), s.getPrice(), s.getNCC(), s.getSoluong()
        });
    }

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
            java.util.logging.Logger.getLogger(ListSanPhamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListSanPhamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListSanPhamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListSanPhamForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 GetNV   detail = new GetNV();
                new ListSanPhamForm(detail).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JComboBox<String> cbxUnit;
    private javax.swing.JComboBox<String> cbxncc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JLabel lblClock;
    private javax.swing.JTable tblListSP;
    private javax.swing.JTextField txtNameSP;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtProID;
    private javax.swing.JTextField txtquantity;
    // End of variables declaration//GEN-END:variables
}
