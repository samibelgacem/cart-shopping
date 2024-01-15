package com.natixis.exercice.cart.utils;

import static org.junit.Assert.assertTrue;

import java.io.File;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.natixis.exercice.cart.builder.ProductBuilder;
import com.natixis.exercice.cart.model.Product;
import com.natixis.exercice.cart.model.ShoppingCart;

public class ShoppingCartUtilsTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }
    
    @Test
    void testMapShoppingCartToJsonFile() {
    	Product penItem = new ProductBuilder()
                .withProductName("Pen")
                .withQuantity(3)
                .withPrice(1.50)
                .build();

    	Product bookItem = new ProductBuilder()
                .withProductName("Book")
                .withQuantity(2)
                .withPrice(8.00)
                .build();

        cart.addProduct(penItem);
        cart.addProduct(bookItem);

        // Map Cart to Json File
        ShoppingCartUtils.mapShoppingCartToJsonFile("test.json", cart.getProducts());

        File jsonFile = new File("test.json");
        assertTrue(jsonFile.exists());
    }
}
