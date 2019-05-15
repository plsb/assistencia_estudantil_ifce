/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.student;

import br.util.GenericDAO;

/**
 *
 * @author pelusb
 */
public class StudentDAO extends GenericDAO<Student> {
    
    public StudentDAO() {
        super(Student.class);
    }
    
}
