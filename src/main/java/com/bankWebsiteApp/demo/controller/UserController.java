package com.bankWebsiteApp.demo.controller;

import com.bankWebsiteApp.demo.dto.UserBankDTO;
import com.bankWebsiteApp.demo.models.UserBank;
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


    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity<ResponseMessagesSuccessful> createAccountUser (@RequestBody @Valid UserBank userBank) throws IllegalAccessException {
        UserBank createdUser = userService.CriarConta(userBank);
        return ResponseEntity.status(HttpStatus.CREATED).
                body(ResponseMessagesSuccessful.userCreated(createdUser.getName()));
    }


    @GetMapping (value = "/consultInfo/{id}",produces = "application/json")
    public UserBankDTO consultInfo  (@PathVariable Long id) {
       UserBankDTO userBank = userService.ConsultAccountUser(id);
        return new ResponseEntity<>(userBank,HttpStatus.OK).getBody();
    }
}