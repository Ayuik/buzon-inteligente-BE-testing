package com.f5.buzon_inteligente_BE.E2E;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.time.Duration;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class LoginE2ETest extends BaseTest {

    @Test
    @DisplayName("Should load HomePage")
    void test_should_load_homepage(){

        List<WebElement> buttonElements = driver.findElements(By.tagName("button"));

        assertThat(buttonElements, hasSize(2));
        assertThat(buttonElements.stream().anyMatch(x -> x.getText().equals("Iniciar sesión")), is(true));
        assertThat(buttonElements.stream().anyMatch(x -> x.getText().equals("Registrarse")), is(true));
    }

    @Test
    @DisplayName("Should login as bobesponja@example.com")
    void test_should_login_as_bobesponja() throws InterruptedException {

       List<WebElement> buttonElements = driver.findElements(By.tagName("button"));

       WebElement loginButton = buttonElements.stream()
                     .filter(button -> button.getText().equals("Iniciar sesión"))
                     .findFirst()
                     .get();

       loginButton.click();

       WebElement emailField = driver.findElement(By.name("email"));
       WebElement passwordField = driver.findElement(By.name("password"));

       emailField.sendKeys("bobesponja@example.com");
       passwordField.sendKeys("bob12345");

       WebElement sendButton = driver.findElement(By.id("submit-button"));
       sendButton.click();

       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("h3")));

       WebElement successModal = driver.findElement(By.tagName("h3"));
              
       assertThat(successModal.getText(), is(equalTo("Login exitoso")));
    }
}
