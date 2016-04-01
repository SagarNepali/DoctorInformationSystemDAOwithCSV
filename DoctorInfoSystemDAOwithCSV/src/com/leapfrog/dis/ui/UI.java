/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.dis.ui;

import com.leapfrog.dis.dao.DoctorDAO;
import com.leapfrog.dis.entity.Doctor;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class UI {

    private Scanner input;
    private DoctorDAO doctorDAO;
    private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public UI(Scanner input, DoctorDAO doctorDAO) {

        this.input = input;
        this.doctorDAO = doctorDAO;
    }

    public void menu() {
        System.out.println("***** Doctor Information System *****");
        System.out.println("1. Insert Doctor Information");
        System.out.println("2. Show Doctor Information");
        System.out.println("3. Search by Doctor's Specialization");
        System.out.println("4. Search");
        System.out.println("5. Save all doctor info in a file.");
        System.out.println("6. Exit");
        System.out.println("Enter your choice [1-6]: ");
    }

    public void control() {
        switch (input.nextInt()) {

            case 1:
                while (true) {
                    Doctor d = new Doctor();

                    System.out.println("Insert Doctor's Information");
                    System.out.print("Enter First name: ");
                    d.setFirstName(input.next());
                    System.out.print("Enter Last name: ");
                    d.setLastName(input.next());
                    System.out.print("Enter Address: ");
                    d.setAddress(input.next());
                    System.out.print("Enter Contact: ");
                    d.setContact(input.next());
                    try {

                        System.out.print("Enter Specialization: ");
                        d.setSpecialization(reader.readLine());
                        System.out.print("Enter current workplace: ");
                        d.setWorkplace(reader.readLine());
                    } catch (IOException ex) {
                        System.out.println(ex.getMessage());
                    }

                    doctorDAO.insert(d);

                    System.out.println("Do you want to add more [y/n] : ");
                    if (input.next().equalsIgnoreCase("n")) {
                        break;
                    }

                }
                break;

            case 2:
                System.out.println("***************************");
                for (Doctor d : doctorDAO.showAll()) {
                    System.out.println(d.toString());
                }
                System.out.println("***************************");

                break;

            case 3:
                System.out.println("***************************");
                System.out.println("Search By Specialization");

                System.out.print("Enter required Specialization: ");
                System.out.println("***************************");

                for (Doctor d : doctorDAO.searchBySpecialization(input.next())) {
                    System.out.println(d.toString());
                }
                System.out.println("***************************");

                break;

            case 4:
                System.out.println("***************************");
                System.out.println("Search");

                System.out.print("Enter search text: ");
                System.out.println("***************************");

                for (Doctor d : doctorDAO.search(input.next())) {
                    System.out.println(d.toString());
                }
                System.out.println("***************************");

                break;

            case 5:
                System.out.println("Enter file location to export: ");
                String location = input.next();

                System.out.println("Enter filename: ");
                String fileName = input.next();

                List<Doctor> list = doctorDAO.showAll();
                doctorDAO.export(location, fileName, list);

                break;

            case 6:
                System.exit(0);
                break;

        }
    }
}
