/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.dis.dao.impl;

import com.leapfrog.dis.dao.DoctorDAO;
import com.leapfrog.dis.entity.Doctor;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author user
 */
public class DoctorDAOimpl implements DoctorDAO {

    private List<Doctor> doctorList = new ArrayList<>();

    @Override
    public List<Doctor> showAll() {

        return doctorList;
    }

    @Override
    public void insert(Doctor d) {
        doctorList.add(d);
    }

    @Override
    public List<Doctor> searchBySpecialization(String specialization) {

        List<Doctor> dummy = new ArrayList<>();

        for (Doctor d : doctorList) {
            if (d.getSpecialization().contains(specialization)) {
                dummy.add(d);

            }
        }
        return dummy;
    }

    @Override
    public List<Doctor> search(String text) {

        List<Doctor> dummy = new ArrayList<>();
        for (Doctor d : doctorList) {
            if (d.getSpecialization().contains(text) || d.getAddress().contains(text) || d.getFirstName().contains(text) || d.getLastName().contains(text) || d.getWorkplace().contains(text)) {
                dummy.add(d);

            }
        }

        return dummy;
    }

    @Override
    public void export(String location, String fileName, List<Doctor> list) {
        try {

            FileWriter writer = new FileWriter(new File(location + '/' + fileName));
            StringBuilder builder = new StringBuilder();

            for (Doctor d : list) {

//                String firstName, lastName, address, specialization, workplace, contact;
//                firstName = d.getFirstName();
//                lastName = d.getLastName();
//                address = d.getAddress();
//                specialization = d.getSpecialization();
//                workplace = d.getWorkplace();
                
                  String csv = d.toCSV();
                  
                  builder.append(csv);
                 
            }
            
             writer.write(builder.toString());
            writer.close();
        } catch (IOException ex) {
            ex.getMessage();
        }
    }

}
