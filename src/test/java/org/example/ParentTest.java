/*
 * File: AddToCartTest.java
 * Author: Yaroslav
 * Date: 30.12.2024
 * Description: Test class for work with pages
 */
package org.example;


import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class ParentTest {
    //поля
    private WebDriver driver;
    protected MainPage mainPage;
    protected ProductPage productPage;
    protected CartPage cartPage;


    // настройка перед тестом
    @BeforeMethod
    public void setup(){
        driver = DriverManager.getDriver();
        mainPage = new MainPage(driver);
        productPage = new ProductPage(driver);
        cartPage = new CartPage(driver);
    }


    //the end
    @AfterMethod
    public void teardown() {
        DriverManager.quitDriver();
    }
}
