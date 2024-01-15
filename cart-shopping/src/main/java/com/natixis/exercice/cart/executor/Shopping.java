package com.natixis.exercice.cart.executor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.exercice.cart.builder.ProductBuilder;
import com.natixis.exercice.cart.model.Product;
import com.natixis.exercice.cart.model.ShoppingCart;
import com.natixis.exercice.cart.utils.ShoppingCartUtils;
/**
 * Main Class for Shopping
 */
public class Shopping {
	
	// Constants
    public static final String SHOPPING_CART_JSON_PATH = "c:\\temp\\shopping_cart.json";

	// Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(Shopping.class);

    public static void main(String[] args) {
		
		try {
            LOGGER.info("****   Start Shopping  ****");

			ShoppingCart cart = new ShoppingCart();
			
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
	
			cart.printCart();
	
		    // Map Cart to Json File
			ShoppingCartUtils.mapShoppingCartToJsonFile(SHOPPING_CART_JSON_PATH, cart.getProducts());
            
			LOGGER.info("****   Finish Shopping  ****");

		}catch(Exception e) {
            LOGGER.error("Unexpected error in the main method", e);
		}
 	}
}
