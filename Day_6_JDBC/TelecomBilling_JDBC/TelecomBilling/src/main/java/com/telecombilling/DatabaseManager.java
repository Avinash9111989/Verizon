
package com.telecombilling;

import java.sql.*;

public class DatabaseManager {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/telecom";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "admin";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    public static void saveCustomer(Customer customer) throws SQLException {
        String insertSql = "INSERT INTO customers (customer_id, name, contact) VALUES (?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertSql)) {
            stmt.setString(1, customer.getCustomerId());
            stmt.setString(2, customer.getName());
            stmt.setString(3, customer.getContact());
            stmt.executeUpdate();
        }
    }

    public static void saveInvoice(Invoice invoice) throws SQLException {
        String insertSql = "INSERT INTO invoices (invoice_id, customer_id, amount, billing_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(insertSql)) {
            stmt.setString(1, invoice.getInvoiceId());
            stmt.setString(2, invoice.getCustomerId());
            stmt.setDouble(3, invoice.getAmount());
            stmt.setDate(4, new java.sql.Date(invoice.getBillingDate().getTime()));
            stmt.executeUpdate();
        }
    }
}
