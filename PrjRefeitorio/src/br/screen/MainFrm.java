/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.screen;

import br.user.User;
import br.util.UserActive;
import br.util.Util;

/**
 *
 * @author Pedro Saraiva
 */
public class MainFrm extends javax.swing.JFrame {

    /**
     * Creates new form MainFrm
     */
    public MainFrm() {
        initComponents();
//        setModal(true);
        setLocationRelativeTo(null);
        setTitle("Refeitório");
        String versao = Double.toString(Util.getVersionSystem());
        lblUserActive.setText("Usuário ativo: "+UserActive.getLogin()
                +" | Versão "+versao);
        verifyMenuByUser();
    }
    
    public void verifyMenuByUser(){
        //Administrador
        if(UserActive.isAdministrador()){
            btStudent1.setEnabled(false);
            btMeal.setEnabled(false);
            btRegisterMeal.setEnabled(false);
            btAgenda.setEnabled(false);
            btVerifyMeal.setEnabled(false);
            smCursos.setVisible(true);
            smUsers.setVisible(true);
            smPermissionMeal.setVisible(false);
            smShift.setVisible(true);
            smiConfig.setVisible(true);
        } else if(UserActive.retornaUsuarioAtivo().getTipo().equals("ASSIS_ESTU")){
        //Assistência Estudantil
            btStudent1.setEnabled(true);
            btMeal.setEnabled(true);
            btRegisterMeal.setEnabled(true);
            btAgenda.setEnabled(true);
            smCursos.setVisible(true);
            smUsers.setVisible(false);
            smPermissionMeal.setVisible(true);
            smShift.setVisible(true);
            smiConfig.setVisible(false);
        } else if(UserActive.retornaUsuarioAtivo().getTipo().equals("RECEPCAO")){
        //Recepção
            btStudent1.setEnabled(false);
            btMeal.setEnabled(false);
            btRegisterMeal.setEnabled(true);
            btAgenda.setEnabled(true);
            btVerifyMeal.setEnabled(true);
            smCursos.setVisible(false);
            smUsers.setVisible(false);
            smPermissionMeal.setVisible(false);
            smShift.setVisible(false);
            smiConfig.setVisible(false);
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

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuBar3 = new javax.swing.JMenuBar();
        jMenu5 = new javax.swing.JMenu();
        jMenu6 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        btAgenda = new javax.swing.JButton();
        btVerifyMeal = new javax.swing.JButton();
        lblUserActive = new javax.swing.JLabel();
        btMeal = new javax.swing.JButton();
        btStudent1 = new javax.swing.JButton();
        btRegisterMeal = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btExit = new javax.swing.JButton();
        jMenuBar2 = new javax.swing.JMenuBar();
        smmCursos = new javax.swing.JMenu();
        smCursos = new javax.swing.JMenuItem();
        smiConfig = new javax.swing.JMenuItem();
        smShift = new javax.swing.JMenuItem();
        smUsers = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        smPermissionMeal = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("jMenu3");

        jMenu5.setText("File");
        jMenuBar3.add(jMenu5);

        jMenu6.setText("Edit");
        jMenuBar3.add(jMenu6);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btAgenda.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        btAgenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/calendar_clock_schedule_icon-icons.com_51085.png"))); // NOI18N
        btAgenda.setToolTipText("Agendamento");
        btAgenda.setHideActionText(true);
        btAgenda.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        btAgenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAgendaActionPerformed(evt);
            }
        });
        jPanel1.add(btAgenda, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        btVerifyMeal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/choose-1_102356.png"))); // NOI18N
        btVerifyMeal.setToolTipText("Verificar Refeições");
        btVerifyMeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btVerifyMealActionPerformed(evt);
            }
        });
        jPanel1.add(btVerifyMeal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 230, -1, -1));

        lblUserActive.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        lblUserActive.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblUserActive.setText("    Usuário Ativo:");
        jPanel1.add(lblUserActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 530, -1));

        btMeal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/-meal_89750-2.png"))); // NOI18N
        btMeal.setToolTipText("Refeições");
        btMeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMealActionPerformed(evt);
            }
        });
        jPanel1.add(btMeal, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        btStudent1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/student.png"))); // NOI18N
        btStudent1.setToolTipText("Alunos");
        btStudent1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btStudent1ActionPerformed(evt);
            }
        });
        jPanel1.add(btStudent1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        btRegisterMeal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/019plate1_113745.png"))); // NOI18N
        btRegisterMeal.setToolTipText("Registrar Refeição");
        btRegisterMeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRegisterMealActionPerformed(evt);
            }
        });
        jPanel1.add(btRegisterMeal, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("SISTEMA DO REFEITÓRIO IFCE CAMPUS CEDRO");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 540, -1));

        btExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/action_exit_close_remove_13915.png"))); // NOI18N
        btExit.setToolTipText("Sair");
        btExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExitActionPerformed(evt);
            }
        });
        jPanel1.add(btExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 410));

        smmCursos.setText("Cadastros");

        smCursos.setText("Cursos");
        smCursos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smCursosActionPerformed(evt);
            }
        });
        smmCursos.add(smCursos);

        smiConfig.setText("Configurações");
        smiConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smiConfigActionPerformed(evt);
            }
        });
        smmCursos.add(smiConfig);

        smShift.setText("Turnos");
        smShift.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smShiftActionPerformed(evt);
            }
        });
        smmCursos.add(smShift);

        smUsers.setText("Usuários");
        smUsers.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smUsersActionPerformed(evt);
            }
        });
        smmCursos.add(smUsers);

        jMenuBar2.add(smmCursos);

        jMenu4.setText("Outros");

        smPermissionMeal.setText("Permissão para Refeição");
        smPermissionMeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smPermissionMealActionPerformed(evt);
            }
        });
        jMenu4.add(smPermissionMeal);

        jMenuBar2.add(jMenu4);

        setJMenuBar(jMenuBar2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btVerifyMealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btVerifyMealActionPerformed
       ChooseByMealFrm rls = new ChooseByMealFrm();
       rls.setVisible(true);
    }//GEN-LAST:event_btVerifyMealActionPerformed

    private void btAgendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAgendaActionPerformed
        AgendaFrm cm = new AgendaFrm();
        cm.setVisible(true);
    }//GEN-LAST:event_btAgendaActionPerformed

    private void btMealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMealActionPerformed
       MealFrmFind rls = new MealFrmFind();
       rls.setVisible(true);
    }//GEN-LAST:event_btMealActionPerformed

    private void btStudent1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btStudent1ActionPerformed
       StudentFrmFind rls = new StudentFrmFind();
       rls.setVisible(true);
    }//GEN-LAST:event_btStudent1ActionPerformed

    private void btRegisterMealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRegisterMealActionPerformed
       RegisterMelStudentFrm rls = new RegisterMelStudentFrm();
       rls.setVisible(true);
    }//GEN-LAST:event_btRegisterMealActionPerformed

    private void smCursosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smCursosActionPerformed
        CourseFrmFind rls = new CourseFrmFind();
       rls.setVisible(true);
    }//GEN-LAST:event_smCursosActionPerformed

    private void smUsersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smUsersActionPerformed
        UserFrmFind rls = new UserFrmFind();
       rls.setVisible(true);
    }//GEN-LAST:event_smUsersActionPerformed

    private void btExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExitActionPerformed
        System.exit(0);
    }//GEN-LAST:event_btExitActionPerformed

    private void smPermissionMealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smPermissionMealActionPerformed
        AllowMealStudentFrm amsf = new AllowMealStudentFrm();
        amsf.setVisible(true);
    }//GEN-LAST:event_smPermissionMealActionPerformed

    private void smShiftActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smShiftActionPerformed
        ShiftFrmFind sff = new ShiftFrmFind();
        sff.setVisible(true);
    }//GEN-LAST:event_smShiftActionPerformed

    private void smiConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smiConfigActionPerformed
        ConfigFrmRegister cfr = new ConfigFrmRegister();
        cfr.setVisible(true);
    }//GEN-LAST:event_smiConfigActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAgenda;
    private javax.swing.JButton btExit;
    private javax.swing.JButton btMeal;
    private javax.swing.JButton btRegisterMeal;
    private javax.swing.JButton btStudent1;
    private javax.swing.JButton btVerifyMeal;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JMenuBar jMenuBar3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblUserActive;
    private javax.swing.JMenuItem smCursos;
    private javax.swing.JMenuItem smPermissionMeal;
    private javax.swing.JMenuItem smShift;
    private javax.swing.JMenuItem smUsers;
    private javax.swing.JMenuItem smiConfig;
    private javax.swing.JMenu smmCursos;
    // End of variables declaration//GEN-END:variables
}
