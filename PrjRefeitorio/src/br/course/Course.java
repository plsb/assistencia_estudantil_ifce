/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.course;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pelusb
 */
@Entity
@Table(name = "course")
public class Course implements Comparable<Course>{
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String description;
    
    private String initials;

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

    /**
     * @return the initials
     */
    public String getInitials() {
        return initials;
    }

    /**
     * @param initials the initials to set
     */
    public void setInitials(String initials) {
        this.initials = initials;
    }

    @Override
    public int compareTo(Course o) {
        return this.description.compareTo(o.description);
    }

    @Override
    public String toString() {
        return this.description;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Course other = (Course) obj;
        if (this.id != other.id) {
            return false;
        }
        
        return true;
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id;
        return hash;
    }
    
}
