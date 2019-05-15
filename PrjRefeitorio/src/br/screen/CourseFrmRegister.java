/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.screen;

import br.course.Course;
import br.course.CourseDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author pelusb
 */
public class CourseFrmRegister extends javax.swing.JDialog {

    private Course course;
    /**
     * Creates new form RegisterStudent
     */
    public CourseFrmRegister() {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        setTitle("Cadastro de Curso");
        this.course = new Course();
    }
    
    public CourseFrmRegister(Course course) {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        setTitle("Edição de Curso");
        this.course = course;
        tfDesc.setText(course.getDescription());
        tfSigla.setText(course.getInitials());
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
        jLabel3 = new javax.swing.JLabel();
        tfSigla = new javax.swing.JTextField();

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

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Sigla: *");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        tfSigla.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        getContentPane().add(tfSigla, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 371, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(tfDesc.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Informe a Descrição!");
            tfDesc.requestFocus();
            return;
        }
        
        if(tfSigla.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Informe a Sigla!");
            tfSigla.requestFocus();
            return;
        }
       
        course.setDescription(tfDesc.getText());
        course.setInitials(tfSigla.getText());
        
        CourseDAO cDAO = new CourseDAO();

        if(course.getId()==null){
            cDAO.add(course);
        } else {
            cDAO.update(course);
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
            java.util.logging.Logger.getLogger(CourseFrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseFrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseFrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseFrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseFrmRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField tfDesc;
    private javax.swing.JTextField tfSigla;
    // End of variables declaration//GEN-END:variables
}
