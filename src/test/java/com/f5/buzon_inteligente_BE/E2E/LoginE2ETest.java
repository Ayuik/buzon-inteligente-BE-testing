package com.f5.buzon_inteligente_BE.E2E;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.springframework.test.context.ActiveProfiles;

import com.f5.buzon_inteligente_BE.E2E.base.BaseTest;

@ActiveProfiles("test")
public class LoginE2ETest extends BaseTest {

    @Test
    @DisplayName("User should log in and reach user dashboard")
    void userShouldLogInAndSeeSuccessModal() {
   
        loginPage.goToLoginPage();
        loginPage.loginAs("bobesponja@example.com", "bob12345");

        String modalTitle = modalLoginPage.waitForModalTitle();
        assertThat(modalTitle, equalTo("Login exitoso"));
    }
}
