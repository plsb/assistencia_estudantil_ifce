/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.util;

import br.campus.Campus;
import br.user.User;
import br.user.UserDAO;
import org.dom4j.util.UserDataAttribute;


/**
 *
 * @author Pedro Saraiva
 */
public class UserActive {

    private static String login;
    private static boolean administrador;
    private static User user;
    
    /**
     * @return the login
     */
    public static String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public static void setLogin(String login) {
        UserActive.login = login;
    }

    /**
     * @return the administrador
     */
    public static boolean isAdministrador() {
        return administrador;
    }

    /**
     * @param aAdministrador the administrador to set
     */
    public static void setAdministrador(boolean aAdministrador) {
        administrador = aAdministrador;
    }
    
    public static void setUser(User u){
        user = u;
    }
    
    public static User retornaUsuarioAtivo(){
        
        /*UserDAO usuDAO = new UserDAO();
        User user = usuDAO.checkExists("login", login).get(0);*/
        return user;
        
    }
    
    public static Campus returnCampus(){
        /*UserDAO usuDAO = new UserDAO();
        User user = usuDAO.checkExists("login", login).get(0);*/
        return user.getCampus();
    }
}