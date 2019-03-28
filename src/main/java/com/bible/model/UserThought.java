package com.bible.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.bible.commons.PageQuery;

/**
 * 用户感悟表
 */
@Entity
public class UserThought extends PageQuery implements Serializable {

	private static final long serialVersionUID = -1513484682868887969L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer thoughtId;
	private Integer userId;
	private Integer sectionId;
	private String thoughtTitle;
	private String thoughtMessage;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date updateTime;
	@Transient
	private String avatarUrl;
	@Transient
	private String nickName;
	@Transient
	private Integer isPraise = 0;			//用户是否点赞 1:点赞 0:未点赞
	@Transient
	private Integer praiseCount = 0;		//用户点赞数量
	
	
	
	
	
	
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public Integer getIsPraise() {
		return isPraise;
	}
	public void setIsPraise(Integer isPraise) {
		this.isPraise = isPraise;
	}
	public Integer getPraiseCount() {
		return praiseCount;
	}
	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount = praiseCount;
	}
	public String getAvatarUrl() {
		return avatarUrl;
	}
	public void setAvatarUrl(String avatarUrl) {
		this.avatarUrl = avatarUrl;
	}
	public Date getUpdateTime() {
		return updateTime;
	}
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	public String getThoughtTitle() {
		return thoughtTitle;
	}
	public void setThoughtTitle(String thoughtTitle) {
		this.thoughtTitle = thoughtTitle;
	}
	public Integer getThoughtId() {
		return thoughtId;
	}
	public void setThoughtId(Integer thoughtId) {
		this.thoughtId = thoughtId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getSectionId() {
		return sectionId;
	}
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	public String getThoughtMessage() {
		return thoughtMessage;
	}
	public void setThoughtMessage(String thoughtMessage) {
		this.thoughtMessage = thoughtMessage;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	

}
