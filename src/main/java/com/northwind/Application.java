package com.northwind;

import com.northwind.data.CustomerDao;
import com.northwind.data.OrderDetailDao;
import com.northwind.data.ProductDao;
import com.northwind.model.Customer;
import com.northwind.model.OrderDetail;
import com.northwind.model.Product;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        String username = args[0];
        String password = args[1];
        String url = "jdbc:mysql://localhost:3306/northwind";

        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);


        System.out.println("========================================");
        System.out.println("TESTING CUSTOMER DAO");
        System.out.println("========================================\n");

        CustomerDao customerDao = new CustomerDao(dataSource);

        // Test 1: Get all customers
        System.out.println("--- Test 1: Get All Customers ---");
        List<Customer> customers = customerDao.getAll();
        System.out.println("Total customers: " + customers.size());
        if (!customers.isEmpty()) {
            System.out.println("First customer: " + customers.get(0));
        }

        // Test 2: Find a specific customer
        System.out.println("\n--- Test 2: Find Customer by ID ---");
        Customer foundCustomer = customerDao.find("ALFKI");
        if (foundCustomer != null) {
            System.out.println("Found: " + foundCustomer);
        } else {
            System.out.println("Customer ALFKI not found.");
        }

        // Test 3: Add a new customer
        System.out.println("\n--- Test 3: Add New Customer ---");
        Customer newCustomer = new Customer(
                "TSTID",
                "Test Company",
                "John Doe",
                "Manager",
                "123 Test St",
                "Test City",
                "TC",
                "12345",
                "USA",
                "555-1234",
                "555-5678"
        );
        Customer addedCustomer = customerDao.add(newCustomer);
        System.out.println("Added: " + addedCustomer);

        // Test 4: Verify the customer was added
        System.out.println("\n--- Test 4: Verify Customer Was Added ---");
        Customer verifyCustomer = customerDao.find("TSTID");
        if (verifyCustomer != null) {
            System.out.println("Verified: " + verifyCustomer);
        } else {
            System.out.println("Customer TSTID not found after adding.");
        }

        // Test 5: Update the customer
        System.out.println("\n--- Test 5: Update Customer ---");
        if (verifyCustomer != null) {
            verifyCustomer.setCompanyName("Updated Test Company");
            verifyCustomer.setContactName("Jane Smith");
            verifyCustomer.setPhone("555-9999");
            customerDao.update(verifyCustomer);
            System.out.println("Updated customer TSTID");

            Customer updatedCustomer = customerDao.find("TSTID");
            System.out.println("After update: " + updatedCustomer);
        }

        // Test 6: Delete the customer
        System.out.println("\n--- Test 6: Delete Customer ---");
        customerDao.delete("TSTID");
        System.out.println("Deleted customer TSTID");

        Customer deletedCustomer = customerDao.find("TSTID");
        if (deletedCustomer == null) {
            System.out.println("Confirmed: Customer TSTID no longer exists.");
        } else {
            System.out.println("Warning: Customer TSTID still exists after deletion.");
        }

        System.out.println("\n========================================");
        System.out.println("TESTING PRODUCT DAO");
        System.out.println("========================================\n");

        ProductDao productDao = new ProductDao(dataSource);

        System.out.println("--- Test 1: Get All Products ---");
        List<Product> products = productDao.getAll();
        System.out.println("Total Products: " + products.size());
        if(!products.isEmpty()) {
            System.out.println("First Product: " + products.get(0));
        }

        System.out.println("\n --- Test 2: Find Product by ID ---");
        Product foundProduct = productDao.find(12);
        if(foundProduct != null){
            System.out.println("Found " + foundProduct);
        } else {
            System.out.println("Product 12 not found.");
        }

        OrderDetailDao orderDetaildao = new OrderDetailDao(dataSource);
        List<OrderDetail> orderDetails = orderDetaildao.getAll();
        System.out.println(orderDetails);

    }
}
