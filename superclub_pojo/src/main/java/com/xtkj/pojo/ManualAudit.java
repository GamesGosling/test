package com.xtkj.pojo;

import java.io.Serializable;
import java.util.Date;

public class ManualAudit implements Serializable {
    private String artId;

    private String photoId;

    private String auditMan;

    private Short isOk;

    private Date auditDate;

    private Date updateDate;

    private String auditManName;

    private static final long serialVersionUID = 1L;

    public String getArtId() {
        return artId;
    }

    public void setArtId(String artId) {
        this.artId = artId == null ? null : artId.trim();
    }

    public String getPhotoId() {
        return photoId;
    }

    public void setPhotoId(String photoId) {
        this.photoId = photoId == null ? null : photoId.trim();
    }

    public String getAuditMan() {
        return auditMan;
    }

    public void setAuditMan(String auditMan) {
        this.auditMan = auditMan == null ? null : auditMan.trim();
    }

    public Short getIsOk() {
        return isOk;
    }

    public void setIsOk(Short isOk) {
        this.isOk = isOk;
    }

    public Date getAuditDate() {
        return auditDate;
    }

    public void setAuditDate(Date auditDate) {
        this.auditDate = auditDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getAuditManName() {
        return auditManName;
    }

    public void setAuditManName(String auditManName) {
        this.auditManName = auditManName == null ? null : auditManName.trim();
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
        ManualAudit other = (ManualAudit) that;
        return (this.getArtId() == null ? other.getArtId() == null : this.getArtId().equals(other.getArtId()))
            && (this.getPhotoId() == null ? other.getPhotoId() == null : this.getPhotoId().equals(other.getPhotoId()))
            && (this.getAuditMan() == null ? other.getAuditMan() == null : this.getAuditMan().equals(other.getAuditMan()))
            && (this.getIsOk() == null ? other.getIsOk() == null : this.getIsOk().equals(other.getIsOk()))
            && (this.getAuditDate() == null ? other.getAuditDate() == null : this.getAuditDate().equals(other.getAuditDate()))
            && (this.getUpdateDate() == null ? other.getUpdateDate() == null : this.getUpdateDate().equals(other.getUpdateDate()))
            && (this.getAuditManName() == null ? other.getAuditManName() == null : this.getAuditManName().equals(other.getAuditManName()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getArtId() == null) ? 0 : getArtId().hashCode());
        result = prime * result + ((getPhotoId() == null) ? 0 : getPhotoId().hashCode());
        result = prime * result + ((getAuditMan() == null) ? 0 : getAuditMan().hashCode());
        result = prime * result + ((getIsOk() == null) ? 0 : getIsOk().hashCode());
        result = prime * result + ((getAuditDate() == null) ? 0 : getAuditDate().hashCode());
        result = prime * result + ((getUpdateDate() == null) ? 0 : getUpdateDate().hashCode());
        result = prime * result + ((getAuditManName() == null) ? 0 : getAuditManName().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", artId=").append(artId);
        sb.append(", photoId=").append(photoId);
        sb.append(", auditMan=").append(auditMan);
        sb.append(", isOk=").append(isOk);
        sb.append(", auditDate=").append(auditDate);
        sb.append(", updateDate=").append(updateDate);
        sb.append(", auditManName=").append(auditManName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}