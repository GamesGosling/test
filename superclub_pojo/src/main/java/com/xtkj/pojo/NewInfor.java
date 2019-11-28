package com.xtkj.pojo;

import java.io.Serializable;
import java.util.Date;

public class NewInfor implements Serializable {
    private String inforId;

    private String inforTitle;

    private String inforContext;

    private Date createTime;

    private Date updateTime;

    private String photoAlbumId;

    private static final long serialVersionUID = 1L;

    public String getInforId() {
        return inforId;
    }

    public void setInforId(String inforId) {
        this.inforId = inforId == null ? null : inforId.trim();
    }

    public String getInforTitle() {
        return inforTitle;
    }

    public void setInforTitle(String inforTitle) {
        this.inforTitle = inforTitle == null ? null : inforTitle.trim();
    }

    public String getInforContext() {
        return inforContext;
    }

    public void setInforContext(String inforContext) {
        this.inforContext = inforContext == null ? null : inforContext.trim();
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
        NewInfor other = (NewInfor) that;
        return (this.getInforId() == null ? other.getInforId() == null : this.getInforId().equals(other.getInforId()))
            && (this.getInforTitle() == null ? other.getInforTitle() == null : this.getInforTitle().equals(other.getInforTitle()))
            && (this.getInforContext() == null ? other.getInforContext() == null : this.getInforContext().equals(other.getInforContext()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getPhotoAlbumId() == null ? other.getPhotoAlbumId() == null : this.getPhotoAlbumId().equals(other.getPhotoAlbumId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getInforId() == null) ? 0 : getInforId().hashCode());
        result = prime * result + ((getInforTitle() == null) ? 0 : getInforTitle().hashCode());
        result = prime * result + ((getInforContext() == null) ? 0 : getInforContext().hashCode());
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
        sb.append(", inforId=").append(inforId);
        sb.append(", inforTitle=").append(inforTitle);
        sb.append(", inforContext=").append(inforContext);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", photoAlbumId=").append(photoAlbumId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}