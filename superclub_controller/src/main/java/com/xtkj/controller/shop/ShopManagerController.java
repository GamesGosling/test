package com.xtkj.controller.shop;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtkj.pojo.Product;
import com.xtkj.service.shop.IShopService;
import com.xtkj.utils.ObjectResult;

@Controller
@RequestMapping("/shop")
public class ShopManagerController {

	@Autowired
	private IShopService iShopService;
	
	/**
	 * -查询商品列表,排在前面的为热门商品
	 * @param request
	 * @return 
	 */
	@RequestMapping("/listItems")
	@ResponseBody
	public ObjectResult commodityList(HttpServletRequest request) {
		ObjectResult json = null; 
		try {
			List<Product> listProduct=iShopService.listProducts();
			json=new ObjectResult("200", "success",listProduct);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}
		return json;			
	}
	
	
	/**
	 * -根据商品id查询商品详细信息
	 * @param request
	 * @param product
	 * @return
	 */
	@RequestMapping("productInfo")
	@ResponseBody
	public ObjectResult commodityInfo(HttpServletRequest request,Product product) {
		ObjectResult json = null; 
		try {
			List<Product> listProduct=iShopService.listProducts();
			json=new ObjectResult("200", "success",listProduct);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}
		return json;			
	}
	
}
