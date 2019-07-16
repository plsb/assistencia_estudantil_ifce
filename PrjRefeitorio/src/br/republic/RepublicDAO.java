/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.republic;

import br.scheduling.*;
import br.meal.Meal;
import br.student.Student;
import br.util.GenericDAO;
import br.util.HibernateUtil;
import br.util.UserActive;
import br.util.Util;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.SQLQuery;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pelusb
 */
public class RepublicDAO extends GenericDAO<Republic>{
    
    public RepublicDAO() {
        super(Republic.class);
    }
    
    
}
