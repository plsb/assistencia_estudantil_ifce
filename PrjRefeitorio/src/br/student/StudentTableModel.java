/* Este arquivo é parte do OSBiblio.
 * Copyright (C) 2014 (Pedro Saraiva, Túlio Vidal, Luís Henrique, Adriano Lima, Oziel Pereira,
 * Marcos Ellys, Francisco Júnior, Fátima Pinheiro, Darly Vinicio).
 *
 * OSBiblio é um software livre; você pode redistribuí-lo e/ou  modificá-lo dentro dos termos da 
 * Licença Pública Geral GNU como publicada pela Fundação do Software Livre (FSF); na versão 2 da Licença,
 * ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser útil, mas SEM NENHUMA GARANTIA; sem uma garantia 
 * implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU
 * para maiores detalhes.
 */
package br.student;

import br.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * @author adriano
 */
@SuppressWarnings("serial")
public class StudentTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Matrícula", "Nome", "Curso","Situação", ""};
    private List<Student> students;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Cidade).
     */
    public StudentTableModel(List<Student> list) {
        students = new ArrayList(new HashSet(list));
        this.students.clear();
        Collections.sort(list);
        this.students.addAll(list);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return students.size();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getColumnCount() {
        return nomeColunas.length;
    }

    /**
     * Método sobrescrito.
     *
     * @param rowIndex int
     * @param columnIndex int.
     * @return Object.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student s = students.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(s.getId());
            case 1:
                return s.getMat();
            case 2:
                return (s.getName());
            case 3:
                return s.getCourse() == null ? "" : s.getCourse().getDescription();
            case 4:
                return (s.getBlock());
            case 5:
                return (s.getActive());

        }
        return null;
    }
    
    public Student getStudent(int rowIndex) {
        return students.get(rowIndex);
    }
    /**
     * Método sobrescrito.
     *
     * @param column int.
     * @return String nomeColunas[index].
     */
    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return nomeColunas[0];
            case 1:
                return nomeColunas[1];
            case 2:
                return nomeColunas[2];
            case 3:
                return nomeColunas[3];
            case 4:
                return nomeColunas[4];
            case 5:
                return nomeColunas[5];
        }
        return null;
    }
    
    
}
