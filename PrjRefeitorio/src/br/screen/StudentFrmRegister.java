/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.screen;

import br.course.Course;
import br.course.CourseDAO;
import br.meal.Meal;
import br.meal.MealDAO;
import br.scheduling.Scheduling;
import br.scheduling.SchedulingDAO;
import br.scheduling.SchedulingTableModel;
import br.student.Student;
import br.student.StudentDAO;
import br.student.StudentSchedulingTableModel;
import br.util.FormatSizeColJTable;
import br.util.OnlyNumberField;
import br.util.Util;
import java.awt.Color;
import java.awt.Component;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author pelusb
 */
public class StudentFrmRegister extends javax.swing.JDialog {

    private Student student;
    /**
     * Creates new form RegisterStudent
     */
    public StudentFrmRegister() {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        setTitle("Cadastro de Aluno");
        insertCourse();
        this.student = new Student();
        lblCodigo.setVisible(false);
        tfMat.setDocument(new OnlyNumberField());
        tbbPanStudente.setEnabledAt(1, false);
        this.student.setBlock(false);
        cbActive.setSelected(true);
    }
    
    public StudentFrmRegister(Student student) {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        setTitle("Edição de Aluno");
        insertCourse();
        tfMat.setDocument(new OnlyNumberField());
        this.student = student;
        tfName.setText(student.getName());
        tfMat.setText(String.valueOf(student.getMat()));
        if(student.isBlock()){
            chbBlock.setSelected(true);
        }
        if(this.student.getCourse()!=null){
            cbCourse.setSelectedItem(student.getCourse());
        }
        if(this.student.isActive()){
            cbActive.setSelected(true);
        }
        lblCodigo.setText(String.valueOf(Util.decimalFormat().format(student.getId())));
        tbbPanStudente.setEnabledAt(1, true);
        preencheTabela();
    }
    
    public void insertCourse() {
        cbCourse.removeAllItems();
        cbCourse.addItem("-");

        CourseDAO cdao = new CourseDAO();
        List<Course> list = cdao.list("description");

        for (int i = 0; i < list.size(); i++) {
            cbCourse.addItem(list.get(i));
        }
    }
    
    public void preencheTabela() {
        SchedulingDAO sDAO = new SchedulingDAO();
        
        List<Scheduling> list = sDAO.checkExists("student", student);
        
        StudentSchedulingTableModel ptm = new StudentSchedulingTableModel(list);
        tbStudentMeals.setModel(ptm);

        FormatSizeColJTable.packColumns(tbStudentMeals, 1);
        
        tbStudentMeals.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                //A coluna do status é 3
                Object ref = table.getValueAt(row, 3);//Coluna Status
                //Coloca cor em todas as linhas,COLUNA(3) que tem o valor "Aberto"
                if (ref != null && ref.equals("Ausente")) {//Se Status for igual a "Aberto"
                    Color cor = new Color(255, 127, 80);
                    setBackground(cor);
                } else {
                    Color cor = new Color(144,238,144);
                    setBackground(cor);
                } 
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

        jPanel1 = new javax.swing.JPanel();
        tbbPanStudente = new javax.swing.JTabbedPane();
        pnlDIni = new javax.swing.JPanel();
        lblCodigo = new javax.swing.JLabel();
        tfMat = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        tfName = new javax.swing.JTextField();
        chbBlock = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbCourse = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        cbActive = new javax.swing.JCheckBox();
        pnlMeals = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStudentMeals = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlDIni.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblCodigo.setFont(new java.awt.Font("Verdana", 1, 19)); // NOI18N
        lblCodigo.setText("000000");
        pnlDIni.add(lblCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        tfMat.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        pnlDIni.add(tfMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 220, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Nome: *");
        pnlDIni.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        tfName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        pnlDIni.add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 440, -1));

        chbBlock.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        chbBlock.setText("Bloqueado");
        pnlDIni.add(chbBlock, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Matrícula: *");
        pnlDIni.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Código:");
        pnlDIni.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        cbCourse.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbCourse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlDIni.add(cbCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 440, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Curso:");
        pnlDIni.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, -1));

        cbActive.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbActive.setText("Ativo");
        cbActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActiveActionPerformed(evt);
            }
        });
        pnlDIni.add(cbActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        tbbPanStudente.addTab("Dados Inicias", pnlDIni);

        tbStudentMeals.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbStudentMeals);

        pnlMeals.add(jScrollPane1);

        tbbPanStudente.addTab("Refeições", pnlMeals);

        jPanel1.add(tbbPanStudente, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 500, 300));

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/Save_37110.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 310, -1, -1));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/forceexit_103817.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 390));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
        if(tfMat.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Informe a Matrícula!");
            tfMat.requestFocus();
            return;
        }
        if(tfName.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Informe o Nome!");
            tfName.requestFocus();
            return;
        }
        
        student.setName(tfName.getText());
        try {
            student.setMat(Integer.valueOf(tfMat.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Matrícula incorreta! Informe apenas números");
        }
        if(chbBlock.isSelected()){
            student.setBlock(true);
        } else {
            student.setBlock(false);
        }
        if(cbCourse.getSelectedIndex()>0){
            student.setCourse((Course) cbCourse.getSelectedItem());
            
        }
        
        StudentDAO sDAO = new StudentDAO();

        if(student.getId()==null){
            if(sDAO.checkExists("mat", Integer.valueOf(tfMat.getText())).size()>0){
                JOptionPane.showMessageDialog(rootPane, "Matrícula ja foi informada!");
                return ;
            }
            student.setActive(true);
            sDAO.add(student);
        } else {
            student.setActive(cbActive.isSelected());
            sDAO.update(student);
        }
        setVisible(false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbActiveActionPerformed

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
            java.util.logging.Logger.getLogger(StudentFrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentFrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentFrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentFrmRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StudentFrmRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox cbActive;
    private javax.swing.JComboBox cbCourse;
    private javax.swing.JCheckBox chbBlock;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JPanel pnlDIni;
    private javax.swing.JPanel pnlMeals;
    private javax.swing.JTable tbStudentMeals;
    private javax.swing.JTabbedPane tbbPanStudente;
    private javax.swing.JTextField tfMat;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}