/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.dis.entity;

/**
 *
 * @author user
 */
public class Doctor {
    
    private String firstName,lastName,address,specialization,workplace,contact;

    public Doctor() {
    }

    public Doctor(String firstName, String lastName, String address, String specialization, String workplace, String contact) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.specialization = specialization;
        this.workplace = workplace;
        this.contact = contact;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    @Override
    public String toString() {
        return "Doctor{" + "firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", specialization=" + specialization + ", workplace=" + workplace + ", contact=" + contact + '}';
    }
    
    public String toCSV() {
        return firstName + "," + lastName + "," + address + "," +contact + "," +specialization  + "," +  workplace +"\n" ;
    }
    
}
