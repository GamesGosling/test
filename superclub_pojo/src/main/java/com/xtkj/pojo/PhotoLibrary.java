package com.xtkj.pojo;

import java.io.Serializable;
import java.util.Date;

public class PhotoLibrary implements Serializable {
    private String id;

    private String photoUrl;

    private String userId;

    private Short ok;

    private Date updateTime;

    private Date createTime;

    private String albumId;

    private String activityId;

    private static final long serialVersionUID = 1L;

    public PhotoLibrary() {
		super();
	}
    
	public PhotoLibrary(String id, String photoUrl, String userId, Short ok, Date updateTime, Date createTime) {
		super();
		this.id = id;
		this.photoUrl = photoUrl;
		this.userId = userId;
		this.ok = ok;
		this.updateTime = updateTime;
		this.createTime = createTime;
	}

	public PhotoLibrary(String id, String photoUrl, String userId, Short ok, Date updateTime, Date createTime,
			String albumId) {
		super();
		this.id = id;
		this.photoUrl = photoUrl;
		this.userId = userId;
		this.ok = ok;
		this.updateTime = updateTime;
		this.createTime = createTime;
		this.albumId = albumId;
	}
	public PhotoLibrary(String id, String photoUrl, String userId, Short ok, Date updateTime, Date createTime,
			String albumId, String activityId) {
		super();
		this.id = id;
		this.photoUrl = photoUrl;
		this.userId = userId;
		this.ok = ok;
		this.updateTime = updateTime;
		this.createTime = createTime;
		this.albumId = albumId;
		this.activityId = activityId;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl == null ? null : photoUrl.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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

    public String getAlbumId() {
        return albumId;
    }

    public void setAlbumId(String albumId) {
        this.albumId = albumId == null ? null : albumId.trim();
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
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
        PhotoLibrary other = (PhotoLibrary) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getPhotoUrl() == null ? other.getPhotoUrl() == null : this.getPhotoUrl().equals(other.getPhotoUrl()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getOk() == null ? other.getOk() == null : this.getOk().equals(other.getOk()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAlbumId() == null ? other.getAlbumId() == null : this.getAlbumId().equals(other.getAlbumId()))
            && (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getPhotoUrl() == null) ? 0 : getPhotoUrl().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getOk() == null) ? 0 : getOk().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAlbumId() == null) ? 0 : getAlbumId().hashCode());
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", photoUrl=").append(photoUrl);
        sb.append(", userId=").append(userId);
        sb.append(", ok=").append(ok);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", albumId=").append(albumId);
        sb.append(", activityId=").append(activityId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}