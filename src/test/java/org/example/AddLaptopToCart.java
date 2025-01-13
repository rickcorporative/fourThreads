/*
 * File: AddToCartTest.java
 * Author: Yaroslav
 * Date: 30.12.2024
 * Description: Test class for work with pages
 */
package org.example;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.ArrayList;
import java.util.List;

public class AddLaptopToCart {
    //поля
    private WebDriver driver;
    private MainPage mainPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private String searchQuery = "Клавиатура";
    private List<String> cartItems = new ArrayList<>();

    // настройка перед тестом
    @BeforeMethod
    public void setup(){
        driver = DriverManager.getDriver();
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }

    //початок тесту
    @Test
    public void testProductSearchAndCartManagement() {
        //opening main page
        mainPage.open();

        mainPage.searchProduct(searchQuery);

        //check if there is similar product in cart already

        //Assert.assertTrue(cartItems.get(0).contains(searchQuery), "Ім'я товару зі сторінки не знайдено в корзині!");


        //Loading
        mainPage.waitProductListLoaded();
        //clicking on the first product


        mainPage.clickFirstProduct();


        //adding product to the state of cart
        this.cartItems.add(productPage.getCurrentTitle());


        //click on btn
        productPage.addToCart();

//        again checking
        Assert.assertTrue(cartItems.get(0).contains(productPage.getCurrentTitle()), "Ім'я товару зі сторінки не знайдено в корзині!");





        cartPage.removeProduct();
        this.cartItems.remove(0);

        //checking if the cart is empty
//        Assert.assertTrue(cartItems.isEmpty(), "Корзина пуста");

    }
    //the end
    @AfterMethod
    public void teardown() {
        DriverManager.quitDriver();
    }
}
