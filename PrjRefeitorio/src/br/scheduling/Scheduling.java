/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.scheduling;

import br.campus.Campus;
import br.meal.Meal;
import br.menu.Menu;
import br.student.Student;
import br.user.User;
import br.util.Util;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Column;
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
    
    @ManyToOne
    private Menu menu;

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
    
    private String ticketCode;
    
    @Column(columnDefinition="default false'")
    private boolean canceled_by_student;

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
        
        if (isWasPresent()) {
            return "Presente";
        } if (getAbsenceJustification() != null) {
            return "Justificado";
        } else {
            SchedulingDAO dao = new SchedulingDAO();
            if (Util.verityDateEquals(dao.getServerDate(), getDate())) {
                return "";
            }
            return "Ausente";
        }

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

    /**
     * @return the menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * @param menu the menu to set
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * @return the ticketCode
     */
    public String getTicketCode() {
        return ticketCode;
    }

    /**
     * @param ticketCode the ticketCode to set
     */
    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    /**
     * @return the canceled_by_student
     */
    public boolean isCanceled_by_student() {
        return canceled_by_student;
    }

    /**
     * @param canceled_by_student the canceled_by_student to set
     */
    public void setCanceled_by_student(boolean canceled_by_student) {
        this.canceled_by_student = canceled_by_student;
    }

}
