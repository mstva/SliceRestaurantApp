package my.Menu;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Moshira
 */
import javax.swing.*;
import java.util.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Ingredients extends javax.swing.JFrame {
   ArrayList<Ingredientsclass> ingredients;
   DefaultListModel DLM;
   String[] units = {"Piece", "Gram", "KiloGram", "Cup", "Litre"};
   Date date;
   DateFormat dayDateFormat;
   String dayDateString;
   
    public Ingredients() {
        initComponents();
        date = new Date();
        dayDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dayDateString = dayDateFormat.format(date);
        dateLbl.setText(dayDateString);
        ingredients = new ArrayList<Ingredientsclass>();
        populatearraylist(); //To get data added to arraylist
        DLM = new DefaultListModel();
        for (int i = 0; i < ingredients.size(); i++)
                DLM.addElement(ingredients.get(i).getName() + ", " + ingredients.get(i).getCost());
        ingrList.setModel(DLM);
        unitCbx.setModel(new DefaultComboBoxModel(units));
        
    }
    public void populatearraylist()
    {
        try
        {
            FileInputStream File= new FileInputStream("ingredients" + dayDateString +".dat");// to make file 
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
    }
    
    
    
    
    public void SaveIngredientsToFile()
    {
        try
        {
            FileOutputStream File= new FileOutputStream("ingredients" + dayDateString + ".dat");
            ObjectOutputStream OutputFile = new ObjectOutputStream(File); 
            for (int i =0;i<ingredients.size();i++){
                OutputFile.writeObject(ingredients.get(i));//to get objects and save it to the aray list
            }
            OutputFile.close();
            JOptionPane.showMessageDialog(null,"successfully saved");
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null,e.getMessage());
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

        ingredientLbl = new javax.swing.JLabel();
        costLbl = new javax.swing.JLabel();
        costTxt = new javax.swing.JTextField();
        addBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        ingredientTxt = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        ingrList = new javax.swing.JList<>();
        jLabel1 = new javax.swing.JLabel();
        doneBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        unitLbl = new javax.swing.JLabel();
        unitCbx = new javax.swing.JComboBox<>();
        quantityTxt = new javax.swing.JTextField();
        quantityLbl = new javax.swing.JLabel();
        dateLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingredients");

        ingredientLbl.setText("Ingredient:");

        costLbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        costLbl.setText("Cost:");

        costTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                costTxtActionPerformed(evt);
            }
        });

        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        clearBtn.setText("Clear");
        clearBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearBtnActionPerformed(evt);
            }
        });

        ingredientTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingredientTxtActionPerformed(evt);
            }
        });

        ingrList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(ingrList);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Add Ingredients");

        doneBtn.setText("Done");
        doneBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                doneBtnActionPerformed(evt);
            }
        });

        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        unitLbl.setText("Unit:");

        unitCbx.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        unitCbx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unitCbxActionPerformed(evt);
            }
        });

        quantityTxt.setText("1");
        quantityTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quantityTxtActionPerformed(evt);
            }
        });

        quantityLbl.setText("Quantity:");

        dateLbl.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        dateLbl.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(92, 92, 92)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(jLabel1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(unitLbl)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ingredientLbl)
                                    .addComponent(costLbl))
                                .addComponent(quantityLbl))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(quantityTxt)
                                .addComponent(ingredientTxt)
                                .addComponent(costTxt)
                                .addComponent(unitCbx, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(144, Short.MAX_VALUE)
                .addComponent(addBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(deleteBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateLbl)
                    .addComponent(doneBtn))
                .addGap(7, 7, 7))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {costLbl, ingredientLbl});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(dateLbl)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ingredientLbl)
                    .addComponent(ingredientTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(costTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(unitLbl)
                    .addComponent(unitCbx, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantityTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quantityLbl))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(clearBtn)
                    .addComponent(doneBtn)
                    .addComponent(deleteBtn))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void costTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_costTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_costTxtActionPerformed

    private void clearBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearBtnActionPerformed

       ingredientTxt.setText("");
       costTxt.setText("");
       unitCbx.setSelectedIndex(0);
       ingredients.clear();
       DLM.clear();
       ingrList.setModel(DLM);
    }//GEN-LAST:event_clearBtnActionPerformed

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
    if(ingredientTxt.getText().isEmpty()|| costTxt.getText().isEmpty()){
           JOptionPane.showMessageDialog(null,"Please enter all fields");
    }
    else{
        String cost = costTxt.getText().trim();
        String ingredient = ingredientTxt.getText().trim();
        String unit = units[unitCbx.getSelectedIndex()];
        double quantity = Double.parseDouble(quantityTxt.getText());
        Ingredientsclass ingr= new Ingredientsclass(ingredient,Double.parseDouble(cost), unit, quantity);
        ingredients.add(ingr);
        DLM.clear();
        for (int i = 0; i < ingredients.size(); i++)
                DLM.addElement(ingredients.get(i).getName() + ", " + ingredients.get(i).getCost() + "LE, " + ingredients.get(i).getQuantity() +
                               " " + ingredients.get(i).getUnit() + "(s)");
        ingrList.setModel(DLM);
        ingredientTxt.setText("");
        costTxt.setText("");
        unitCbx.setSelectedIndex(0);
        quantityTxt.setText("1");
    }
        
    }//GEN-LAST:event_addBtnActionPerformed

    private void ingredientTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingredientTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingredientTxtActionPerformed

    private void doneBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_doneBtnActionPerformed
        SaveIngredientsToFile();
        this.dispose();
    }//GEN-LAST:event_doneBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        ingredients.remove(ingrList.getSelectedIndex());
        DLM.clear();
        for (int i = 0; i < ingredients.size(); i++)
                DLM.addElement(ingredients.get(i).getName() + ", " + ingredients.get(i).getCost());
        ingrList.setModel(DLM);
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void unitCbxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unitCbxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_unitCbxActionPerformed

    private void quantityTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quantityTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quantityTxtActionPerformed

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
            java.util.logging.Logger.getLogger(Ingredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ingredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ingredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ingredients.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ingredients().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JLabel costLbl;
    private javax.swing.JTextField costTxt;
    private javax.swing.JLabel dateLbl;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton doneBtn;
    private javax.swing.JList<String> ingrList;
    private javax.swing.JLabel ingredientLbl;
    private javax.swing.JTextField ingredientTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel quantityLbl;
    private javax.swing.JTextField quantityTxt;
    private javax.swing.JComboBox<String> unitCbx;
    private javax.swing.JLabel unitLbl;
    // End of variables declaration//GEN-END:variables

}