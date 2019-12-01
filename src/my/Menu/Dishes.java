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
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author Moshira
 */
public class Dishes extends javax.swing.JFrame {

    ArrayList<Ingredientsclass> ingredients;
    ArrayList<Ingredientsclass> dishIngredients;
    ArrayList<Dish> dishes;
    DefaultComboBoxModel comboModel;
    DefaultListModel DLM;
    Date date;
    DateFormat dayDateFormat;
    String dayDateString;
    
    public Dishes() {
        initComponents();
        date = new Date();
        dayDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dayDateString = dayDateFormat.format(date);
        ingredients = new ArrayList<Ingredientsclass>();
        dishIngredients = new ArrayList<Ingredientsclass>();
        dishes = new ArrayList<Dish>();
        populatearraylist();
        comboModel = new DefaultComboBoxModel();
        DLM = new DefaultListModel();
        DLM.clear();
        ingredientsList.setModel(DLM);
        for (int i = 0; i < ingredients.size(); i++)
            comboModel.addElement(ingredients.get(i).getName());
        ingredientCbx.setModel(comboModel);
        
    }

    public void populatearraylist()
    {
        try
        {
            FileInputStream File= new FileInputStream("ingredients" + dayDateString + ".dat");// to make file 
            ObjectInputStream inputFile = new ObjectInputStream(File); //read object from file
            boolean endOfFile =false; //to check whether if it's the end of the file
            while(!endOfFile)// it's not the end of the file so keep extracting data
            {
                try
                {
                    ingredients.add((Ingredientsclass) inputFile.readObject());// reading from file and add to arraylist
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
            FileInputStream File2 = new FileInputStream("dishes.dat");// to make file 
            ObjectInputStream inputFile2 = new ObjectInputStream(File2); //read object from file
            boolean endOfFile = false; //to check whether if it's the end of the file
            while(!endOfFile)// it's not the end of the file so keep extracting data
            {
                try
                {
                    dishes.add((Dish) inputFile2.readObject());// reading from file and add to arraylist
                }
                catch(EOFException e) //when end of file
                {
                    endOfFile = true;
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
    
    public void SaveDishToFile()
    {
        try
        {
            FileOutputStream File = new FileOutputStream("dishes.dat");
            ObjectOutputStream OutputFile = new ObjectOutputStream(File); 
            for (int i =0;i<dishes.size();i++){
                OutputFile.writeObject(dishes.get(i));//to get objects and save it to the aray list
            }
            OutputFile.close();
            JOptionPane.showMessageDialog(null,"successfully saved");
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        addNewDishLbl = new javax.swing.JLabel();
        dishNameLbl = new javax.swing.JLabel();
        dishNameTxt = new javax.swing.JTextField();
        ingrLbl = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ingredientsList = new javax.swing.JList<>();
        ingredientCbx = new javax.swing.JComboBox<>();
        quantityLbl = new javax.swing.JLabel();
        doneBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        priceLbl = new javax.swing.JLabel();
        priceTxt = new javax.swing.JTextField();
        unitLbl = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        quantityTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dishes");

        addNewDishLbl.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addNewDishLbl.setText("Add New Dish");

        dishNameLbl.setText("Dish Name:");

        ingrLbl.setText("Ingredient:");

        ingredientsList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ingredientsList);

        ingredientCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        ingredientCbx.addPopupMenuListener(new javax.swing.event.PopupMenuListener() {
            public void popupMenuCanceled(javax.swing.event.PopupMenuEvent evt) {
            }
            public void popupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {
                ingredientCbxPopupMenuWillBecomeInvisible(evt);
            }
            public void popupMenuWillBecomeVisible(javax.swing.event.PopupMenuEvent evt) {
            }
        });

        quantityLbl.setText("Quantity:");

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

        priceLbl.setText("Price:");

        unitLbl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        unitLbl.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        unitLbl.setText("unit");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(doneBtn)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ingrLbl)
                                    .addComponent(dishNameLbl)
                                    .addComponent(quantityLbl)
                                    .addComponent(priceLbl))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(dishNameTxt)
                                    .addComponent(ingredientCbx, 0, 247, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(unitLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addComponent(priceTxt, javax.swing.GroupLayout.Alignment.TRAILING)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(addBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 73, Short.MAX_VALUE)
                                .addComponent(deleteBtn)
                                .addGap(71, 71, 71)
                                .addComponent(clearBtn))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(73, 73, 73))))
            .addGroup(layout.createSequentialGroup()
                .addGap(175, 175, 175)
                .addComponent(addNewDishLbl)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(addNewDishLbl)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dishNameLbl)
                    .addComponent(dishNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(priceLbl)
                    .addComponent(priceTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ingrLbl)
                    .addComponent(ingredientCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityLbl)
                    .addComponent(unitLbl)
                    .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(clearBtn)
                    .addComponent(deleteBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(doneBtn)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void doneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneBtnActionPerformed
        String name = dishNameTxt.getText();
        double price = Double.parseDouble(priceTxt.getText());
        Dish dish = new Dish(dishIngredients, name, price);
        dishes.add(dish);
        SaveDishToFile();
        this.dispose();
    }//GEN-LAST:event_doneBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        
        if (Double.parseDouble(quantityTxt.getText()) == 0) {
            JOptionPane.showMessageDialog(null,"Please enter a quantity");
        }
        else 
        { 
        Ingredientsclass ingredient = ingredients.get(ingredientCbx.getSelectedIndex());
        ingredient.setDishQuantity(Double.parseDouble(quantityTxt.getText()));
        dishIngredients.add(ingredient);
        DLM.clear();
        for (int i = 0; i < dishIngredients.size(); i++)
            DLM.addElement(dishIngredients.get(i).getName() + ", " + dishIngredients.get(i).getDishQuantity() + "/" + dishIngredients.get(i).getUnit());
        ingredientsList.setModel(DLM);
        quantityTxt.setText("");
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void ingredientCbxPopupMenuWillBecomeInvisible(javax.swing.event.PopupMenuEvent evt) {//GEN-FIRST:event_ingredientCbxPopupMenuWillBecomeInvisible
        Ingredientsclass ingredient = ingredients.get(ingredientCbx.getSelectedIndex());
        unitLbl.setText(ingredient.getUnit());
    }//GEN-LAST:event_ingredientCbxPopupMenuWillBecomeInvisible

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        dishIngredients.remove(ingredientsList.getSelectedIndex());
        DLM.clear();
        for (int i = 0; i < dishIngredients.size(); i++)
            DLM.addElement(dishIngredients.get(i).getName() + ", " + dishIngredients.get(i).getQuantity() + "/" + dishIngredients.get(i).getUnit());
        ingredientsList.setModel(DLM);
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed
        dishIngredients.clear();
        DLM.clear();
        ingredientsList.setModel(DLM);
    }//GEN-LAST:event_clearBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Dishes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dishes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dishes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dishes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dishes().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JLabel addNewDishLbl;
    private javax.swing.JButton clearBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel dishNameLbl;
    private javax.swing.JTextField dishNameTxt;
    private javax.swing.JButton doneBtn;
    private javax.swing.JLabel ingrLbl;
    private javax.swing.JComboBox<String> ingredientCbx;
    private javax.swing.JList<String> ingredientsList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel priceLbl;
    private javax.swing.JTextField priceTxt;
    private javax.swing.JLabel quantityLbl;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JLabel unitLbl;
    // End of variables declaration//GEN-END:variables
}
