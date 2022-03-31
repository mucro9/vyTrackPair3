package com.vytrack.step_definitions;


import com.vytrack.pages.VytrackPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.Driver;
import com.vytrack.utilities.VytrackUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Filters_Step_Definitions {

    VytrackPage vytrackPage = new VytrackPage();

    @Given("user is on the login page")
    public void userIsOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env1"));
    }

    @When("user logins as a store manager")
    public void user_logs_in_as_a_store_manager() {
        VytrackUtils.loginAsStoreManager();
        VytrackUtils.waitTillLoaderMaskDisappear();
    }

    @When("user clicks Customers dropdown")
    public void user_clicks_customers_dropdown() {
        vytrackPage.customersDropdown.click();


    }

    @When("user clicks Accounts button")
    public void user_clicks_accounts_button() {
        vytrackPage.accountsButton.click();
    }

    @When("user clicks filter icon")
    public void user_clicks_filter_icon() {
        vytrackPage.filterIcon.click();
    }


    @Then("user should see filter options")
    public void userShouldSeeFilterOptions(List<String> expectedFilters) {

        List<String> actualFilters = VytrackUtils.actualFilterAsString(expectedFilters);

        List<WebElement> filters = VytrackPage.filters;
        List<String> actualFiltersAsString = new ArrayList<>();
        for (int i = 0; i < expectedFilters.size(); i++) {
            String[] filter = filters.get(i).getText().split(":");
            String actualFilter = filter[0].toString();
            Assert.assertEquals(expectedFilters.get(i), actualFilter);
        }

    }
}


