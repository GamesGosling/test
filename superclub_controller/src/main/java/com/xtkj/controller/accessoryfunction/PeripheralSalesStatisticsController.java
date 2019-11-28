package com.xtkj.controller.accessoryfunction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xtkj.pojo.OrderProductDetail;
import com.xtkj.service.accessoryfunction.IPeripheralSalesStatisticsService;
import com.xtkj.utils.ObjectResult;


/**
 * @version:1.0
 * @Description: 商品销售统计接口
 * @author: HCC
 * @date: 2019年7月7日下午4:37:57
 */
@Controller
@RequestMapping("/peripheralSales")
public class PeripheralSalesStatisticsController {

	@Autowired
	private IPeripheralSalesStatisticsService iPeripheralSalesStatisticsService;

	@RequestMapping("/year")
	@ResponseBody
	public ObjectResult userActivityDateYear() {
		ObjectResult json = null; 
		try {
			List<OrderProductDetail> listOrderProductDetail=iPeripheralSalesStatisticsService.userRegistrationVolumeOnYear();
			json=new ObjectResult("200", "success",listOrderProductDetail);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}


	@RequestMapping("/quarter")
	@ResponseBody
	public ObjectResult userActivityDateQuarter() {
		ObjectResult json = null; 
		try {
			List<OrderProductDetail> listOrderProductDetail=iPeripheralSalesStatisticsService.userRegistrationVolumeOnQueter();
			json=new ObjectResult("200", "success",listOrderProductDetail);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}


	@RequestMapping("/month")
	@ResponseBody
	public ObjectResult userActivityDateMonth() {
		ObjectResult json = null; 
		try {
			List<OrderProductDetail> listOrderProductDetail=iPeripheralSalesStatisticsService.userRegistrationVolumeOnMonth();
			json=new ObjectResult("200", "success",listOrderProductDetail);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}

	@RequestMapping("/day")
	@ResponseBody
	public ObjectResult userActivityDateDay() {
		ObjectResult json = null; 
		try {
			List<OrderProductDetail> listOrderProductDetail=iPeripheralSalesStatisticsService.userRegistrationVolumeOnDay();
			json=new ObjectResult("200", "success",listOrderProductDetail);

		} catch (Exception e) {
			e.printStackTrace();
			json=new ObjectResult("500", "error", e.getMessage());
		}

		return json;		
	}

}
