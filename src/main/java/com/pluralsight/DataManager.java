package com.pluralsight;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataManager {
    private BasicDataSource dataSource;

    public  DataManager() {
        this.dataSource= new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://localhost:3306/northwind");
        dataSource.setUsername("testUser1");
        dataSource.setPassword("password123");
    }
    public void getProducts(){
        String sql = "select ProductID,ProductName,UnitPrice,UnitsInStock" +
                " from products";
        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();    ){
            System.out.printf(ColorUtils.YELLOW_BOLD+"%-5s %-35s %-7s %-7s\n-----------------------------------------------------------\n"+ColorUtils.RESET,"Id", "Name", "Price", "Stock");
            while(rs.next()){
                int productId = rs.getInt(1);
                String name =  rs.getString(2);
                double price = rs.getDouble(3);
                int unitInStock = rs.getInt(4);
                System.out.printf(ColorUtils.PURPLE+"%-5d %-35s %-7.2f %-7d\n"+ColorUtils.RESET,productId,name,price,unitInStock);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void getCustomers() {
        String sql = "Select ContactName, CompanyName,City,Country,Phone from customers order by Country";
        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();){
            System.out.printf(ColorUtils.YELLOW_BOLD+"%-20s %-40s %-20s %-20s %-20s\n"+ColorUtils.RESET,"contactName","companyName","city","country","phone");
          while(rs.next()){
              String contactName = rs.getString(1);
              String companyName = rs.getString(2);
              String city = rs.getString(3);
              String country = rs.getString(4);
              String phone = rs.getString(5);
              System.out.printf(ColorUtils.BLUE+"%-20s %-40s %-20s %-20s %-20s\n"+ColorUtils.RESET,contactName,companyName,city,country,phone);
          }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
