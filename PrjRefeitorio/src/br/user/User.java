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

import br.campus.Campus;
import br.util.Util;
import java.io.Serializable;
import java.util.Objects;
import javax.persistence.*;
import org.hibernate.annotations.NaturalId;

/**
 *
 * @author pedrosaraiva
 */
@Entity
@Table(name = "user")
public class User implements Serializable, Comparable<User> {

    /**
     * Método sobrescrito
     *
     * @param o objeto a ser acessado através da Composição.
     * @return inteiro negativo, zero ou inteiro positivo.
     */
    @Override
    public int compareTo(User o) {
        return getLogin().compareTo(o.getLogin());
    }
    @Id // chave primária
    @GeneratedValue // campo auto incremento
    private Integer id;
    @Column(length = 100, nullable = false)
    private String name;
    @NaturalId(mutable = true) // será um valor único mas poderá ser alterado
    @Column(length = 50, nullable = false)
    private String login;
    @Column(length = 50, nullable = false)
    private String senha;
    
    private String tipo;
    
    private boolean active;
    
    @ManyToOne
    private Campus campus;

    /**
     * @return String login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login String.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return String senha.
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha String.
     */
    public void setSenha(String senha) {
        this.senha = Util.md5(senha);
    }
    private static long serialVersionUID = -8877584534061371241L;

    

    /**
     * Método sobrescrito
     *
     * @return um inteiro(hash) contendo o valor total do cálculo de todos os
     * hasCodes dos Atributos contidos na classe.
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + this.getId();
        return hash;
    }

    /**
     * Método sobrescrito
     *
     * @param obj a ser acessado através da composição.
     * @return booleando (true|false).
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        return true;
    }

    /**
     * Método sobrescrito
     *
     * @return String contendo o id do Usuario e o Login.
     */
    @Override
    public String toString() {
        return this.getName();
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the serialVersionUID
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * @param aSerialVersionUID the serialVersionUID to set
     */
    public static void setSerialVersionUID(long aSerialVersionUID) {
        serialVersionUID = aSerialVersionUID;
    }

   
    
    public String getActive(){
        if(isActive()){
            return "Ativo";
        } else {
            return "Inativo";
        }
    }

    /**
     * @return the active
     */
    public boolean isActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(boolean active) {
        this.active = active;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the campus
     */
    public Campus getCampus() {
        return campus;
    }

    /**
     * @param campus the campus to set
     */
    public void setCampus(Campus campus) {
        this.campus = campus;
    }
    
    
}
