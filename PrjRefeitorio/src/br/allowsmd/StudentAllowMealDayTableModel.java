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
package br.allowsmd;

import br.allowsmd.*;
import br.course.*;
import br.meal.*;
import br.student.*;
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
public class StudentAllowMealDayTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Refeição", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};
    private List<StudentAllowMealDay> allows;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Cidade).
     */
    public StudentAllowMealDayTableModel(List<StudentAllowMealDay> list) {
        allows = new ArrayList(new HashSet(list));
        this.allows.clear();
        Collections.sort(list);
        this.allows.addAll(list);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return allows.size();
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
        StudentAllowMealDay s = allows.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(s.getId());
            case 1:
                return s.getMeal().getDescription();
            case 2:
                return s.isMonday() ? "Permissão" : "";
            case 3:
                return s.isTuesday() ? "Permissão" : "";
            case 4:
                return s.isWednesday() ? "Permissão" : "";    
            case 5:
                return s.isThursday() ? "Permissão" : ""; 
            case 6:
                return s.isFriday() ? "Permissão" : "";
            case 7:
                return s.isSaturday() ? "Permissão" : "";
        }
        return null;
    }
    
    public StudentAllowMealDay getAllowStudentMealDay(int rowIndex) {
        return allows.get(rowIndex);
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
            case 6:
                return nomeColunas[6];
            case 7:
                return nomeColunas[7];
        }
        return null;
    }
}
