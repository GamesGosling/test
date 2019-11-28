package com.xtkj.service.accessoryfunction;

import java.util.List;

import com.xtkj.pojo.OrderProductDetail;

public interface IPeripheralSalesStatisticsService {

	
	List<OrderProductDetail> userRegistrationVolumeOnYear();
	
	List<OrderProductDetail> userRegistrationVolumeOnQueter();
	
	List<OrderProductDetail> userRegistrationVolumeOnMonth();
	
	List<OrderProductDetail> userRegistrationVolumeOnDay();
}
