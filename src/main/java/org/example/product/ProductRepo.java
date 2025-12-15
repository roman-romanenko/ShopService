package org.example.product;

import java.util.*;

public class ProductRepo {
    private final Map<Product, Integer> products = new HashMap<>();

    public void addProduct(Product product) {
        if (products.containsKey(product)) {
            System.out.println("Product already exists");
            return;
        }

        products.put(product, 0);
    }

    public void addProduct(Product product, int quantity) {
        int availableQuantity = products.containsKey(product) ? getQuantity(product) : 0;

        products.put(product, availableQuantity + quantity);
    }

    public int getQuantity(Product product) {
        return product == null ? 0 : products.get(product);
    }

    public Product findProductById(String productId) {
        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            Product product = entry.getKey();
            if (product.id().equals(productId)) {
                return entry.getKey();
            }
        }

        return null;
    }

    public void removeProduct(String productId) {
        Product product = findProductById(productId);
        if(product != null) {
            products.remove(product);
        }
    }

    public void removeProduct(Product product) {
        products.remove(product);
    }

    public void removeAllProducts() {
        products.clear();
    }

    public Product retrieveProductById(String productId, int quantity) {
        Product product = findProductById(productId);
        int availableQuantity = products.containsKey(product) ? getQuantity(product) : 0;

        if(availableQuantity == 0) {
            System.out.println("There are no products");
            return null;
        }

        if (availableQuantity >= quantity) {
            products.put(product, availableQuantity - quantity);
        } else {
            System.out.println("There is no" + product.name() + " with the given quantity, rest is: " + availableQuantity);
        }

        return product;
    }

//    public Product retrieveProductById(Product product, int quantity) {
//
//        Product product = findProductById(productId);
//
//
//        if (product != null) {
//            removeProduct(productId);
//        }
//
//        return product;
//    }

    public Map<Product, Integer> retrieveAllProducts() {
        Map<Product, Integer> retrievedProductsList = new HashMap<>(products);
        products.clear();

        return retrievedProductsList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(products, that.products);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(products);
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "productsList=" + products +
                '}';
    }
}