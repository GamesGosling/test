package com.xtkj.pojo;

import java.io.Serializable;
import java.util.Date;

public class ActivityPhotoAlbum extends ActivityPhotoAlbumKey implements Serializable {
    
    private Date updateTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

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

    
}