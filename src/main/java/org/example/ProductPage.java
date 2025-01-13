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
    private By buyBtn = By.xpath("//button[contains(@class, 'buy-button')]]");
    private By addToCartBtn = By.cssSelector(".button.cart-receipt__submit");
    private By productTitle = By.cssSelector("h1.title__font.ng-star-inserted");

    public ProductPage(WebDriver driver){
        this.driver = driver;
    }


    public void addToCart(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement clickableBuyButton = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(buyBtn)));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement clickableBuyButton = wait.until(ExpectedConditions.elementToBeClickable(buyBtn));
        driver.findElement(buyBtn).click();


        WebDriverWait waitfor = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement order = waitfor.until(ExpectedConditions.elementToBeClickable(addToCartBtn));

        driver.findElement(addToCartBtn).click();

    }

    public String getCurrentTitle(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement currentTitle = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(productTitle)));

        return currentTitle.getText();
    }
}