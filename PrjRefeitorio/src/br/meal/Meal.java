/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.meal;


import br.campus.Campus;
import br.shift.Shift;
import java.sql.Time;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
    
    private int qtdTimeReservationStart;
    
    private int qtdTimeReservationEnd;
    
    @Temporal(TemporalType.TIME)
    private Date timeStart;
    
    @Temporal(TemporalType.TIME)
    private Date timeEnd;
    
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
     * @return the timeStart
     */
    public Date getTimeStart() {
        return timeStart;
    }

    /**
     * @param timeStart the timeStart to set
     */
    public void setTimeStart(Date timeStart) {
        this.timeStart = timeStart;
    }

    /**
     * @return the timeEnd
     */
    public Date getTimeEnd() {
        return timeEnd;
    }

    /**
     * @param timeEnd the timeEnd to set
     */
    public void setTimeEnd(Date timeEnd) {
        this.timeEnd = timeEnd;
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

    

    /**
     * @return the qtdTimeReservationEnd
     */
    public int getQtdTimeReservationEnd() {
        return qtdTimeReservationEnd;
    }

    /**
     * @param qtdTimeReservationEnd the qtdTimeReservationEnd to set
     */
    public void setQtdTimeReservationEnd(int qtdTimeReservationEnd) {
        this.qtdTimeReservationEnd = qtdTimeReservationEnd;
    }

    /**
     * @return the qtdTimeReservationStart
     */
    public int getQtdTimeReservationStart() {
        return qtdTimeReservationStart;
    }

    /**
     * @param qtdTimeReservationStart the qtdTimeReservationStart to set
     */
    public void setQtdTimeReservationStart(int qtdTimeReservationStart) {
        this.qtdTimeReservationStart = qtdTimeReservationStart;
    }

    
    
    
    
}
