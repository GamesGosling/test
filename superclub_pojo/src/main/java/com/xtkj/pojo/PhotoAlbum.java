package com.xtkj.pojo;

import java.io.Serializable;
import java.util.Date;

public class PhotoAlbum implements Serializable {
    private String id;

    private Date updateTime;

    private Date createTime;

    private String albumName;

    private String albumDefaultPicture;

    private String activityId;
    
    private static final long serialVersionUID = 1L;
    
    public PhotoAlbum() {
		super();
	}

	public PhotoAlbum(String id, Date updateTime, Date createTime, String albumName, String albumDefaultPicture) {
		super();
		this.id = id;
		this.updateTime = updateTime;
		this.createTime = createTime;
		this.albumName = albumName;
		this.albumDefaultPicture = albumDefaultPicture;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
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

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName == null ? null : albumName.trim();
    }

    public String getAlbumDefaultPicture() {
        return albumDefaultPicture;
    }

    public void setAlbumDefaultPicture(String albumDefaultPicture) {
        this.albumDefaultPicture = albumDefaultPicture == null ? null : albumDefaultPicture.trim();
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
        PhotoAlbum other = (PhotoAlbum) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getAlbumName() == null ? other.getAlbumName() == null : this.getAlbumName().equals(other.getAlbumName()))
            && (this.getAlbumDefaultPicture() == null ? other.getAlbumDefaultPicture() == null : this.getAlbumDefaultPicture().equals(other.getAlbumDefaultPicture()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getAlbumName() == null) ? 0 : getAlbumName().hashCode());
        result = prime * result + ((getAlbumDefaultPicture() == null) ? 0 : getAlbumDefaultPicture().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", albumName=").append(albumName);
        sb.append(", albumDefaultPicture=").append(albumDefaultPicture);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}