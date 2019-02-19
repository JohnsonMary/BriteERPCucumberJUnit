package com.cybertek.step_definitions;

import com.cybertek.pages.LoginPage;
import com.cybertek.pages.ProductPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import java.util.List;

public class Product_step_definitions {

    @Given("user on login page")
    public void user_on_login_page() {

        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @When("user logs in using {string} and {string}")
    public void user_logs_in_using_and(String email, String password) {

        LoginPage loginPage = new LoginPage();
        loginPage.BriteErpLink.click();
        loginPage.signIn.click();
        loginPage.email.sendKeys(email);
        loginPage.password.sendKeys(password);
        loginPage.logInButton.click();

    }

    @Then("user clicks on sales link,then products link")
    public void user_clicks_on_sales_link_then_products_link() throws InterruptedException {

        ProductPage productPage = new ProductPage();
        BrowserUtils.waitForClickablility(productPage.salesLink,10);
        productPage.salesLink.click();

        Thread.sleep(8000);
        productPage.productsLink.click();

    }

    @Then("user clicks on create button")
    public void user_clicks_on_create_button() {

        ProductPage productPage = new ProductPage();
        productPage.createButton.click();
    }

    @When("user enters name of the product as {string} then saves it")
    public void user_enters_name_of_the_product_as_then_saves_it(String name) {

        ProductPage productPage = new ProductPage();
        productPage.productNameEntry.sendKeys(name);
        productPage.saveButton.click();

    }

    @Then("user should be able to see the {string} on the page.")
    public void user_should_be_able_to_see_the_on_the_page(String name) {

        ProductPage productPage = new ProductPage();
        productPage.productsLink.click();
        productPage.productName(name);
    }

    @Then("user should see these buttons on the top left")
    public void user_should_see_these_buttons_on_the_top_left(List <String > expectedButtons) {

        ProductPage productPage = new ProductPage();

        List <String> actualButtons= BrowserUtils.getElementsText(productPage.importCreateButton);
        System.out.println(expectedButtons);
        System.out.println(actualButtons);
        Assert.assertNotEquals(expectedButtons,actualButtons);

    }

    @Then("user should receive {string} error")
    public void user_should_receive_error(String expectedErrorMessage) {

        ProductPage productPage = new ProductPage();

        BrowserUtils.waitForVisibility(productPage.errorMessageInvalidField,3);
        String actualErrorMessage = productPage.errorMessageInvalidField.getText();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage));

    }

    @When("user should see these product information headers")
    public void user_should_see_these_product_information_headers(List <String> expectedHeaders) {

        ProductPage productPage = new ProductPage();
        List <String > actualHeaders = BrowserUtils.getElementsText(productPage.headers);
        Assert.assertTrue(actualHeaders.containsAll(expectedHeaders));

    }

    @When("user enters valid credentials")
    public void user_enters_valid_credentials()  {

        ProductPage productPage = new ProductPage();
        productPage.salesPrice.clear();
        productPage.salesPrice.sendKeys("13.99");
        productPage.barcodeBox.sendKeys("352525628372");

    }

    @Then("user clicks on save button")
    public void user_clicks_on_save_button() {

        ProductPage productPage = new ProductPage();
        productPage.saveButton.click();
    }


}
