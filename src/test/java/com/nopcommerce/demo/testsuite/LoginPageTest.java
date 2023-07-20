package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.customlisteners.CustomListeners;
import com.nopcommerce.demo.pages.LoginPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    LoginPage loginPage;

    @BeforeMethod
    public void inIT() {

        loginPage = new LoginPage();

    }


    @Test
    public void verifyUserShouldNavigateToLoginPageSuccessfully() {
        loginPage.clickOnLoginLink();
        verifyText(loginPage.getWelcomeText(), "Welcome, Please Sign In!");
    }

    @Test
    public void verifyErrorMessageWithInvalidCredentials() {

        loginPage.clickOnLoginLink();
        loginPage.enterEmailId("Shweta123@gmail.com");
        loginPage.enterPassword("shwetasagar123");
        loginPage.clickOnLoginButton();

        verifyText(loginPage.getGetErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found");
    }


    @Test
    public void verifyThatUserShouldLogInSuccessFullyWithValidCredentials() {
        sleep(2000);
        loginPage.clickOnLoginLink();
        loginPage.enterEmailId("Shwetashah123@gmail.com");
        loginPage.enterPassword("Shweta123");
        loginPage.clickOnLoginButton();
        verifyText(loginPage.getLoginOutLink(), "Log out");


    }


    @Test
    public void VerifyThatUserShouldLogOutSuccessFully() {

        sleep(2000);
        loginPage.clickOnLoginLink();
        loginPage.enterEmailId("Shwetashah123@gmail.com");
        loginPage.enterPassword("Shweta123");
        loginPage.clickOnLoginButton();
        loginPage.clickOnLogoutLink();
        verifyText(loginPage.getLoginLink(),"Log in");


    }


}