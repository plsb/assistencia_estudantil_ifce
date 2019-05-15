/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.meal;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pelusb
 */
@Entity
@Table(name = "meal")
public class Meal implements Comparable<Meal> {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String description;
    
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
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Meal o) {
        return description.compareTo(o.description);
    }

    @Override
    public String toString() {
        return this.description;
    }
    
    

    
}
