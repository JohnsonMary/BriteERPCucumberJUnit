package com.cybertek.step_definitions;

import com.cybertek.pages.AllChannelsSalesOrdersPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AllChannelsSalesOrdersPageStepDefinitions {


    @Then("user clicks on a sales link, then All Channels Sales Orders link")
    public void user_clicks_on_a_sales_link_then_All_Channels_Orders_link() throws InterruptedException {
        AllChannelsSalesOrdersPage allChannelsSalesOrdersPage = new AllChannelsSalesOrdersPage();
        BrowserUtils.waitForVisibility(allChannelsSalesOrdersPage.salesMenu, 10);
        allChannelsSalesOrdersPage.salesMenu.click();
        Thread.sleep(8000);
        allChannelsSalesOrdersPage.allChannelsSalesOrdersLink.click();
    }

}
