package com.vytrack.step_definitions;
import com.vytrack.pages.LoginPage;
import com.vytrack.pages.PinbarPage;
import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class Pinbar_Step_Definitions {
    LoginPage loginPage = new LoginPage();//Created an object from login page (POM)
    PinbarPage pinbarPage = new PinbarPage();//Created an object from pinbar page(POM)

    @When("user enter  username {string} and password {string}")
    public void user_enter_username_and_password(String username, String password) {
       loginPage.login(username,password); //Login method from login page
    }
    @Then("user should be on the homepage")
    public void user_should_be_on_the_homepage() {
        Assert.assertTrue(Driver.getDriver().getTitle().equals("Dashboard")); //Verifying  user is on the  dashboard by  title
    }
    @Then("user click the “Learn how to use this space”")
    public void users_click_the_learn_how_to_use_this_space() {
       BrowserUtils.sleep(3);//Application is not stable that's why we used Browser.utils
        pinbarPage.pinbarLink.click(); //Clicking pinbar link
    }
    @Then("users should see: “How To Use Pinbar”  and “Use pin icon on the right top corner of the page to create fast access link in the pinbar.”")
    public void users_should_see_how_to_use_pinbar_and_use_pin_icon_on_the_right_top_corner_of_the_page_to_create_fast_access_link_in_the_pinbar() {
        Assert.assertTrue(pinbarPage.howToUsePinbarText.isDisplayed()); //Verifying first text is Displayed ?
        Assert.assertTrue(pinbarPage.fastAccessLongText.isDisplayed()); //Verifying second text is Displayed ?
        BrowserUtils.sleep(3);
        loginPage.logout();//Once is completed one turn will log out, in order to log in with new different credentials since we used Scenario Outline
    }

    @Then("user see an pinbar image")//Second Scenario, since some  steps the same as first scenario will repeat them first then this.
    public void user_see_an_pinbar_image() {
        BrowserUtils.sleep(3);
        Assert.assertTrue(pinbarPage.pinBarImage.isDisplayed());//Verifying pinbar picture is Displayed
        loginPage.logout();//Then will log out and will log in with different credentials
    }

}
