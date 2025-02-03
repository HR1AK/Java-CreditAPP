package com.example.credit_app.service;

import com.example.credit_app.entity.CreditApplication;
import com.example.credit_app.entity.CreditContract;
import com.example.credit_app.repository.CreditApplicationRepository;
import com.example.credit_app.repository.CreditContractRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class CreditApplicationService {
    private final CreditApplicationRepository creditApplicationRepository;
    private final CreditContractRepository creditContractRepository;

    private Random random = new Random();

    public CreditApplicationService(CreditApplicationRepository creditApplicationRepository, CreditContractRepository creditContractRepository) {
        this.creditApplicationRepository = creditApplicationRepository;
        this.creditContractRepository = creditContractRepository;
    }

    public List<CreditApplication> getAllApplications(){
        return creditApplicationRepository.findAllApplications();
    }

    public Optional<CreditApplication> getApplicationById(Long id){
        return Optional.ofNullable(creditApplicationRepository.findById(id));
    }

    public CreditApplication saveApplication(CreditApplication application) {
        creditApplicationRepository.save(application);
        return application;
    }

    public void deleteApplication(Long id){
        creditApplicationRepository.delete(id);
    }

    public List<CreditApplication> searchApplications(String phone, String firstName, String lastName, String passport) {
        return creditApplicationRepository.findByPhoneNumberOrFirstNameOrLastNameOrPassportNumber(phone, firstName, lastName, passport);
    }

    public List<CreditApplication> getApprovedApplications() {
        return creditApplicationRepository.findByApprovedTrue();
    }

    public List<CreditContract> getSignedContracts() {
        return creditContractRepository.findBySigningStatus(false);
    }


    //для одобрения заявки
    public CreditContract processApplication(long applicationId){
        CreditApplication application = creditApplicationRepository.findById(applicationId);
        if(application == null) {
            throw new RuntimeException("Application not found");
        }
        boolean approved = random.nextBoolean();
        CreditContract contract = null;

        if(approved){
            application.setApproved(approved);
            int loanTerm = random.nextInt(12) + 1;
            double loanAmount = application.getRequestedAmount() * (random.nextDouble() * 0.5 + 0.5);

            contract = new CreditContract(
                application,
                false,
                null,
                loanTerm,
                loanAmount
            );
            creditContractRepository.save(contract);
        }
        return contract; 
    }
}
