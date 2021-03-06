/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.screen;

import br.config.Config;
import br.config.ConfigDAO;
import br.scheduling.Scheduling;
import br.scheduling.SchedulingDAO;
import br.scheduling.SchedulingTableModel;
import br.student.Student;
import br.student.StudentDAO;
import br.student.StudentSchedulingTableModel;
import br.student.StudentTableModel;
import br.util.ConnectionFactory;
import br.util.FormatSizeColJTable;
import br.util.UserActive;
import br.util.Util;
import java.awt.event.KeyEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author pelusb
 */
public class ReportCarteirinhas extends javax.swing.JDialog {

    private Student student;
    private List<Student> list = new ArrayList<Student>();
    
    /**
     * Creates new form RegisterStudent
     */
    public ReportCarteirinhas() {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        setTitle("Gerar Carteirinhas");
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
        jButton1 = new javax.swing.JButton();
        btPrint = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStudents = new javax.swing.JTable();
        edtMat = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taStudent = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        btAddStudentMeal = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/forceexit_103817.png"))); // NOI18N
        jButton1.setToolTipText("");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 400, -1, -1));

        btPrint.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btPrint.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/printerprint_9416.png"))); // NOI18N
        btPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btPrintActionPerformed(evt);
            }
        });
        jPanel1.add(btPrint, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 400, -1, -1));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 780, 270));

        edtMat.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        edtMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtMatKeyPressed(evt);
            }
        });
        jPanel1.add(edtMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 150, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Matrícula ou Código:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        taStudent.setEditable(false);
        taStudent.setColumns(20);
        taStudent.setFont(new java.awt.Font("Verdana", 1, 13)); // NOI18N
        taStudent.setRows(5);
        jScrollPane3.setViewportView(taStudent);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 540, 80));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Aluno:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, -1, -1));

        btAddStudentMeal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/new-file_40454.png"))); // NOI18N
        btAddStudentMeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddStudentMealActionPerformed(evt);
            }
        });
        jPanel1.add(btAddStudentMeal, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 60, 60, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 450));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btPrintActionPerformed
        if(list.size()==0){
            JOptionPane.showMessageDialog(rootPane, "Informe os alunos!", "IFCE", JOptionPane.ERROR_MESSAGE);
            return ;
        }
        
        String sql = "";
        

        sql +="where s.id in (";
        for(int i=0; i<list.size();i++){
            if(i==0){
                sql+=list.get(i).getId();
                continue; 
            } 
            sql+=","+list.get(i).getId();
        }
        sql +=")";

        //pega dados das configurações
        Config config = null;
        ConfigDAO dao = new ConfigDAO();
        List<Config> list = dao.list();
        if (list != null) {
            if (list.size() > 0) {
                config = list.get(0);
            }
        }

        // TODO add your handling code here:
        JasperReport pathjrxml;
        HashMap parametros = new HashMap();
        parametros.put("sql", sql);
        parametros.put("campus", UserActive.returnCampus().getDescription());
        System.out.println(sql);
        
        Connection connection = new ConnectionFactory().getConnection();
        try {
            JDialog viewer = new JDialog(new javax.swing.JFrame(), "Visualização do Relatório", true);
            viewer.setSize(1200, 600);
            viewer.setLocationRelativeTo(null);
            viewer.setModal(true);
           
            
            InputStream is=null;
            try {
                is = new URL(config.getPathReport() + "carteirinhas.jasper").openStream();
            } catch (MalformedURLException ex) {
                Logger.getLogger(ReportCarteirinhas.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReportCarteirinhas.class.getName()).log(Level.SEVERE, null, ex);
            }
            //JOptionPane.showMessageDialog(rootPane, caminho);
            //pathjrxml = JasperCompileManager.compileReport("src/br/report/summaryMeals.jasper");
            JasperPrint printReport = JasperFillManager.fillReport(is
                    , parametros,
                    connection);
            JasperViewer jv = new JasperViewer(printReport, false);
            viewer.getContentPane().add(jv.getContentPane());
            viewer.setVisible(true);


            //jv.setVisible(true);
        } catch (JRException ex) {
            JOptionPane.showMessageDialog(rootPane, ex.getMessage(), "IFCE", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(ReportCarteirinhas.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btPrintActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStudentsMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tbStudentsMouseClicked

    private void tbStudentsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStudentsMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tbStudentsMouseEntered

    public void verifyF2(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == 113) {//F2
            if (this.student != null) {
                btAddStudentMealActionPerformed(null);
                return;
            }
        }
    }
    
    public void clearFields() {
        student = null;
        taStudent.setText("");
        edtMat.setText("");
        preencheTabela();
        edtMat.requestFocus();
    }
    
    public void preencheTabela() {
        StudentDAO sDAO = new StudentDAO();

        StudentTableModel ptm = new StudentTableModel(
                new ArrayList(new HashSet(list)));
        tbStudents.setModel(ptm);

        FormatSizeColJTable.packColumns(tbStudents, 1);
    }
    
    private void edtMatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtMatKeyPressed
        verifyF2(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (edtMat.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Informe a matrícula!");
            } else {

                StudentDAO sDAO = new StudentDAO();

                String mat = edtMat.getText();
                if (mat.equals("")) {
                    JOptionPane.showMessageDialog(rootPane, "Informe uma matrícula!");
                }

                List<Student> list = sDAO.checkExists("mat", mat, "campus", UserActive.returnCampus());
                if (list.size() == 0) {
                    try {
                        list = sDAO.checkExists("id", Integer.parseInt(mat), "campus", UserActive.returnCampus());
                    } catch (Exception e) {
                        list = new ArrayList<Student>();
                    }
                    if (list.size() == 0) {
                        clearFields();
                        JOptionPane.showMessageDialog(rootPane, "Matrícula/Código não encontrado!");
                        return;
                    }
                }

                student = new Student();
                student = list.get(0);
                taStudent.setText(br.util.Util.decimalFormat().format(student.getId())
                    + " - " + student.getName()
                    + "\n" + student.getCourse().getDescription()
                    + "\nData da Próxima Atualização Cadastral: " + new SimpleDateFormat("dd/MM/yyyy").format(student.getDateValid()));

                if (!Util.verifyStudent(rootPane, this.student)) {
                    clearFields();
                } 

            }
        }
    }//GEN-LAST:event_edtMatKeyPressed

    private void btAddStudentMealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddStudentMealActionPerformed

        if (student == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe o Aluno.");
            return;
        }
        list.add(student);
        preencheTabela();
        clearFields();
    }//GEN-LAST:event_btAddStudentMealActionPerformed

    public void verifyPressedEnter(java.awt.event.KeyEvent evt) {
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btPrintActionPerformed(null);
        }
    }

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
            java.util.logging.Logger.getLogger(ReportCarteirinhas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportCarteirinhas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportCarteirinhas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportCarteirinhas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new ReportCarteirinhas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAddStudentMeal;
    private javax.swing.JButton btPrint;
    private javax.swing.JTextField edtMat;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea taStudent;
    private javax.swing.JTable tbStudents;
    // End of variables declaration//GEN-END:variables
}
