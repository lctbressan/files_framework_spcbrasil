package com.braziltest;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
public class Grid2 {
    WebDriver driver;
    String baseUrl, nodeUrl;

    @BeforeTest
    public void setup() throws MalformedURLException {
        baseUrl="https://192.168.15.1/";
        nodeUrl = "http://10.10.0.5:5557/wd/hub";
                DesiredCapabilities cap = DesiredCapabilities.firefox();
        cap.setBrowserName("firefox");
        cap.setPlatform(Platform.WIN10);
                driver = new RemoteWebDriver(new URL(nodeUrl),cap);

    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    @Test
    public void simpleTest(){
        driver.get(baseUrl);

    }
}
