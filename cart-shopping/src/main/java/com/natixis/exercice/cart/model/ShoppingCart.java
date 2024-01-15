package com.natixis.exercice.cart.model;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.natixis.exercice.cart.exception.DuplicateProductException;

/**
 * ShoppingCart class follows SRP by handling cart operations and serialization separately
 */
public class ShoppingCart {
 
	// Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCart.class);

	private List<Product> products;

	public ShoppingCart() {
		this.products = new ArrayList<>();
	}

	public List<Product> getProducts() {
		return products;
	}
	
	/**
	 * Add product method if it doesn't exist in cart
	 * @param product
	 */
	public void addProduct(Product product) {
		// Business Rule: Cannot have repeated products
		if (!containsProduct(product.getProductName())) {
			products.add(product);
            LOGGER.info("Added item: {}", product.getProductName());
            
		}else {
            LOGGER.warn("Attempted to add duplicate product: {}", product.getProductName());
            throw new DuplicateProductException(product.getProductName());
        }
	}
	/**
	 * Print Cart Method
	 */
	public void printCart() {
		
        LOGGER.info("Printing cart contents");
        
		System.out.println("Product\t\tQuantity\tPrice\t\tTotal");
		System.out.println("--------------------------------------------");

		double grandTotal = 0;

		for (Product product : products) {
			System.out.printf("%-15s\t%-10d\t$%-10.2f\t$%-10.2f%n",product.getProductName(), product.getQuantity(), product.getPrice(), product.getTotal());
			grandTotal += product.getTotal();
		}

		System.out.println("--------------------------------------------");
		System.out.printf("Total\t\t\t\t\t\t$%-10.2f%n", grandTotal);
	}
	/**
	 * Contains product Method 
	 * @param productName
	 * @return
	 */
	private boolean containsProduct(String productName) {
		for (Product product : products) {
			if (product.getProductName().equals(productName)) {
				return true;
			}
		}
		return false;
	}
}
