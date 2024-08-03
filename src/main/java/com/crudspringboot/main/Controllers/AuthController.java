package com.crudspringboot.main.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.crudspringboot.main.Automators.itsx.SeleniumItsx;
import com.crudspringboot.main.Services.UserService;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RestController()
@RequestMapping("/api")
public class AuthController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    UserService userService;

    @Autowired
    SeleniumItsx driverItsx;

    @PostMapping("login")
    public ResponseEntity<String> postMethodName(@RequestBody Map<String, Object> payload) {
        logger.info(payload.toString());
        
        return ResponseEntity.ok()
        .body("Custom header set");
    }

    @GetMapping("testing")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok().body("SI");
    }

    @GetMapping("login-to-itsx")
    public ResponseEntity<String> loginToItsx(){
        logger.info("ENTRANDO AL ENDPOINT DE SELENIUM");

        driverItsx.webDriver.get("https://gaatx.itsx.edu.mx/auth/login");

        String titlePage=driverItsx.webDriver.getTitle();

        driverItsx.closeWindow();

        return ResponseEntity.ok()
        .body(titlePage);
    }
    
    
}
