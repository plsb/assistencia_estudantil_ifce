package br.product;

import br.util.GenericDAO;

public class ProductDAO extends GenericDAO<Product>{
    
    public ProductDAO(){
        super(Product.class);
    }
    
}
