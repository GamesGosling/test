package com.xtkj.pojo;

import java.io.Serializable;
import java.util.Date;

public class AdviceShenhe implements Serializable {
    private String id;

    private String adviceId;

    private String judge;

    private String response;

    private String contactWayShenhe;

    private Date responseTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getAdviceId() {
        return adviceId;
    }

    public void setAdviceId(String adviceId) {
        this.adviceId = adviceId == null ? null : adviceId.trim();
    }

    public String getJudge() {
        return judge;
    }

    public void setJudge(String judge) {
        this.judge = judge == null ? null : judge.trim();
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response == null ? null : response.trim();
    }

    public String getContactWayShenhe() {
        return contactWayShenhe;
    }

    public void setContactWayShenhe(String contactWayShenhe) {
        this.contactWayShenhe = contactWayShenhe == null ? null : contactWayShenhe.trim();
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
        AdviceShenhe other = (AdviceShenhe) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getAdviceId() == null ? other.getAdviceId() == null : this.getAdviceId().equals(other.getAdviceId()))
            && (this.getJudge() == null ? other.getJudge() == null : this.getJudge().equals(other.getJudge()))
            && (this.getResponse() == null ? other.getResponse() == null : this.getResponse().equals(other.getResponse()))
            && (this.getContactWayShenhe() == null ? other.getContactWayShenhe() == null : this.getContactWayShenhe().equals(other.getContactWayShenhe()))
            && (this.getResponseTime() == null ? other.getResponseTime() == null : this.getResponseTime().equals(other.getResponseTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getAdviceId() == null) ? 0 : getAdviceId().hashCode());
        result = prime * result + ((getJudge() == null) ? 0 : getJudge().hashCode());
        result = prime * result + ((getResponse() == null) ? 0 : getResponse().hashCode());
        result = prime * result + ((getContactWayShenhe() == null) ? 0 : getContactWayShenhe().hashCode());
        result = prime * result + ((getResponseTime() == null) ? 0 : getResponseTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", adviceId=").append(adviceId);
        sb.append(", judge=").append(judge);
        sb.append(", response=").append(response);
        sb.append(", contactWayShenhe=").append(contactWayShenhe);
        sb.append(", responseTime=").append(responseTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}