/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.testyummy;

import java.awt.HeadlessException;
import java.awt.event.KeyEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Frza
 */
public class FormOrders extends javax.swing.JFrame {

    /**
     * Creates new form FrameOrder
     */
    public FormOrders() {
        initComponents();
        getData();
        noOrder();
        sumOrder();
    }

    private void getData()
    {
        // menampilkan data dari database
        try 
        {
            java.sql.Connection conn =(java.sql.Connection)App_Order.Connection.koneksiDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet sql = stm.executeQuery("SELECT Item, Qty, Total FROM order_temp");
            tblDaftar.setModel(DbUtils.resultSetToTableModel(sql));
        }
        catch (SQLException | HeadlessException e) 
        {
        }
    }
    private void sumOrder(){
        try {
            getData();
            String sql = "SELECT SUM(Total) AS Total FROM order_temp";
            java.sql.Connection conn = (java.sql.Connection)App_Order.Connection.koneksiDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
           
            while (rs.next()) {
                txtTotalPay.setText(rs.getString(""+"total"));
                
            }
            rs.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Terjadi Error");
        }
    }
    
    private void noOrder(){
        try {
        java.sql.Connection conn = (java.sql.Connection)App_Order.Connection.koneksiDB();
        Statement st = conn.createStatement();

            String sql = "SELECT * FROM `order` ORDER BY OrderID DESC";
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                String no_or = rs.getString("OrderID").substring(3);
                String no = "" +(Integer.parseInt(no_or)+1);
                String nol = "";

                if(no.length()==1){ 
                    nol = "000";
                }else if (no.length() == 2){
                    nol = "00";
                }else if (no.length() == 3){
                    nol = "0";
                }else if (no.length() == 4){
                    nol = "";
                }
                txtNoOrder.setText("ODR" + nol + no);
            } else {
                txtNoOrder.setText("ODR0001");
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    private void insertOrder(String strPizzaID, int intQty) {
        try {
            //Mengambil data dari tabel pizza
            java.sql.Connection conn = (java.sql.Connection)App_Order.Connection.koneksiDB();
            String sql = "SELECT * FROM pizza WHERE PizzaID = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, strPizzaID);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String pizzaName = rs.getString("Name");
                int price = rs.getInt("Price");
                double dbltotal = price * intQty;
                String strtotal = Double.toString(dbltotal);
                txtTotalPay.setText(strtotal);

                // Memasukkan data ke dalam tabel order_temp
                String sqll = "INSERT INTO order_temp VALUES (?, ?, ?, ?) ON DUPLICATE KEY UPDATE Qty = Qty + VALUES(Qty), Total = Total + VALUES(Total)";
                PreparedStatement pst = conn.prepareStatement(sqll);
                pst.setString(1, pizzaName);
                pst.setInt(2, price);
                pst.setInt(3, intQty);
                pst.setString(4, txtTotalPay.getText());
                pst.execute();

            } 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void FilterLetter(KeyEvent letter){
        if(Character.isDigit(letter.getKeyChar())){
           letter.consume();
           JOptionPane.showMessageDialog(null, "Please input letters only!", "Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void FilterNumber(KeyEvent number){
        if(Character.isLetter(number.getKeyChar())){
           number.consume();
           JOptionPane.showMessageDialog(null, "Please input numbers only!", "Information", JOptionPane.INFORMATION_MESSAGE);
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
        txtCustomer = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDaftar = new javax.swing.JTable();
        btnPay = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtTotalPay = new javax.swing.JTextField();
        txtPay = new javax.swing.JTextField();
        txtChange = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        txtQty1 = new javax.swing.JTextField();
        btnPilih1 = new javax.swing.JButton();
        btnPilih2 = new javax.swing.JButton();
        txtQty2 = new javax.swing.JTextField();
        txtQty4 = new javax.swing.JTextField();
        btnPilih3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        btnSave = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        txtQty5 = new javax.swing.JTextField();
        btnPilih4 = new javax.swing.JButton();
        txtQty6 = new javax.swing.JTextField();
        btnPilih5 = new javax.swing.JButton();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtQty3 = new javax.swing.JTextField();
        btnPilih6 = new javax.swing.JButton();
        bottombar = new javax.swing.JLabel();
        PanelPass = new javax.swing.JPanel();
        lblAdmin = new javax.swing.JLabel();
        btnPrint1 = new javax.swing.JButton();
        txtNoOrder = new javax.swing.JTextField();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(14, 16, 15));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(1135, 744));

        txtCustomer.setFont(new java.awt.Font("Open Sans Semibold", 0, 12)); // NOI18N
        txtCustomer.setText("Customer");
        txtCustomer.setMaximumSize(new java.awt.Dimension(64, 22));
        txtCustomer.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtCustomerFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCustomerFocusLost(evt);
            }
        });
        txtCustomer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCustomerKeyTyped(evt);
            }
        });

        tblDaftar.setBackground(new java.awt.Color(102, 102, 102));
        tblDaftar.setFont(new java.awt.Font("Roboto Medium", 0, 12)); // NOI18N
        tblDaftar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Item", "Qty.", "Total"
            }
        ));
        tblDaftar.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tblDaftar.setMaximumSize(new java.awt.Dimension(247, 80));
        tblDaftar.setMinimumSize(new java.awt.Dimension(247, 80));
        tblDaftar.setName(""); // NOI18N
        tblDaftar.setPreferredSize(new java.awt.Dimension(247, 80));
        tblDaftar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDaftarMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblDaftar);

        btnPay.setBackground(new java.awt.Color(255, 0, 51));
        btnPay.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPay.setForeground(new java.awt.Color(255, 255, 255));
        btnPay.setText("Pay");
        btnPay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPayActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Order List :");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Payment");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Total");

        txtTotalPay.setEditable(false);
        txtTotalPay.setBackground(new java.awt.Color(255, 255, 255));
        txtTotalPay.setFont(new java.awt.Font("Segoe UI Semibold", 0, 12)); // NOI18N
        txtTotalPay.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTotalPayKeyTyped(evt);
            }
        });

        txtPay.setFont(new java.awt.Font("Open Sans Semibold", 0, 12)); // NOI18N

        txtChange.setFont(new java.awt.Font("Open Sans Semibold", 0, 12)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Change");

        btnPilih1.setBackground(new java.awt.Color(255, 153, 0));
        btnPilih1.setText("Add");
        btnPilih1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPilih1MouseClicked(evt);
            }
        });
        btnPilih1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilih1ActionPerformed(evt);
            }
        });

        btnPilih2.setBackground(new java.awt.Color(255, 153, 0));
        btnPilih2.setText("Add");
        btnPilih2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPilih2MouseClicked(evt);
            }
        });
        btnPilih2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilih2ActionPerformed(evt);
            }
        });

        txtQty2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQty2ActionPerformed(evt);
            }
        });

        btnPilih3.setBackground(new java.awt.Color(255, 153, 0));
        btnPilih3.setText("Add");
        btnPilih3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPilih3MouseClicked(evt);
            }
        });
        btnPilih3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilih3ActionPerformed(evt);
            }
        });

        btnSave.setBackground(new java.awt.Color(255, 0, 51));
        btnSave.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSave.setForeground(new java.awt.Color(255, 255, 255));
        btnSave.setText("Save");
        btnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSaveActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Rp. 40.000");

        jLabel20.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("CHICKEN SAUSAGE");

        jLabel21.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("BBQ BEEF");

        jLabel22.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setText("Rp. 50.000");

        jLabel23.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Rp. 45.000");

        jLabel24.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("CLASSIC PEPPER");

        jLabel25.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Rp. 48.000");

        jLabel26.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setText("TROPICALL HAWAII");

        btnPilih4.setBackground(new java.awt.Color(255, 153, 0));
        btnPilih4.setText("Add");
        btnPilih4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPilih4MouseClicked(evt);
            }
        });
        btnPilih4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilih4ActionPerformed(evt);
            }
        });

        btnPilih5.setBackground(new java.awt.Color(255, 153, 0));
        btnPilih5.setText("Add");
        btnPilih5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPilih5MouseClicked(evt);
            }
        });
        btnPilih5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilih5ActionPerformed(evt);
            }
        });

        jLabel27.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("SPICY BEEF");

        jLabel28.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setText("Rp. 60.000");

        jLabel29.setFont(new java.awt.Font("Segoe UI Black", 1, 12)); // NOI18N
        jLabel29.setForeground(new java.awt.Color(255, 255, 255));
        jLabel29.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel29.setText("CHEESE MELT");

        jLabel30.setFont(new java.awt.Font("Roboto", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setText("Rp. 50.000");

        txtQty3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtQty3ActionPerformed(evt);
            }
        });

        btnPilih6.setBackground(new java.awt.Color(255, 153, 0));
        btnPilih6.setText("Add");
        btnPilih6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnPilih6MouseClicked(evt);
            }
        });
        btnPilih6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPilih6ActionPerformed(evt);
            }
        });

        PanelPass.setBackground(new java.awt.Color(255, 153, 0));
        PanelPass.setMaximumSize(new java.awt.Dimension(1366, 75));
        PanelPass.setPreferredSize(new java.awt.Dimension(1366, 75));

        lblUser.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblUser.setForeground(new java.awt.Color(255, 255, 255));
        lblUser.setText("Firjatullah");

        lblAdmin.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        lblAdmin.setForeground(new java.awt.Color(255, 255, 255));
        lblAdmin.setText("Admin");

        lblUser1.setFont(new java.awt.Font("Roboto Medium", 0, 14)); // NOI18N
        lblUser1.setForeground(new java.awt.Color(255, 255, 255));
        lblUser1.setIcon(new javax.swing.ImageIcon("E:\\ProfilP.png")); // NOI18N

        javax.swing.GroupLayout PanelPassLayout = new javax.swing.GroupLayout(PanelPass);
        PanelPass.setLayout(PanelPassLayout);
        PanelPassLayout.setHorizontalGroup(
            PanelPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelPassLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(lblUser1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUser)
                    .addComponent(lblAdmin))
                .addContainerGap(1146, Short.MAX_VALUE))
        );
        PanelPassLayout.setVerticalGroup(
            PanelPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelPassLayout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(PanelPassLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelPassLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(lblUser, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblAdmin))
                    .addComponent(lblUser1, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        btnPrint1.setBackground(new java.awt.Color(255, 153, 0));
        btnPrint1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnPrint1.setForeground(new java.awt.Color(255, 255, 255));
        btnPrint1.setText("Print");
        btnPrint1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrint1ActionPerformed(evt);
            }
        });

        txtNoOrder.setEditable(false);
        txtNoOrder.setMaximumSize(new java.awt.Dimension(64, 22));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bottombar, javax.swing.GroupLayout.PREFERRED_SIZE, 806, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(885, 885, 885))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(PanelPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(txtQty1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPilih1, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel20)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(jLabel19))))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel13)
                        .addComponent(jLabel15))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel25))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel26))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(txtQty4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPilih3, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(txtQty2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPilih2, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(jLabel22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(140, 140, 140)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(54, 54, 54)
                                .addComponent(jLabel28))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addComponent(jLabel27))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(txtQty5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPilih4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(91, 91, 91)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(txtQty3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnPilih6, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGap(62, 62, 62)
                            .addComponent(jLabel23))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(37, 37, 37)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel8))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(64, 64, 64)
                                        .addComponent(jLabel30))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel29)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(53, 53, 53)
                                    .addComponent(txtQty6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(btnPilih5, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(39, 39, 39))))
                .addGap(75, 75, 75)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNoOrder, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnPrint1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1)
                    .addComponent(btnPay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jSeparator3)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel11))
                                .addGap(54, 54, 54)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTotalPay, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtPay, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addComponent(txtCustomer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(426, 426, 426))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(PanelPass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel13)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel20)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel19)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnPilih1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtQty1, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addComponent(jLabel15)
                            .addGap(29, 29, 29)
                            .addComponent(jLabel26)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel25)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnPilih3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtQty4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jLabel21)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel22)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnPilih2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtQty2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(26, 26, 26)
                            .addComponent(jLabel14)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel27)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel28)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btnPilih4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtQty5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(23, 23, 23)
                                    .addComponent(jLabel23))
                                .addComponent(jLabel24))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnPilih6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtQty3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(25, 25, 25)
                            .addComponent(jLabel8)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel29)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel30)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txtQty6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPilih5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNoOrder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(15, 15, 15)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtTotalPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtPay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel10))
                                        .addGap(12, 12, 12)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(txtChange, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel12))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnPay, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnSave, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnPrint1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 525, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                .addComponent(bottombar)
                .addGap(12, 12, 12))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1370, 770));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnPilih1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilih1ActionPerformed
        // TODO add your handling code here:
        //Mengirim nilai ke method insertOrder untuk diproses
        int intQty = Integer.parseInt(txtQty1.getText());
        insertOrder("PZ-001", intQty);
        
        //Mengosongkan textboxt dan mengambil nilai        
        txtQty1.setText("");
        getData();
        sumOrder(); 
    }//GEN-LAST:event_btnPilih1ActionPerformed

    private void btnPilih1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPilih1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPilih1MouseClicked

    private void btnPayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPayActionPerformed
        // TODO add your handling code here:
        //Mengambil nilai dari textbox 
        String strTotalPay = txtTotalPay.getText();
        //Mengosongkan textboxt
        String strPay = txtPay.getText();
        
        //Mengubah nilai string ke integer
        int intTotalPay = Integer.parseInt(strTotalPay); 
        int intPay = Integer.parseInt(strPay);
        
        //Jika uang kurang tampilkan pesan
        if(intPay < intTotalPay ){
        JOptionPane.showMessageDialog(null, "Sorry, your payment is insufficient. Please add more funds!");
        //Mengosongkan textbox
        txtPay.setText("");
        
        //Jika uang mencukupi
        }else{
            //Perhitungan
            int intChange = intPay - intTotalPay;       
            //Konversi Hasil
            String strChange = Integer.toString(intChange);                
            //Display Hasil
            txtChange.setText(strChange);
                      
        }  
        
    }//GEN-LAST:event_btnPayActionPerformed

    private void btnPilih2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPilih2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPilih2MouseClicked

    private void btnPilih2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilih2ActionPerformed
        // TODO add your handling code here:
        int intQty = Integer.parseInt(txtQty2.getText());
        insertOrder("PZ-002", intQty);
        
        //Mengosongkan textboxt dan mengambil nilai        
        txtQty2.setText("");
        getData();
        sumOrder(); 
    }//GEN-LAST:event_btnPilih2ActionPerformed

    private void btnPilih3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPilih3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPilih3MouseClicked

    private void btnPilih3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilih3ActionPerformed
        // TODO add your handling code here:
        int intQty = Integer.parseInt(txtQty4.getText());
        insertOrder("PZ-004", intQty);
        
        //Mengosongkan textboxt dan mengambil nilai        
        txtQty4.setText("");
        getData();
        sumOrder(); 
    }//GEN-LAST:event_btnPilih3ActionPerformed

    private void txtQty2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQty2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQty2ActionPerformed

    private void btnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSaveActionPerformed
        // TODO add your handling code here:
        if(txtCustomer.getText().equals("") || txtChange.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Please complete the data!");

        }else{
            try {
                java.sql.Connection conn = (java.sql.Connection)App_Order.Connection.koneksiDB();
                Statement s = conn.createStatement();

                String sql = "SELECT * FROM order_temp";
                ResultSet r = s.executeQuery(sql);

                while (r.next()) {
                String sqll = "INSERT INTO order_detail VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pst = conn.prepareStatement(sqll);                         
                pst.setString(1, txtNoOrder.getText());
                pst.setString(2, r.getString("Item"));
                pst.setString(3, r.getString("Price"));
                pst.setString(4, r.getString("Qty"));
                pst.setString(5, r.getString("Total"));
                pst.executeUpdate();
                pst.close();
                }
                java.sql.Date dates = new java.sql.Date(System.currentTimeMillis());
                String date = dates.toString();
                String sqlll = "INSERT INTO `order` VALUES (?, ?, ?, ?, ?)";
                PreparedStatement pstt = conn.prepareStatement(sqlll);
                pstt.setString(1, txtNoOrder.getText());
                pstt.setString(2, txtCustomer.getText());
                pstt.setString(3, lblUser.getText());
                pstt.setString(4, txtPay.getText());
                pstt.setString(5, date);
                pstt.executeUpdate();
                pstt.close();
                r.close();
                s.close();
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }finally{
                try {

                    String sql ="TRUNCATE order_temp";
                    java.sql.Connection conn = (java.sql.Connection)App_Order.Connection.koneksiDB();
                    java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                    pst.execute();
                    JOptionPane.showMessageDialog(null, "Transaction Complete");
                    getData();
                    txtNoOrder.setText("");
                    txtCustomer.setText("");
                    txtTotalPay.setText("");
                    txtPay.setText("");
                    txtChange.setText("");
                    noOrder();
                } catch (SQLException | HeadlessException e) {
                }
            }
        }
    }//GEN-LAST:event_btnSaveActionPerformed

    private void btnPilih4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPilih4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPilih4MouseClicked

    private void btnPilih4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilih4ActionPerformed
        // TODO add your handling code here:
        int intQty = Integer.parseInt(txtQty5.getText());
        insertOrder("PZ-005", intQty);
        
        //Mengosongkan textboxt dan mengambil nilai        
        txtQty5.setText("");
        getData();
        sumOrder(); 
    }//GEN-LAST:event_btnPilih4ActionPerformed

    private void btnPilih5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPilih5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPilih5MouseClicked

    private void btnPilih5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilih5ActionPerformed
        // TODO add your handling code here:
        int intQty = Integer.parseInt(txtQty6.getText());
        insertOrder("PZ-006", intQty);
        
        //Mengosongkan textboxt dan mengambil nilai        
        txtQty6.setText("");
        getData();
        sumOrder(); 
    }//GEN-LAST:event_btnPilih5ActionPerformed

    private void txtQty3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtQty3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtQty3ActionPerformed

    private void btnPilih6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnPilih6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPilih6MouseClicked

    private void btnPilih6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPilih6ActionPerformed
        // TODO add your handling code here:
        int intQty = Integer.parseInt(txtQty3.getText());
        insertOrder("PZ-003", intQty);
        
        //Mengosongkan textboxt dan mengambil nilai        
        txtQty3.setText("");
        getData();
        sumOrder(); 
    }//GEN-LAST:event_btnPilih6ActionPerformed

    private void btnPrint1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrint1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrint1ActionPerformed

    private void txtTotalPayKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTotalPayKeyTyped
        // TODO add your handling code here:
        FilterNumber(evt);
    }//GEN-LAST:event_txtTotalPayKeyTyped

    private void txtCustomerKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCustomerKeyTyped
        // TODO add your handling code here:
        FilterLetter(evt);
    }//GEN-LAST:event_txtCustomerKeyTyped

    private void txtCustomerFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerFocusGained
        // TODO add your handling code here:
        String cust=txtCustomer.getText();
        if(cust.equals("Customer")){
            txtCustomer.setText("");
        }
    }//GEN-LAST:event_txtCustomerFocusGained

    private void txtCustomerFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCustomerFocusLost
        // TODO add your handling code here:
        String cust=txtCustomer.getText();
        if(cust.equals("")||cust.equals("Customer")){
            txtCustomer.setText("Customer");
        }
    }//GEN-LAST:event_txtCustomerFocusLost

    private void tblDaftarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDaftarMouseClicked
        // TODO add your handling code here:
        try {
        int row = tblDaftar.getSelectedRow();
        String tableclick = tblDaftar.getModel().getValueAt(row, 0).toString();  
        int option = JOptionPane.showConfirmDialog(null, "Delete item?", "Confirm", JOptionPane.YES_NO_OPTION);
        
        //Jika memilih option Yes
        if (option == JOptionPane.YES_OPTION) { 
            java.sql.Connection conn = App_Order.Connection.koneksiDB();
            Statement st = conn.createStatement();
            st.executeUpdate("DELETE FROM order_temp WHERE Item = '" + tableclick + "'");
            
        //Jika memilih option No
        } else if (option == JOptionPane.NO_OPTION) {
        }
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        getData();
        sumOrder();
    }//GEN-LAST:event_tblDaftarMouseClicked

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
            java.util.logging.Logger.getLogger(FormOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormOrders.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormOrders().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelPass;
    private javax.swing.JLabel bottombar;
    private javax.swing.JButton btnPay;
    private javax.swing.JButton btnPilih1;
    private javax.swing.JButton btnPilih2;
    private javax.swing.JButton btnPilih3;
    private javax.swing.JButton btnPilih4;
    private javax.swing.JButton btnPilih5;
    private javax.swing.JButton btnPilih6;
    private javax.swing.JButton btnPrint1;
    private javax.swing.JButton btnSave;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAdmin;
    public static final javax.swing.JLabel lblUser = new javax.swing.JLabel();
    public static final javax.swing.JLabel lblUser1 = new javax.swing.JLabel();
    private javax.swing.JTable tblDaftar;
    private javax.swing.JTextField txtChange;
    private javax.swing.JTextField txtCustomer;
    private javax.swing.JTextField txtNoOrder;
    private javax.swing.JTextField txtPay;
    private javax.swing.JTextField txtQty1;
    private javax.swing.JTextField txtQty2;
    private javax.swing.JTextField txtQty3;
    private javax.swing.JTextField txtQty4;
    private javax.swing.JTextField txtQty5;
    private javax.swing.JTextField txtQty6;
    private javax.swing.JTextField txtTotalPay;
    // End of variables declaration//GEN-END:variables
}
