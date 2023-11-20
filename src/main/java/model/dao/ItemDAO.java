package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.ItemBean;

public class ItemDAO {

	public ItemBean getItemDetail(String itemId) throws ClassNotFoundException, SQLException {
		// 各値を入れる為の配列作成
		ItemBean item = null;
		// 読み込みたいSQL文を記述
		String sql = "select\n"
				+ "  mi.item_id,\n"
				+ "  mi.item_name,\n"
				+ "  mm.maker_name,\n"
				+ "  mi.price,\n"
				+ "  mi.insert_datetime,\n"
				+ "  mi.update_datetime\n"
				+ "from\n"
				+ "  m_item mi\n"
				+ "  inner join m_maker mm on mi.maker_code = mm.maker_code where item_id = ?;";
		// try with resources & プリペアドステイトメントでConnectionManagerと連携
		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			// プレースホルダに値をセット
			pstmt.setString(1, itemId);

			// SQLを実行
			ResultSet res = pstmt.executeQuery();
			// m_itemの各カラムと一致する情報がデータベースにあれば、ItemBeanをインスタンス化し、各カラムの値をインスタンスにセット
			if (res.next()) {
				item = new ItemBean();
				item.setItemId(res.getInt("itemId"));
				item.setItemName(res.getString("itemName"));
				item.setMakerCode(res.getString("makerCode"));
				item.setPrice(res.getInt("price"));
				item.setInsertDatetime(res.getDate("insertDatetime"));
				item.setUpdateDatetime(res.getDate("updateDatetime"));
			}
		}
		return item;
	}

	public ItemBean editItem(String itemName, String makerCode, int price) throws ClassNotFoundException, SQLException {
		ItemBean item = null;

		String sql = "UPDATE m_item SET (item_name, maker_code, price) = (?, ?, ?)";

		try (Connection con = ConnectionManager.getConnection();
				PreparedStatement pstmt = con.prepareStatement(sql)) {

			pstmt.setString(1, itemName);
			pstmt.setString(2, makerCode);
			pstmt.setInt(3, price);

			pstmt.executeUpdate();
		}
		return item;
	}
}
