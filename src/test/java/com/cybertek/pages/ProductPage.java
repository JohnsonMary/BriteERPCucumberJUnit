package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class ProductPage {

    public ProductPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy(linkText = "Sales")
    public WebElement salesLink;

    @FindBy(linkText = "Products")
    public WebElement productsLink;

    @FindBy (xpath = "//button[@class='btn btn-primary btn-sm o-kanban-button-new btn-default']")
    public  WebElement createButton;

    @FindBy (xpath = "//input[@class='o_field_char o_field_widget o_input o_required_modifier']")
    public  WebElement productNameEntry;

    @FindBy (xpath = "//button[@class='btn btn-primary btn-sm o_form_button_save']")
    public  WebElement saveButton;

    @FindBy (xpath = "//div[@class='o_notification_manager']")
    public WebElement errorMessageInvalidField;

    @FindBy (xpath = "(//input[@class='o_field_char o_field_widget o_input'])[2]")
    public  WebElement barcodeBox;

    @FindBy (xpath = "(//div[@class='o_cp_buttons'])/div")
    public  List <WebElement> importCreateButton;

    @FindBy (xpath = "//table[@class='o_group o_inner_group o_group_col_6']//tr/td[1]")
    public  List <WebElement> headers;

    @FindBy (xpath = "//div[@class='o_field_monetary o_field_number o_input o_field_widget']/input")
    public  WebElement salesPrice;


    public static void productName(String productName) {

        List<WebElement> products = Driver.getDriver().findElements(By.xpath("(//div[@class='oe_kanban_global_click o_kanban_record'])/div[2]/strong"));

        for (WebElement product : products) {

            if(product.getText().equals(productName)){

                Assert.assertEquals(product.getText(),productName);

            }
        }
    }

}