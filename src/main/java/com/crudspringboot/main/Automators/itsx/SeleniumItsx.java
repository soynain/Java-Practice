package com.crudspringboot.main.Automators.itsx;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.stereotype.Component;

@Component
public class SeleniumItsx {
    public WebDriver webDriver;
    public SeleniumItsx(){
        FirefoxOptions optionsConf = new FirefoxOptions();
     //   optionsConf.addArguments("--headless");
        this.webDriver = new FirefoxDriver(optionsConf);
        this.webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void closeWindow(){
        this.webDriver.close();
    }
}
