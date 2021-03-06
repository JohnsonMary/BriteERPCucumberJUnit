package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }

    @FindBy (xpath = "//a[@href='/web/login']")
    public WebElement signIn;

    @FindBy (id = "login")
    public  WebElement email;

    @FindBy (id = "password")
    public  WebElement password;

    @FindBy (xpath = "//button[@class='btn btn-primary']")
    public  WebElement logInButton;

    @FindBy (linkText = "BriteErpDemo")
    public WebElement BriteErpLink;










}
