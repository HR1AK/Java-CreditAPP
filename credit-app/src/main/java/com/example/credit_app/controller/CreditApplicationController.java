package com.example.credit_app.controller;

import com.example.credit_app.entity.CreditApplication;
import com.example.credit_app.entity.CreditContract;
import com.example.credit_app.service.CreditApplicationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/applications")
public class CreditApplicationController {
    private final CreditApplicationService service;

    @Autowired
    private CreditApplicationService creditApplicationService;

    public CreditApplicationController(CreditApplicationService service){
        this.service = service;
    }

    @GetMapping
    public List<CreditApplication> getAllApplications() {
        return service.getAllApplications();
    }

    @GetMapping("/{id}")
    public Optional<CreditApplication> getApplicationById(@PathVariable Long id) {
        return service.getApplicationById(id);
    }

    @PostMapping
    public CreditApplication createApplication(@RequestBody CreditApplication application) {
        return service.saveApplication(application);
    }

    @DeleteMapping("/{id}")
    public void deleteApplication(@PathVariable Long id) {
        service.deleteApplication(id);
    }

    //для одобрения заявки
    @PutMapping("/{id}/process")
    public CreditContract processApplication(@PathVariable long id) {
        return creditApplicationService.processApplication(id);
    }

    @GetMapping("/search")
    public List<CreditApplication> searchApplications(
        @RequestParam(required = false) String phone,
        @RequestParam(required = false) String firstName,
        @RequestParam(required = false) String lastName,
        @RequestParam(required = false) String passport) {
        return creditApplicationService.searchApplications(phone, firstName, lastName, passport);
    }

    @GetMapping("/approved")
    public List<CreditApplication> getApprovedApplications() {
        return creditApplicationService.getApprovedApplications();
    }
}
