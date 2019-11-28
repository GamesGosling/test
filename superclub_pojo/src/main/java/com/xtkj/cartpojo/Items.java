package com.xtkj.cartpojo;

public class Items {

	private ProductColorSizeVo  product;
	
	private int prototalNum;//列项数量

	@SuppressWarnings("unused")
	private float protoordertalprice;//列项订单总金额


	public ProductColorSizeVo getProduct() {
		return product;
	}

	public void setProduct(ProductColorSizeVo product) {
		this.product = product;
	}
	public int getPrototalNum() {
		return prototalNum;
	}

	public void setPrototalNum(int prototalNum) {
		this.prototalNum = prototalNum;
	}

	public double getProtoordertalprice() {
		return this.protoordertalprice=(float) (product.getProId().getPrice()*this.prototalNum);
	}

}
