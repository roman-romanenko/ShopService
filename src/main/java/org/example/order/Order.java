package org.example.order;

import org.example.product.Product;
import java.util.Map;

public record Order(int orderId, Map<Product, Integer> products) {}
