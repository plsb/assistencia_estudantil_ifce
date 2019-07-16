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
package br.menu;

import br.meal.*;
import br.student.*;
import br.util.Util;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * @author adriano
 */
@SuppressWarnings("serial")
public class MenuTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Data", "Refeição", "Descrição"};
    private List<Menu> menus;

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Cidade).
     */
    public MenuTableModel(List<Menu> list) {
        menus = new ArrayList(new HashSet(list));
        this.menus.clear();
        Collections.sort(list);
        this.menus.addAll(list);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return menus.size();
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
        Menu m = menus.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(m.getId());
            case 1:
                return m.getDate()!=null ? new SimpleDateFormat("dd/MM/yyyy").format( m.getDate()) : "";
            case 2:
                return m.getMeal().getDescription();
            case 3:
                return m.getDescription();
        }
        return null;
    }
    
    public Menu getMenu(int rowIndex) {
        return menus.get(rowIndex);
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
        }
        return null;
    }
}
