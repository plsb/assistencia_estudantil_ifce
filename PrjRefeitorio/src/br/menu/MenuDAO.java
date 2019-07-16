/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.menu;

import br.meal.*;
import br.util.GenericDAO;

/**
 *
 * @author pelusb
 */
public class MenuDAO extends GenericDAO<Menu>{
    
    public MenuDAO() {
        super(Menu.class);
    }
   
}
