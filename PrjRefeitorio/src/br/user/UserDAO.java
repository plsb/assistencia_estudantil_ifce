/* Este arquivo é parte do OSBiblio.
 * Copyright (C) 2014 (Pedro Saraiva, Túlio Vidal, Luís Henrique, Adriano Lima, Oziel Pereira,
 * Marcos Ellys, Francisco Júnior, Fátima Pinheiro, Darly Vinicio).
 *
 * OSBiblio é um software livre; você pode redistribuí-lo e/ou  modificá-lo dentro dos termos da 
 * Licença Pública Geral GNU como publicada pela Fundação do Software Livre (FSF); na versão 2 da Licença,
 * ou (na sua opinião) qualquer versão.
 *
 * Este programa é distribuído na esperança de que possa ser útil, mas SEM NENHUMA GARANTIA; sem uma garantia 
 * implícita de ADEQUAÇÃO a qualquer MERCADO ou APLICAÇÃO EM PARTICULAR. Veja a Licença Pública Geral GNU
 * para maiores detalhes.
 */
package br.user;

import br.util.GenericDAO;
import br.util.HibernateUtil;
import java.util.List;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author Pedro Saraiva
 */
public class UserDAO extends GenericDAO<User> {

    /**
     * Construtor da classe UsuarioDAO.
     */
    public UserDAO() {
        super(User.class);
    }

    /**
     * Pesquisa um Usuario que contenha o usuario passado por parâmetro.
     *
     * @param usuario Usuario.
     * @return usuario Usuario.
     */
    public User searchUser(String login, String pass) {
        try {
            this.setSessao(HibernateUtil.getSessionFactory().openSession());
            this.setTransacao(this.getSessao().beginTransaction());
            return (User) getSessao().createCriteria(User.class).
                    add(Restrictions.eq("login", login)).
                    add(Restrictions.eq("senha", pass)).uniqueResult();
        } catch (Exception e) {
            System.out.println("Erro encontrado. Erro " + e.getMessage());
        } finally {
            this.getSessao().close();
        }
        return null;
    }
}