/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.student;

import br.course.Course;
import java.math.BigInteger;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student implements Comparable<Student> {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private Integer mat;
    
    private String name;
    
    private boolean block;
    
    private boolean active;
    
    @ManyToOne
    private Course course;

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
    public Integer getMat() {
        return mat;
    }

    /**
     * @param mat the mat to set
     */
    public void setMat(Integer mat) {
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
     * @return the block
     */
    public boolean isBlock() {
        return block;
    }

    /**
     * @param block the block to set
     */
    public void setBlock(boolean block) {
        this.block = block;
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

    public String getBlock(){
        if(isBlock()){
            return "Bloqueado";
        } else {
            return "";
        }
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
    
    
}
