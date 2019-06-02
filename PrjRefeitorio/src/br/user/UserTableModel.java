package br.user;

import br.student.Student;
import br.util.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author adrianolima
 */
@SuppressWarnings("serial")
public class UserTableModel extends AbstractTableModel {

    private String[] nomeColunas = {"Código", "Nome", "Login", "Tipo", "Campus",""};
    private List<User> usuarios;

    /**
     * Construtor padrão.
     */
    public UserTableModel() {
    }

    /**
     * Construtor sobrecarregado.
     *
     * @param lista List(Usuario).
     */
    public UserTableModel(List<User> lista) {
        usuarios = new ArrayList(new HashSet(lista));
        //this.usuarios.clear();
        //this.usuarios.addAll(lista);
        Collections.sort(usuarios);
        super.fireTableDataChanged();
    }

    /**
     * Método sobrescrito.
     *
     * @return int.
     */
    @Override
    public int getRowCount() {
        return usuarios.size();
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
     * @param rowIndex int.
     * @param columnIndex int.
     * @return Object.
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        User usuario = usuarios.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return Util.decimalFormat().format(usuario.getId());
            case 1:
                return usuario.getName();
            case 2:
                return usuario.getLogin();
            case 3:
                return usuario.getTipo();
            case 4:
                return usuario.getCampus()!=null ? usuario.getCampus().getDescription() : ""; 
            case 5:
                return usuario.getActive(); 
              
        }
        return null;
    }

    /**
     * Método sobrescrito
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
    
    public User getUser(int rowIndex) {
        return usuarios.get(rowIndex);
    }
}