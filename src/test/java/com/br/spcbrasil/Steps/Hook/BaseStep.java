package com.br.spcbrasil.Steps.Hook;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseStep {
    protected static final String ANDROID = "android";
    protected static final String IOS = "ios";
    private static final String UNSUPPORTED_PLATFORM_ERROR = "Plataforma de desenvolvimento não suportada!";
    public static WebDriver Webdriver;
    public static WebDriverWait wait;
    public static AppiumDriver<MobileElement> driver;
}
