package com.f5.buzon_inteligente_BE.E2E.base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.f5.buzon_inteligente_BE.E2E.pages.LoginPage;
import com.f5.buzon_inteligente_BE.E2E.pages.ModalLoginPage;

public abstract class BaseTest {

    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ModalLoginPage modalLoginPage;

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:5173/");
        loginPage = new LoginPage(driver);
        modalLoginPage = new ModalLoginPage(driver);
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
