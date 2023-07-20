package com.nopcommerce.demo.testsuite;

import com.nopcommerce.demo.pages.RegisterPage;
import com.nopcommerce.demo.testbase.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegisterPageTest extends BaseTest {

    RegisterPage registerPage;


    @BeforeMethod
    public void inIT() {
        registerPage = new RegisterPage();
    }

    @Test
    public void verifyUserShouldNavigateToRegisterPageSuccessfully() {
        sleep(2000);
        registerPage.clickOnRegisterLink();
        verifyText(registerPage.getRegisterText(), "Register");

    }

    @Test
    public void verifyThatFirstNameLastNameEmailPasswordAndConfirmPasswordFieldsAreMandatory() {
        sleep(2000);
        registerPage.clickOnRegisterLink();
        registerPage.clickOnRegisterButton();
        verifyText(registerPage.getFirstNameError(), "First name is required.");
        verifyText(registerPage.getLastNameError(), "Last name is required.");
        verifyText(registerPage.getEmailError(), "Email is required.");
        verifyText(registerPage.getPasswordRequired(), "Password is required.");
        verifyText(registerPage.getConfirmPasswordRequired(), "Password is required.");

    }

    @Test
    public void VerifyThatUserShouldCreateAccountSuccessfully() {

        registerPage.clickOnRegisterLink();
        registerPage.clickOnGender();
        registerPage.setFirstName("Shweta");
        registerPage.setLastName("Shah");
        registerPage.selectFromDropDownDay("28");
        registerPage.selectFromDropDownMonth("September");
        registerPage.selectFromDropDownYear("1983");
        registerPage.setEmail("shweta.shah123@gmail.com");
        registerPage.setPassword("shweta123456");
        registerPage.setConfirmPasswordPassword1("shweta123456");
        registerPage.clickOnregister();



    }


}
