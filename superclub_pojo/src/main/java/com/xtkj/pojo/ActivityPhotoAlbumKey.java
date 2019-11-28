package com.xtkj.pojo;

import java.io.Serializable;

public class ActivityPhotoAlbumKey implements Serializable {
    private String activityId;

    private String photoAlbumId;

    private static final long serialVersionUID = 1L;

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId == null ? null : activityId.trim();
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
        ActivityPhotoAlbumKey other = (ActivityPhotoAlbumKey) that;
        return (this.getActivityId() == null ? other.getActivityId() == null : this.getActivityId().equals(other.getActivityId()))
            && (this.getPhotoAlbumId() == null ? other.getPhotoAlbumId() == null : this.getPhotoAlbumId().equals(other.getPhotoAlbumId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getActivityId() == null) ? 0 : getActivityId().hashCode());
        result = prime * result + ((getPhotoAlbumId() == null) ? 0 : getPhotoAlbumId().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", activityId=").append(activityId);
        sb.append(", photoAlbumId=").append(photoAlbumId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}