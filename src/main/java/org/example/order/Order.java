package org.example.order;

import org.example.product.Product;

import java.util.List;

public record Order(int orderId, List<Product> products) {}
