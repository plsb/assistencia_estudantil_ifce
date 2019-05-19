/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.allowsmd;

import br.allowsmd.StudentAllowMealDay;
import br.meal.Meal;
import br.student.Student;
import br.util.GenericDAO;
import br.util.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author pelusb
 */
public class StudentAllowMealDayDAO extends GenericDAO<StudentAllowMealDay>{
    
    public StudentAllowMealDayDAO() {
        super(StudentAllowMealDay.class);
    }
    
    public StudentAllowMealDay checkStudentMeal(Student student, Meal meal) {
        StudentAllowMealDay obj = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            obj = (StudentAllowMealDay)  this.getSessao().createCriteria(StudentAllowMealDay.class)
                    .add(Restrictions.eq("student", student))
                    .add(Restrictions.eq("meal", meal)).uniqueResult();
            //Hibernate.initialize(lista);
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            getSessao().close();
        }
        return obj;

    }
    
}
