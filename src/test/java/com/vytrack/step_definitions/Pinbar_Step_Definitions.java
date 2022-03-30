package com.vytrack.step_definitions;

import com.vytrack.pages.LoginPage;
import com.vytrack.pages.PinbarPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.vyTrackUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Pinbar_Step_Definitions {
    LoginPage loginPage = new LoginPage();
    PinbarPage pinbarPage = new PinbarPage();

    @When("user enter  username {string} and password {string}")
    public void user_enter_username_and_password(String username, String password) {
       loginPage.login(username,password);
    }
    @Then("user should be on the homepage")
    public void user_should_be_on_the_homepage() {
       // Assert.assertTrue(Driver.getDriver().getTitle().equals("Dashboard"));//Verifying dashboard title
    }
    @Then("user click the “Learn how to use this space”")
    public void users_click_the_learn_how_to_use_this_space() {
       BrowserUtils.sleep(3);
        pinbarPage.pinbarLink.click();
    }
    @Then("users should see: “How To Use Pinbar”  and “Use pin icon on the right top corner of the page to create fast access link in the pinbar.”")
    public void users_should_see_how_to_use_pinbar_and_use_pin_icon_on_the_right_top_corner_of_the_page_to_create_fast_access_link_in_the_pinbar() {
        Assert.assertTrue(pinbarPage.howToUsePinbarText.isDisplayed());
        Assert.assertTrue(pinbarPage.fastAccessLongText.isDisplayed());
        BrowserUtils.sleep(3);
        loginPage.logout();
    }

    @Then("user see an pinbar image")
    public void user_see_an_pinbar_image() {
        BrowserUtils.sleep(3);
        Assert.assertTrue(pinbarPage.pinBarImage.isDisplayed());
        loginPage.logout();
    }

}
