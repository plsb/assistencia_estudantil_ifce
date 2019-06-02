/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.screen;

import br.meal.Meal;
import br.meal.MealDAO;
import br.student.Student;
import br.student.StudentDAO;
import br.util.UserActive;
import java.math.BigInteger;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author pelusb
 */
public class MealFrmRegister extends javax.swing.JDialog {

    private Meal meal;

    /**
     * Creates new form RegisterStudent
     */
    public MealFrmRegister() {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        setTitle("Cadastro de Refeição");
        this.meal = new Meal();
    }

    public MealFrmRegister(Meal meal) {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        setTitle("Edição de Refeição");
        this.meal = meal;
        tfDesc.setText(meal.getDescription());
        //tfTimeInitial.setText(String.valueOf(meal.getMat()));
        if (meal.getTimeStart() != null) {
            Date time = meal.getTimeStart();
            SimpleDateFormat dfdtTime;
            dfdtTime = new SimpleDateFormat("hh:mm");
            tfTimeStart.setText(dfdtTime.format(time));
        }
        if (meal.getTimeEnd() != null) {
            Date time = meal.getTimeEnd();
            SimpleDateFormat dfdtTime;
            dfdtTime = new SimpleDateFormat("hh:mm");
            tfTimeEnd.setText(dfdtTime.format(time));
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

        tfDesc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        tfTimeStart = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        tfTimeEnd = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tfDesc.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        getContentPane().add(tfDesc, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 39, 371, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Descrição: *");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(14, 17, -1, -1));

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/Save_37110.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 140, -1, -1));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/forceexit_103817.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        try {
            tfTimeStart.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTimeStart.setToolTipText("Informe a data de nascimento");
        tfTimeStart.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        tfTimeStart.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        getContentPane().add(tfTimeStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 150, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Hora Inicio *:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        try {
            tfTimeEnd.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfTimeEnd.setToolTipText("Informe a data de nascimento");
        tfTimeEnd.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        tfTimeEnd.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        getContentPane().add(tfTimeEnd, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 150, -1));

        jLabel7.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel7.setText("Hora Fim *:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 70, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if (tfDesc.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a Descrição!");
            tfDesc.requestFocus();
            return;
        }

        String timeStart = tfTimeStart.getText();
        try {
            DateFormat fmt = new SimpleDateFormat("hh:mm");
            java.util.Date time;
            time = new java.util.Date(fmt.parse(timeStart).getTime());
            meal.setTimeStart(time);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Hora de início em formato incorreto.", 
                    "IFCE", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        String timeEnd = tfTimeEnd.getText();
        try {
            DateFormat fmt = new SimpleDateFormat("hh:mm");
            java.util.Date time;
            time = new java.util.Date(fmt.parse(timeEnd).getTime());
            meal.setTimeEnd(time);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Hora de fim em formato incorreto.", 
                    "IFCE", JOptionPane.ERROR_MESSAGE);
            return ; 
        }

        meal.setDescription(tfDesc.getText());

        MealDAO mDAO = new MealDAO();
        meal.setCampus(UserActive.returnCampus());
        if (meal.getId() == null) {
            mDAO.add(meal);
        } else {
            mDAO.update(meal);
        }
        setVisible(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(MealFrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MealFrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MealFrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MealFrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MealFrmRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JTextField tfDesc;
    private javax.swing.JFormattedTextField tfTimeEnd;
    private javax.swing.JFormattedTextField tfTimeStart;
    // End of variables declaration//GEN-END:variables
}
