package com.example.gademo;

import line.OrderLine;
import line.OrderLineRepository;
import order.Order;
import order.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import product.Product;
import product.ProductRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class GAdemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(GAdemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner importData(OrderRepository orderRepository,
                                        OrderLineRepository orderLineRepository,
                                        ProductRepository productRepository) {
        return (args) -> {

            /**
             *  Orders
             */
            final List<Order> orders = new ArrayList<>();
            orders.add(new Order(new Date()));
            orders.add(new Order(new Date()));
            orders.add(new Order(new Date()));
            orderRepository.saveAll(orders);

            /**
             *  Products
             */
            final List<Product> products = new ArrayList<>();
            products.add(new Product("Product 1"));
            products.add(new Product("Product 2"));
            products.add(new Product("Product 3"));
            productRepository.saveAll(products);

            /**
             *  Orderlines
             */
            final List<OrderLine> orderLines = new ArrayList<>();
            orderLines.add(new OrderLine(orders.get(0), products.get(0)));
            orderLines.add(new OrderLine(orders.get(1), products.get(1)));
            orderLines.add(new OrderLine(orders.get(2), products.get(2)));
            orderLineRepository.saveAll(orderLines);

        };

    }

}
