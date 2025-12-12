package org.example.product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ProductRepo {
    private final List<Product> productsList = new ArrayList<>();

    public void addProduct(Product product) {
        productsList.add(product);
    }

    public Product findProductById(String productId) {
        for (Product product : productsList) {
            if(product.id().equals(productId)) {
                return product;
            }
        }

        return null;
    }

    public void removeProduct(String productId) {
        Product product = findProductById(productId);
        if(product != null) {
            productsList.remove(product);
        }
    }

    public void removeAllProducts() {
        productsList.clear();
    }

    public Product retrieveProductById(String productId) {
        Product product = findProductById(productId);

        if (product != null) {
            removeProduct(productId);
        }

        return product;
    }

    public List<Product> retrieveAllProducts() {
        List<Product> retrievedProductsList = new ArrayList<>(productsList);
        productsList.clear();

        return retrievedProductsList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ProductRepo that = (ProductRepo) o;
        return Objects.equals(productsList, that.productsList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productsList);
    }

    @Override
    public String toString() {
        return "ProductRepo{" +
                "productsList=" + productsList +
                '}';
    }
}