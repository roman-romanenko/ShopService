package org.example.order;

import org.example.product.Product;

import java.util.List;

public interface OrderRepo {
    void add(List<Product> products);
    void addList(List<Order> orders);

    Order getById(int id);
    List<Order> getAll();


    void remove(int id);
    void removeAll();

    Order retrieveById(int id);
    public List<Order> retrieveAll();
}
