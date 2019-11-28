package com.xtkj.service.shop;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.ProductColorMapper;
import com.xtkj.dao.ProductMapper;
import com.xtkj.dao.ProductSizeMapper;
import com.xtkj.pojo.Product;
import com.xtkj.pojo.ProductColor;
import com.xtkj.pojo.ProductSize;

@Service
public class ShopServiceImp implements IShopService{

	@Autowired
	private ProductMapper productMapper;
	@Autowired
	private ProductColorMapper productColorMapper;
	@Autowired
	private ProductSizeMapper productSizeMapper;
	
	//查询商品列表
	@Override
	public List<Product> listProducts() {

		return productMapper.selectProducts();
	}

	//根据商品id查询商品颜色
	public List<ProductColor> productColorInfo(Product product) {
	
		return productColorMapper.selectByKey(product.getId());
	
	}

	//根据商品id和颜色查询商品的尺寸
	public List<ProductSize> productColorSizeInfo(Product product,String colorId) {
		return productSizeMapper.selectSizeByProIdColor(product.getId(), colorId);
	}

}
