package com.cydeo.library.step_definitions;

import com.cydeo.library.pages.BasePage;
import com.cydeo.library.pages.UsersPage;
import com.cydeo.library.utilities.BrowserUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UsersTable_StDf {

    UsersPage usersPage = new UsersPage();


    @Given("click on {string} link")
    public void click_on_link(String link) {

        BrowserUtil.waitForVisibility(usersPage.dashboardLink, 10);

        switch (link.toLowerCase()){
            case "dashboard":
                usersPage.dashboardLink.click();
                break;
            case "users":
                usersPage.usersLink.click();
                break;
            case "books":
                usersPage.booksLink.click();
                break;
            default:
                System.out.println("You selected wrong Link!");
        }
    }


    @Then("table should have following columns names:")
    public void table_should_have_following_columns_names(List<WebElement> expTableHeader) {
        List<String> actTableHeader = BrowserUtil.getElementsText(usersPage.usersTableHeader);
        Assert.assertEquals(expTableHeader, actTableHeader);
    }



}
