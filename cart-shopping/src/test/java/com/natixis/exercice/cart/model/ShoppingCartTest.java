package com.natixis.exercice.cart.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.natixis.exercice.cart.builder.ProductBuilder;
import com.natixis.exercice.cart.exception.DuplicateProductException;
/**
 * Test class for shopping Cart
 */
public class ShoppingCartTest {

    private ShoppingCart cart;

    @BeforeEach
    void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    void testAddProduct() {
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

        List<Product> products = cart.getProducts();

        assertEquals(2, products.size());
        assertTrue(products.contains(penItem));
        assertTrue(products.contains(bookItem));
    }

    @Test
    void testAddDuplicateItem() {
    	Product penItem = new ProductBuilder()
                .withProductName("Pen")
                .withQuantity(3)
                .withPrice(1.50)
                .build();

        cart.addProduct(penItem);

        DuplicateProductException exception = assertThrows(DuplicateProductException.class, () -> {
            cart.addProduct(penItem);
        });

        assertEquals("Product 'Pen' is already in the cart.", exception.getMessage());
    }
}
