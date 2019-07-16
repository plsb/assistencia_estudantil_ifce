/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.republic;

import br.student.Student;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author pelusb
 */
@Entity
@Table(name = "itens_republic")
public class ItensRepublic implements Comparable<ItensRepublic>{
    
    @Id
    @GeneratedValue
    private Integer id;
    
    @ManyToOne
    private Student student;
    
    private boolean responsability;
    
    
    @ManyToOne
    private Republic republic;

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
     * @return the responsability
     */
    public boolean isResponsability() {
        return responsability;
    }

    /**
     * @param responsability the responsability to set
     */
    public void setResponsability(boolean responsability) {
        this.responsability = responsability;
    }

    @Override
    public int compareTo(ItensRepublic o) {
        return getId().compareTo(o.getId());
    }
    
    public String getResponsability(){
        if(this.isResponsability()){
            return "Sim";
        } else {
            return "";
        }
    }

    /**
     * @return the republic
     */
    public Republic getRepublic() {
        return republic;
    }

    /**
     * @param republic the republic to set
     */
    public void setRepublic(Republic republic) {
        this.republic = republic;
    }

    
    
    
}
