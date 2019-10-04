/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.util;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author @author JOABB
 */
@SuppressWarnings("unchecked")
public abstract class GenericDAO<T> {

    /*
     * Essa classe possui operações comuns a todas as classes persistentes
     * para utilizar-la deverá criar uma classe DAO específica para a classe
     * persistente e extends GenericDAO<T> onde T é a classe Persistente 
     */
    private Session sessao;
    private Transaction transacao;
    private Class classe;

    public GenericDAO(Class classe) {
        this.classe = classe;
    }

    public boolean add(T entity) {
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            this.getSessao().save(entity);
            this.getTransacao().commit();
        } catch (HibernateException e) {
            System.out.println(e.getMessage() + " | " + e.getCause());
            JOptionPane.showMessageDialog(null, "Não foi possível inserir " + entity.getClass()
                    + ". Erro: " + e.getMessage());
            return false;
        } finally {
            getSessao().close();
        }
        return true;
    }

    public boolean update(T entity) {
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(getSessao().beginTransaction());
            this.getSessao().merge(entity);
            this.getTransacao().commit();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar " + entity.getClass()
                    + ". Erro: " + e.getMessage());
            return false;
        } finally {
            getSessao().close();

        }
        return true;
    }

    public boolean remove(T entity) {
//        try {
        this.setSessao(HibernateUtil.getSessionFactory().openSession());
        this.setTransacao(getSessao().beginTransaction());
        this.getSessao().delete(entity);
        this.getTransacao().commit();

//        } catch (HibernateException e) {
//            JOptionPane.showMessageDialog(null, "Não foi possível remover " + entity.getClass()
//                    + ". Erro: " + e.getMessage());
//            return false;
//        } finally {
        getSessao().close();

//        }
        return true;
    }

    public List<T> list() {
        List<T> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(classe).list();

        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            sessao.close();
        }
        return lista;
    }
    

    public List<T> list(String orderBy) {
        List<T> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(classe).addOrder(Order.asc(orderBy)).list();

        } catch (Throwable e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }

        } finally {
            sessao.close();
        }
        return lista;
    }
    
    public List<T> list(String campo, Object valor,String orderBy) {
        List<T> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(classe)
                    .add(Restrictions.eq(campo, valor))
                    .addOrder(Order.asc(orderBy)).list();

        } catch (Throwable e) {
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }

        } finally {
            sessao.close();
        }
        return lista;
    }

    /*
     * ao passar uma chave primária
     * ele retorna um objeto referente a chave primária
     */
    public T carregaChavePrimaria(int chavePrimaria) {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            Object o = sessao.load(classe, chavePrimaria);
            return (T) o;
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar por chave primária" + e.getMessage());
        } finally {
            sessao.close();
        }
        return null;
    }

    public List<T> checkExists(String campo, Object valor) {
        List<T> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(classe).add(Restrictions.eq(campo, valor)).list();
            //Hibernate.initialize(lista);
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            sessao.close();
        }
        return lista;

    }
    
    public List<T> checkExists(String campo, Object valor, String campo2, Object valor2) {
        List<T> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(classe)
                    .add(Restrictions.eq(campo, valor))
                    .add(Restrictions.eq(campo2, valor2)).list();
            //Hibernate.initialize(lista);
        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            sessao.close();
        }
        return lista;

    }
    
    

    public List<T> checkExistsLike(String campo, String valor) {
        List<T> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(classe).add(Restrictions.like(campo, valor, MatchMode.ANYWHERE)).list();

        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            sessao.close();
        }
        return lista;

    }
    
    public List<T> checkExistsLike(String campo, String valor, String campo2, Object valor2) {
        List<T> lista = null;
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            setTransacao(getSessao().beginTransaction());
            lista = this.getSessao().createCriteria(classe)
                    .add(Restrictions.eq(campo2, valor2))
                    .add(Restrictions.like(campo, valor, MatchMode.ANYWHERE)).list();

        } catch (Throwable e) {
            if (getTransacao().isActive()) {
                getTransacao().rollback();
            }
            JOptionPane.showMessageDialog(null, "Não foi possível listar: " + e.getMessage());
        } finally {
            sessao.close();
        }
        return lista;

    }
    
    

    /**
     * @return the sessao
     */
    public Session getSessao() {
        return sessao;
    }

    /**
     * @param sessao the sessao to set
     */
    public void setSessao(Session sessao) {
        this.sessao = sessao;
    }

    /**
     * @return the transacao
     */
    public Transaction getTransacao() {
        return transacao;
    }

    /**
     * @param transacao the transacao to set
     */
    public void setTransacao(Transaction transacao) {
        this.transacao = transacao;
    }

    public List<T> listar(String campo, Object valor) {

        List<T> lista = null;
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();
            lista = sessao.createCriteria(classe).add(Restrictions.eq(campo, valor)).list();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return lista;
        } finally {
            sessao.close();
        }
        return lista;
    }

    public Time getServerTime() {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();;
            sessao.beginTransaction();
            SQLQuery query = sessao.createSQLQuery("SELECT CURTIME()");
            Time time = (Time) query.uniqueResult();
            return time;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        } finally {
            sessao.close();
        }

    }

    public Date getServerDate() {
        try {
            sessao = HibernateUtil.getSessionFactory().openSession();;
            SQLQuery query = sessao.createSQLQuery("SELECT CURDATE()");
            Date date = (Date) query.uniqueResult();
            return date;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            return null;
        } finally {
            sessao.close();
        }
    }
    
    public void executeSQL(String query) {
        try {
            setSessao(HibernateUtil.getSessionFactory().openSession());
            
            this.setTransacao(getSessao().beginTransaction());
            this.getSessao().createSQLQuery(query).executeUpdate();
            this.getTransacao().commit();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            sessao.close();
        }
    }
    
    public List executaSqlPuro(String sql){
        List list = new ArrayList();
        try {
            setSessao(HibernateUtil.getSessionFactory().openSession());
            
            this.setTransacao(getSessao().beginTransaction());
            list = this.getSessao().createSQLQuery(sql).list();
            this.getTransacao().commit();
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } finally {
            sessao.close();
        }
        return list;
    }
}
