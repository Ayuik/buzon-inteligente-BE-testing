package com.f5.buzon_inteligente_BE.E2E;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.springframework.test.context.ActiveProfiles;

import com.f5.buzon_inteligente_BE.E2E.base.BaseTest;

@ActiveProfiles("test")
public class LogoutE2EMobileTest extends BaseTest {
    
    @Test
    @DisplayName(" User should logout suscessfully in mobile view using scroll")
    void testUserShouldLogoutSuccessfullyInMobileView() {

        driver.manage().window().setSize(new Dimension(593, 824));

        loginPage.loginAs("bobesponja@example.com", "bob12345");
        modalLoginPage.waitForModalTitle();
        modalLoginPage.closeModal();

        dashboardPage.logoutMobile();

        assertThat(dashboardPage.isLoggedOut()).isTrue();
    }
    }





