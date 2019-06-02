/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.screen;


import br.config.Config;
import br.config.ConfigDAO;
import br.meal.Meal;
import br.meal.MealDAO;
import br.scheduling.Scheduling;
import br.scheduling.SchedulingDAO;
import br.scheduling.SchedulingTableModel;
import br.student.Student;
import br.student.StudentDAO;
import br.student.StudentTableModel;
import br.util.FormatSizeColJTable;
import br.util.OnlyNumberField;
import br.util.UserActive;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author João
 */
public class RegisterMelStudentFrm extends javax.swing.JDialog {

    private Set<Meal> meals;
    private Student student;
    /**
     * Creates new form FindPersonFrm
     */
    public RegisterMelStudentFrm() {
        initComponents();
        setModal(true);
        setLocationRelativeTo(null);
        preencheTabela();
        insertMeals();
        lblData.setText(returnDate());
        //edtMat.setDocument(new OnlyNumberField());
        
                
    }
    
    public String returnDate(){
        SchedulingDAO dao = new SchedulingDAO();
        Date dataAtual = dao.getServerDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data = sdf.format(dataAtual);
        return data;
    }
    
    public void insertMeals() {
        cbMeal.removeAllItems();
        cbMeal.addItem("-");

        MealDAO mdao = new MealDAO();
        List<Meal> list = mdao.list("campus", UserActive.returnCampus(), "description");

        for (int i = 0; i < list.size(); i++) {
            cbMeal.addItem(list.get(i));
        }
    }
    
   

    public void preencheTabela() {
        SchedulingDAO sDAO = new SchedulingDAO();
        
        List<Scheduling> list = sDAO.schedulingWasPresent(new Date());
        
        lblAgendamentos.setText("Total do dia: "+list.size()+" confirmações.");
        
        SchedulingTableModel ptm = new SchedulingTableModel(list);
        tbStudents.setModel(ptm);

        FormatSizeColJTable.packColumns(tbStudents, 1);
    }
    
    public void clearFields(){
        student = null;
        taStudent.setText("");
        edtMat.setText("");
        preencheTabela();
        edtMat.requestFocus();
        insertImage("/br/imagens/photo.png");
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
        edtMat = new javax.swing.JTextField();
        lblAgendamentos = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        btConfirmStudentMeal = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        lblData = new javax.swing.JLabel();
        cbMeal = new javax.swing.JComboBox();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        taStudent = new javax.swing.JTextArea();
        jPanel4 = new javax.swing.JPanel();
        lblPhoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(0, 86, 201));
        jPanel3.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Confirmação das Refeições");
        jPanel3.add(jLabel23);
        jLabel23.setBounds(0, 0, 460, 30);

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 800, 40));

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

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 780, 210));

        jButton3.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/exit_icon-icons.com_48304.png"))); // NOI18N
        jButton3.setToolTipText("Sair");
        jButton3.setPreferredSize(new java.awt.Dimension(63, 39));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 430, 57, 40));

        edtMat.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        edtMat.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                edtMatKeyPressed(evt);
            }
        });
        jPanel1.add(edtMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 180, -1));

        lblAgendamentos.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblAgendamentos.setText("0 agendamentos.");
        jPanel1.add(lblAgendamentos, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, 560, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Data:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        btConfirmStudentMeal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/new-file_40454.png"))); // NOI18N
        btConfirmStudentMeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConfirmStudentMealActionPerformed(evt);
            }
        });
        jPanel1.add(btConfirmStudentMeal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 140, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Matrícula ou Código:");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Matrícula ou Código:");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, -1));
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 780, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Aluno:");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        lblData.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        lblData.setText("jLabel3");
        jPanel1.add(lblData, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 180, -1));

        cbMeal.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        cbMeal.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbMeal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                cbMealKeyPressed(evt);
            }
        });
        jPanel1.add(cbMeal, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 360, 30));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Refeição:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, -1, -1));

        taStudent.setEditable(false);
        taStudent.setColumns(20);
        taStudent.setFont(new java.awt.Font("Verdana", 1, 16)); // NOI18N
        taStudent.setRows(5);
        jScrollPane3.setViewportView(taStudent);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 550, 80));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/photo.png"))); // NOI18N
        lblPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhotoMouseClicked(evt);
            }
        });
        jPanel4.add(lblPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 150));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, 150, 170));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 800, 480));

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

    public void verifyF2(java.awt.event.KeyEvent evt){
        if (evt.getKeyCode() == 113) {//F2
            if(this.student!=null){
                btConfirmStudentMealActionPerformed(null);
                return ;
            }
        }
    }
    
    private void edtMatKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_edtMatKeyPressed
        verifyF2(evt);
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if(edtMat.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Informe a matrícula!");
            } else {
                
                StudentDAO sDAO = new StudentDAO();
                
                String mat = edtMat.getText();
                if(mat.equals("")){
                    JOptionPane.showMessageDialog(rootPane, "Informe uma matrícula!");
                }
                
                List<Student> list = sDAO.checkExists("mat", mat, "campus", UserActive.returnCampus());
                if(list.size()==0){
                    try {
                        list = sDAO.checkExists("id", Integer.parseInt(mat), "campus", UserActive.returnCampus());
                    } catch (Exception e) {
                        list = new ArrayList<Student>();
                    }
                    if(list.size()==0){
                        clearFields();
                        JOptionPane.showMessageDialog(rootPane, "Matrícula/Código não encontrado!"); 
                        return ;
                    }
                } 
                student = new Student();
                student = list.get(0);
                taStudent.setText(br.util.Util.decimalFormat().format(student.getId())
                        +" - "+student.getName() 
                        +"\n"+student.getCourse().getDescription()
                        +"\nData da Próxima Atualização Cadastral: "+new SimpleDateFormat("dd/MM/yyyy").format(student.getDateValid()));
                //pega foto
                if (student.getPhoto() != null) {
                    try {
                        ConfigDAO cDAO = new ConfigDAO();
                        List<Config> listConfig = cDAO.list();
                        if (list != null) {
                            if (list.size() > 0) {
                                Config config = listConfig.get(0);
                                insertImage(config.getPathPhotoStudent() + "/" + student.getPhoto());
                            }
                        }
                    } catch (Exception e) {
                    }
                }else {
                    insertImage("/br/imagens/photo.png");
                }
            }
        }
    }//GEN-LAST:event_edtMatKeyPressed

    
    private void insertImage(String path) {
        ImageIcon image = new ImageIcon(path);
        lblPhoto.setIcon(new ImageIcon(
                image.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(),
                        Image.SCALE_DEFAULT)));
    }
    
    private void btConfirmStudentMealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConfirmStudentMealActionPerformed
        
        
        if (student == null) {
            JOptionPane.showMessageDialog(rootPane, "Informe o Aluno.");
            return ;
        }
        if(cbMeal.getSelectedIndex()==0){
            JOptionPane.showMessageDialog(rootPane, "Informe a Refeição.");
            return ;
        }
        if(JOptionPane.showConfirmDialog(rootPane, "Deseja confirmar a refeição "+cbMeal.getSelectedItem()+" para "+student.getName()+"?", 
                "IFCE", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION){
            
            SchedulingDAO sDAO = new SchedulingDAO();
            Meal meal = (Meal) cbMeal.getSelectedItem();
            List<Scheduling> listStudentDateMeal = 
                    sDAO.schedulingDateStudentMeal(new Date(), student, meal);
            if(listStudentDateMeal.size()>0){
                Scheduling scheduling = new Scheduling();
                scheduling = listStudentDateMeal.get(0);
                scheduling.setWasPresent(true);
                sDAO.update(scheduling);
                
            } else {
                JOptionPane.showMessageDialog(rootPane, student.getName()+" não tem permissão para a refeição "+
                        meal.getDescription()+".", "IFCE", JOptionPane.ERROR_MESSAGE);
            }
            clearFields();
            
        }
    }//GEN-LAST:event_btConfirmStudentMealActionPerformed

    private void cbMealKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_cbMealKeyPressed
        verifyF2(evt);
    }//GEN-LAST:event_cbMealKeyPressed

    private void lblPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhotoMouseClicked

    }//GEN-LAST:event_lblPhotoMouseClicked

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
            java.util.logging.Logger.getLogger(RegisterMelStudentFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterMelStudentFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterMelStudentFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterMelStudentFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new RegisterMelStudentFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btConfirmStudentMeal;
    private javax.swing.JComboBox cbMeal;
    private javax.swing.JTextField edtMat;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblAgendamentos;
    private javax.swing.JLabel lblData;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JTextArea taStudent;
    private javax.swing.JTable tbStudents;
    // End of variables declaration//GEN-END:variables
}
