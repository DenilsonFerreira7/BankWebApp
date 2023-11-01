package com.bankWebsiteApp.demo.controller;

import com.bankWebsiteApp.demo.dto.CombinedDTO;
import com.bankWebsiteApp.demo.service.CombinedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController

@RequestMapping("/user")
public class UserBankInfos {

    private final CombinedService combinedService;

//CONCERTAR RETORNO
    @GetMapping(value = "/consult/{id}", produces = "application/json")
    public ResponseEntity<CombinedDTO> getCombinedData(@PathVariable Long id) {
        CombinedDTO combinedData = combinedService.getCombinedDataById(id);
        return ResponseEntity.ok(combinedData);
    }
}

