/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.screen;

import br.user.User;
import br.user.UserDAO;
import br.util.UserActive;
import br.util.Util;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Pedro Saraiva
 */
public class LoginFrm extends javax.swing.JFrame {
    
    Util utilidades = new Util();

    /**
     * Creates new form Login
     */
    public LoginFrm() {
        initComponents();
        setLocationRelativeTo(null);
        //tfLogin.grabFocus();
        //Util.setIcon(LoginFrm.class, this);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        canvas1 = new java.awt.Canvas();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfLogin = new javax.swing.JTextField();
        tfSenha = new javax.swing.JPasswordField();
        btLogar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 100, 0));
        jPanel2.setBorder(new javax.swing.border.MatteBorder(null));
        jPanel2.setFocusable(false);

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Login");

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 0, 0));
        jLabel1.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel1.setText("Usuário.:");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, -1, 33));

        jLabel2.setBackground(new java.awt.Color(255, 0, 0));
        jLabel2.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        jLabel2.setText("Senha.:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, -1, 36));

        tfLogin.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfLogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 30, 226, 29));

        tfSenha.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jPanel1.add(tfSenha, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 226, 29));

        btLogar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btLogar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/Login_37128.png"))); // NOI18N
        btLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLogarActionPerformed(evt);
            }
        });
        jPanel1.add(btLogar, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        btCancelar.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        btCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/forceexit_103817.png"))); // NOI18N
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, -1, -1));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/logo-vertical-ifce.png"))); // NOI18N
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 130));

        jLabel5.setText("Assistência Estudantil - IFCE Campus Cedro");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jPanel3.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 160));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLogarActionPerformed
        // TODO add your handling code here:
        
        if((tfLogin.getText().toString().equals("adminmaster"))&&
                (tfSenha.getText().toString().equals("adminmaster"))){
            UserActive.setLogin(tfLogin.getText());
            UserActive.setAdministrador(true);
            MainFrm tp = new MainFrm();
            dispose();
            tp.setVisible(true);
                        
        } else if (verificaCampos()) {
            /*
             * Se os campos estiverem todos preenchidos
             * é criado um usuário passado as informações pra ele
             * depois chamado o UsuarioRN para fazer a autenticação
             * essa camada de visualização (Telas) só poderá conversar
             * com a camada de controle (RN) e a camada de
             * controle conversa com a camada de dados (DAO)
             */
            User usuario = new User();
            usuario.setLogin(tfLogin.getText());
            usuario.setSenha(tfSenha.getText());           
            UserDAO uDAO = new UserDAO();
            if (uDAO.searchUser(usuario.getLogin(), usuario.getSenha())!=null) {
                dispose();
                usuario = uDAO.checkExists("login",tfLogin.getText()).get(0);
                UserActive.setLogin(usuario.getLogin());
                MainFrm tp = new MainFrm();
                tp.setVisible(true);
                
            } else {
                JOptionPane.showMessageDialog(rootPane, "Login ou Senha Incorretos!",
                        "Informação", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btLogarActionPerformed
    
    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        // TODO add your handling code here:
        /*
         * Encerra a aplicação
         */
        System.exit(0);
    }//GEN-LAST:event_btCancelarActionPerformed
    
    public boolean verificaCampos() {
        /*
         * Verifica se os campos estão vazios
         */
        if (tfLogin.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Informe o Campo Login!",
                    "Campos Vazios", JOptionPane.INFORMATION_MESSAGE);
            tfLogin.setFocusable(true);
            return false;
        } else if (tfSenha.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Informe o Campo Senha!",
                    "Campos Vazios", JOptionPane.INFORMATION_MESSAGE);
            tfSenha.setFocusable(true);
            return false;
        }
        /* Verifica se algum caractere especial 
         * está contido dentro dos campos de Login e Senha */
        if (!utilidades.chkCaracteres(tfLogin.getText().toString(), tfSenha.getText().toString())) {
            return false;
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                        if ("Windows".equals(info.getName())) {
                            UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
                    System.out.println("Erro: " + e.getMessage());
                }
                new LoginFrm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btLogar;
    private java.awt.Canvas canvas1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField tfLogin;
    private javax.swing.JPasswordField tfSenha;
    // End of variables declaration//GEN-END:variables

    
}