package com.example.credit_app.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "credit_applications")
public class CreditApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String firstName;
    private String lastName;
    private String middleName;
    private String passportNumber;
    private String maritalStatus;
    private String registrationAddress;
    private String phoneNumber;
    private String employmentInfo;
    private double requestedAmount;
    private LocalDate applicationDate;
    private boolean approved;

    public CreditApplication() {}

    public CreditApplication(String firstName, String lastName, String middleName,
                             String passportNumber, String maritalStatus, String registrationAddress,
                             String phoneNumber, String employmentInfo, double requestedAmount,
                             LocalDate applicationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.passportNumber = passportNumber;
        this.maritalStatus = maritalStatus;
        this.registrationAddress = registrationAddress;
        this.phoneNumber = phoneNumber;
        this.employmentInfo = employmentInfo;
        this.requestedAmount = requestedAmount;
        this.applicationDate = applicationDate;
        this.approved = false;
    }

    public Long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getMiddleName() { return middleName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }

    public String getPassportNumber() { return passportNumber; }
    public void setPassportNumber(String passportNumber) { this.passportNumber = passportNumber; }

    public String getMaritalStatus() { return maritalStatus; }
    public void setMaritalStatus(String maritalStatus) { this.maritalStatus = maritalStatus; }

    public String getRegistrationAddress() { return registrationAddress; }
    public void setRegistrationAddress(String registrationAddress) { this.registrationAddress = registrationAddress; }

    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }

    public String getEmploymentInfo() { return employmentInfo; }
    public void setEmploymentInfo(String employmentInfo) { this.employmentInfo = employmentInfo; }

    public double getRequestedAmount() { return requestedAmount; }
    public void setRequestedAmount(double requestedAmount) { this.requestedAmount = requestedAmount; }

    public LocalDate getApplicationDate() { return applicationDate; }
    public void setApplicationDate(LocalDate applicationDate) { this.applicationDate = applicationDate; }

    public boolean getApproved() { return approved; }
    public void setApproved(boolean approved) { this.approved = approved; }
}
