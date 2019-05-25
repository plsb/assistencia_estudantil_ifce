/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.config;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author pelusb
 */
@Entity
@Table(name = "config")
public class Config {
    
    @Id
    @GeneratedValue
    private Integer id;
    
    private double version;
    
    private String pathPhotoStudent;
    
    private String pathReport;
    
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
     * @return the version
     */
    public double getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(double version) {
        this.version = version;
    }

    /**
     * @return the pathPhotoStudent
     */
    public String getPathPhotoStudent() {
        return pathPhotoStudent;
    }

    /**
     * @param pathPhotoStudent the pathPhotoStudent to set
     */
    public void setPathPhotoStudent(String pathPhotoStudent) {
        this.pathPhotoStudent = pathPhotoStudent;
    }

    /**
     * @return the pathRelatorio
     */
    public String getPathReport() {
        return pathReport;
    }

    /**
     * @param pathRelatorio the pathRelatorio to set
     */
    public void setPathReport(String pathReport) {
        this.pathReport = pathReport;
    }

    
}
