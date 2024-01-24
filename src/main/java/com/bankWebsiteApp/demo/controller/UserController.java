package com.bankWebsiteApp.demo.controller;

import com.bankWebsiteApp.demo.dto.CombinedDTO;
import com.bankWebsiteApp.demo.dto.UserBankDTO;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.service.CombinedService;
import com.bankWebsiteApp.demo.service.UserService;
import com.bankWebsiteApp.demo.util.ResponseMessagesSuccessful;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accountUser")
public class UserController {

    private final UserService userService;
    private final CombinedService combinedService;

    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<ResponseMessagesSuccessful> createAccountUser (@RequestBody @Valid UserBank userBank) throws IllegalAccessException {
        UserBank createdUser = userService.CriarConta(userBank);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(ResponseMessagesSuccessful.userCreated(createdUser.getName()));
    }


    @GetMapping (value = "/MyAccont/{id}",produces = "application/json")
    public UserBankDTO consultInfo  (@PathVariable Long id) {
       UserBankDTO userBank = userService.ConsultAccountUser(id);
        return new ResponseEntity<>(userBank,HttpStatus.OK).getBody();
    }

    @GetMapping(value = "/{userId}", produces = "application/json")
    public ResponseEntity<CombinedDTO> getUserInfoById(@PathVariable Long userId) {
        CombinedDTO userDTO = combinedService.getUserInfoById(userId);
        if (userDTO == null) {
            return ResponseEntity.notFound().build(); // Handle user not found
        }
        return ResponseEntity.ok(userDTO);
    }
}