package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.entity.ItemBean;

public class ItemDAO {
	
	public ItemBean editItem(String itemName, String makerCode, int price, int itemId) throws ClassNotFoundException, SQLException {
		ItemBean item = null;
		
		String sql = "UPDATE m_item SET (item_name, maker_code, price) = (?, ?, ?) WHERE item_id = ?";
		
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {
			
			pstmt.setString(1, itemName);
			pstmt.setString(2, makerCode);
			pstmt.setInt(3, price);
			pstmt.setInt(4, itemId);
			
			pstmt.executeUpdate();
		}
		return item;
	}
}