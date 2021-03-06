/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.screen;


import br.course.Course;
import br.course.CourseDAO;
import br.course.CourseTableModel;
import br.meal.Meal;
import br.meal.MealDAO;
import br.meal.MealTableModel;
import br.student.Student;
import br.student.StudentDAO;
import br.student.StudentTableModel;
import br.util.FormatSizeColJTable;
import br.util.UserActive;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

/**
 *
 * @author João
 */
public class CourseFrmFind extends javax.swing.JDialog {

    /**
     * Creates new form FindPersonFrm
     */
    public CourseFrmFind() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        preencheTabela("");
    }

    public void preencheTabela(String texto) {
        CourseDAO cDAO = new CourseDAO();
        if (texto.equals("")) {
            CourseTableModel ptm = new CourseTableModel(cDAO.checkExists("campus", UserActive.returnCampus()));
            tbCourse.setModel(ptm);
        } else {
            CourseTableModel ptm = new CourseTableModel(cDAO.checkExistsLike("description", texto,
                    "campus", UserActive.returnCampus()));
            tbCourse.setModel(ptm);
        }

        FormatSizeColJTable.packColumns(tbCourse, 1);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbCourse = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        btSearch = new javax.swing.JButton();
        tfPesquisarNome = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 100, 0));
        jPanel3.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Consulta de Cursos");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(0, 0, 460, 30);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(432, 177));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbCourse.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tbCourse.setModel(new javax.swing.table.DefaultTableModel(
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
        tbCourse.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCourseMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbCourseMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbCourse);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 580, 220));

        jButton3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/exit_icon-icons.com_48304.png"))); // NOI18N
        jButton3.setToolTipText("Sair");
        jButton3.setPreferredSize(new java.awt.Dimension(63, 39));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 300, 57, 40));

        btSearch.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/search.png"))); // NOI18N
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        tfPesquisarNome.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tfPesquisarNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfPesquisarNomeKeyPressed(evt);
            }
        });
        jPanel1.add(tfPesquisarNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 280, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Pesquisar por nome:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnDelete.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/ic_delete_128_28267.png"))); // NOI18N
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 300, -1, -1));

        btnNew.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/new-file_40454.png"))); // NOI18N
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 300, -1, -1));

        btnEdit.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/edit_icon-icons.com_52382.png"))); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 300, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 600, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbCourseMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCourseMouseClicked
        if(evt.getClickCount() == 2){
            btnEditActionPerformed(null);
        }
    }//GEN-LAST:event_tbCourseMouseClicked

    private void tbCourseMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCourseMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbCourseMouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed
        preencheTabela(tfPesquisarNome.getText().toString());
    }//GEN-LAST:event_btSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tbCourse.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha da tabela!");
        } else {
            CourseTableModel ptm = (CourseTableModel) tbCourse.getModel();
            Course select = ptm.getCourse(tbCourse.getSelectedRow());
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Excluir o Curso " + select.getDescription() + "?",
                    "Excluir Curso", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                CourseDAO cDAO = new CourseDAO();
                try {
                    cDAO.remove(select);
                } catch (Exception ex) {
                      JOptionPane.showMessageDialog(rootPane, "Curso não pode ser excluído!");
                }
                preencheTabela(tfPesquisarNome.getText().toString());
            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        CourseFrmRegister rpf = new CourseFrmRegister();
        rpf.setVisible(true);
        preencheTabela(tfPesquisarNome.getText().toString());
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       if (tbCourse.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha da tabela!");
        } else {
            CourseTableModel ptm = (CourseTableModel) tbCourse.getModel();
            Course select = ptm.getCourse(tbCourse.getSelectedRow());
            CourseFrmRegister rpf = new CourseFrmRegister(select);
            rpf.setVisible(true);
            preencheTabela(tfPesquisarNome.getText().toString());
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tfPesquisarNomeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfPesquisarNomeKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { 
            btSearchActionPerformed(null);
        }
    }//GEN-LAST:event_tfPesquisarNomeKeyPressed

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
            java.util.logging.Logger.getLogger(CourseFrmFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseFrmFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseFrmFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseFrmFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
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
                new CourseFrmFind().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btSearch;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbCourse;
    private javax.swing.JTextField tfPesquisarNome;
    // End of variables declaration//GEN-END:variables
}
