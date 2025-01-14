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
import org.testng.annotations.Parameters;


public class ParentTest {
    protected MainPage mainPage;
    protected ProductPage productPage;
    protected CartPage cartPage;

    // настройка перед тестом
    @Parameters({"browser", "useBrowserStack"})
    @BeforeMethod
    public void setup(String browser, String useBrowserStack) {
        System.setProperty("browser", browser);
        if(useBrowserStack != null && useBrowserStack.equalsIgnoreCase("true")){
            System.setProperty("useBrowserStack", "true");
        }
        WebDriver driver = DriverManager.getDriver();
        driver.get("https://rozetka.com.ua/");
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
