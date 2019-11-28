package com.xtkj.service.shop;

import com.xtkj.cartpojo.ProductColorSizeVo;
import com.xtkj.cartpojo.ShopCart;
import com.xtkj.pojo.Order;

public interface IShopCartService {

	ShopCart selectProByProIdAndColorId(ProductColorSizeVo productColorSizeVo, ShopCart shopCart);
	
	ShopCart addToShopCart(ProductColorSizeVo productColorSizeVo,ShopCart shopCart);
	
	boolean paySumMoney(ShopCart shopcart, Order order) throws Exception;
	
	ShopCart delToShopCart(ProductColorSizeVo productColorSizeVo,ShopCart shopCart);
}
