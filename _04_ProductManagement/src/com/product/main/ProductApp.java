package com.product.main;

import java.util.List;
import java.util.Scanner;

import com.product.bean.Product;
import com.product.service.ProductDao;
import com.product.service.ProductDaoImpl;

public class ProductApp {

    public static void main(String[] args) {

        ProductDao dao = new ProductDaoImpl();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("1. Add Product");
            System.out.println("2. View Product by ID");
            System.out.println("3. View All Products");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");

            System.out.print("Enter choice : ");
            int ch = sc.nextInt();

            switch (ch) {

                case 1 -> {
                    System.out.print("Enter id : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter price : ");
                    double price = sc.nextDouble();

                    System.out.print("Enter quantity : ");
                    int quantity = sc.nextInt();

                    Product product = new Product(id, name, price, quantity);

                    int result = dao.addProduct(product);

                    if (result > 0)
                        System.out.println("Product added successfully.");
                    else
                        System.out.println("Product not added.");

                    System.out.println();
                }

                case 2 -> {
                    System.out.print("Enter id to search product : ");
                    int id = sc.nextInt();

                    Product product = dao.getProductById(id);

                    if (product != null)
                        System.out.println(product);
                    else
                        System.out.println("Product not found.");

                    System.out.println();
                }

                case 3 -> {
                    List<Product> products = dao.getAllProducts();

                    if (products.isEmpty())
                        System.out.println("No products available.");
                    else
                        products.forEach(System.out::println);

                    System.out.println();
                }

                case 4 -> {
                    System.out.print("Enter id to update product : ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter updated name : ");
                    String name = sc.nextLine();

                    System.out.print("Enter updated price : ");
                    double price = sc.nextDouble();

                    System.out.print("Enter updated quantity : ");
                    int quantity = sc.nextInt();

                    Product product = new Product(id, name, price, quantity);

                    int result = dao.updateProduct(product);

                    if (result > 0)
                        System.out.println("Product updated successfully.");
                    else
                        System.out.println("Product not updated.");

                    System.out.println();
                }

                case 5 -> {
                    System.out.print("Enter id to delete product : ");
                    int id = sc.nextInt();

                    int result = dao.deleteProduct(id);

                    if (result > 0)
                        System.out.println("Product deleted successfully.");
                    else
                        System.out.println("Product not found.");

                    System.out.println();
                }

                case 6 -> {
                    System.out.println("Thanks for using the application.");
                    sc.close();
                    System.exit(0);
                }

                default -> {
                    System.out.println("Please enter a valid choice.");
                    System.out.println();
                }
            }
        }
    }
}