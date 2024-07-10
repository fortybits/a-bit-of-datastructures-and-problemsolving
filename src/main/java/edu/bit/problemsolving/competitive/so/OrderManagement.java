package edu.bit.problemsolving.competitive.so;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OrderManagement {

    private BigDecimal findHighestValueOrder(List<Order> customerOrders) {
        return customerOrders.stream()
                .flatMap(o -> o.orderLines().stream())
                .map(OrderLine::product)
                .map(Product::price)
                .max(Comparator.comparing(e -> e))
                .orElse(BigDecimal.ZERO);
    }

    record Order(String id, Set<OrderLine> orderLines, Customer customer) {
    }

    record OrderLine(Product product, Integer quantity) {
    }

    record Product(String name, BigDecimal price) {
    }

    public class OrdersAnalyzer {
        /**
         * Should return at most three most popular products. Most popular product is the product that have the most occurrences
         * in given orders (ignoring product quantity).
         * If two products have the same popularity, then products should be ordered by name
         *
         * @param orders orders stream
         * @return list with up to three most popular products
         */
        public List<Product> findThreeMostPopularProducts(Stream<Order> orders) {
            Map<Product, Long> productFrequency = orders.flatMap(o -> o.orderLines.stream())
                    .collect(Collectors.groupingBy(OrderLine::product, Collectors.counting()));
            Comparator<Map.Entry<Product, Long>> productFrequencyComparator =
                    Comparator.<Map.Entry<Product, Long>>comparingLong(Map.Entry::getValue).reversed()
                            .thenComparing(e -> e.getKey().name());
            return productFrequency.entrySet().stream()
                    .sorted(productFrequencyComparator)
                    .limit(3)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
        }

        /**
         * Should return the most valuable customer, that is the customer that has the highest value of all placed orders.
         * If two customers have the same orders value, then any of them should be returned.
         *
         * @param orders orders stream
         * @return Optional of most valuable customer
         */
        public Optional<Customer> findMostValuableCustomer(Stream<Order> orders) {
            Map<Customer, List<Order>> customerOrders = orders.collect(Collectors.groupingBy(Order::customer));

            return customerOrders.entrySet().stream()
                    .max(Comparator.comparing(o -> findHighestValueOrder(o.getValue())))
                    .map(Map.Entry::getKey);
        }
    }

    class Customer {
    }
}