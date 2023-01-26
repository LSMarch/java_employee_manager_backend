package com.example.employee_manager.models;

import jakarta.persistence.*;

import java.io.Serializable;
@Entity
public class Employee implements Serializable {
    // Serializable transform class into diff types of stream
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String jobTitle;
    private String phoneNumber;
    private String imageURL;
    @Column(nullable = false, updatable = false)
    private String employeeCode;

    public Employee() {
    }

    public Employee(Long id,
                    String firstName, String lastName, String email, String jobTitle,
                    String phoneNumber, String imageURL, String employeeCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.jobTitle = jobTitle;
        this.phoneNumber = phoneNumber;
        this.imageURL = imageURL;
        this.employeeCode = employeeCode;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getImageURL() {
        return imageURL;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }
}
