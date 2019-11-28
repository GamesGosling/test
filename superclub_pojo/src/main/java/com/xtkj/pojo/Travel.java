package com.xtkj.pojo;

import java.io.Serializable;
import java.util.Date;

public class Travel extends TravelKey implements Serializable {
    private Date publishTime;

    private String travelContext;

    private Short travelLike;
    
    private User user;

    private String location;

    private String channel;

    private String ip;

    private Short readNum;

    private Short ok;

    private Date updateTime;

    private Date createTime;

    private String travelTitled;

    private String photoAlbumId;

    private static final long serialVersionUID = 1L;

    public Date getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(Date publishTime) {
        this.publishTime = publishTime;
    }

    public String getTravelContext() {
        return travelContext;
    }

    public void setTravelContext(String travelContext) {
        this.travelContext = travelContext == null ? null : travelContext.trim();
    }

    public Short getTravelLike() {
        return travelLike;
    }

    public void setTravelLike(Short travelLike) {
        this.travelLike = travelLike;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel == null ? null : channel.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Short getReadNum() {
        return readNum;
    }

    public void setReadNum(Short readNum) {
        this.readNum = readNum;
    }

    public Short getOk() {
        return ok;
    }

    public void setOk(Short ok) {
        this.ok = ok;
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

    public String getTravelTitled() {
        return travelTitled;
    }

    public void setTravelTitled(String travelTitled) {
        this.travelTitled = travelTitled == null ? null : travelTitled.trim();
    }

    public String getPhotoAlbumId() {
        return photoAlbumId;
    }

    public void setPhotoAlbumId(String photoAlbumId) {
        this.photoAlbumId = photoAlbumId == null ? null : photoAlbumId.trim();
    }
    
    

    public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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
        Travel other = (Travel) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPublishTime() == null ? other.getPublishTime() == null : this.getPublishTime().equals(other.getPublishTime()))
            && (this.getTravelContext() == null ? other.getTravelContext() == null : this.getTravelContext().equals(other.getTravelContext()))
            && (this.getTravelLike() == null ? other.getTravelLike() == null : this.getTravelLike().equals(other.getTravelLike()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getChannel() == null ? other.getChannel() == null : this.getChannel().equals(other.getChannel()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getReadNum() == null ? other.getReadNum() == null : this.getReadNum().equals(other.getReadNum()))
            && (this.getOk() == null ? other.getOk() == null : this.getOk().equals(other.getOk()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getTravelTitled() == null ? other.getTravelTitled() == null : this.getTravelTitled().equals(other.getTravelTitled()))
            && (this.getPhotoAlbumId() == null ? other.getPhotoAlbumId() == null : this.getPhotoAlbumId().equals(other.getPhotoAlbumId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPublishTime() == null) ? 0 : getPublishTime().hashCode());
        result = prime * result + ((getTravelContext() == null) ? 0 : getTravelContext().hashCode());
        result = prime * result + ((getTravelLike() == null) ? 0 : getTravelLike().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getChannel() == null) ? 0 : getChannel().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getReadNum() == null) ? 0 : getReadNum().hashCode());
        result = prime * result + ((getOk() == null) ? 0 : getOk().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getTravelTitled() == null) ? 0 : getTravelTitled().hashCode());
        result = prime * result + ((getPhotoAlbumId() == null) ? 0 : getPhotoAlbumId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", publishTime=").append(publishTime);
        sb.append(", travelContext=").append(travelContext);
        sb.append(", travelLike=").append(travelLike);
        sb.append(", location=").append(location);
        sb.append(", channel=").append(channel);
        sb.append(", ip=").append(ip);
        sb.append(", readNum=").append(readNum);
        sb.append(", ok=").append(ok);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", travelTitled=").append(travelTitled);
        sb.append(", photoAlbumId=").append(photoAlbumId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}