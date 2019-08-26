/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.screen;

import br.meal.Meal;
import br.meal.MealDAO;
import br.scheduling.Scheduling;
import br.scheduling.SchedulingDAO;
import br.scheduling.SchedulingTableModel;
import br.student.Student;
import br.student.StudentDAO;
import br.student.StudentTableModel;
import br.util.FormatSizeColJTable;
import br.util.UserActive;
import br.util.Util;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author João
 */
public class ChooseByMealFrm extends javax.swing.JDialog {

    private List<Scheduling> list;

    /**
     * Creates new form FindPersonFrm
     */
    public ChooseByMealFrm() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        insertMeals();
        edDate.setText(returnDate());
        tbStudents.setAutoCreateRowSorter(true);
        preencheTabela(null, 0, "");
        if (UserActive.retornaUsuarioAtivo().getTipo().equals("RECEPCAO")) {
            btDelete.setEnabled(false);
        }
    }

    public String returnDate() {
        Date dataAtual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(dataAtual);
        return data;
    }

    public void insertMeals() {
        cbMeal.removeAllItems();
        cbMeal.addItem("-");

        MealDAO mdao = new MealDAO();
        List<Meal> list = mdao.list("campus", UserActive.returnCampus(),"description");

        for (int i = 0; i < list.size(); i++) {
            cbMeal.addItem(list.get(i));
        }
    }

    public void preencheTabela(Date date, int opcao, String nameStudent) {
        if (date == null) {
            SchedulingTableModel ptm = new SchedulingTableModel(new ArrayList<Scheduling>());
            tbStudents.setModel(ptm);
        } else {
            SchedulingDAO sDAO = new SchedulingDAO();
            if (!nameStudent.equals("")) {
                StudentDAO studentDAO = new StudentDAO();
                List<Student> students = studentDAO.checkExistsLike("name", nameStudent);
                list = sDAO.checkExistsin("student", students, date, (Meal) cbMeal.getSelectedItem());
            } else {
                switch (opcao) {
                    case 0:
                        list = sDAO.schedulingDateMeal(date, (Meal) cbMeal.getSelectedItem());
                        break;
                    case 1:
                        list = sDAO.schedulingDateMealWasPresent(date, (Meal) cbMeal.getSelectedItem(), true);
                        break;
                    case 2:
                        list = sDAO.schedulingDateMealWasPresent(date, (Meal) cbMeal.getSelectedItem(), false);
                        break;
                }
            }

            List<Scheduling> listPres = sDAO.schedulingDateMealWasPresent(date, (Meal) cbMeal.getSelectedItem(), true);

            List<Scheduling> listNoPres = sDAO.schedulingDateMealWasPresent(date, (Meal) cbMeal.getSelectedItem(), false);

            if (list.size() > 0) {
                if(!nameStudent.equals("")){
                    lblInfo.setText("Pesquisa por aluno.");
                } else {
                    lblInfo.setText(list.size() + " refeições (" + cbMeal.getSelectedItem().toString() + "). " + listPres.size() + " presentes. " + listNoPres.size() + " ausentes.");
                }
            } else {
                lblInfo.setText("0 refeições.");
            }

            SchedulingTableModel ptm = new SchedulingTableModel(list);
            tbStudents.setModel(ptm);
        }

        FormatSizeColJTable.packColumns(tbStudents, 1);

        tbStudents.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                //A coluna do status é 3
                Object ref = table.getValueAt(row, 6);//Coluna Status
                //Coloca cor em todas as linhas,COLUNA(3) que tem o valor "Aberto"
                if (ref != null && ref.equals("Ausente")) {//Se Status for igual a "Aberto"
                    Color cor = new Color(255, 127, 80);
                    setBackground(cor);
                } else if (ref != null && ref.equals("Presente")) {
                    Color cor = new Color(144, 238, 144);
                    setBackground(cor);
                } else {
                    setBackground(Color.WHITE);
                }
                comp.setForeground(Color.black);
                return this;
            }
        });
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
        tbStudents = new javax.swing.JTable();
        jButton3 = new javax.swing.JButton();
        lblInfo = new javax.swing.JLabel();
        btSearch = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        cbOpcao = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        btDelete = new javax.swing.JButton();
        edDate = new javax.swing.JFormattedTextField();
        btExcel = new javax.swing.JButton();
        cbMeal = new javax.swing.JComboBox();
        tfNameStudent = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 100, 0));
        jPanel3.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Verificar refeições");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(0, 0, 460, 30);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 820, 40));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(432, 177));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbStudents.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tbStudents.setModel(new javax.swing.table.DefaultTableModel(
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
        tbStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbStudentsMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tbStudentsMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(tbStudents);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 790, 280));

        jButton3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/exit_icon-icons.com_48304.png"))); // NOI18N
        jButton3.setToolTipText("Sair");
        jButton3.setPreferredSize(new java.awt.Dimension(63, 39));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 430, 57, 40));

        lblInfo.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblInfo.setText("0 refeições.");
        jPanel1.add(lblInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 530, -1));

        btSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/search.png"))); // NOI18N
        btSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Data:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 790, -1));

        cbOpcao.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        cbOpcao.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Todos", "Presentes", "Ausentes" }));
        cbOpcao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbOpcaoKeyPressed(evt);
            }
        });
        jPanel1.add(cbOpcao, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 170, 30));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Refeição:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));

        btDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/ic_delete_128_28267.png"))); // NOI18N
        btDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 430, -1, -1));

        try {
            edDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        edDate.setToolTipText("Informe a data de nascimento");
        edDate.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        edDate.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        edDate.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edDateKeyPressed(evt);
            }
        });
        jPanel1.add(edDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 150, -1));

        btExcel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/excel.png"))); // NOI18N
        btExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcelActionPerformed(evt);
            }
        });
        jPanel1.add(btExcel, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 430, -1, -1));

        cbMeal.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        cbMeal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMeal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbMealKeyPressed(evt);
            }
        });
        jPanel1.add(cbMeal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 280, 30));

        tfNameStudent.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        tfNameStudent.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfNameStudentKeyPressed(evt);
            }
        });
        jPanel1.add(tfNameStudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 620, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Nome: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 820, 490));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStudentsMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_tbStudentsMouseClicked

    private void tbStudentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStudentsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbStudentsMouseEntered

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchActionPerformed

        if (edDate.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a data.");
            return;
        }
        if (cbMeal.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Informe a refeição.");
            return;
        }

        String dataString = edDate.getText();
        java.util.Date data;
        try {
            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            data = new java.util.Date(fmt.parse(dataString).getTime());
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(rootPane, "Data inválida.");
            return;
        }

        preencheTabela(data, cbOpcao.getSelectedIndex(), tfNameStudent.getText());

    }//GEN-LAST:event_btSearchActionPerformed

    private void btDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDeleteActionPerformed
        if (tbStudents.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha da tabela!");
        } else {
            SchedulingTableModel ptm = (SchedulingTableModel) tbStudents.getModel();
                Scheduling select = ptm.getScheduling(tbStudents.getSelectedRow());
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Cancelar a refeição de "+
                    select.getStudent().getName()+"?",
                    "Excluir Refeição", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                

                if (select.isWasPresent()) {
                    JOptionPane.showMessageDialog(rootPane,
                            "Não foi possível excluir a refeição. \nRefeição já validada!", "IFCE", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                SchedulingDAO dao = new SchedulingDAO();
                select.setCanceled_by_student(true);
                dao.update(select);

                String dataString = edDate.getText();
                java.util.Date data;
                try {
                    DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
                    data = new java.util.Date(fmt.parse(dataString).getTime());
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Data inválida.");
                    return;
                }
                preencheTabela(data, cbOpcao.getSelectedIndex(), "");
            }
        }
    }//GEN-LAST:event_btDeleteActionPerformed

    private void btExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcelActionPerformed
        Util.exportJTableToExcel(tbStudents);
    }//GEN-LAST:event_btExcelActionPerformed

    public void verifyPressedEnter(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btSearchActionPerformed(null);
        }
    }

    private void edDateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edDateKeyPressed
        verifyPressedEnter(evt);
    }//GEN-LAST:event_edDateKeyPressed

    private void cbMealKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbMealKeyPressed
        verifyPressedEnter(evt);
    }//GEN-LAST:event_cbMealKeyPressed

    private void cbOpcaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbOpcaoKeyPressed
        verifyPressedEnter(evt);
    }//GEN-LAST:event_cbOpcaoKeyPressed

    private void tfNameStudentKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfNameStudentKeyPressed
        verifyPressedEnter(evt);
    }//GEN-LAST:event_tfNameStudentKeyPressed

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
            java.util.logging.Logger.getLogger(ChooseByMealFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChooseByMealFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChooseByMealFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChooseByMealFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ChooseByMealFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btDelete;
    private javax.swing.JButton btExcel;
    private javax.swing.JButton btSearch;
    private javax.swing.JComboBox cbMeal;
    private javax.swing.JComboBox cbOpcao;
    private javax.swing.JFormattedTextField edDate;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblInfo;
    private javax.swing.JTable tbStudents;
    private javax.swing.JTextField tfNameStudent;
    // End of variables declaration//GEN-END:variables
}
