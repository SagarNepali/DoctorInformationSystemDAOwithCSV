/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.dis.dao;

import com.leapfrog.dis.entity.Doctor;
import java.util.List;

/**
 *
 * @author user
 */
public interface DoctorDAO {
    
    List<Doctor> showAll();
    void insert(Doctor d);
    List<Doctor> searchBySpecialization(String specialization);
    List<Doctor> search(String text);
    void export(String location,String fileName, List<Doctor> list);
    
}
