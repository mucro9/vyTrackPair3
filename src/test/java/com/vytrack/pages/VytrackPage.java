package com.vytrack.pages;


import com.vytrack.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class VytrackPage {

    public VytrackPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//li[@class='dropdown dropdown-level-1'][2]")
    public WebElement customersDropdown;

    @FindBy(xpath = "//span[.='Accounts']")
    public WebElement accountsButton;

    @FindBy(xpath = "//a[@class='action btn mode-icon-only']")
    public WebElement filterIcon;

    @FindBy(xpath = "//div[@class='filter-item oro-drop']")
    public static List<WebElement> filters;


}
