package com.xtkj.pojo;

import java.io.Serializable;
import java.util.Date;

public class UserAdvice implements Serializable {
    private String id;

    private String advice;

    private String userId;

    private Short doStatus;

    private Short shenHeStatus;

    private String contactWay;

    private Short isUpperTracker;

    private Short infoLevel;

    private Date updateTime;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAdvice() {
        return advice;
    }

    public void setAdvice(String advice) {
        this.advice = advice == null ? null : advice.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public Short getDoStatus() {
        return doStatus;
    }

    public void setDoStatus(Short doStatus) {
        this.doStatus = doStatus;
    }

    public Short getShenHeStatus() {
        return shenHeStatus;
    }

    public void setShenHeStatus(Short shenHeStatus) {
        this.shenHeStatus = shenHeStatus;
    }

    public String getContactWay() {
        return contactWay;
    }

    public void setContactWay(String contactWay) {
        this.contactWay = contactWay == null ? null : contactWay.trim();
    }

    public Short getIsUpperTracker() {
        return isUpperTracker;
    }

    public void setIsUpperTracker(Short isUpperTracker) {
        this.isUpperTracker = isUpperTracker;
    }

    public Short getInfoLevel() {
        return infoLevel;
    }

    public void setInfoLevel(Short infoLevel) {
        this.infoLevel = infoLevel;
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
        UserAdvice other = (UserAdvice) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAdvice() == null ? other.getAdvice() == null : this.getAdvice().equals(other.getAdvice()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getDoStatus() == null ? other.getDoStatus() == null : this.getDoStatus().equals(other.getDoStatus()))
            && (this.getShenHeStatus() == null ? other.getShenHeStatus() == null : this.getShenHeStatus().equals(other.getShenHeStatus()))
            && (this.getContactWay() == null ? other.getContactWay() == null : this.getContactWay().equals(other.getContactWay()))
            && (this.getIsUpperTracker() == null ? other.getIsUpperTracker() == null : this.getIsUpperTracker().equals(other.getIsUpperTracker()))
            && (this.getInfoLevel() == null ? other.getInfoLevel() == null : this.getInfoLevel().equals(other.getInfoLevel()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAdvice() == null) ? 0 : getAdvice().hashCode());
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getDoStatus() == null) ? 0 : getDoStatus().hashCode());
        result = prime * result + ((getShenHeStatus() == null) ? 0 : getShenHeStatus().hashCode());
        result = prime * result + ((getContactWay() == null) ? 0 : getContactWay().hashCode());
        result = prime * result + ((getIsUpperTracker() == null) ? 0 : getIsUpperTracker().hashCode());
        result = prime * result + ((getInfoLevel() == null) ? 0 : getInfoLevel().hashCode());
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
        sb.append(", advice=").append(advice);
        sb.append(", userId=").append(userId);
        sb.append(", doStatus=").append(doStatus);
        sb.append(", shenHeStatus=").append(shenHeStatus);
        sb.append(", contactWay=").append(contactWay);
        sb.append(", isUpperTracker=").append(isUpperTracker);
        sb.append(", infoLevel=").append(infoLevel);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}