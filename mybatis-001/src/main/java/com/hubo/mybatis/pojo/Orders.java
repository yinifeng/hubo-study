package com.hubo.mybatis.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 订单表
 * @author hubo
 *
 */
public class Orders implements Serializable{

	private static final long serialVersionUID = -8092190099305362776L;
	private Integer id;
	private Integer userId;
	private String number;
	private Date createTime;
	private String note;
	
	//利用组合
	private User user;
	
	private List<OrderDetail> orderDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
}
