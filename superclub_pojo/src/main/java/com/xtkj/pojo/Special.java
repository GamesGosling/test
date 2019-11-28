package com.xtkj.pojo;

import java.io.Serializable;
import java.util.Date;

public class Special implements Serializable {
    private String specialId;

    private String specialType;

    private String specialSummary;

    private String specialTitle;

    private String specialContext;

    private Date createTime;

    private Date updateTime;

    private String photoAlbumId;

    private static final long serialVersionUID = 1L;

    public String getSpecialId() {
        return specialId;
    }

    public void setSpecialId(String specialId) {
        this.specialId = specialId == null ? null : specialId.trim();
    }

    public String getSpecialType() {
        return specialType;
    }

    public void setSpecialType(String specialType) {
        this.specialType = specialType == null ? null : specialType.trim();
    }

    public String getSpecialSummary() {
        return specialSummary;
    }

    public void setSpecialSummary(String specialSummary) {
        this.specialSummary = specialSummary == null ? null : specialSummary.trim();
    }

    public String getSpecialTitle() {
        return specialTitle;
    }

    public void setSpecialTitle(String specialTitle) {
        this.specialTitle = specialTitle == null ? null : specialTitle.trim();
    }

    public String getSpecialContext() {
        return specialContext;
    }

    public void setSpecialContext(String specialContext) {
        this.specialContext = specialContext == null ? null : specialContext.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getPhotoAlbumId() {
        return photoAlbumId;
    }

    public void setPhotoAlbumId(String photoAlbumId) {
        this.photoAlbumId = photoAlbumId == null ? null : photoAlbumId.trim();
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
        Special other = (Special) that;
        return (this.getSpecialId() == null ? other.getSpecialId() == null : this.getSpecialId().equals(other.getSpecialId()))
            && (this.getSpecialType() == null ? other.getSpecialType() == null : this.getSpecialType().equals(other.getSpecialType()))
            && (this.getSpecialSummary() == null ? other.getSpecialSummary() == null : this.getSpecialSummary().equals(other.getSpecialSummary()))
            && (this.getSpecialTitle() == null ? other.getSpecialTitle() == null : this.getSpecialTitle().equals(other.getSpecialTitle()))
            && (this.getSpecialContext() == null ? other.getSpecialContext() == null : this.getSpecialContext().equals(other.getSpecialContext()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getPhotoAlbumId() == null ? other.getPhotoAlbumId() == null : this.getPhotoAlbumId().equals(other.getPhotoAlbumId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getSpecialId() == null) ? 0 : getSpecialId().hashCode());
        result = prime * result + ((getSpecialType() == null) ? 0 : getSpecialType().hashCode());
        result = prime * result + ((getSpecialSummary() == null) ? 0 : getSpecialSummary().hashCode());
        result = prime * result + ((getSpecialTitle() == null) ? 0 : getSpecialTitle().hashCode());
        result = prime * result + ((getSpecialContext() == null) ? 0 : getSpecialContext().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getPhotoAlbumId() == null) ? 0 : getPhotoAlbumId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", specialId=").append(specialId);
        sb.append(", specialType=").append(specialType);
        sb.append(", specialSummary=").append(specialSummary);
        sb.append(", specialTitle=").append(specialTitle);
        sb.append(", specialContext=").append(specialContext);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", photoAlbumId=").append(photoAlbumId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}