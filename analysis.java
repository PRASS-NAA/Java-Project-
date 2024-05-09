package org.example;
import java.sql.*;

public class analysis {

    //static final String QUERY = "SELECT * from products where pid = ?";

    public static void main(String[] args) throws Exception{

        //Total sales amount for a specific month
        String queryTotalSales = "SELECT SUM(salesamt) AS total_sales FROM salesmaster WHERE MONTH(stransdate) = ? AND YEAR(stransdate) = ?";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(queryTotalSales)) {
            pstmt.setInt(1, 5); // Month (e.g., May)
            pstmt.setInt(2, 2024); // Year
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                double totalSales = rs.getDouble("total_sales");
                System.out.println("Total Sales Amount: " + totalSales);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        //Highest selling product
        String queryHighestSelling = "SELECT p.prodname, SUM(sd.quantity) AS total_quantity_sold " +
                "FROM salesdetails sd " +
                "JOIN products p ON sd.product_id = p.product_id " +
                "JOIN salesmaster sm ON sd.stransid = sm.stransid " +
                "WHERE MONTH(sm.stransdate) = ? AND YEAR(sm.stransdate) = ? " +
                "GROUP BY p.prodname ORDER BY total_quantity_sold DESC LIMIT 1";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(queryHighestSelling)) {
            pstmt.setInt(1, 5); // Month (e.g., May)
            pstmt.setInt(2, 2024); // Year
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String productName = rs.getString("prodname");
                int totalQuantitySold = rs.getInt("total_quantity_sold");
                System.out.println("Highest Selling Product: " + productName + " (Total Quantity Sold: " + totalQuantitySold + ")");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        //Lowest selling product:
        String queryLowestSelling = "SELECT p.prodname, SUM(sd.quantity) AS total_quantity_sold " +
                "FROM salesdetails sd " +
                "JOIN products p ON sd.product_id = p.product_id " +
                "JOIN salesmaster sm ON sd.stransid = sm.stransid " +
                "WHERE MONTH(sm.stransdate) = ? AND YEAR(sm.stransdate) = ? " +
                "GROUP BY p.prodname ORDER BY total_quantity_sold ASC LIMIT 1";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(queryLowestSelling)) {
            pstmt.setInt(1, 5); // Month (e.g., May)
            pstmt.setInt(2, 2024); // Year
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String productName = rs.getString("prodname");
                int totalQuantitySold = rs.getInt("total_quantity_sold");
                System.out.println("Lowest Selling Product: " + productName + " (Total Quantity Sold: " + totalQuantitySold + ")");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


        // Customer with Highest Points
        String queryHighestPoints = "SELECT cname, points FROM customer WHERE points = (SELECT MAX(points) FROM customer)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(queryHighestPoints)) {
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Customer with Highest Points");
            while(rs.next()){
                String customerName = rs.getString("cname");
                int points = rs.getInt("points");
                System.out.println(customerName + " (Points: " + points + ")");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        // Customer with Lowest Points
        String queryLowestPoints = "SELECT cname, points FROM customer WHERE points = (SELECT MIN(points) FROM customer)";
        try (Connection conn = DbConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(queryLowestPoints)) {
            ResultSet rs = pstmt.executeQuery();
            System.out.println("Customer with Lowest Points");
            while(rs.next()){
                String customerName = rs.getString("cname");
                int points = rs.getInt("points");
                System.out.println(customerName + " (Points: " + points + ")");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }


    }
}