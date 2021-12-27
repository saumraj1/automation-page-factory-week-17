package com.automationpractice.pages;

import com.automationpractice.utility.Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

public class ShoppingCartPage extends Utility {
    public ShoppingCartPage(){
        PageFactory.initElements(driver,this);
    }
    @CacheLookup
    @FindBy(xpath = "//a[@class='ajax_cart_block_remove_link']")
    WebElement deleteCross;

    @CacheLookup
    @FindBy(xpath = "//b[normalize-space()='Cart']")
    WebElement cartButton;

    @CacheLookup
    @FindBy(xpath = "//span[@title='Close window']")
    WebElement closeShoppingCartWindow;

    public void closeShoppingCartWindow(){
        clickOnElement(closeShoppingCartWindow);
        Reporter.log("closing shopping cart window : " + closeShoppingCartWindow.toString() + "<br>");
    }
    public void confirmationDeleteIconLogoInShoppingCart(){
        mouseHoverNoClick(cartButton);
        waitUntilVisibilityOfElementLocated(By.xpath("//a[@class='ajax_cart_block_remove_link']"),30);
        //boolean logoPresent = deleteCross.isDisplayed();
        Assert.assertTrue(deleteCross.isDisplayed());
    }
    public void removeItemFromCart(){
        clickOnElement(deleteCross);
    }


}
