package com.xtkj.pojo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Activity implements Serializable {
    private String id;

    private ActivityType activityType;

    private User user;

    private String issueType;

    private String iemi;

    private String ip;

    private String activityLocation;
    
    private Short isCharge;

    private String insuranceChannel;

    private String chargeMode;

    private String activityDetail;

    private Short activityIshot;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date activityEndTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date activityBeginTime;
    
    private Long activityMaxPeople;

    private Long activityViewCount;

    private Short ok;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date activityExpiredTime;

    private String chargeModechargeMode;

    private String activityBeginLocation;

    private String activityCover;

    private String activityTitle;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType == null ? null : activityType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user == null ? null : user;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType == null ? null : issueType.trim();
    }

    public String getIemi() {
        return iemi;
    }

    public void setIemi(String iemi) {
        this.iemi = iemi == null ? null : iemi.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getActivityLocation() {
        return activityLocation;
    }

    public void setActivityLocation(String activityLocation) {
        this.activityLocation = activityLocation == null ? null : activityLocation.trim();
    }

    public Short getIsCharge() {
        return isCharge;
    }

    public void setIsCharge(Short isCharge) {
        this.isCharge = isCharge;
    }

    public String getInsuranceChannel() {
        return insuranceChannel;
    }

    public void setInsuranceChannel(String insuranceChannel) {
        this.insuranceChannel = insuranceChannel == null ? null : insuranceChannel.trim();
    }

    public String getChargeMode() {
        return chargeMode;
    }

    public void setChargeMode(String chargeMode) {
        this.chargeMode = chargeMode == null ? null : chargeMode.trim();
    }

    public String getActivityDetail() {
        return activityDetail;
    }

    public void setActivityDetail(String activityDetail) {
        this.activityDetail = activityDetail == null ? null : activityDetail.trim();
    }

    public Short getActivityIshot() {
        return activityIshot;
    }

    public void setActivityIshot(Short activityIshot) {
        this.activityIshot = activityIshot;
    }

    public Date getActivityEndTime() {
        return activityEndTime;
    }

    public void setActivityEndTime(Date activityEndTime) {
        this.activityEndTime = activityEndTime;
    }

    public Date getActivityBeginTime() {
        return activityBeginTime;
    }

    public void setActivityBeginTime(Date activityBeginTime) {
        this.activityBeginTime = activityBeginTime;
    }

    public Long getActivityMaxPeople() {
        return activityMaxPeople;
    }

    public void setActivityMaxPeople(Long activityMaxPeople) {
        this.activityMaxPeople = activityMaxPeople;
    }

    public Long getActivityViewCount() {
        return activityViewCount;
    }

    public void setActivityViewCount(Long activityViewCount) {
        this.activityViewCount = activityViewCount;
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

    public Date getActivityExpiredTime() {
        return activityExpiredTime;
    }

    public void setActivityExpiredTime(Date activityExpiredTime) {
        this.activityExpiredTime = activityExpiredTime;
    }

    public String getChargeModechargeMode() {
        return chargeModechargeMode;
    }

    public void setChargeModechargeMode(String chargeModechargeMode) {
        this.chargeModechargeMode = chargeModechargeMode == null ? null : chargeModechargeMode.trim();
    }

    public String getActivityBeginLocation() {
        return activityBeginLocation;
    }

    public void setActivityBeginLocation(String activityBeginLocation) {
        this.activityBeginLocation = activityBeginLocation == null ? null : activityBeginLocation.trim();
    }

    public String getActivityCover() {
        return activityCover;
    }

    public void setActivityCover(String activityCover) {
        this.activityCover = activityCover == null ? null : activityCover.trim();
    }

    public String getActivityTitle() {
        return activityTitle;
    }

    public void setActivityTitle(String activityTitle) {
        this.activityTitle = activityTitle == null ? null : activityTitle.trim();
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
        Activity other = (Activity) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getActivityType() == null ? other.getActivityType() == null : this.getActivityType().equals(other.getActivityType()))
            && (this.getUser() == null ? other.getUser() == null : this.getUser().equals(other.getUser()))
            && (this.getIssueType() == null ? other.getIssueType() == null : this.getIssueType().equals(other.getIssueType()))
            && (this.getIemi() == null ? other.getIemi() == null : this.getIemi().equals(other.getIemi()))
            && (this.getIp() == null ? other.getIp() == null : this.getIp().equals(other.getIp()))
            && (this.getActivityLocation() == null ? other.getActivityLocation() == null : this.getActivityLocation().equals(other.getActivityLocation()))
            && (this.getIsCharge() == null ? other.getIsCharge() == null : this.getIsCharge().equals(other.getIsCharge()))
            && (this.getInsuranceChannel() == null ? other.getInsuranceChannel() == null : this.getInsuranceChannel().equals(other.getInsuranceChannel()))
            && (this.getChargeMode() == null ? other.getChargeMode() == null : this.getChargeMode().equals(other.getChargeMode()))
            && (this.getActivityDetail() == null ? other.getActivityDetail() == null : this.getActivityDetail().equals(other.getActivityDetail()))
            && (this.getActivityIshot() == null ? other.getActivityIshot() == null : this.getActivityIshot().equals(other.getActivityIshot()))
            && (this.getActivityEndTime() == null ? other.getActivityEndTime() == null : this.getActivityEndTime().equals(other.getActivityEndTime()))
            && (this.getActivityBeginTime() == null ? other.getActivityBeginTime() == null : this.getActivityBeginTime().equals(other.getActivityBeginTime()))
            && (this.getActivityMaxPeople() == null ? other.getActivityMaxPeople() == null : this.getActivityMaxPeople().equals(other.getActivityMaxPeople()))
            && (this.getActivityViewCount() == null ? other.getActivityViewCount() == null : this.getActivityViewCount().equals(other.getActivityViewCount()))
            && (this.getOk() == null ? other.getOk() == null : this.getOk().equals(other.getOk()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getActivityExpiredTime() == null ? other.getActivityExpiredTime() == null : this.getActivityExpiredTime().equals(other.getActivityExpiredTime()))
            && (this.getChargeModechargeMode() == null ? other.getChargeModechargeMode() == null : this.getChargeModechargeMode().equals(other.getChargeModechargeMode()))
            && (this.getActivityBeginLocation() == null ? other.getActivityBeginLocation() == null : this.getActivityBeginLocation().equals(other.getActivityBeginLocation()))
            && (this.getActivityCover() == null ? other.getActivityCover() == null : this.getActivityCover().equals(other.getActivityCover()))
            && (this.getActivityTitle() == null ? other.getActivityTitle() == null : this.getActivityTitle().equals(other.getActivityTitle()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getActivityType() == null) ? 0 : getActivityType().hashCode());
        result = prime * result + ((getUser() == null) ? 0 : getUser().hashCode());
        result = prime * result + ((getIssueType() == null) ? 0 : getIssueType().hashCode());
        result = prime * result + ((getIemi() == null) ? 0 : getIemi().hashCode());
        result = prime * result + ((getIp() == null) ? 0 : getIp().hashCode());
        result = prime * result + ((getActivityLocation() == null) ? 0 : getActivityLocation().hashCode());
        result = prime * result + ((getIsCharge() == null) ? 0 : getIsCharge().hashCode());
        result = prime * result + ((getInsuranceChannel() == null) ? 0 : getInsuranceChannel().hashCode());
        result = prime * result + ((getChargeMode() == null) ? 0 : getChargeMode().hashCode());
        result = prime * result + ((getActivityDetail() == null) ? 0 : getActivityDetail().hashCode());
        result = prime * result + ((getActivityIshot() == null) ? 0 : getActivityIshot().hashCode());
        result = prime * result + ((getActivityEndTime() == null) ? 0 : getActivityEndTime().hashCode());
        result = prime * result + ((getActivityBeginTime() == null) ? 0 : getActivityBeginTime().hashCode());
        result = prime * result + ((getActivityMaxPeople() == null) ? 0 : getActivityMaxPeople().hashCode());
        result = prime * result + ((getActivityViewCount() == null) ? 0 : getActivityViewCount().hashCode());
        result = prime * result + ((getOk() == null) ? 0 : getOk().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getActivityExpiredTime() == null) ? 0 : getActivityExpiredTime().hashCode());
        result = prime * result + ((getChargeModechargeMode() == null) ? 0 : getChargeModechargeMode().hashCode());
        result = prime * result + ((getActivityBeginLocation() == null) ? 0 : getActivityBeginLocation().hashCode());
        result = prime * result + ((getActivityCover() == null) ? 0 : getActivityCover().hashCode());
        result = prime * result + ((getActivityTitle() == null) ? 0 : getActivityTitle().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", activityTypeId=").append(activityType);
        sb.append(", userId=").append(user);
        sb.append(", issueType=").append(issueType);
        sb.append(", iemi=").append(iemi);
        sb.append(", ip=").append(ip);
        sb.append(", activityLocation=").append(activityLocation);
        sb.append(", isCharge=").append(isCharge);
        sb.append(", insuranceChannel=").append(insuranceChannel);
        sb.append(", chargeMode=").append(chargeMode);
        sb.append(", activityDetail=").append(activityDetail);
        sb.append(", activityIshot=").append(activityIshot);
        sb.append(", activityEndTime=").append(activityEndTime);
        sb.append(", activityBeginTime=").append(activityBeginTime);
        sb.append(", activityMaxPeople=").append(activityMaxPeople);
        sb.append(", activityViewCount=").append(activityViewCount);
        sb.append(", ok=").append(ok);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", activityExpiredTime=").append(activityExpiredTime);
        sb.append(", chargeModechargeMode=").append(chargeModechargeMode);
        sb.append(", activityBeginLocation=").append(activityBeginLocation);
        sb.append(", activityCover=").append(activityCover);
        sb.append(", activityTitle=").append(activityTitle);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}