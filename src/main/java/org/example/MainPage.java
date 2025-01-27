/*
 * File: MainPage.java
 * Author: Yaroslav
 * Date: 30.12.2024
 * Description: Page Object of rozetka`s main page
 */
package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {

    private WebDriver driver;
    private By searchBox = By.name("search"); // Локатор поля поиска
    private By searchButton = By.cssSelector("button.button_color_green.button_size_medium.search-form__submit"); // Локатор кнопки поиска
    private By cartBtn = By.cssSelector("button.header-cart__button");
    private By firstProduct = By.xpath("//span[contains(@class, 'goods-tile__title')]");

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://rozetka.com.ua/");
    }

    public void searchProduct(String productName) {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.findElement(searchBox).sendKeys(productName);
        driver.findElement(searchButton).click();
    }

    public void clickFirstProduct () {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(firstProduct));

        driver.findElements(firstProduct).get(0).click();
    }

    public void openCart(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cart = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(cartBtn)));

        cart.click();
    }




}