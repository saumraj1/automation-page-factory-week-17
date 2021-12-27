package com.automationpractice.testsuite;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.ShoppingCartPage;
import com.automationpractice.pages.ShoppingCartSummaryPage;
import com.automationpractice.pages.SummerDerssesPage;
import com.automationpractice.testbase.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import resources.testdata.TestData;

public class DeletionTest extends TestBase {
    HomePage homePage;
    SummerDerssesPage summerDerssesPage;
    ShoppingCartPage shoppingCartPage;
    ShoppingCartSummaryPage shoppingCartSummaryPage;


    @BeforeMethod(groups = {"smoke","sanity","regression"})
    public void init(){
        homePage=new HomePage();
        summerDerssesPage = new SummerDerssesPage();
        shoppingCartPage = new ShoppingCartPage();
        shoppingCartSummaryPage = new ShoppingCartSummaryPage();
    }

    @Test(groups = {"sanity","regression"},dataProvider = "Deletion Test",dataProviderClass= TestData.class)
    public void userShouldAbleToDeleteAnItemFromBasket(String mainMenu,String subMenu,String message) throws InterruptedException{
        // Select Women tab from the main menu
        homePage.selectItemFromMainMenu(mainMenu);
        // Select Blouses from the sub menu
        homePage.selectItemsFromWomensMenu(subMenu);
         // Add item to cart
        summerDerssesPage.addPrintChiffonDressToCart();
        // close shopping cart window
        shoppingCartPage.closeShoppingCartWindow();
        // verify shopping cart has delete button
        shoppingCartPage.confirmationDeleteIconLogoInShoppingCart();
        //Remove item from cart
        shoppingCartPage.removeItemFromCart();
        //Banner must display "Your shopping cart is empty."
        shoppingCartSummaryPage.verifyShoppingCartIsEmptyMessage(message);
    }
}
