package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class SummerDerssesPage extends Utility {
    public SummerDerssesPage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//span[contains(text(),'Add to cart')]")
    WebElement addToCart;

    @CacheLookup
    @FindBy(xpath = " //a[normalize-space()='Printed Chiffon Dress']")
    WebElement printedChiffonDress;

    @CacheLookup
    @FindBy(xpath = "(//span[@class='cat-name'])[1]")
    WebElement summerDressesPageVerificationText;

    @CacheLookup
    @FindBy(xpath = "")
    WebElement mainSlider;

    @CacheLookup
    @FindBy(xpath = "//div[@id='left_column']//a[2]")
    WebElement slider;

    public void addPrintChiffonDressToCart(){
        clickOnElement(printedChiffonDress);
        clickOnElement(addToCart);
    }
    public void verifySummerDressesPageVerificationText(String message){
        verifyElements(summerDressesPageVerificationText,message,"Incorrect page");
        Reporter.log("verifying summer page text : " + summerDressesPageVerificationText.toString() + "<br>");
    }
    public void moveSliderToChangePrice(){
        Actions actions= new Actions(driver);
        actions.dragAndDropBy(slider,-183,0).build().perform();
        Reporter.log("moving slider to change price : " + slider.toString() + "<br>");
    }

}
