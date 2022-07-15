package com.cydeo.library.pages;

import com.cydeo.library.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

// page_url = https://library2.cydeo.com/#users
public class UsersPage extends BasePage{


    public UsersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(tagName = "th")     // or use xpath = "//th"
    public List<WebElement> usersTableHeader;

    // No page elements added

}