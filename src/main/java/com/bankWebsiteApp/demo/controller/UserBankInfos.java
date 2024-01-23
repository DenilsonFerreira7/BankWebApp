package com.bankWebsiteApp.demo.controller;

import com.bankWebsiteApp.demo.dto.CombinedDTO;
import com.bankWebsiteApp.demo.mapper.DtoMapper;
import com.bankWebsiteApp.demo.models.Balance;
import com.bankWebsiteApp.demo.models.CardUser;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.service.BalanceService;
import com.bankWebsiteApp.demo.service.CardUserService;
import com.bankWebsiteApp.demo.service.CombinedService;
import com.bankWebsiteApp.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequiredArgsConstructor
@RestController

@RequestMapping("/user")
public class UserBankInfos {

private final CombinedService combinedService;

    @GetMapping("/{userId}")
    public ResponseEntity<CombinedDTO> getUserInfoById(@PathVariable Long userId) {
        CombinedDTO userDTO = combinedService.getUserInfoById(userId);
        if (userDTO == null) {
            return ResponseEntity.notFound().build(); // Handle user not found
        }
        return ResponseEntity.ok(userDTO);
    }
}
