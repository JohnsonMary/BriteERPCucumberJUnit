package com.cybertek.pages;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InvoicingPage{


    public InvoicingPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public void logIN() throws InterruptedException {
        Thread.sleep(5000);
        salesClick.click();
        ordersToInvoice.click();
    }

    @FindBy(xpath = "//*[@id=\"oe_main_menu_navbar\"]/div[2]/ul[1]/li[6]/a/span")
    public WebElement salesClick;

    @FindBy (linkText = "Orders to Invoice")
    public WebElement ordersToInvoice;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[1]/div/input")
    public WebElement orderNumberCheckboxHeader;


    @FindBy(xpath = "//td//input[@type='checkbox']")
    public List<WebElement> checkboxList;

    @FindBy(xpath = "//table/tbody/tr[6]/td[1]/div/input")
    public WebElement singleNumberCheckbox;

    @FindBy(xpath = "//button[@class = 'o_dropdown_toggler_btn btn btn-sm dropdown-toggle']")
    public WebElement printMenu;

    @FindBy (xpath = "(//button[@class = 'o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[2]")
    public WebElement actionMenu;

    @FindBy (xpath = "(//*[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[2]/following-sibling::ul/li")
    public List<WebElement> dropDownOptionsActions;

    @FindBy (xpath = "//h4[@class='modal-title']")
    public WebElement exportData;

    @FindBy (xpath = "//button[@class='btn btn-sm btn-default']")
    public WebElement exportDataClose;

    @FindBy (xpath = "//h4[@class='modal-title']")
    public WebElement invoceOrder;

    @FindBy (xpath ="//button[@class='btn btn-sm btn-default']")
    public WebElement invoceOrderClose;

    @FindBy (xpath =  "//h4[@class='modal-title']")
    public WebElement thirdDropdownOdoo;

    @FindBy (xpath = "//button[@class='btn btn-sm btn-default']")
    public WebElement thirdDropdownOdooClose;

    @FindBy(xpath = "(//button[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[1]")
    public WebElement printMenuTab;

    @FindBy(linkText = "Quotation / Order")
    public WebElement printMenuTabAppeareance;

    @FindBy(xpath = "//input[@class = 'o_searchview_input']")
    public WebElement searchBox;

    @FindBy(xpath = "(//button[@type='button'])[16]")
    public WebElement calendar;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div/div/button[3]")
    public WebElement calendarMonthButtonClick;

    @FindBy(xpath = "(//div[1]//li[@class = 'active'])[2]")
    public WebElement calendarPageVerify;

    @FindBy(xpath = "//div[3]/button[3]")
    public WebElement graph;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/button[1]")
    public WebElement barChartClick;

    @FindBy(xpath = "//div[1]/ol/li")
    public WebElement graphPageVerify;

    @FindBy(xpath = "//div[3]/button[4]")
    public WebElement pivot;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[2]/div[1]/div[2]/button[1]")
    public WebElement flipAxis;

    @FindBy(xpath = "//div[1]/ol")
    public WebElement pivotPageVerify;

    @FindBy(xpath = "//div[3]/button[5]")
    public WebElement kanban;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/div[1]")
    public WebElement kanbanValue;

    @FindBy(xpath = "//div[1]/ol/li")
    public WebElement kanbanPageVerify;

    @FindBy(xpath = "/html/body/div[1]/div[2]/div[1]/div[1]/div/ul")
    public WebElement checkboxDropDownList;


}


