/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.shift;

import br.course.*;
import br.util.GenericDAO;
import java.lang.reflect.GenericDeclaration;

/**
 *
 * @author pelusb
 */
public class ShiftDAO extends GenericDAO<Shift>{
    
    public ShiftDAO() {
        super(Shift.class);
    }
    
    
}
