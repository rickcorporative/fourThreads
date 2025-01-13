/*
 * File: MainPage.java
 * Author: Yaroslav
 * Date: 30.12.2024
 * Description: Page Object of rozetka`s main page
 */
package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class CartPage {

    private WebDriver driver;
    private By cart = By.cssSelector(".header-actions__item.header-actions__item--cart");
    private By dots = By.cssSelector(".cart-product__actions");
    private By deleteBtn = By.id("cartProductActions0");
    private By cross = By.cssSelector(".text-base.ms-auto.d-block");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(cart));
        driver.findElement(cart).click();

    }

    public void close(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(cross));
        driver.findElement(cross).click();
    }

    public void removeProduct(){


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(dots));
        driver.findElement(dots).click();

        WebDriverWait waitfor = new WebDriverWait(driver, Duration.ofSeconds(10));
        waitfor.until(ExpectedConditions.presenceOfElementLocated(deleteBtn));
        driver.findElement(deleteBtn).click();
    }



}