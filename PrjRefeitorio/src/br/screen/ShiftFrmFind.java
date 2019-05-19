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
import br.shift.Shift;
import br.shift.ShiftDAO;
import br.shift.ShiftTableModel;
import br.student.Student;
import br.student.StudentDAO;
import br.student.StudentTableModel;
import br.util.FormatSizeColJTable;
import java.util.ArrayList;
import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author João
 */
public class ShiftFrmFind extends javax.swing.JDialog {

    /**
     * Creates new form FindPersonFrm
     */
    public ShiftFrmFind() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        preencheTabela("");
    }

    public void preencheTabela(String texto) {
        ShiftDAO sDAO = new ShiftDAO();
        if (texto.equals("")) {
            ShiftTableModel ptm = new ShiftTableModel(new ArrayList(new HashSet(sDAO.list())));
            tbShift.setModel(ptm);
        } else {
            ShiftTableModel ptm = 
                    new ShiftTableModel(
                            new ArrayList(new HashSet(sDAO.checkExistsLike("description", texto))));
            tbShift.setModel(ptm);
        }

        FormatSizeColJTable.packColumns(tbShift, 1);
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
        tbShift = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
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
        jLabel23.setText("Consulta de Turnos");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(0, 0, 460, 30);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(432, 177));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbShift.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tbShift.setModel(new javax.swing.table.DefaultTableModel(
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
        tbShift.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbShiftMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbShiftMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbShift);

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

        jButton1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/search.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        tfPesquisarNome.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jPanel1.add(tfPesquisarNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 280, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Pesquisar por nome:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnDelete.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/ic_delete_128_28267.png"))); // NOI18N
        btnDelete.setText("Excluir");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 300, -1, -1));

        btnNew.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/new-file_40454.png"))); // NOI18N
        btnNew.setText("Novo");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 300, -1, -1));

        btnEdit.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/edit_icon-icons.com_52382.png"))); // NOI18N
        btnEdit.setText("Editar");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 300, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 600, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbShiftMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbShiftMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_tbShiftMouseClicked

    private void tbShiftMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbShiftMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbShiftMouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        preencheTabela(tfPesquisarNome.getText().toString());
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        if (tbShift.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha da tabela!");
        } else {
            ShiftTableModel ptm = (ShiftTableModel) tbShift.getModel();
            Shift select = ptm.getShift(tbShift.getSelectedRow());
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Excluir o Turno " + select.getDescription() + "?",
                    "Excluir Turno", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                ShiftDAO cDAO = new ShiftDAO();
                try {
                    cDAO.remove(select);
                } catch (Exception ex) {
                      JOptionPane.showMessageDialog(rootPane, "Turno não pode ser excluído!");
                }
                preencheTabela(tfPesquisarNome.getText().toString());
            }

        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        ShiftFrmRegister rpf = new ShiftFrmRegister();
        rpf.setVisible(true);
        preencheTabela(tfPesquisarNome.getText().toString());
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
       if (tbShift.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha da tabela!");
        } else {
            ShiftTableModel ptm = (ShiftTableModel) tbShift.getModel();
            Shift select = ptm.getShift(tbShift.getSelectedRow());
            ShiftFrmRegister rpf = new ShiftFrmRegister(select);
            rpf.setVisible(true);
            preencheTabela(tfPesquisarNome.getText().toString());
        }
    }//GEN-LAST:event_btnEditActionPerformed

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
            java.util.logging.Logger.getLogger(ShiftFrmFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ShiftFrmFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ShiftFrmFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ShiftFrmFind.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ShiftFrmFind().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbShift;
    private javax.swing.JTextField tfPesquisarNome;
    // End of variables declaration//GEN-END:variables
}