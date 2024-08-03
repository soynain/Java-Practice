package com.crudspringboot.main.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.crudspringboot.main.Automators.itsx.SeleniumItsx;
import com.crudspringboot.main.Services.UserService;

import java.time.Duration;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
    SeleniumItsx driverItsx;

    @Value("${my.correo}")
    String myCorreo;
    @Value("${my.passcon}")
    String myPass;

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

        logger.info(myCorreo);

        driverItsx.webDriver.findElement(By.name("username")).sendKeys(myCorreo);
        driverItsx.webDriver.findElement(By.name("password")).sendKeys(myPass);

        driverItsx.webDriver.findElement(By.cssSelector(".btn.btn-lg.btn-primary.btn-block")).click();

        WebDriverWait wait = new WebDriverWait(driverItsx.webDriver, Duration.ofSeconds(20));
            boolean containsTramites = wait.until(ExpectedConditions.or(
                ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Trámites")
            ));

            if (containsTramites) {
                return ResponseEntity.ok()
                .body(driverItsx.webDriver.getPageSource());
            } else {
                return ResponseEntity.internalServerError()
                .body("Hubo un error al iniciar sesion en el itsx");
            }
    }
}
