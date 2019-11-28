package com.xtkj.pojo;

import java.io.Serializable;

public class PersonalPhotoAlbumKey implements Serializable {
    private String userId;

    private String photoAlbumId;

    private static final long serialVersionUID = 1L;

    
    public PersonalPhotoAlbumKey() {
		super();
	}

	public PersonalPhotoAlbumKey(String userId, String photoAlbumId) {
		super();
		this.userId = userId;
		this.photoAlbumId = photoAlbumId;
	}

	public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
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
        PersonalPhotoAlbumKey other = (PersonalPhotoAlbumKey) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPhotoAlbumId() == null ? other.getPhotoAlbumId() == null : this.getPhotoAlbumId().equals(other.getPhotoAlbumId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPhotoAlbumId() == null) ? 0 : getPhotoAlbumId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", photoAlbumId=").append(photoAlbumId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}