package com.f5.buzon_inteligente_BE.E2E;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginE2ETest extends BaseTest {

    @Test
    @DisplayName("Should load HomePage")
    void test_should_load_homepage(){

        List<WebElement> buttonElements = driver.findElements(By.tagName("button"));

        assertThat(buttonElements, hasSize(2));
        assertThat(buttonElements.stream().anyMatch(x -> x.getText().equals("Iniciar sesión")), is(true));
        assertThat(buttonElements.stream().anyMatch(x -> x.getText().equals("Registrarse")), is(true));
    }


}
