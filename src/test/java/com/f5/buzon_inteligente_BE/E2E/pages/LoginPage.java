package com.f5.buzon_inteligente_BE.E2E.pages;

import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private final WebDriver driver;

    private static final By BUTTONS = By.tagName("button");
    private static final String LOGIN_TEXT = "Iniciar sesión";
    private static final By EMAIL_INPUT = By.name("email");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By SUBMIT_BUTTON = By.id("submit-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void goToLoginPage() {
        driver.get("http://localhost:5173/");

        WebElement loginBtn = driver.findElements(BUTTONS)
                .stream()
                .filter(b -> LOGIN_TEXT.equals(b.getText()))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Botón '" + LOGIN_TEXT + "' no encontrado"));

        loginBtn.click();
    }

    public void enterEmail(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void submitLogin() {
        driver.findElement(SUBMIT_BUTTON).click();
    }

    public void loginAs(String email, String password) {
        goToLoginPage();
        enterEmail(email);
        enterPassword(password);
        submitLogin();
    }
}
