package com.xtkj.controller.shop;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtkj.cartpojo.ProductColorSizeVo;
import com.xtkj.cartpojo.ShopCart;
import com.xtkj.pojo.Order;
import com.xtkj.service.shop.IShopCartService;
import com.xtkj.utils.ObjectResult;

@Controller
@RequestMapping("/shop")
public class ShopCartManagerController {
	
	@Autowired
	private IShopCartService ShopCartService;
	@RequestMapping("/addCart")
	public void addShopToCart(HttpServletRequest request,HttpServletResponse response, ProductColorSizeVo productColorSizeVo) {
		ShopCart shopCart;
		
		if(request.getSession().getAttribute("shopCart")==null) {
			
			shopCart=new ShopCart();
			
			request.getSession().setAttribute("shopCart", shopCart);
		}else {
			shopCart=(ShopCart) request.getSession().getAttribute("shopCart");
		}
		

		try {
			ShopCart pCart=ShopCartService.selectProByProIdAndColorId(productColorSizeVo,shopCart);
			request.getSession().setAttribute("shopCart", pCart);
			if(pCart.getOrders().isEmpty()) {
				response.getWriter().println("500");
			}else {
				response.getWriter().println("200");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


	@RequestMapping("/delProFromCart")
	@ResponseBody
	public ObjectResult delToShopCart(HttpServletRequest request,HttpServletResponse response,ProductColorSizeVo productColorSizeVo) {
		ObjectResult json = null; 
		try {
			ShopCart shopCart=(ShopCart) request.getSession().getAttribute("shopCart");
			ShopCart pCart=ShopCartService.delToShopCart(productColorSizeVo, shopCart);			
			json=new ObjectResult("200","success",pCart);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}


	/**
	 * -结账
	 * @param request
	 * @param order
	 * @return
	 */
	@RequestMapping("/payforMoney")
	@ResponseBody
	public ObjectResult paySumMoney(HttpServletRequest request,Order order) {
		ObjectResult json = null; 
		try {
			ShopCart shopCart=(ShopCart) request.getSession().getAttribute("shopCart");
			Boolean i=ShopCartService.paySumMoney(shopCart, order);

			if(i) {
				json=new ObjectResult("200", "success","支付成功");
			}else {
				json=new ObjectResult("200", "fail","支付失败");
			}

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}

}
