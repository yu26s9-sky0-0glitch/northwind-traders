package com.pluralsight;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataManager {

    public static void DataManager() {
        BasicDataSource dataSource= new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("testUser1");
        dataSource.setPassword("password123");
        String sql = "select ProductID,ProductName,UnitPrice,UnitsInStock" +
                " from products";
        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();    ){
                System.out.printf("%-5s %-35s %-7s %-7s\n-----------------------------------------------------------\n","Id", "Name", "Price", "Stock");
            while(rs.next()){
              int productId = rs.getInt(1);
              String name =  rs.getString(2);
              double price = rs.getDouble(3);
              int unitInStock = rs.getInt(4);
                System.out.printf("%-5d %-35s %-7.2f %-7d\n",productId,name,price,unitInStock);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
