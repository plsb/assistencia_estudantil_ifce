/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.campus;


import br.course.Course;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pelusb
 */
@Entity
@Table(name = "campus")
public class Campus implements Comparable<Campus> {
    
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
    public int compareTo(Campus o) {
        return this.getDescription().compareTo(o.getDescription());
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
        final Campus other = (Campus) obj;
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
    
}
