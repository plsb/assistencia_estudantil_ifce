/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.scheduling;

import br.campus.Campus;
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

    @Temporal(TemporalType.DATE)
    private Date dateInsert;

    @Temporal(TemporalType.TIME)
    private Date time;

    private boolean wasPresent;

    @ManyToOne
    private User user;
    
    @ManyToOne
    private Campus campus;
    
    private String absenceJustification;

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

    public String getSituaction() {
        Date date = new Date();
        if (this.getDate().before(date)) {
            if(getAbsenceJustification()!=null){
                return "Justificado";
            }
            if (isWasPresent()) {
                return "Presente";
            } else {
                return "Ausente";
            }
        }
        return "";
    }

    @Override
    public int compareTo(Scheduling o) {
        return o.getId().compareTo(getId());
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

    /**
     * @return the dateInsert
     */
    public Date getDateInsert() {
        return dateInsert;
    }

    /**
     * @param dateInsert the dateInsert to set
     */
    public void setDateInsert(Date dateInsert) {
        this.dateInsert = dateInsert;
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
     * @return the absenceJustification
     */
    public String getAbsenceJustification() {
        return absenceJustification;
    }

    /**
     * @param absenceJustification the absenceJustification to set
     */
    public void setAbsenceJustification(String absenceJustification) {
        this.absenceJustification = absenceJustification;
    }

    
}
