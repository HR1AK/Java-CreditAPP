package com.example.credit_app.entity;

import jakarta.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name = "credit_contracts")
public class CreditContract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "application_id")
    private CreditApplication application;

    private boolean signingStatus;
    private LocalDate signingDate;

    private int loanTerm;  
    private double loanAmount; 

    public CreditContract(){}
    public CreditContract(CreditApplication application, boolean signingStatus, LocalDate signingDate, int loanTerm, double loanAmount){
        this.application = application;
        this.signingStatus = signingStatus;
        this.signingDate = signingDate;
        this.loanTerm = loanTerm;
        this.loanAmount = loanAmount;
    }

    public Long getId() {return id;}
    public void setId(Long id){this.id = id;}

    public CreditApplication getApplication() {return application;}
    public void setApplication(CreditApplication application){this.application = application;}

    public boolean getSigningStatus() {return signingStatus;}
    public void setSigningStatus(boolean signingStatus){this.signingStatus = signingStatus;}

    public LocalDate getSigningDate() {return signingDate;}
    public void setSigningDate(LocalDate signingDate){this.signingDate = signingDate;}

    public int getLoanTerm() { return loanTerm; }
    public void setLoanTerm(int loanTerm) { this.loanTerm = loanTerm; }

    public double getLoanAmount() { return loanAmount; }
    public void setLoanAmount(double loanAmount) { this.loanAmount = loanAmount; }
}
