package model.entity;

import java.io.Serializable;

public class ItemBean implements Serializable {
	/**
	 * 商品ID
	 */
	private int itemId;
	/**
	 * 商品名
	 */	
	private String itemName;
	/**
	 *　メーカーコード
	 */	
	private String makerCode;
	/**
	 * 価格(万)
	 */
	private int price;
	/**
	 * 登録日
	 */
	private int insertDatetime;
	/**
	 * 更新日
	 */
	private int updateDatetime;
	/**
	 * デフォルトコンストラクタ
	 */
	public ItemBean() {
		
	}
	
	/**
	 * @return itemId
	 */
	public int getItemId() {
		return itemId;
	}
	
	/**
	 * @param itemId
	 */
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	
	/**
	 * @return itemName
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * @param itemName
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	
	/**
	 * @return makerCode
	 */
	public String getMakerCode() {
		return makerCode;
	}
	
	/**
	 * @param makerCode
	 */
	public void setMakerCode(String makerCode) {
		this.makerCode = makerCode;
	}
	
	/**
	 * @return price
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * @param price
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * @return insertDatetime
	 */
	public int getInsertDatetime() {
		return insertDatetime;
	}
	
	
	/**
	 * @param insertDatetime
	 */
	public void setInsertDatetime(int insertDatetime) {
		this.insertDatetime = insertDatetime;
	}
	
	/**
	 * @return updateDatetime
	 */
	public int getUpdateDatetime() {
		return updateDatetime;
	}
	
	/**
	 * @param updateDatetime
	 */
	public void setUpdateDatetime(int updateDatetime) {
		this.updateDatetime = updateDatetime;
	}
}
