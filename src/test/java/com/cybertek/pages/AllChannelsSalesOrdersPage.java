package com.briteErp.pages;

import com.briteErp.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AllChannelsSalesOrdersPage {
    public AllChannelsSalesOrdersPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(linkText = "Sales")
    public WebElement salesMenu;

    @FindBy(linkText = "Dashboards")
    public WebElement dashboardsMenu;

    @FindBy(partialLinkText = "All Channels Sales Orders")
    public WebElement allChannelsSalesOrdersLink;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/button")
    public WebElement measuresMenu;

    @FindBy(linkText = "Price Subtotal")
    public WebElement priceSubtotal;

    @FindBy(linkText = "Total")
    public WebElement total;

    @FindBy(linkText = "Product Quantity")
    public WebElement productQuantity;

    @FindBy(linkText = "Count")
    public WebElement count;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/button[1]")
    public WebElement flipAxis;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/button[2]")
    public WebElement expandAll;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/button[3]")
    public WebElement download;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/span")
    public WebElement advancedSearch;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/button")
    public WebElement filters;

    @FindBy(linkText = "Current Year Sales")
    public WebElement currentYearSales;

    @FindBy(linkText = "Add Custom Filter")
    public WebElement addCustomFilter;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/button")
    public WebElement groupByMenu;

    @FindBy(linkText = "Sales Channel")
    public WebElement salesChannel;

    @FindBy(linkText = "Add custom group")
    public WebElement addCustomGroup;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/button")
    public WebElement favorites;

    @FindBy(linkText = "Save current search")
    public WebElement saveCurrentSearch;

    @FindBy(linkText = "Add to my Dashboard")
    public WebElement addToMyDashboard;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/ol/li")
    public WebElement allChannelsSalesOrdersTitle;

    @FindBy(xpath = "//li[@class='o_save_name']/input[1]")
    public WebElement favoritesText;

    @FindBy(xpath = "//input[@class='o_add_to_dashboard_input']")
    public WebElement dashboardText;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm']")
    public WebElement favoritesSaveButton;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-sm o_add_to_dashboard_button']")
    public WebElement dasboardAddButton;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/ul/li[4]/select")
    public WebElement groupBySelect;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[2]/ul/li[5]/button")
    public WebElement groupBySaveButton;


}
