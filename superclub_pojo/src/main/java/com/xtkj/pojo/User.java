package com.xtkj.pojo;

import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {
	
	private String dates;
	private String QUARTER;	
	private String ADDRESS;
	private String SUM;
	
		
    public User() {
		super();
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getQUARTER() {
		return QUARTER;
	}

	public void setQUARTER(String qUARTER) {
		QUARTER = qUARTER;
	}

	public String getADDRESS() {
		return ADDRESS;
	}

	public void setADDRESS(String aDDRESS) {
		ADDRESS = aDDRESS;
	}

	public String getSUM() {
		return SUM;
	}

	public void setSUM(String sUM) {
		SUM = sUM;
	}

	private String userId;

    private String personalAlbumId;

    private String nickName;

    private String sex;

    private String telephone;

    private Date creatdtm;

    private Short islimit;

    private String headPortrait;

    private Short age;

    private String personalizedSignature;

    private String hobby;

    private String post;

    private String hometown;

    private String city;

    private String email;

    private Short integral;

    private String updatedtm;

    private String userPassword;

    private String solemelber;

    private Date createdtm;

    private static final long serialVersionUID = 1L;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getPersonalAlbumId() {
        return personalAlbumId;
    }

    public void setPersonalAlbumId(String personalAlbumId) {
        this.personalAlbumId = personalAlbumId == null ? null : personalAlbumId.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    public Date getCreatdtm() {
        return creatdtm;
    }

    public void setCreatdtm(Date creatdtm) {
        this.creatdtm = creatdtm;
    }

    public Short getIslimit() {
        return islimit;
    }

    public void setIslimit(Short islimit) {
        this.islimit = islimit;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait == null ? null : headPortrait.trim();
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getPersonalizedSignature() {
        return personalizedSignature;
    }

    public void setPersonalizedSignature(String personalizedSignature) {
        this.personalizedSignature = personalizedSignature == null ? null : personalizedSignature.trim();
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby == null ? null : hobby.trim();
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post == null ? null : post.trim();
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown == null ? null : hometown.trim();
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public Short getIntegral() {
        return integral;
    }

    public void setIntegral(Short integral) {
        this.integral = integral;
    }

    public String getUpdatedtm() {
        return updatedtm;
    }

    public void setUpdatedtm(String updatedtm) {
        this.updatedtm = updatedtm == null ? null : updatedtm.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getSolemelber() {
        return solemelber;
    }

    public void setSolemelber(String solemelber) {
        this.solemelber = solemelber == null ? null : solemelber.trim();
    }

    public Date getCreatedtm() {
        return createdtm;
    }

    public void setCreatedtm(Date createdtm) {
        this.createdtm = createdtm;
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
        User other = (User) that;
        return (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getPersonalAlbumId() == null ? other.getPersonalAlbumId() == null : this.getPersonalAlbumId().equals(other.getPersonalAlbumId()))
            && (this.getNickName() == null ? other.getNickName() == null : this.getNickName().equals(other.getNickName()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getTelephone() == null ? other.getTelephone() == null : this.getTelephone().equals(other.getTelephone()))
            && (this.getCreatdtm() == null ? other.getCreatdtm() == null : this.getCreatdtm().equals(other.getCreatdtm()))
            && (this.getIslimit() == null ? other.getIslimit() == null : this.getIslimit().equals(other.getIslimit()))
            && (this.getHeadPortrait() == null ? other.getHeadPortrait() == null : this.getHeadPortrait().equals(other.getHeadPortrait()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getPersonalizedSignature() == null ? other.getPersonalizedSignature() == null : this.getPersonalizedSignature().equals(other.getPersonalizedSignature()))
            && (this.getHobby() == null ? other.getHobby() == null : this.getHobby().equals(other.getHobby()))
            && (this.getPost() == null ? other.getPost() == null : this.getPost().equals(other.getPost()))
            && (this.getHometown() == null ? other.getHometown() == null : this.getHometown().equals(other.getHometown()))
            && (this.getCity() == null ? other.getCity() == null : this.getCity().equals(other.getCity()))
            && (this.getEmail() == null ? other.getEmail() == null : this.getEmail().equals(other.getEmail()))
            && (this.getIntegral() == null ? other.getIntegral() == null : this.getIntegral().equals(other.getIntegral()))
            && (this.getUpdatedtm() == null ? other.getUpdatedtm() == null : this.getUpdatedtm().equals(other.getUpdatedtm()))
            && (this.getUserPassword() == null ? other.getUserPassword() == null : this.getUserPassword().equals(other.getUserPassword()))
            && (this.getSolemelber() == null ? other.getSolemelber() == null : this.getSolemelber().equals(other.getSolemelber()))
            && (this.getCreatedtm() == null ? other.getCreatedtm() == null : this.getCreatedtm().equals(other.getCreatedtm()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getPersonalAlbumId() == null) ? 0 : getPersonalAlbumId().hashCode());
        result = prime * result + ((getNickName() == null) ? 0 : getNickName().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getTelephone() == null) ? 0 : getTelephone().hashCode());
        result = prime * result + ((getCreatdtm() == null) ? 0 : getCreatdtm().hashCode());
        result = prime * result + ((getIslimit() == null) ? 0 : getIslimit().hashCode());
        result = prime * result + ((getHeadPortrait() == null) ? 0 : getHeadPortrait().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getPersonalizedSignature() == null) ? 0 : getPersonalizedSignature().hashCode());
        result = prime * result + ((getHobby() == null) ? 0 : getHobby().hashCode());
        result = prime * result + ((getPost() == null) ? 0 : getPost().hashCode());
        result = prime * result + ((getHometown() == null) ? 0 : getHometown().hashCode());
        result = prime * result + ((getCity() == null) ? 0 : getCity().hashCode());
        result = prime * result + ((getEmail() == null) ? 0 : getEmail().hashCode());
        result = prime * result + ((getIntegral() == null) ? 0 : getIntegral().hashCode());
        result = prime * result + ((getUpdatedtm() == null) ? 0 : getUpdatedtm().hashCode());
        result = prime * result + ((getUserPassword() == null) ? 0 : getUserPassword().hashCode());
        result = prime * result + ((getSolemelber() == null) ? 0 : getSolemelber().hashCode());
        result = prime * result + ((getCreatedtm() == null) ? 0 : getCreatedtm().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", personalAlbumId=").append(personalAlbumId);
        sb.append(", nickName=").append(nickName);
        sb.append(", sex=").append(sex);
        sb.append(", telephone=").append(telephone);
        sb.append(", creatdtm=").append(creatdtm);
        sb.append(", islimit=").append(islimit);
        sb.append(", headPortrait=").append(headPortrait);
        sb.append(", age=").append(age);
        sb.append(", personalizedSignature=").append(personalizedSignature);
        sb.append(", hobby=").append(hobby);
        sb.append(", post=").append(post);
        sb.append(", hometown=").append(hometown);
        sb.append(", city=").append(city);
        sb.append(", email=").append(email);
        sb.append(", integral=").append(integral);
        sb.append(", updatedtm=").append(updatedtm);
        sb.append(", userPassword=").append(userPassword);
        sb.append(", solemelber=").append(solemelber);
        sb.append(", createdtm=").append(createdtm);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}