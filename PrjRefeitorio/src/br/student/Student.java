/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.student;

import br.allowsmd.StudentAllowMealDay;
import br.campus.Campus;
import br.course.Course;
import br.screen.AllowMealStudentFrm;
import br.shift.Shift;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student")
public class Student implements Comparable<Student> {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private String mat;
    
    private String name;
    
    private boolean active;
    
    private boolean semRegular;
    
    @ManyToOne
    private Course course;
    
    @ManyToOne
    private Shift shift;
    
    @Temporal(TemporalType.DATE)
    private Date dateValid;
    
    private String photo;
    
    @ManyToOne
    private Campus campus;
    
    
    private String observation;
    
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
     * @return the mat
     */
    public String getMat() {
        return mat;
    }

    /**
     * @param mat the mat to set
     */
    public void setMat(String mat) {
        this.mat = mat;
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

    @Override
    public int compareTo(Student o) {
        return getName().compareTo(o.getName());
    }

    /**
     * @return the course
     */
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
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
     * @return the shift
     */
    public Shift getShift() {
        return shift;
    }

    /**
     * @param shift the shift to set
     */
    public void setShift(Shift shift) {
        this.shift = shift;
    }
    
    
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
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
     * @return the dateValid
     */
    public Date getDateValid() {
        return dateValid;
    }

    /**
     * @param dateValid the dateValid to set
     */
    public void setDateValid(Date dateValid) {
        this.dateValid = dateValid;
    }

    /**
     * @return the semRegular
     */
    public boolean isSemRegular() {
        return semRegular;
    }

    /**
     * @param semRegular the semRegular to set
     */
    public void setSemRegular(boolean semRegular) {
        this.semRegular = semRegular;
    }

    /**
     * @return the foto
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * @param foto the foto to set
     */
    public void setPhoto(String foto) {
        this.photo = foto;
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

    @Override
    public String toString() {
        return getName();
    }

    /**
     * @return the observation
     */
    public String getObservation() {
        return observation;
    }

    /**
     * @param observation the observation to set
     */
    public void setObservation(String observation) {
        this.observation = observation;
    }

    
    
}
