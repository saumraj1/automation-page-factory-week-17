package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class CreateAccountPage extends Utility {
    public CreateAccountPage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//input[@id='customer_firstname']")
    WebElement firstNameLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='customer_lastname']")
    WebElement lastNameLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='passwd']")
    WebElement passwordLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='address1']")
    WebElement addressLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='city']")
    WebElement cityLink;
    @CacheLookup
    @FindBy(xpath = "//select[@id='id_state']")
    WebElement stateLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='postcode']")
    WebElement zipPostalLink;
    @CacheLookup
    @FindBy(xpath = "//input[@id='phone_mobile']")
    WebElement mobilePhoneLink;
    @CacheLookup
    @FindBy(xpath = "//button[@id='submitAccount']")
    WebElement registerLink;
    @CacheLookup
    @FindBy (css = "div[class='alert alert-danger'] p")
    WebElement errorMessage;


    @CacheLookup
    @FindBy(xpath = "//h1[contains(text(),'My account')]")
    WebElement myAccountTextLink;

    public void fillMandatoryFields(String name,String surname,String password,String address,
                                    String city,String state,String postcode,String mobileNumber){

        Reporter.log("Entering firstname" + firstNameLink.toString()+ "<br>");
        sendTextToElement(firstNameLink, name);
        Reporter.log("Entering lastname" + lastNameLink.toString()+ "<br>");
        sendTextToElement(lastNameLink, surname);
        Reporter.log("Entering password" + passwordLink.toString()+ "<br>");
        sendTextToElement(passwordLink, password);
        Reporter.log("Entering address" + addressLink.toString()+ "<br>");
        sendTextToElement(addressLink, address);
        Reporter.log("Entering city" + cityLink.toString()+ "<br>");
        sendTextToElement(cityLink, city);
        Reporter.log("Selecting the state" + stateLink.toString()+ "<br>");
        selectByVisibleTextFromDropDown(stateLink, state);
        Reporter.log("Entering postalcode" + zipPostalLink.toString()+ "<br>");
         sendTextToElement(zipPostalLink, postcode);
        Reporter.log("Entering contact number" + mobilePhoneLink.toString()+ "<br>");
        sendTextToElement(mobilePhoneLink, mobileNumber);
    }
    public void clickOnRegister(){
        clickOnElement(registerLink);
        Reporter.log("Clicking on register link" + registerLink.toString()+ "<br>");

    }
    public void verifyMyAccountText(String message){
        verifyElements(myAccountTextLink,message,"Message is Not displayed correctly ");
        Reporter.log("Verifying the message" + myAccountTextLink.toString()+ "<br>");
    }
    public void verifyErrorMessage(String error){
        Assert.assertTrue(errorMessage.getText().contains(error));
        Reporter.log("verifying error message : " + errorMessage.toString() + "<br>");
    }

}

