package com.cybertek.step_definitions;

import com.cybertek.pages.InvoicingPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import java.util.List;

public class Invoicing_Steps {


    @Given("user on the login page")
    public void user_on_the_login_page() {
             Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user logs in using these {string} and {string}")
    public void user_logs_in_using_these_and(String email, String password) throws InterruptedException {


        LoginPage loginPage = new LoginPage();
        loginPage.BriteErpLink.click();
        loginPage.signIn.click();
        loginPage.email.sendKeys(email);
        loginPage.password.sendKeys(password);
        loginPage.logInButton.click();

    }

    @Then("user clicks on a sales link, then Orders to Invoice link")
    public void user_clicks_on_a_sales_link_then_Orders_to_Invoice_link() throws InterruptedException {
        InvoicingPage invoicingPage = new InvoicingPage();
        BrowserUtils.waitForVisibility(invoicingPage.salesClick, 10);
        invoicingPage.salesClick.click();
        Thread.sleep(8000);
        invoicingPage.ordersToInvoice.click();

    }

    @When("user clicks on Order Number checkbox header")
    public void user_clicks_on_Order_Number_checkbox_header() {
        InvoicingPage invoicingPage = new InvoicingPage();
        BrowserUtils.waitForVisibility(invoicingPage.orderNumberCheckboxHeader, 8);
        invoicingPage.orderNumberCheckboxHeader.click();
    }


    @Then("user should be able to see print and action tabs")
    public void user_should_be_able_to_see_print_and_action_tabs() {
        InvoicingPage invoicingPage = new InvoicingPage();
        String Print = invoicingPage.printMenuTab.getText();
        String Action = invoicingPage.actionMenu.getText();
        Assert.assertTrue(Print.matches("Print"));
        Assert.assertTrue(Action.matches("Action"));
    }


    @Then("user clicks on action tab")
    public void user_clicks_on_tab(){
        InvoicingPage invoicingPage = new InvoicingPage();
        invoicingPage.actionMenu.click();
    }

    @Then("user should be able to see the following dropdown list")
    public void user_should_be_able_to_see_the_following_dropdown_lis(List < String > actionDropdownList) {

        InvoicingPage invoicingPage = new InvoicingPage();
        List <String > actionsList = BrowserUtils.getElementsText(invoicingPage.dropDownOptionsActions);
        Assert.assertTrue(actionsList.containsAll(actionDropdownList));

    }


    @Then("user clicks export dropdown list")
    public void user_clicks_export_dropdown_list(){
        InvoicingPage invoicingPage = new InvoicingPage();
        BrowserUtils.waitForVisibility(invoicingPage.exportDropDown, 10);
        invoicingPage.exportDropDown.click();
    }

    @Then("user should be able to see the following text")
    public void user_should_be_able_to_see_the_following_text(List <String> exportData) {

        InvoicingPage invoicingPage = new InvoicingPage();
        List <String > actionsList = BrowserUtils.getElementsText(invoicingPage.exportDataText);
        Assert.assertTrue(actionsList.containsAll(exportData));

    }


    @Then("user clicks on print tab")
    public void user_clicks_on_print_tab() {
        InvoicingPage invoicingPage = new InvoicingPage();
        BrowserUtils.waitForVisibility(invoicingPage.printMenuTab, 10);
        invoicingPage.printMenuTab.click();
    }


    @Then("user should be able to see the following dropdown menu")
    public void user_should_be_able_to_see_the_following_dropdown_list(List <String > quotationOrderDrop ) {
        InvoicingPage invoicingPage = new InvoicingPage();
        List <String > printList = BrowserUtils.getElementsText(invoicingPage.quotationOrderDropDown);
        Assert.assertTrue(printList.containsAll(quotationOrderDrop));

    }

}
