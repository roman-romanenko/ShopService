package org.example.order;

import org.example.product.Product;

import java.util.List;

public interface OrderRepo {
    public void add(List<Product> products);
    public Order getById(int id);
    public void remove(int id);
    public List<Order> getAll();
}
