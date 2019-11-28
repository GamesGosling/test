package com.xtkj.service.accessoryfunction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtkj.dao.OrderProductDetailMapper;
import com.xtkj.pojo.OrderProductDetail;

@Service
public class PeripheralSalesStatisticsServiceImp implements IPeripheralSalesStatisticsService{

	@Autowired
	private OrderProductDetailMapper orderProductDetailMapper;
	
	@Override
	public List<OrderProductDetail> userRegistrationVolumeOnYear() {
		
		return orderProductDetailMapper.selectYear();
	}

	@Override
	public List<OrderProductDetail> userRegistrationVolumeOnQueter() {
		
		return orderProductDetailMapper.selectQuarter();
	}

	@Override
	public List<OrderProductDetail> userRegistrationVolumeOnMonth() {
		
		return orderProductDetailMapper.selectMonth();
	}

	@Override
	public List<OrderProductDetail> userRegistrationVolumeOnDay() {
		
		return orderProductDetailMapper.selectDay();
	}

}
