package org.example.order;

import org.example.product.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderListRepo {
    private static int orderId = 1;

    private final List<Order> orderList = new ArrayList<>();

    public void addOrder(List<Product> products) {
        Order order = new Order(orderId++, products);
        orderList.add(order);
    }

    public void addOrders(List<Order> orders) {
        for (Order order : orders) {
            orderList.add(order);
        }
    }

    public void removeOrder(int id) {
        orderList.remove(id);
    }

    public void removeAllOrders() {
        orderList.clear();
    }

    public Order getOrderById(int id) {
        for (Order order : orderList) {
            if(order.orderId() == id)
                return order;
        }

        return null;
    }

    public List<Order> getOrders() {
        return orderList;
    }

    public Order retrieveOrderById(int id) {
        Order order = getOrderById(id);
        orderList.remove(order);

        return order;
    }

    public List<Order> retrieveAllOrders() {
        List<Order> orders = new ArrayList<>(orderList);
        orderList.clear();

        return orders;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        OrderListRepo that = (OrderListRepo) o;
        return Objects.equals(orderList, that.orderList);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(orderList);
    }

    @Override
    public String toString() {
        return "OrderListRepo{" +
                "orderList=" + orderList +
                '}';
    }
}
