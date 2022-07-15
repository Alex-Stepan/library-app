package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.LandingPage;
import com.cydeo.library.pages.LoginPage;
import com.cydeo.library.utilities.BrowserUtil;
import com.cydeo.library.utilities.ConfigurationReader;
import com.cydeo.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login_StDf {

    LoginPage loginPage = new LoginPage();
    LandingPage landingPage = new LandingPage();

    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);



    @Given("I am on the login page")
    public void i_am_on_the_login_page() {
        Driver.getDriver().get( ConfigurationReader.getProperty("qa2_url") );
    }


    /** @librarian */
    @When("I login as a librarian")
    public void i_login_as_a_librarian() {
        loginPage.inputUsername.sendKeys( ConfigurationReader.getProperty("lib22_user") );
        loginPage.inputPassword.sendKeys( ConfigurationReader.getProperty("lib22_pass"));
        loginPage.signinButton.click();
    }

    @Then("dashboard should be displayed")
    public void dashboard_should_be_displayed() {
//        BrowserUtil.waitForPageToLoad(10);
        String expURL = "dashboard";

        wait.until(ExpectedConditions.urlContains(expURL));

        String actURL = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(
                "\"dashboard\" does not appear on the URL !" ,
                actURL.contains( expURL )
        );

    }


    /** @student */
    @When("I login as a student")
    public void i_login_as_a_student() {
        loginPage.inputUsername.sendKeys( ConfigurationReader.getProperty("student55_user") );
        loginPage.inputPassword.sendKeys( ConfigurationReader.getProperty("student55_pass"));
        loginPage.signinButton.click();
    }

    @Then("books should be displayed")
    public void books_should_be_displayed() {
        String expURL = "books";

        wait.until(ExpectedConditions.urlContains(expURL));

        String actURL = Driver.getDriver().getCurrentUrl();


        Assert.assertTrue(
                "\"books\" does not appear on the URL !" ,
                actURL.contains( expURL )
        );
    }


    //--------------------------------------------------------------------------------------

        //@librarianParam
    @When("I enter username {string}")
    public void i_enter_username(String username) {
        loginPage.inputUsername.sendKeys(username);
    }
    @When("I enter password {string}")
    public void i_enter_password(String password) {
        loginPage.inputPassword.sendKeys(password);
    }
    @When("click the sign in button")
    public void click_the_sign_in_button() {
        loginPage.signinButton.click();
    }

    @When("there should be {string} users")
    public void there_should_be_users(String expUserCount) {

        BrowserUtil.waitForVisibility(landingPage.userCount, 10);
        String actUserCount = landingPage.userCount.getText();
//        String actUSerCount = String.valueOf(expUserCount);
        Assert.assertEquals("The user count is not matching ! FAIL", expUserCount, actUserCount);
    }



}
