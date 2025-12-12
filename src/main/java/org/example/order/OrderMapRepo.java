package org.example.order;


import org.example.product.Product;

import java.util.*;

public class OrderMapRepo implements OrderRepo{
    private static int orderId = 1;

    private final Map<Integer, Order> orders = new HashMap<>();

    @Override
    public void add(List<Product> products) {
        orders.put(orderId, new Order(orderId, products));
        orderId++;
    }

    @Override
    public Order getById(int id) {
        return orders.get(id);
    }

    @Override
    public void remove(int id) {
        orders.remove(id);
    }

    @Override
    public List<Order> getAll() {
        List<Order> ordersList = new ArrayList<>();

        for(Map.Entry<Integer, Order> entry: orders.entrySet()) {
            ordersList.add(entry.getValue());
        }

        return ordersList;
    }

    @Override
    public void addList(List<Order> ordersList) {
        for(Order order: ordersList) {
            orders.put(order.orderId(), order);
        }
    }

    @Override
    public void removeAll() {
        orders.clear();
    }

    @Override
    public Order retrieveById(int id) {
        Order order = getById(id);
        if(order != null) {
            remove(id);
        }

        return order;
    }

    @Override
    public List<Order> retrieveAll() {
        List<Order> ordersList = new ArrayList<>();
        for(Map.Entry<Integer, Order> entry: orders.entrySet()) {
            ordersList.add(entry.getValue());
        }

        orders.clear();
        return ordersList;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderMapRepo that = (OrderMapRepo) o;
        return Objects.equals(orders, that.orders);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orders);
    }

    @Override
    public String toString() {
        return "OrderMapRepo{" +
                "orders=" + orders +
                '}';
    }
}
