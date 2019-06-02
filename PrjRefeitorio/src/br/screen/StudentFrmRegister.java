/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.screen;

import br.allowsmd.StudentAllowMealDay;
import br.allowsmd.StudentAllowMealDayDAO;
import br.allowsmd.StudentAllowMealDayTableModel;
import br.config.Config;
import br.config.ConfigDAO;
import br.course.Course;
import br.course.CourseDAO;
import br.meal.Meal;
import br.meal.MealDAO;
import br.scheduling.Scheduling;
import br.scheduling.SchedulingDAO;
import br.scheduling.SchedulingTableModel;
import br.shift.Shift;
import br.shift.ShiftDAO;
import br.shift.ShiftTableModel;
import br.student.Student;
import br.student.StudentDAO;
import br.student.StudentSchedulingTableModel;
import br.util.FormatSizeColJTable;
import br.util.OnlyNumberField;
import br.util.UserActive;
import br.util.Util;
import java.awt.Color;
import java.awt.Component;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author pelusb
 */
public class StudentFrmRegister extends javax.swing.JDialog {

    private Student student;
    private File file;

    /**
     * Creates new form RegisterStudent
     */
    public StudentFrmRegister() {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        setTitle("Cadastro de Aluno");
        insertCourse();
        insertShift();
        this.student = new Student();
        lblCodigo.setVisible(false);
        //tfMat.setDocument(new OnlyNumberField());
        tbbPanStudente.setEnabledAt(1, false);
        tbbPanStudente.setEnabledAt(2, false);
        this.student.setBlock(false);
        cbActive.setSelected(true);
    }

    public StudentFrmRegister(Student student) {
        initComponents();
        setLocationRelativeTo(null);
        setModal(true);
        setTitle("Edição de Aluno");
        insertCourse();
        insertShift();
        //tfMat.setDocument(new OnlyNumberField());
        this.student = student;
        tfName.setText(student.getName());
        tfMat.setText(student.getMat());
        if (student.isBlock()) {
            chbBlock.setSelected(true);
        }
        if (student.isSemRegular()) {
            chbAlunoSemRegu.setSelected(true);
        }
        if (this.student.getCourse() != null) {
            cbCourse.setSelectedItem(student.getCourse());
        }
        if (this.student.getShift() != null) {
            cbShift.setSelectedItem(student.getShift());
        }
        if (this.student.isActive()) {
            cbActive.setSelected(true);
        }
        lblCodigo.setText(String.valueOf(Util.decimalFormat().format(student.getId())));
        tbbPanStudente.setEnabledAt(1, true);
        if (student.getDateValid() != null) {
            Date date = student.getDateValid();
            SimpleDateFormat dfdtDate;
            dfdtDate = new SimpleDateFormat("dd/MM/yyyy");
            tfDateValid.setText(dfdtDate.format(date));
        }
        //pega foto
        if (student.getPhoto() != null) {
            try {
                ConfigDAO cDAO = new ConfigDAO();
                List<Config> list = cDAO.list();
                if (list != null) {
                    if (list.size() > 0) {
                        Config config = list.get(0);
                        insertImage(config.getPathPhotoStudent() + "/" + student.getPhoto());
                    }
                }
            } catch (Exception e) {
            }
        }
        preencheTabelaHist();

        preencheTabelaAllowMeal();
    }

    public void insertCourse() {
        cbCourse.removeAllItems();
        cbCourse.addItem("-");

        CourseDAO cdao = new CourseDAO();
        List<Course> list = cdao.list("campus", UserActive.returnCampus(),"description");

        for (int i = 0; i < list.size(); i++) {
            cbCourse.addItem(list.get(i));
        }
    }

    public void insertShift() {
        cbShift.removeAllItems();
        cbShift.addItem("-");

        ShiftDAO cdao = new ShiftDAO();
        List<Shift> list = new ArrayList(new HashSet(cdao.list("campus", UserActive.returnCampus(), "description")));

        for (int i = 0; i < list.size(); i++) {
            cbShift.addItem(list.get(i));
        }
    }

    public void preencheTabelaAllowMeal() {
        StudentAllowMealDayDAO samDAO = new StudentAllowMealDayDAO();
        List<StudentAllowMealDay> list = samDAO.checkExists("student", this.student);
        StudentAllowMealDayTableModel atm = new StudentAllowMealDayTableModel(list);
        tbAllowMeal.setModel(atm);
    }

    public void preencheTabelaHist() {
        SchedulingDAO sDAO = new SchedulingDAO();

        List<Scheduling> list = sDAO.checkExists("student", student);

        StudentSchedulingTableModel ptm = new StudentSchedulingTableModel(list);
        tbStudentMeals.setModel(ptm);

        FormatSizeColJTable.packColumns(tbStudentMeals, 1);

        tbStudentMeals.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value,
                    boolean isSelected, boolean hasFocus, int row, int column) {
                Component comp = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                //A coluna do status é 3
                Object ref = table.getValueAt(row, 3);//Coluna Status
                //Coloca cor em todas as linhas,COLUNA(3) que tem o valor "Aberto"
                if (ref != null && ref.equals("Ausente")) {//Se Status for igual a "Aberto"
                    Color cor = new Color(255, 127, 80);
                    setBackground(cor);
                } else if (ref != null && ref.equals("Presente")) {
                    Color cor = new Color(144, 238, 144);
                    setBackground(cor);
                } else if(ref != null && ref.equals("Justificado")) {
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
        cbShift = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        tfDateValid = new javax.swing.JFormattedTextField();
        chbAlunoSemRegu = new javax.swing.JCheckBox();
        jPanel3 = new javax.swing.JPanel();
        lblPhoto = new javax.swing.JLabel();
        pnlMeals = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbStudentMeals = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbAllowMeal = new javax.swing.JTable();
        cbAddStudentAllowMealDay = new javax.swing.JButton();
        btEditAllowStudentMeal = new javax.swing.JButton();
        cbDeletarAllowStudentDay = new javax.swing.JButton();
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
        pnlDIni.add(tfMat, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 220, -1));

        jLabel1.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel1.setText("Nome: *");
        pnlDIni.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        tfName.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        pnlDIni.add(tfName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 450, -1));

        chbBlock.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        chbBlock.setText("Bloqueado");
        pnlDIni.add(chbBlock, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 20, -1, -1));

        jLabel3.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel3.setText("Matrícula: *");
        pnlDIni.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, -1));

        jLabel4.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel4.setText("Código:");
        pnlDIni.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        cbCourse.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbCourse.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlDIni.add(cbCourse, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 190, 450, -1));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel2.setText("Curso:*");
        pnlDIni.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, -1));

        cbActive.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbActive.setText("Ativo");
        cbActive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbActiveActionPerformed(evt);
            }
        });
        pnlDIni.add(cbActive, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        cbShift.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        cbShift.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlDIni.add(cbShift, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, 290, -1));

        jLabel5.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel5.setText("Turno:*");
        pnlDIni.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, -1));

        jLabel6.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        jLabel6.setText("Data de Validade *:");
        pnlDIni.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 220, -1, -1));

        try {
            tfDateValid.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        tfDateValid.setToolTipText("Informe a data de nascimento");
        tfDateValid.setFocusLostBehavior(javax.swing.JFormattedTextField.PERSIST);
        tfDateValid.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        pnlDIni.add(tfDateValid, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 240, 150, -1));

        chbAlunoSemRegu.setFont(new java.awt.Font("Verdana", 0, 14)); // NOI18N
        chbAlunoSemRegu.setText("Aluno do Semestre Regular");
        pnlDIni.add(chbAlunoSemRegu, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, -1, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblPhoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/photo.png"))); // NOI18N
        lblPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblPhotoMouseClicked(evt);
            }
        });
        jPanel3.add(lblPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 150));

        pnlDIni.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 90, 150, 170));

        tbbPanStudente.addTab("Dados Inicias", pnlDIni);

        pnlMeals.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        tbStudentMeals.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbStudentMealsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbStudentMeals);

        pnlMeals.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(16, 5, 610, 290));

        jLabel7.setText("** Clique duas vezes para justificar ausência");
        pnlMeals.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 300, 600, -1));

        tbbPanStudente.addTab("Histórico de Refeições", pnlMeals);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbAllowMeal.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tbAllowMeal);

        jPanel2.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(4, 60, 630, 250));

        cbAddStudentAllowMealDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/new-file_40454.png"))); // NOI18N
        cbAddStudentAllowMealDay.setToolTipText("Adicionar Permissão");
        cbAddStudentAllowMealDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbAddStudentAllowMealDayActionPerformed(evt);
            }
        });
        jPanel2.add(cbAddStudentAllowMealDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));

        btEditAllowStudentMeal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/edit_icon-icons.com_52382.png"))); // NOI18N
        btEditAllowStudentMeal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditAllowStudentMealActionPerformed(evt);
            }
        });
        jPanel2.add(btEditAllowStudentMeal, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, -1, -1));

        cbDeletarAllowStudentDay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/ic_delete_128_28267.png"))); // NOI18N
        cbDeletarAllowStudentDay.setToolTipText("Deletar");
        cbDeletarAllowStudentDay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbDeletarAllowStudentDayActionPerformed(evt);
            }
        });
        jPanel2.add(cbDeletarAllowStudentDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, -1, -1));

        tbbPanStudente.addTab("Permissão das Refeições", jPanel2);

        jPanel1.add(tbbPanStudente, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 660, 370));

        jButton2.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/Save_37110.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, -1, -1));

        jButton1.setFont(new java.awt.Font("Verdana", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/imagens/forceexit_103817.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 380, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 670, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

        if (tfMat.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a Matrícula!");
            tfMat.requestFocus();
            return;
        }
        if (tfName.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Informe o Nome!");
            tfName.requestFocus();
            return;
        }

        if (cbCourse.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Informe o Curso!");
            cbCourse.requestFocus();
            return;
        }

        if (cbShift.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(rootPane, "Informe o Turno!");
            cbShift.requestFocus();
            return;
        }

        if (tfDateValid.getText().equals("  /  /    ")) {
            JOptionPane.showMessageDialog(rootPane, "Informe a Data de Validade do Cadastro!");
            tfDateValid.requestFocus();
            return;
        }

        student.setName(tfName.getText());
        try {
            student.setMat(tfMat.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Matrícula incorreta! Informe apenas números");
        }

        student.setBlock(chbBlock.isSelected());
        student.setSemRegular(chbAlunoSemRegu.isSelected());
        if (cbCourse.getSelectedIndex() > 0) {
            student.setCourse((Course) cbCourse.getSelectedItem());

        }
        if (cbShift.getSelectedIndex() > 0) {
            student.setShift((Shift) cbShift.getSelectedItem());

        }

        String date = tfDateValid.getText();
        try {
            DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
            java.util.Date data;
            data = new java.util.Date(fmt.parse(date).getTime());
            student.setDateValid(data);
        } catch (ParseException ex) {
            System.out.println(ex.getMessage());
        }

        //foto
        if (file != null) {
            try {
                String extensao = file.getName().substring(file.getName().lastIndexOf("."), file.getName().length());
                String namePhoto = student.getId() + extensao;
                ConfigDAO cDAO = new ConfigDAO();
                List<Config> list = cDAO.list();
                if (list != null) {
                    if (list.size() > 0) {
                        Config config = list.get(0);
                        Util.copyArquivo(file.getAbsolutePath(),
                                config.getPathPhotoStudent() + "/" + namePhoto,
                                300, 350); 
                         
                        student.setPhoto(namePhoto);
                    }
                }
            } catch (Exception e) {
            }

        }

        StudentDAO sDAO = new StudentDAO();
        student.setCampus(UserActive.returnCampus());
        if (student.getId()
                == null) {
            if (sDAO.checkExists("mat", tfMat.getText()).size() > 0) {
                JOptionPane.showMessageDialog(rootPane, "Matrícula ja foi informada!");
                return;
            }
            student.setActive(true);
            sDAO.add(student);
        } else {
            student.setActive(cbActive.isSelected());
            sDAO.update(student);
        }

        setVisible(
                false);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbActiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbActiveActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbActiveActionPerformed

    private void cbAddStudentAllowMealDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbAddStudentAllowMealDayActionPerformed
        StudentAllowMealDay stdAmd = new StudentAllowMealDay();
        stdAmd.setStudent(student);
        StudentAllowMealRegisterFrm samd = new StudentAllowMealRegisterFrm(stdAmd);
        samd.setVisible(true);
        preencheTabelaAllowMeal();
    }//GEN-LAST:event_cbAddStudentAllowMealDayActionPerformed

    private void btEditAllowStudentMealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditAllowStudentMealActionPerformed
        if (tbAllowMeal.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha da tabela!");
        } else {
            StudentAllowMealDayTableModel ptm = (StudentAllowMealDayTableModel) tbAllowMeal.getModel();
            StudentAllowMealDay select = ptm.getAllowStudentMealDay(tbAllowMeal.getSelectedRow());
            StudentAllowMealRegisterFrm rpf = new StudentAllowMealRegisterFrm(select);
            rpf.setVisible(true);
            preencheTabelaAllowMeal();
        }
    }//GEN-LAST:event_btEditAllowStudentMealActionPerformed

    private void cbDeletarAllowStudentDayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbDeletarAllowStudentDayActionPerformed
        if (tbAllowMeal.getSelectedRow() < 0) {
            JOptionPane.showMessageDialog(rootPane, "Selecione uma linha da tabela!");
        } else {
            if (JOptionPane.showConfirmDialog(rootPane, "Deseja Excluir a permissão?",
                    "Excluir Permissão", JOptionPane.YES_NO_OPTION)
                    == JOptionPane.YES_OPTION) {
                StudentAllowMealDayTableModel ptm = (StudentAllowMealDayTableModel) tbAllowMeal.getModel();
                StudentAllowMealDay select = ptm.getAllowStudentMealDay(tbAllowMeal.getSelectedRow());
                StudentAllowMealDayDAO dao = new StudentAllowMealDayDAO();
                dao.remove(select);
                preencheTabelaAllowMeal();
            }
        }
    }//GEN-LAST:event_cbDeletarAllowStudentDayActionPerformed

    private void lblPhotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblPhotoMouseClicked
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg", "png");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            insertImage(file.getAbsolutePath());
        }

    }//GEN-LAST:event_lblPhotoMouseClicked

    private void tbStudentMealsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbStudentMealsMouseClicked
        if(evt.getClickCount() == 2){
            StudentSchedulingTableModel ptm = (StudentSchedulingTableModel) tbStudentMeals.getModel();
            Scheduling select = ptm.getScheduling(tbStudentMeals.getSelectedRow());
            if(select.isWasPresent()){
                JOptionPane.showMessageDialog(rootPane, "O Estudante esteve presente!", "IFCE", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JustificationFrmRegister jfr = new JustificationFrmRegister(select);
                jfr.setVisible(true);
            }
        }
    }//GEN-LAST:event_tbStudentMealsMouseClicked

    private void insertImage(String path) {
        ImageIcon image = new ImageIcon(path);
        lblPhoto.setIcon(new ImageIcon(
                image.getImage().getScaledInstance(lblPhoto.getWidth(), lblPhoto.getHeight(),
                        Image.SCALE_DEFAULT)));
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
            java.util.logging.Logger.getLogger(StudentFrmRegister.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StudentFrmRegister.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StudentFrmRegister.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StudentFrmRegister.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btEditAllowStudentMeal;
    private javax.swing.JCheckBox cbActive;
    private javax.swing.JButton cbAddStudentAllowMealDay;
    private javax.swing.JComboBox cbCourse;
    private javax.swing.JButton cbDeletarAllowStudentDay;
    private javax.swing.JComboBox cbShift;
    private javax.swing.JCheckBox chbAlunoSemRegu;
    private javax.swing.JCheckBox chbBlock;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblPhoto;
    private javax.swing.JPanel pnlDIni;
    private javax.swing.JPanel pnlMeals;
    private javax.swing.JTable tbAllowMeal;
    private javax.swing.JTable tbStudentMeals;
    private javax.swing.JTabbedPane tbbPanStudente;
    private javax.swing.JFormattedTextField tfDateValid;
    private javax.swing.JTextField tfMat;
    private javax.swing.JTextField tfName;
    // End of variables declaration//GEN-END:variables
}
