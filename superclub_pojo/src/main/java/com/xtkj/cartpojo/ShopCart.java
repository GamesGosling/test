package com.xtkj.cartpojo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class ShopCart {
	
	private HashMap<String,Items> orders=new  HashMap<>();
	private Integer totalNum;
	private float totalPrice;
	
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public HashMap<String, Items> getOrders() {
		return orders;
	}

	public void setOrders(HashMap<String, Items> orders) {
		this.orders = orders;
	}

	//得到购物车总数量
	public Integer getTotalNum() {
		Set<String> keys= orders.keySet();
		Iterator<String> keyid= keys.iterator();
		int ordertotalsum=0;//订单总数
		while(keyid.hasNext()) {
			String key=keyid.next();
			Items item=orders.get(key);
			ordertotalsum =ordertotalsum+item.getPrototalNum();
		}
		return ordertotalsum;
	}
	//得到购物车总金额
	public float getTotalPrice() {
		Set<String> keys= orders.keySet();
		Iterator<String> keyid= keys.iterator();
		float ordertotalprice=0;//购物车总金额
		while(keyid.hasNext()) {
			String key=keyid.next();
			Items item=orders.get(key);
			ordertotalprice =(float) (ordertotalprice+item.getProtoordertalprice());
		}
		return ordertotalprice;
	}
}