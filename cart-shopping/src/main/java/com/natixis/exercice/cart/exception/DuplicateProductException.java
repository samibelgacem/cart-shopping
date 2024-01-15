package com.natixis.exercice.cart.exception;
/**
 * Custom exception for handling repeated products in the cart
 */
public class DuplicateProductException extends RuntimeException {
	
	private static final long serialVersionUID = -7507757711920950004L;

	public DuplicateProductException(String productName) {
		super("Product '" + productName + "' is already in the cart.");
	}
}
