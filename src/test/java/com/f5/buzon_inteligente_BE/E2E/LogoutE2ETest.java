package com.f5.buzon_inteligente_BE.E2E;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.f5.buzon_inteligente_BE.E2E.base.BaseTest;

public class LogoutE2ETest extends BaseTest {
    @Test
    @DisplayName("User should be able to logout and return to login screen")
    void userShouldLogoutSuccessfully() {
        loginPage.loginAs("bobesponja@example.com", "bob12345");

        modalLoginPage.waitForModalTitle();
        modalLoginPage.closeModal();

        dashboardPage.waitForDashboardToLoad();
        dashboardPage.logout();

        assertThat(dashboardPage.isLoggedOut()).isTrue();
    }

}