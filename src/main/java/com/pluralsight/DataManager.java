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
        String sql = "select * from products";
        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();    ){
            while(rs.next()){
              String name =  rs.getString("ProductName");
                System.out.println(name);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
