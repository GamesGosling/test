package com.xtkj.service.shop;

import java.util.List;

import com.xtkj.pojo.Product;
import com.xtkj.pojo.ProductColor;
import com.xtkj.pojo.ProductSize;

public interface IShopService {

	/**
	 * -查询商品列表
	 * @return
	 */
	List<Product> listProducts();
	
	/**
	 * -查询商品id查询颜色
	 * @return
	 */
	List<ProductColor> productColorInfo(Product product);
	
	/**
	 * -查询商品id和颜色查询尺寸
	 * @return
	 */
	List<ProductSize> productColorSizeInfo(Product product,String colorId);
}
