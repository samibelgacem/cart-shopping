package com.natixis.exercice.cart.utils;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.natixis.exercice.cart.exception.JsonGenerationException;
import com.natixis.exercice.cart.model.Product;

public class ShoppingCartUtils {
	
	// Logger
    private static final Logger LOGGER = LoggerFactory.getLogger(ShoppingCartUtils.class);

	/**
	 * Generate a ShoppingCart Json File Method
	 * @param filePath
	 */
	public static void mapShoppingCartToJsonFile(String filePath, List<Product> products) {
		try {
            LOGGER.info("Generating JSON file: {}", filePath);

			ObjectMapper objectMapper = new ObjectMapper();
			objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
			objectMapper.writeValue(new File(filePath), products);
		} catch (IOException e) {
            LOGGER.error("Error generating JSON file", e);
            throw new JsonGenerationException("Error generating JSON file.", e);		}
	}
}
