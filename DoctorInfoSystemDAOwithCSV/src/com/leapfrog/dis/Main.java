/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.dis;

import com.leapfrog.dis.dao.DoctorDAO;
import com.leapfrog.dis.dao.impl.DoctorDAOimpl;
import com.leapfrog.dis.entity.Doctor;
import com.leapfrog.dis.ui.UI;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author user
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        

        UI ui = new UI(new Scanner(System.in),new DoctorDAOimpl());
        
        while (true) {

            ui.menu();

            ui.control();
            
            
        }
    }

}
