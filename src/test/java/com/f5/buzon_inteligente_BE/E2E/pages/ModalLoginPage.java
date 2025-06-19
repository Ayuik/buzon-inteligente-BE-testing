package com.f5.buzon_inteligente_BE.E2E.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModalLoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By modalTitleLocator = By.tagName("h3");
    private static final String EXPECTED_TITLE = "Login exitoso";

    public ModalLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String waitForModalTitle() {
        wait.until(d -> d.findElements(modalTitleLocator).stream()
                .map(WebElement::getText)
                .anyMatch(EXPECTED_TITLE::equals));

        return driver.findElements(modalTitleLocator).stream()
                .map(WebElement::getText)
                .filter(EXPECTED_TITLE::equals)
                .findFirst()
                .orElseThrow(
                        () -> new NoSuchElementException("El modal con texto '" + EXPECTED_TITLE + "' no apareció"));
    }
}
