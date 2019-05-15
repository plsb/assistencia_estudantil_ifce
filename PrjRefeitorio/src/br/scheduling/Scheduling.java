/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.scheduling;

import br.meal.Meal;
import br.student.Student;
import br.user.User;
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
@Table(name = "scheduling")
public class Scheduling implements Comparable<Scheduling> {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @ManyToOne
    private Student student;
    
    @ManyToOne
    private Meal meal;
    
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @Temporal(TemporalType.TIME)
    private Date time;
    
    private boolean wasPresent;
    
    @ManyToOne
    private User user;

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
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return the meal
     */
    public Meal getMeal() {
        return meal;
    }

    /**
     * @param meal the meal to set
     */
    public void setMeal(Meal meal) {
        this.meal = meal;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the time
     */
    public Date getTime() {
        return time;
    }

    /**
     * @param time the time to set
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * @return the wasPresent
     */
    public boolean isWasPresent() {
        return wasPresent;
    }

    /**
     * @param wasPresent the wasPresent to set
     */
    public void setWasPresent(boolean wasPresent) {
        this.wasPresent = wasPresent;
    }
    
    public String getSituaction(){
        if(isWasPresent()){
            return "Presente";
        } else {
            return "Ausente";
        }
    }

    @Override
    public int compareTo(Scheduling o) {
        return o.getTime().compareTo(getTime());
    }

    /**
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    
    
}