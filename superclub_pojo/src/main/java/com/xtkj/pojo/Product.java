package com.xtkj.pojo;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private String id;

    private String productName;

    private String productDescript;

    private Double price;

    private String imgUrl;

    private Short productIshot;

    private Short upper;

    private Long lookNum;

    private Long sellNum;

    private Date updateTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductDescript() {
        return productDescript;
    }

    public void setProductDescript(String productDescript) {
        this.productDescript = productDescript == null ? null : productDescript.trim();
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public Short getProductIshot() {
        return productIshot;
    }

    public void setProductIshot(Short productIshot) {
        this.productIshot = productIshot;
    }

    public Short getUpper() {
        return upper;
    }

    public void setUpper(Short upper) {
        this.upper = upper;
    }

    public Long getLookNum() {
        return lookNum;
    }

    public void setLookNum(Long lookNum) {
        this.lookNum = lookNum;
    }

    public Long getSellNum() {
        return sellNum;
    }

    public void setSellNum(Long sellNum) {
        this.sellNum = sellNum;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Product other = (Product) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getProductName() == null ? other.getProductName() == null : this.getProductName().equals(other.getProductName()))
            && (this.getProductDescript() == null ? other.getProductDescript() == null : this.getProductDescript().equals(other.getProductDescript()))
            && (this.getPrice() == null ? other.getPrice() == null : this.getPrice().equals(other.getPrice()))
            && (this.getImgUrl() == null ? other.getImgUrl() == null : this.getImgUrl().equals(other.getImgUrl()))
            && (this.getProductIshot() == null ? other.getProductIshot() == null : this.getProductIshot().equals(other.getProductIshot()))
            && (this.getUpper() == null ? other.getUpper() == null : this.getUpper().equals(other.getUpper()))
            && (this.getLookNum() == null ? other.getLookNum() == null : this.getLookNum().equals(other.getLookNum()))
            && (this.getSellNum() == null ? other.getSellNum() == null : this.getSellNum().equals(other.getSellNum()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getProductName() == null) ? 0 : getProductName().hashCode());
        result = prime * result + ((getProductDescript() == null) ? 0 : getProductDescript().hashCode());
        result = prime * result + ((getPrice() == null) ? 0 : getPrice().hashCode());
        result = prime * result + ((getImgUrl() == null) ? 0 : getImgUrl().hashCode());
        result = prime * result + ((getProductIshot() == null) ? 0 : getProductIshot().hashCode());
        result = prime * result + ((getUpper() == null) ? 0 : getUpper().hashCode());
        result = prime * result + ((getLookNum() == null) ? 0 : getLookNum().hashCode());
        result = prime * result + ((getSellNum() == null) ? 0 : getSellNum().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", productName=").append(productName);
        sb.append(", productDescript=").append(productDescript);
        sb.append(", price=").append(price);
        sb.append(", imgUrl=").append(imgUrl);
        sb.append(", productIshot=").append(productIshot);
        sb.append(", upper=").append(upper);
        sb.append(", lookNum=").append(lookNum);
        sb.append(", sellNum=").append(sellNum);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}