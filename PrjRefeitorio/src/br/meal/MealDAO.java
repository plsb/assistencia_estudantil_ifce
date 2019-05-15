/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.meal;

import br.util.GenericDAO;

/**
 *
 * @author pelusb
 */
public class MealDAO extends GenericDAO<Meal>{
    
    public MealDAO() {
        super(Meal.class);
    }
   
}
