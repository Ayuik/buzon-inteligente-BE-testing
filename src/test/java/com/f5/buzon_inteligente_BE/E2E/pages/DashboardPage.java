package com.f5.buzon_inteligente_BE.E2E.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private static final By LOGOUT_LINK = By.xpath("//a[normalize-space(text())='Cerrar sesión']");
    private static final String EXPECTED_URL = "/user/packages";
    private static final By MENU_TOGGLE_BUTTON = By.cssSelector("button.cursor-pointer");
    private static final By mobileMenu = By.cssSelector("ul[data-testid='mobile-menu']");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void waitForDashboardToLoad() {
        wait.until(ExpectedConditions.urlContains(EXPECTED_URL));
    }

    public void logout() {
        waitForDashboardToLoad();

        wait.until(ExpectedConditions.presenceOfElementLocated(LOGOUT_LINK));
        wait.until(ExpectedConditions.visibilityOfElementLocated(LOGOUT_LINK));
        wait.until(ExpectedConditions.elementToBeClickable(LOGOUT_LINK));

        WebElement logoutElement = driver.findElement(LOGOUT_LINK);
        logoutElement.click();
    }

    public boolean isLoggedOut() {
        return driver.getCurrentUrl().contains("/login") ||
                driver.getPageSource().contains("Iniciar sesión");
    }

    public void logoutMobile() {        
        waitForDashboardToLoad();

        WebElement menuButton = wait.until(ExpectedConditions.elementToBeClickable(MENU_TOGGLE_BUTTON));
        menuButton.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileMenu));

        WebElement logoutElement = wait.until(ExpectedConditions.presenceOfElementLocated(LOGOUT_LINK));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({ behavior: 'auto', block: 'center' });", logoutElement);

        //wait.until(ExpectedConditions.elementToBeClickable(logoutElement));

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }     

        js.executeScript("arguments[0].click();", logoutElement);
    }
}

