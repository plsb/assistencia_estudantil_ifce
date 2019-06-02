/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.shift;

import br.campus.Campus;
import br.course.*;
import br.meal.Meal;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author pelusb
 */
@Entity
@Table(name = "shift")
public class Shift implements Comparable<Shift>{
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String description;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "shift_meal",
            joinColumns =
            @JoinColumn(name = "idShift"),
            inverseJoinColumns =
            @JoinColumn(name = "idMeal"))
    private List<Meal> meals;
    
    @ManyToOne
    private Campus campus;
   
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
     * @return the descriptrion
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param descriptrion the descriptrion to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int compareTo(Shift o) {
        return this.getDescription().compareTo(o.getDescription());
    }

    @Override
    public String toString() {
        return this.getDescription();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Shift other = (Shift) obj;
        if (this.getId() != other.getId()) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.getId();
        return hash;
    }

    /**
     * @return the meals
     */
    public List<Meal> getMeals() {
        return meals;
    }

    /**
     * @param meals the meals to set
     */
    public void setMeals(List<Meal> meals) {
        this.meals = meals;
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
