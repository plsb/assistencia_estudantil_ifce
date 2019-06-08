/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.scheduling;

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
public class SchedulingDAO extends GenericDAO<Scheduling>{
    
    public SchedulingDAO() {
        super(Scheduling.class);
    }
    
    public List<Scheduling> schedulingNotPresent(Object valor) {
        List<Scheduling> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Scheduling.class).add(Restrictions.eq("date", valor))
                    .add(Restrictions.eq("wasPresent", false))
                    .add(Restrictions.eq("campus", UserActive.returnCampus())).list();
            
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            getSessao().close();
        }
        return lista;

    }
    
    public List<Scheduling> schedulingWasPresent(Object valor) {
        List<Scheduling> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Scheduling.class).add(Restrictions.eq("date", valor))
                    .add(Restrictions.eq("wasPresent", true))
                    .add(Restrictions.eq("campus", UserActive.returnCampus())).list();
            
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            getSessao().close();
        }
        return lista;

    }
    
    public List<Scheduling> verifyStudentBlocked(Student s) {
        List<Scheduling> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            
            SQLQuery query = this.getSessao().createSQLQuery("SELECT CURDATE()");
            Date date = (Date) query.uniqueResult();
            
            
            lista = this.getSessao().createCriteria(Scheduling.class)
                    .add(Restrictions.eq("student", s))
                    .add(Restrictions.eq("wasPresent", false))
                    .add(Restrictions.lt("date", date))
                    .add(Restrictions.isNull("absenceJustification")).list();
            
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return lista;

    }
    
    
    public List<Scheduling> schedulingDateStudentMeal(Date date, Student student, Meal meal) {
        List<Scheduling> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Scheduling.class).add(Restrictions.eq("date", date))
                    .add(Restrictions.eq("meal", meal))
                    .add(Restrictions.eq("student", student)).list();
            
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return lista;

    }
    
    public List<Scheduling> schedulingDateMeal(Date date, Meal meal) {
        List<Scheduling> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Scheduling.class).add(Restrictions.eq("date", date))
                    .add(Restrictions.eq("meal", meal)).list();
            
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return lista;

    }
    
    public List<Scheduling> schedulingDateMealWasPresent(Date date, Meal meal, boolean wasPresent) {
        List<Scheduling> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Scheduling.class).add(Restrictions.eq("date", date))
                    .add(Restrictions.eq("meal", meal))
                    .add(Restrictions.eq("wasPresent", wasPresent)).list();
            
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return lista;

    }
    
    
    public List<Scheduling> checkExistsin(String campo, List<Student> valor, Date date, Meal meal) {
        List<Scheduling> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(Scheduling.class)
                    .add(Restrictions.eq("date", date))
                    .add(Expression.in(campo, valor))
                    .add(Restrictions.eq("meal", meal))
                    .add(Restrictions.eq("campus", UserActive.returnCampus())).list();

        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return lista;

    }
}
