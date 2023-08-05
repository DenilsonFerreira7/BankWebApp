package com.bankWebsiteApp.demo.controller;
import com.bankWebsiteApp.demo.models.UserBank;
import com.bankWebsiteApp.demo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/accountUser")
public class UserController {

    private final UserService userService;


    @PostMapping(value = "/create", produces = "application/json")
    public ResponseEntity <String> createAccount (@RequestBody UserBank userBank){
        userService.CriarConta(userBank);
        return ResponseEntity.status(HttpStatus.CREATED).body("CREATED");
    }

    @GetMapping (value = "/consultInfo/{id}",produces = "application/json")
    public ResponseEntity<UserBank> consultInfo  (@PathVariable Long id) {
       UserBank userBank = userService.ConsultAccountUser(id);
        return new ResponseEntity<>(userBank,HttpStatus.OK);
    }
}