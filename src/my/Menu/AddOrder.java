/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.Menu;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lap
 */
public final class AddOrder extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    Date date;
    DateFormat dateformat;
    DateFormat dayDateFormat;
    DefaultComboBoxModel comboModel;
    ArrayList<Dish> dishes;
    Order order;
    ArrayList<Order> orders;
    String dateString;
    String dayDateString;
    
    public AddOrder() {
        initComponents();
        dishes = new ArrayList<Dish>();
        orders = new ArrayList<Order>();
        tableModel = new DefaultTableModel();
        comboModel = new DefaultComboBoxModel();
        dateformat = new SimpleDateFormat("dd-MM-yyyy - hh:mm:ss");
        dayDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        date = new Date();
        dateString = dateformat.format(date);
        dayDateString = dayDateFormat.format(date);
        order = new Order(dateString);
        populatearraylist();
        tableModel = (DefaultTableModel) orderTbl.getModel();
        comboModel.removeAllElements();
        for (int i = 0; i < dishes.size(); i++)
                comboModel.addElement(dishes.get(i).getName());
        dishCbx.setModel(comboModel);
        
    }

    public void populatearraylist()
    {
        try
        {
            FileInputStream file= new FileInputStream("dishes.dat");// to make file 
            ObjectInputStream inputFile = new ObjectInputStream(file); //read object from file
            boolean endOfFile =false; //to check whether if it's the end of the file
            while(!endOfFile)// it's not the end of the file so keep extracting data
            {
                try
                {
                    dishes.add((Dish) inputFile.readObject());// reading from file and add to arraylist
                }
                catch(EOFException e) //when end of file
                {
                    endOfFile=true;
                }
                catch(Exception f)
                {
                    JOptionPane.showMessageDialog(null,f.getMessage());
                }
            }
            inputFile.close();
        }
        catch(IOException e) // if there is no data in the file
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        
        try
        {
            FileInputStream File2 = new FileInputStream("Orders" + dayDateString +".dat");// to make file 
            ObjectInputStream inputFile2 = new ObjectInputStream(File2); //read object from file
            boolean endOfFile =false; //to check whether if it's the end of the file
            while(!endOfFile)// it's not the end of the file so keep extracting data
            {
                try
                {
                    orders.add((Order) inputFile2.readObject());// reading from file and add to arraylist
                }
                catch(EOFException e) //when end of file
                {
                    endOfFile=true;
                }
                catch(Exception f)
                {
                    JOptionPane.showMessageDialog(null,f.getMessage());
                }
            }
            inputFile2.close();
        }
        catch(IOException e) // if there is no data in the file
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    public void SaveOrderToFile()
    {
        try
        {
            FileOutputStream file= new FileOutputStream("Orders" + dayDateString +".dat");
            ObjectOutputStream OutputFile = new ObjectOutputStream(file); 
            for (Order order: orders){
                System.out.println("added");
                OutputFile.writeObject(order);//to get objects and save it to the aray list
            }
            OutputFile.close();
            JOptionPane.showMessageDialog(null,"successfully saved");
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addDishesLbl = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        orderTbl = new javax.swing.JTable();
        dishLbl = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        dishCbx = new javax.swing.JComboBox<>();
        doneBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        quantityTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        addDishesLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addDishesLbl.setText("Add dishes of new order");

        orderTbl.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        orderTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Dish", "Quantity", "Unit price", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Double.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        orderTbl.setRowHeight(30);
        orderTbl.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(orderTbl);
        if (orderTbl.getColumnModel().getColumnCount() > 0) {
            orderTbl.getColumnModel().getColumn(0).setMinWidth(40);
            orderTbl.getColumnModel().getColumn(0).setMaxWidth(40);
            orderTbl.getColumnModel().getColumn(1).setMinWidth(200);
            orderTbl.getColumnModel().getColumn(1).setMaxWidth(200);
            orderTbl.getColumnModel().getColumn(2).setMinWidth(60);
            orderTbl.getColumnModel().getColumn(2).setMaxWidth(60);
            orderTbl.getColumnModel().getColumn(3).setMinWidth(80);
            orderTbl.getColumnModel().getColumn(3).setMaxWidth(80);
            orderTbl.getColumnModel().getColumn(4).setMinWidth(80);
            orderTbl.getColumnModel().getColumn(4).setMaxWidth(80);
        }

        dishLbl.setText("Dish:");

        jLabel1.setText("Quantity:");

        dishCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        dishCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dishCbxActionPerformed(evt);
            }
        });

        doneBtn.setText("Done");
        doneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneBtnActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        quantityTxt.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(addDishesLbl))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(dishLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(dishCbx, 0, 225, Short.MAX_VALUE)
                            .addComponent(quantityTxt))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(61, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(clearBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(doneBtn)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addDishesLbl)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dishLbl)
                    .addComponent(dishCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(doneBtn)
                    .addComponent(clearBtn)
                    .addComponent(deleteBtn)
                    .addComponent(addBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneBtnActionPerformed
        orders.add(order);
        SaveOrderToFile();
        this.dispose();
    }//GEN-LAST:event_doneBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        tableModel = (DefaultTableModel) orderTbl.getModel();
        int size = tableModel.getRowCount();
        order.clearDishes();
        try {
        for (int i = size - 1; i >= 0; i--) {
            tableModel.removeRow(i);
        }
        } catch (ArrayIndexOutOfBoundsException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        orderTbl.setModel(tableModel);
    }//GEN-LAST:event_clearBtnActionPerformed

    private void dishCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dishCbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dishCbxActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        tableModel = (DefaultTableModel) orderTbl.getModel();
        Dish dish = dishes.get(dishCbx.getSelectedIndex());
        if (order.getDishes().contains(dish)) {
            dish.setQuantity(dish.getQuantity() + Double.parseDouble(quantityTxt.getText()));
            tableModel.setValueAt(dish.getQuantity(), order.getDishes().indexOf(dish), 2);
            tableModel.setValueAt(dish.getQuantity()*dish.getPrice(), order.getDishes().indexOf(dish), 4);
        } else {
            dish.setQuantity(Double.parseDouble(quantityTxt.getText()));
            order.addDish(dish);
            tableModel.insertRow(tableModel.getRowCount(), new Object[]{orderTbl.getRowCount() + 1, dish.getName(), dish.getQuantity(), dish.getPrice(), dish.getQuantity()*dish.getPrice()});
        }
        orderTbl.setModel(tableModel);
    }//GEN-LAST:event_addBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        tableModel = (DefaultTableModel) orderTbl.getModel();
        order.removeDish(orderTbl.getSelectedRow());
        tableModel.removeRow(orderTbl.getSelectedRow());
        for (int i = 0; i < orderTbl.getRowCount(); i++) {
            tableModel.setValueAt(new String(i + 1 + ""), i, 0);
        }
        orderTbl.setModel(tableModel);
    }//GEN-LAST:event_deleteBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddOrder.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddOrder().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel addDishesLbl;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JComboBox<String> dishCbx;
    private javax.swing.JLabel dishLbl;
    private javax.swing.JButton doneBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable orderTbl;
    private javax.swing.JTextField quantityTxt;
    // End of variables declaration//GEN-END:variables
}
