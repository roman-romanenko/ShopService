package org.example.shop;

import org.example.order.Order;
import org.example.order.OrderRepo;
import org.example.product.Product;
import org.example.product.ProductRepo;

import java.util.*;


public class ShopService {
    private static int orderId = 1;

    private final ProductRepo products;
    private final OrderRepo orders;

    public ShopService(ProductRepo products, OrderRepo orders) {
        this.products = products;
        this.orders = orders;
    }

    public void addProductToOrder(Order order, String productId, int quantity) {
        Product product = products.retrieveProductById(productId, quantity);

        if (product == null) {
            System.out.println("Product not found: " + productId);
            return;
        }

        if(order.products().containsKey(product)) {
            int availableQuantity = order.products().get(product);

            if(order.products().containsKey(product) && availableQuantity > 0) {
                order.products().put(product, availableQuantity + quantity);
            }
        } else {
            order.products().put(product, quantity);
        }
    }

    public Order makeOrder() {
        Order order = new Order(orderId, new HashMap<>());

        orders.add(order);
        orderId++;
        return order;
    }

    public ProductRepo getProducts() {
        return products;
    }

    public OrderRepo getOrders() {
        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ShopService that = (ShopService) o;
        return Objects.equals(products, that.products) && Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(products, orders);
    }

    @Override
    public String toString() {
        return "ShopService{" +
                "products=" + products +
                ", orders=" + orders +
                '}';
    }
}
