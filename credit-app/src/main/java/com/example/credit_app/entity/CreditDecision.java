// package com.example.credit_app.entity;

// import  jakarta.persistence.*;

// @Entity
// @Table(name = "credit_decisions")
// public class CreditDecision {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private boolean approved;
//     private int loanTerm;
//     private double approvedAmount;

//     @ManyToOne
//     @JoinColumn(name = "application_id")
//     private CreditApplication application;

//     public CreditDecision(){}
    
//     public CreditDecision(boolean approved, int loanTerm, double approvedAmount, CreditApplication application){
//         this.approved = approved;
//         this.loanTerm = loanTerm;
//         this.approvedAmount = approvedAmount;
//         this.application = application;
//     }

//     // Геттеры сеттеры
//     public Long getId() {return id;}
//     public void setId(Long id){this.id = id;}

//     public boolean getApproved() {return approved;}
//     public void setApproved(boolean approved){this.approved = approved;}

//     public int getLoanTerm() {return loanTerm;}
//     public void setLoanTerm(int loanTerm){this.loanTerm = loanTerm;}

//     public double getApprovedAmount() {return approvedAmount;}
//     public void setApprovedAmount(int approvedAmount){this.approvedAmount = approvedAmount;}

//     public CreditApplication getApplication() {return application;}
//     public void setApplication(CreditApplication application){this.application = application;}
// }
