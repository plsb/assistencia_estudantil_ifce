package br.product;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class ProductTableModel extends AbstractTableModel{

    private List<Product> products;
    private String[] nameColumns = {"Código", "Descrição", "Valor"};
    
    public ProductTableModel(List<Product> products){
        this.products  = products;
    }
    
    @Override
    public int getRowCount() {
        return this.products.size();
    }

    @Override
    public int getColumnCount() {
        return this.nameColumns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Product product = this.products.get(rowIndex);
        switch(columnIndex){
            case 0: 
                return product.getId();
            case 1: 
                return product.getDescription();
            case 2:
                return product.getPrice();
        }
        return null;
    }
    
    public Product getProduct(int rowIndex){
        return this.products.get(rowIndex);
    }

    @Override
    public String getColumnName(int column) {
        return this.nameColumns[column];
    }
    
    
    
}
