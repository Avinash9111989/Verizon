package com.verizon.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.verizon.DB.DBUtil;
import com.verizon.pojo.Customer;
import com.verizon.pojo.Tones;

public class Subscription implements Invoice{
	public boolean subscribe(Customer c,Tones t) {
        String sql = "INSERT INTO subscription (titleId, custId, isActive,startDate,endDate) VALUES (?, ?,?, NOW(),date_add(now(),interval 1 month))";
        
        try (Connection conn = DBUtil.getInstance().getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, t.getToneId());
            pstmt.setInt(2, c.getCustomerId());
            pstmt.setBoolean(3, true);

            int rowsInserted = pstmt.executeUpdate();
            return rowsInserted > 0;

        } catch (SQLException e) {
            System.err.println("Error subscribing to VAS: " + e.getMessage());
            return false;
        }
    }

	@Override
	public void generateInvoice() {
		
		
	}

//public void unsubscribe() {
//	DBUtil con=DBUtil.getInstance();
//	System.out.println(con.toString());
//}
//@Override
//public void generateInvoice() {
//	DBUtil con=DBUtil.getInstance();
//	System.out.println(con.toString());
//	
//}
}
