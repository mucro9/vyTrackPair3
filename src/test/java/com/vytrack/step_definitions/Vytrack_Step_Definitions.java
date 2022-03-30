package com.vytrack.step_definitions;


import com.vytrack.pages.VytrackPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Vytrack_Step_Definitions {

    VytrackPage vytrackPage = new VytrackPage();

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env2"));
    }

    @When("user logins as a store manager.")
    public void user_logs_in_as_a_store_manager() {
        VytrackUtils.loginAsStoreManager();
        VytrackUtils.waitTillLoaderMaskDisappear();
    }

    @When("user clicks Customers dropdown.")
    public void user_clicks_customers_dropdown() {
        vytrackPage.customersDropdown.click();

    }

    @When("user clicks Accounts button.")
    public void user_clicks_accounts_button() {
        vytrackPage.accountButton.click();
    }

    @When("user clicks filter icon.")
    public void user_clicks_filter_icon() throws InterruptedException {
        vytrackPage.filterIcon.click();
    }

    @Then("user sees Account Name, Contact Name, Contact Email, Contact Phone, Owner, Business Unit, Created At, Updated At filter options")
    public void user_sees_account_name_contact_name_contact_email_contact_phone_owner_business_unit_created_at_updated_at_filter_options() {

        List<String> expectedFilters = Arrays.asList("Account Name","Contact Name","Contact Email","Contact Phone",
                "Owner","Business Unit","Created At","Updated At");

        Object[][] objData = new Object[1][1];
        objData[0][0]= expectedFilters;

       // List<WebElement> filters = Driver.getDriver().findElements(By.xpath("//div[@class='filter-item oro-drop']"));
        List<WebElement> filters = vytrackPage.filters;
        for (int i = 0; i < expectedFilters.size(); i++) {
            System.out.println(filters.get(i).getText());
            String[] filter= filters.get(i).getText().split(":");
            String actualFilter = filter[0].toString();
            assertEquals(actualFilter,expectedFilters.get(i));
        }
    }

}


