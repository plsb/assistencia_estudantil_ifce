/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.republic;

import br.campus.Campus;
import br.meal.Meal;
import br.student.Student;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pelusb
 */
@Entity
@Table(name = "republic")
public class Republic implements Comparable<Republic> {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String description;
    
    private String neighborhood;
    
    private String address;
    
    private String city;
    
    private String ownerRepublic;
    
    private double valueRepublic;
    
    @ManyToOne
    private Campus campus;
    
    /*@OneToMany(mappedBy = "republic", fetch = FetchType.EAGER)
    private List<ItensRepublic> itensRepublic;*/
    
    @Override
    public int compareTo(Republic o) {
        return getDescription().compareTo(o.getDescription());
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
        final Meal other = (Meal) obj;
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

    /**
     * @return the neighborhood
     */
    public String getNeighborhood() {
        return neighborhood;
    }

    /**
     * @param neighborhood the neighborhood to set
     */
    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the ownerRepublic
     */
    public String getOwnerRepublic() {
        return ownerRepublic;
    }

    /**
     * @param ownerRepublic the ownerRepublic to set
     */
    public void setOwnerRepublic(String ownerRepublic) {
        this.ownerRepublic = ownerRepublic;
    }

    /**
     * @return the valueRepublic
     */
    public double getValueRepublic() {
        return valueRepublic;
    }

    /**
     * @param valueRepublic the valueRepublic to set
     */
    public void setValueRepublic(double valueRepublic) {
        this.valueRepublic = valueRepublic;
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
