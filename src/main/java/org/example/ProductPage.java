/*
 * File: ProductPage.java
 * Author: Yaroslav
 * Date: 30.12.2024
 * Description: Page Object of product
 */
package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {
    private WebDriver driver;
    private By buyBtn = By.cssSelector(".product-button__buy.ng-star-inserted");
    private By productTitle = By.cssSelector("h1.title__font.ng-star-inserted");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }


    public void addToCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickableBuyButton = wait.until(ExpectedConditions.presenceOfElementLocated(buyBtn));
        driver.findElement(buyBtn).click();

    }

    public String getCurrentTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement currentTitle = wait.until(ExpectedConditions.presenceOfElementLocated(productTitle));

        return driver.findElement(productTitle).getText();
    }
}
