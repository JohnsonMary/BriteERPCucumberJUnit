package com.cybertek.pages;
import com.cybertek.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class InvoicingPage{


    public InvoicingPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"oe_main_menu_navbar\"]/div[2]/ul[1]/li[6]/a/span")
    public WebElement salesClick;

    @FindBy (linkText = "Orders to Invoice")
    public WebElement ordersToInvoice;

    @FindBy (xpath = "/html/body/div[1]/div[2]/div[2]/div/div/div/table/thead/tr/th[1]/div/input")
    public WebElement orderNumberCheckboxHeader;

    @FindBy (xpath = "(//button[@class = 'o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[2]")
    public WebElement actionMenu;

    @FindBy (xpath = "(//*[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[2]/following-sibling::ul/li")
    public List<WebElement> dropDownOptionsActions;

    @FindBy (xpath = "//h4[@class='modal-title']")
    public List <WebElement> exportDataText;

    @FindBy (xpath = "((//*[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[2]/following-sibling::ul/li)[1]")
    public WebElement exportDropDown;

    @FindBy(xpath = "(//button[@class='o_dropdown_toggler_btn btn btn-sm dropdown-toggle'])[1]")
    public WebElement printMenuTab;

    @FindBy(linkText = "Quotation / Order")
    public List  <WebElement> quotationOrderDropDown;

    // hello



}


