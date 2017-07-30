package com.hubo.mybatis.pojo;

import java.io.Serializable;

/**
 * 订单明细表
 * @author hubo
 *
 */
public class OrderDetail implements Serializable {

	private static final long serialVersionUID = -3489784474931560143L;

	private Integer id;
	private Integer ordersId;
	private Integer itemsId;
	private Integer itemsNum;
	
	private Items items;
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getOrdersId() {
		return ordersId;
	}

	public void setOrdersId(Integer ordersId) {
		this.ordersId = ordersId;
	}

	public Integer getItemsId() {
		return itemsId;
	}

	public void setItemsId(Integer itemsId) {
		this.itemsId = itemsId;
	}

	public Integer getItemsNum() {
		return itemsNum;
	}

	public void setItemsNum(Integer itemsNum) {
		this.itemsNum = itemsNum;
	}

	public Items getItems() {
		return items;
	}

	public void setItems(Items items) {
		this.items = items;
	}
	
	
}
