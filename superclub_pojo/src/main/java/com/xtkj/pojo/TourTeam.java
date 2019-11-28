package com.xtkj.pojo;

import java.io.Serializable;

public class TourTeam implements Serializable {
    private String id;

    private String teamId;

    private String leaderId;

    private String teamLogo;

    private String localtion;

    private String mainProject;

    private String intro;

    private String manifesto;

    private String principalName;

    private String principalTelphone;

    private String photoAlbumId;

    private String tourId;

    private String updateTime;

    private String createTime;

    private String teamName;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId == null ? null : teamId.trim();
    }

    public String getLeaderId() {
        return leaderId;
    }

    public void setLeaderId(String leaderId) {
        this.leaderId = leaderId == null ? null : leaderId.trim();
    }

    public String getTeamLogo() {
        return teamLogo;
    }

    public void setTeamLogo(String teamLogo) {
        this.teamLogo = teamLogo == null ? null : teamLogo.trim();
    }

    public String getLocaltion() {
        return localtion;
    }

    public void setLocaltion(String localtion) {
        this.localtion = localtion == null ? null : localtion.trim();
    }

    public String getMainProject() {
        return mainProject;
    }

    public void setMainProject(String mainProject) {
        this.mainProject = mainProject == null ? null : mainProject.trim();
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro == null ? null : intro.trim();
    }

    public String getManifesto() {
        return manifesto;
    }

    public void setManifesto(String manifesto) {
        this.manifesto = manifesto == null ? null : manifesto.trim();
    }

    public String getPrincipalName() {
        return principalName;
    }

    public void setPrincipalName(String principalName) {
        this.principalName = principalName == null ? null : principalName.trim();
    }

    public String getPrincipalTelphone() {
        return principalTelphone;
    }

    public void setPrincipalTelphone(String principalTelphone) {
        this.principalTelphone = principalTelphone == null ? null : principalTelphone.trim();
    }

    public String getPhotoAlbumId() {
        return photoAlbumId;
    }

    public void setPhotoAlbumId(String photoAlbumId) {
        this.photoAlbumId = photoAlbumId == null ? null : photoAlbumId.trim();
    }

    public String getTourId() {
        return tourId;
    }

    public void setTourId(String tourId) {
        this.tourId = tourId == null ? null : tourId.trim();
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName == null ? null : teamName.trim();
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
        TourTeam other = (TourTeam) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTeamId() == null ? other.getTeamId() == null : this.getTeamId().equals(other.getTeamId()))
            && (this.getLeaderId() == null ? other.getLeaderId() == null : this.getLeaderId().equals(other.getLeaderId()))
            && (this.getTeamLogo() == null ? other.getTeamLogo() == null : this.getTeamLogo().equals(other.getTeamLogo()))
            && (this.getLocaltion() == null ? other.getLocaltion() == null : this.getLocaltion().equals(other.getLocaltion()))
            && (this.getMainProject() == null ? other.getMainProject() == null : this.getMainProject().equals(other.getMainProject()))
            && (this.getIntro() == null ? other.getIntro() == null : this.getIntro().equals(other.getIntro()))
            && (this.getManifesto() == null ? other.getManifesto() == null : this.getManifesto().equals(other.getManifesto()))
            && (this.getPrincipalName() == null ? other.getPrincipalName() == null : this.getPrincipalName().equals(other.getPrincipalName()))
            && (this.getPrincipalTelphone() == null ? other.getPrincipalTelphone() == null : this.getPrincipalTelphone().equals(other.getPrincipalTelphone()))
            && (this.getPhotoAlbumId() == null ? other.getPhotoAlbumId() == null : this.getPhotoAlbumId().equals(other.getPhotoAlbumId()))
            && (this.getTourId() == null ? other.getTourId() == null : this.getTourId().equals(other.getTourId()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getTeamName() == null ? other.getTeamName() == null : this.getTeamName().equals(other.getTeamName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTeamId() == null) ? 0 : getTeamId().hashCode());
        result = prime * result + ((getLeaderId() == null) ? 0 : getLeaderId().hashCode());
        result = prime * result + ((getTeamLogo() == null) ? 0 : getTeamLogo().hashCode());
        result = prime * result + ((getLocaltion() == null) ? 0 : getLocaltion().hashCode());
        result = prime * result + ((getMainProject() == null) ? 0 : getMainProject().hashCode());
        result = prime * result + ((getIntro() == null) ? 0 : getIntro().hashCode());
        result = prime * result + ((getManifesto() == null) ? 0 : getManifesto().hashCode());
        result = prime * result + ((getPrincipalName() == null) ? 0 : getPrincipalName().hashCode());
        result = prime * result + ((getPrincipalTelphone() == null) ? 0 : getPrincipalTelphone().hashCode());
        result = prime * result + ((getPhotoAlbumId() == null) ? 0 : getPhotoAlbumId().hashCode());
        result = prime * result + ((getTourId() == null) ? 0 : getTourId().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getTeamName() == null) ? 0 : getTeamName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", teamId=").append(teamId);
        sb.append(", leaderId=").append(leaderId);
        sb.append(", teamLogo=").append(teamLogo);
        sb.append(", localtion=").append(localtion);
        sb.append(", mainProject=").append(mainProject);
        sb.append(", intro=").append(intro);
        sb.append(", manifesto=").append(manifesto);
        sb.append(", principalName=").append(principalName);
        sb.append(", principalTelphone=").append(principalTelphone);
        sb.append(", photoAlbumId=").append(photoAlbumId);
        sb.append(", tourId=").append(tourId);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", createTime=").append(createTime);
        sb.append(", teamName=").append(teamName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}