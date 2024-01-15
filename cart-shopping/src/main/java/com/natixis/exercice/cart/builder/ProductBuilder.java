package com.natixis.exercice.cart.builder;

import com.natixis.exercice.cart.model.Product;

/**
 * Builder pattern for building Product objects
 */
public class ProductBuilder {
 
	private String productName;
	private int quantity;
	private double price;

	public ProductBuilder withProductName(String productName) {
		this.productName = productName;
		return this;
	}

	public ProductBuilder withQuantity(int quantity) {
		this.quantity = quantity;
		return this;
	}

	public ProductBuilder withPrice(double price) {
		this.price = price;
		return this;
	}

	public Product build() {
		return new Product(productName, quantity, price);
	}
}

