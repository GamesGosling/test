package com.xtkj.cartpojo;

import java.io.Serializable;
import java.util.Date;

import com.xtkj.pojo.Product;
import com.xtkj.pojo.ProductColor;
import com.xtkj.pojo.ProductSize;

public class ProductColorSizeVo implements Serializable{

	private Product proId;
	private ProductColor colorId;
	private ProductSize sizeId;
	private Integer cnt;
	private Date CREATEDT;
	private Date UPDATEDT;
	public Product getProId() {
		return proId;
	}
	public void setProId(Product proId) {
		this.proId = proId;
	}
	public ProductColor getColorId() {
		return colorId;
	}
	public void setColorId(ProductColor colorId) {
		this.colorId = colorId;
	}
	public ProductSize getSizeId() {
		return sizeId;
	}
	public void setSizeId(ProductSize sizeId) {
		this.sizeId = sizeId;
	}
	public Integer getCnt() {
		return cnt;
	}
	public void setCnt(Integer cnt) {
		this.cnt = cnt;
	}
	public Date getCREATEDT() {
		return CREATEDT;
	}
	public void setCREATEDT(Date cREATEDT) {
		CREATEDT = cREATEDT;
	}
	public Date getUPDATEDT() {
		return UPDATEDT;
	}
	public void setUPDATEDT(Date uPDATEDT) {
		UPDATEDT = uPDATEDT;
	}
	public ProductColorSizeVo(Product proId, ProductColor colorId, ProductSize sizeId, Integer cnt) {
		super();
		this.proId = proId;
		this.colorId = colorId;
		this.sizeId = sizeId;
		this.cnt = cnt;
	}
	@Override
	public String toString() {
		return "ProductColorSizeVo [proId=" + proId + ", colorId=" + colorId + ", sizeId=" + sizeId + ", cnt=" + cnt
				+ ", CREATEDT=" + CREATEDT + ", UPDATEDT=" + UPDATEDT + "]";
	}
	public ProductColorSizeVo() {
		super();
	}

}
