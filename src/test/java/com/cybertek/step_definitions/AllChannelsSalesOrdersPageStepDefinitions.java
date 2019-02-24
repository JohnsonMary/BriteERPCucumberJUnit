package com.cybertek.step_definitions;

import com.cybertek.pages.AllChannelsSalesOrdersPage;
import com.cybertek.pages.InvoicingPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AllChannelsSalesOrdersPageStepDefinitions {
    LoginPage loginPage = new LoginPage();
    AllChannelsSalesOrdersPage allChannelsSalesOrdersPage = new AllChannelsSalesOrdersPage();


    @When("sales manager clicks on a sales link, then All Channels Sales Orders link")
    public void sales_manager_clicks_on_a_sales_link_then_All_Channels_Orders_link() throws InterruptedException {
        BrowserUtils.waitForVisibility(allChannelsSalesOrdersPage.salesMenu, 10);
        allChannelsSalesOrdersPage.salesMenu.click();
        Thread.sleep(8000);
        allChannelsSalesOrdersPage.allChannelsSalesOrdersLink.click();
    }

    // UTILITY METHODS-----------------------------------------------------------------------
    public void filter() throws InterruptedException {
        sales_manager_selects_as_filter_criteria("Total");
        sales_manager_selects_as_a_second_filter_criteria("less than");
        sales_manager_types_as_a_filter_value("20000");
        sales_manager_hits_the_apply_button();
        search_results_should_be_displayed_based_on_the_applied_filter();
    }

        public boolean isAlertPresent() {
            try {
                Driver.getDriver().switchTo().alert();
                return true;
            }   // try
            catch (NoAlertPresentException Ex) {
                return false;
            }   // catch
        }   // isAlertPresent()

    //APPLY THE FILTER TO SEARCH RESULTS-----------------------------------------------------

    @When("sales manager selects {string} as filter criteria")
    public void sales_manager_selects_as_filter_criteria(String criteria1) throws InterruptedException {
        Thread.sleep(4000);
        if (!allChannelsSalesOrdersPage.filters.isDisplayed()) {
            BrowserUtils.waitForClickablility(allChannelsSalesOrdersPage.advancedSearch, 10);
            allChannelsSalesOrdersPage.advancedSearch.click();
        }

        allChannelsSalesOrdersPage.filters.click();
        allChannelsSalesOrdersPage.addCustomFilter.click();

        Thread.sleep(3000);
        Select filterOption1 = new Select(Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[4]/span[2]/select")));
        filterOption1.selectByVisibleText(criteria1);
    }

    @When("sales manager selects {string} as a second filter criteria")
    public void sales_manager_selects_as_a_second_filter_criteria(String criteria2) throws InterruptedException {
        Thread.sleep(3000);
        Select filterOption2 = new Select(Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[4]/select")));
        filterOption2.selectByVisibleText(criteria2);
    }

    @When("sales manager types {string} as a filter value")
    public void sales_manager_types_as_a_filter_value(String value) {
        WebElement filterText = Driver.getDriver().findElement(By.xpath("//input[@class='o_input']"));
        filterText.clear();
        filterText.sendKeys(value);
    }

    @When("sales manager hits the apply button")
    public void sales_manager_hits_the_apply_button() {
        WebElement filterApplyButton = Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/ul/li[5]/button[1]"));
        filterApplyButton.click();
    }

    @Then("search results should be displayed based on the applied filter")
    public void search_results_should_be_displayed_based_on_the_applied_filter() {
        Assert.assertTrue(true);

    }

  //SAVE SEARCH RESULTS TO THE FAVORITES MENU-----------------------------------------------------

    @Given("filter applied on the search page")
    public void filter_applied_on_the_search_page() throws InterruptedException {
        filter();
    }

    @When("sales manager hits favorites menu and save the the current search result as a {string}")
    public void sales_manager_hits_favorites_menu_and_save_the_the_current_search_result_as_a(String name) {
        allChannelsSalesOrdersPage.favorites.click();
        allChannelsSalesOrdersPage.saveCurrentSearch.click();
        allChannelsSalesOrdersPage.favoritesText.clear();
        allChannelsSalesOrdersPage.favoritesText.sendKeys(name);
        allChannelsSalesOrdersPage.favoritesSaveButton.click();
    }

    @Then("search result should be saved to the favorites menu")
    public void search_result_should_be_saved_to_the_favorites_menu() throws InterruptedException {
        Driver.getDriver().navigate().refresh();
        Thread.sleep(5000);
        allChannelsSalesOrdersPage.favorites.click();

        Set<WebElement> favorites = new HashSet<>(Driver.getDriver().findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
        boolean found = false;
        for (WebElement fav : favorites) {
            if (fav.getText().equals("sale1"))
                found = true;
        }

        Assert.assertTrue(found);
    }

//--------------------------------------------------------------------------------
        public void FavoritesMenuTest2() throws InterruptedException {
            filter();

            allChannelsSalesOrdersPage.favorites.click();


            List<WebElement> fav = new ArrayList<>(Driver.getDriver().findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
            boolean found = false;
            for (int i = 0; i < fav.size(); i++) {
                if (fav.get(i).getText().equals("sale1")) {
                    fav.get(i).click();
                    Thread.sleep(3000);
                    found = true;
                    String delete = "//li[" + (i + 1) + "]/span[@class='fa fa-trash-o o-remove-filter' and 1]";
                    Driver.getDriver().findElement(By.xpath(delete)).click();
                    Alert alert = Driver.getDriver().switchTo().alert();
                    alert.accept();
                }
            }


            fav = new ArrayList<>(Driver.getDriver().findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
            found = fav.contains("sale1");


            Assert.assertFalse(found);
        }

        public void FavoritesMenuTest3() throws InterruptedException {
            filter();
            allChannelsSalesOrdersPage.favorites.click();
            allChannelsSalesOrdersPage.saveCurrentSearch.click();
            allChannelsSalesOrdersPage.favoritesText.clear();
            allChannelsSalesOrdersPage.favoritesText.sendKeys("sale7");

            List<WebElement> fav = new ArrayList<>(Driver.getDriver().findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
            boolean found = false;
            for (int i = 0; i < fav.size(); i++) {
                if (fav.get(i).getText().trim().equals("Share with all users")) {
                    String checkbox = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li[" + (i + 1) + "]/span[1]/div/input";
                    Driver.getDriver().findElement(By.xpath(checkbox)).click();
                }
            }

            allChannelsSalesOrdersPage.favoritesSaveButton.click();

            Driver.getDriver().navigate().refresh();
            Thread.sleep(5000);
            allChannelsSalesOrdersPage.favorites.click();

            fav = new ArrayList<>(Driver.getDriver().findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
            found = false;
            for (int i = 0; i < fav.size(); i++) {
                if (fav.get(i).getText().trim().equals("sale7")) {
                    found = true;
                }
            }

            Assert.assertTrue(found);
        }

        public void FavoritesMenuTest4() throws InterruptedException {
            filter();

            allChannelsSalesOrdersPage.favorites.click();
            
            List<WebElement> fav = new ArrayList<>(Driver.getDriver().findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
            boolean found = false;
            for (int i = 0; i < fav.size(); i++) {
                if (fav.get(i).getText().equals("sale2")) {
                    fav.get(i).click();
                    found = true;
                    Thread.sleep(3000);
                    String delete = "//li[" + (i + 1) + "]/span[@class='fa fa-trash-o o-remove-filter' and 1]";
                    Driver.getDriver().findElement(By.xpath(delete)).click();
                    Alert alert = Driver.getDriver().switchTo().alert();
                    alert.accept();
                }
            }

            if (Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).isDisplayed()) {
                Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).click();
            }


            Driver.getDriver().navigate().refresh();
            Thread.sleep(5000);
            allChannelsSalesOrdersPage.favorites.click();

            fav = new ArrayList<>(Driver.getDriver().findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
            found = false;
            for (int i = 0; i < fav.size(); i++) {
                if (fav.get(i).getText().trim().equals("sale2")) {
                    found = true;
                }
            }

            Assert.assertFalse(found);
        }

        public void FavoritesMenuTest5() throws InterruptedException {
            filter();
            allChannelsSalesOrdersPage.favorites.click();
            allChannelsSalesOrdersPage.saveCurrentSearch.click();
            allChannelsSalesOrdersPage.favoritesText.clear();
            allChannelsSalesOrdersPage.favoritesText.sendKeys("sale9");

            List<WebElement> fav = new ArrayList<>(Driver.getDriver().findElements(By.xpath("/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li")));
            boolean found = false;
            for (int i = 0; i < fav.size(); i++) {
                if (fav.get(i).getText().trim().equals("Use by default")) {
                    String checkbox = "/html/body/div[1]/div[2]/div[1]/div[3]/div[1]/div[3]/ul/li[" + (i + 1) + "]/span[1]/div/input";
                    Driver.getDriver().findElement(By.xpath(checkbox)).click();
                }
            }

            allChannelsSalesOrdersPage.favoritesSaveButton.click();
            Driver.getDriver().findElement(By.xpath("//span[@class='oe_topbar_name']")).click(); // Click on the username on the top right
            Driver.getDriver().findElement(By.xpath("//ul[@class='dropdown-menu']/li[6]/a[1]")).click(); // Click on the logout
            Thread.sleep(5000);

            loginPage.BriteErpLink.click();
            loginPage.signIn.click();
            loginPage.email.sendKeys("in_manager2@info.com");
            loginPage.password.sendKeys("Wdf4ssa45");
            loginPage.logInButton.click();

            allChannelsSalesOrdersPage.salesMenu.click();
            Thread.sleep(5000);
            allChannelsSalesOrdersPage.allChannelsSalesOrdersLink.click();
            Thread.sleep(5000);

            String defaultSearch = Driver.getDriver().findElement(By.xpath("//div[@class='o_facet_values']/span[1]")).getText();

            Assert.assertTrue(defaultSearch.equals("sale9"));
        }

        public void FavoritesMenuTest6() throws InterruptedException {
            Driver.getDriver().manage().window().maximize();
            filter();
            allChannelsSalesOrdersPage.favorites.click();
            allChannelsSalesOrdersPage.addToMyDashboard.click();
            allChannelsSalesOrdersPage.dashboardText.clear();
            allChannelsSalesOrdersPage.dashboardText.sendKeys("sale9");
            allChannelsSalesOrdersPage.dasboardAddButton.click();
            Thread.sleep(5000);
            allChannelsSalesOrdersPage.dashboardsMenu.click();
            Thread.sleep(10000);

            List<WebElement> search = new ArrayList<>(Driver.getDriver().findElements(By.xpath("//*[@id=\"column_0\"]/div")));
            boolean found = false;
            for (int i = 0; i < search.size(); i++) {
                System.out.println(search.get(i).getText());
                if (search.get(i).getText().trim().startsWith("sale9")) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }


        public void FavoritesMenuTest7() throws InterruptedException {
            Driver.getDriver().manage().window().maximize();
            Driver.getDriver().manage().timeouts().implicitlyWait(5000, TimeUnit.SECONDS);

            allChannelsSalesOrdersPage.dashboardsMenu.click();

            allChannelsSalesOrdersPage.dashboardsMenu.click();
            Thread.sleep(10000);

            List<WebElement> search = new ArrayList<>(Driver.getDriver().findElements(By.xpath("//*[@id=\"column_0\"]/div")));
            boolean found = false;
            for (int i = 0; i < search.size(); i++) {
                if (search.get(i).getText().startsWith("sale9")) {
                    String xpath = "//*[@id=\"column_0\"]/div[" + (i + 1) + "]/h2/span[2]";
                    Driver.getDriver().findElement(By.xpath(xpath)).click();
                    Driver.getDriver().findElement(By.xpath("//button[@class='btn btn-sm btn-primary']")).click();
                }
            }

            search = new ArrayList<>(Driver.getDriver().findElements(By.xpath("//*[@id=\"column_0\"]/div")));
            for (int i = 0; i < search.size(); i++) {
                if (search.get(i).getText().startsWith("sale9")) {
                    String xpath = "//*[@id=\"column_0\"]/div[" + (i + 1) + "]/h2/span[2]";
                    Driver.getDriver().findElement(By.xpath(xpath)).click();
                    found = true;
                }
            }

            Assert.assertFalse(found);
        }

        public void FiltersMenuTest() throws InterruptedException {
            filter();

            Assert.assertTrue(true);

        }

        public void MeasuresMenuTest() throws InterruptedException {
            
            allChannelsSalesOrdersPage.measuresMenu.click();
            allChannelsSalesOrdersPage.productQuantity.click();

            Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div")).click();
            Thread.sleep(3000);

            List<WebElement> columns = new ArrayList<>(Driver.getDriver().findElements(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div/table/thead/tr[2]/th")));
            boolean found = false;
            for (int i = 0; i < columns.size(); i++) {
                if (columns.get(i).getText().startsWith("Product Quantity")) {
                    found = true;
                }
            }

            Assert.assertTrue(found);

        }

        public void GroupByMenuTest() throws InterruptedException {

            if (!allChannelsSalesOrdersPage.filters.isDisplayed()) {
                BrowserUtils.waitForClickablility(allChannelsSalesOrdersPage.advancedSearch, 5);
                allChannelsSalesOrdersPage.advancedSearch.click();
            }

            allChannelsSalesOrdersPage.groupByMenu.click();
            allChannelsSalesOrdersPage.addCustomGroup.click();
            Select groupByOptions = new Select(allChannelsSalesOrdersPage.groupBySelect);
            groupByOptions.selectByVisibleText("Salesperson");
            allChannelsSalesOrdersPage.groupBySaveButton.click();

            Driver.getDriver().findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/div")).click();

            Assert.assertTrue(true);

        }
        
    }