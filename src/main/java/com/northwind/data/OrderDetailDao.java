package com.northwind.data;

import com.northwind.model.OrderDetail;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDetailDao {
    private DataSource dataSource;

    public OrderDetailDao(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<OrderDetail> getAll(){
        List<OrderDetail> orderDetails = new ArrayList<>();

        String query = """
                SELECT OrderID, ProductID, UnitPrice, Quantity, Discount
                FROM `Order Details`;
                """;
        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            try (ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    OrderDetail orderDetail = new OrderDetail(
                            resultSet.getInt("OrderID"),
                            resultSet.getInt("ProductID"),
                            resultSet.getDouble("UnitPrice"),
                            resultSet.getInt("Quantity"),
                            resultSet.getDouble("Discount"));

                    orderDetails.add(orderDetail);
                }
            }

        } catch (SQLException e) {
            System.out.println("There was an error retrieving the data. Please try again.");
            e.printStackTrace();
        }

        return orderDetails;

    }
}
