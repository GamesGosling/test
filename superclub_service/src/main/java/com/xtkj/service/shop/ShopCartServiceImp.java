package com.xtkj.service.shop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.cartpojo.Items;
import com.xtkj.cartpojo.ProductColorSizeVo;
import com.xtkj.cartpojo.ShopCart;
import com.xtkj.dao.OrderMapper;
import com.xtkj.dao.OrderProductDetailMapper;
import com.xtkj.dao.ProductMapper;
import com.xtkj.pojo.Order;
import com.xtkj.pojo.OrderProductDetail;
import com.xtkj.pojo.Product;

@Service
public class ShopCartServiceImp implements IShopCartService{

	@Autowired
	private ProductMapper ProductMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private OrderProductDetailMapper orderProductDetailMapper;

	/**
	 * -添加到购物车
	 */
	@Override
	public ShopCart selectProByProIdAndColorId(ProductColorSizeVo productColorSizeVo, ShopCart shopCart) {

		Product pro=ProductMapper.selectByPrimaryKey(productColorSizeVo.getProId().getId());
		
		productColorSizeVo.setProId(pro);
		return addToShopCart(productColorSizeVo,shopCart);
	}

	/**
	 * -添加商品到购物车
	 * @param productId
	 * @return
	 */
	public ShopCart addToShopCart(ProductColorSizeVo productColorSizeVo,ShopCart shopCart) {

		//拿到购物车
		HashMap<String, Items> cart= shopCart.getOrders();
		String mapKey=productColorSizeVo.getProId().getId()+productColorSizeVo.getColorId().getId();

		if (cart.containsKey(mapKey)) {
			System.out.println("是加还是减");
			cart.get(mapKey).setPrototalNum((cart.get(mapKey).getPrototalNum() + 1)); // 列项总数
			System.out.println("多次添加成功");
		} else {
			Items items = new Items();
			//item.setProduct(ProColorSizeVo);
			items.setProduct(productColorSizeVo);
			items.setPrototalNum(1);// 订单的数量
			cart.put(mapKey, items);// 向订单集合购物车里面添加商品数据
			System.out.println("第一次添加成功");
		}
		return shopCart;
	}
	
	/**
	 * -删除商品从购物车
	 * @param productColorSizeVo
	 * @param shopCart
	 * @return
	 */
	public ShopCart delToShopCart(ProductColorSizeVo productColorSizeVo,ShopCart shopCart) {
		//拿到购物车
		HashMap<String, Items> cart= shopCart.getOrders();
		String mapKey=productColorSizeVo.getProId().getId()+productColorSizeVo.getColorId().getId();
		if (cart.containsKey(mapKey)&&(cart.get(mapKey).getPrototalNum() - 1)>=0) {	
			cart.get(mapKey).setPrototalNum((cart.get(mapKey).getPrototalNum() - 1)); // 列项总数
		} 
		return shopCart;
	}
	
	/**
	 * @param shopcart
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	public boolean updateProData(ShopCart shopcart, Order order) throws Exception {
		Boolean index=true;
		HashMap<String, Items> orders = shopcart.getOrders();// 拿到购物车的map集合

		try {
			//订单编号主键
			String orderId=UUID.randomUUID().toString();
			// 向订单表中插入数据
			orderMapper.insertOrders(order);			
			order.setId(orderId);
			// 向订单商品表中插入数据
			insert_order_pro(orders,orderId);
			
			/*更新账户余额
			String sql2 = "update user set user_balance=user_balance-" + shopcart.getTotalPrice() + " where user_id ="
					+ userid + "";*/
			
		} catch (Exception e) {
			index=false;
			e.printStackTrace();
		}
		return index; 		
	}

	// 向订单商品表插入数据
	public void insert_order_pro(HashMap<String, Items> orders,String orderId)
			throws Exception {
		
		Set<String> pro_keys = orders.keySet();
		Iterator<String> pro_key = pro_keys.iterator();
		while (pro_key.hasNext()) {
			String key = pro_key.next();
			Items item = orders.get(key);
			String orderProId=UUID.randomUUID().toString();
			
			OrderProductDetail orderProDetail=new OrderProductDetail(orderProId, 
					orderId, item.getProduct().getProId().getId(), 
					item.getProduct().getProId().getPrice(), 
					item.getPrototalNum(), 
					item.getProduct().getColorId().getId(), 
					item.getProduct().getSizeId().getId(),
					item.getProtoordertalprice());
			orderProductDetailMapper.insertSelective(orderProDetail);
		}
	}
	
	/**
	 * 
	 * @param userid -------根据用户id清空购物车
	 * @throws Exception
	 */
	public boolean paySumMoney(ShopCart shopcart, Order order) throws Exception {		
		boolean i=this.updateProData(shopcart,order);
		if(i) {
			shopcart.getOrders().clear();
			return i;
		}else {
			return i;
		}
	}

}
