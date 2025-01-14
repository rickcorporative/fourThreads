/*
 * File: AddToCartTest.java
 * Author: Yaroslav
 * Date: 30.12.2024
 * Description: Test class for work with pages
 */
package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.List;

public class AddLaptopToCart extends ParentTest{

    private String searchQuery = "Клавиатура";
    private List<String> cartItems = new ArrayList<>();



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

}
