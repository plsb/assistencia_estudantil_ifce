package br.util;

import javax.swing.JOptionPane;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SessionFactory sessionFactory
            = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            /*AnnotationConfiguration cfg = 
			new AnnotationConfiguration();
            cfg.configure("hibernate.cfg.xml");*/
            Configuration cfg
                    = new Configuration();
            cfg.configure("hibernate.cfg.xml");
            return cfg.buildSessionFactory();
        } catch (Throwable e) {
            // TODO: handle exception
            JOptionPane.showMessageDialog(null,"Criação inicial do objeto"
                    + " SessionFactory falhou. Erro: " + e.getMessage());
            throw new ExceptionInInitializerError(e);
        }
    }

}
