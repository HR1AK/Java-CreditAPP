package com.example.credit_app.controller;

import com.example.credit_app.entity.CreditContract;
import com.example.credit_app.service.CreditApplicationService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contracts")
public class CreditContractController {
    private final CreditApplicationService creditApplicationService;

    public CreditContractController(CreditApplicationService service) {
        this.creditApplicationService = service;
    }

    // 4. Вывод всех подписанных кредитных договоров
    @GetMapping("/api/contracts/signed")
    public List<CreditContract> getSignedContracts() {
        return creditApplicationService.getSignedContracts();
    }
}