package com.gd.services;

import com.gd.models.order.Order;
import com.gd.models.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by mic on 1/25/17.
 */
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Transactional("orderTransactionManager")
    public Iterable<Order> findAll(){
        return orderRepository.findAll();
    }
}
