package org.example.Pr1;

public class Main {
    public static void main(String[] args) {
        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор");
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном та високою автономністю");
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням");

        System.out.println(product1.getName());
        System.out.println(product2.toString());
        System.out.println(product3.toString());
    }
}