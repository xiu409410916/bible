package com.bible.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.bible.commons.PageQuery;


/**
 * 用户阅读记录表
 * @author xiuxiuzhang
 *
 */
@Entity
public class UserRead extends PageQuery implements Serializable {

	private static final long serialVersionUID = -8896500481301220666L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer readId;
	private Integer userId;
	private Integer sectionId;
	private String readTitle;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date createTime;
	
	
	

	public String getReadTitle() {
		return readTitle;
	}
	public void setReadTitle(String readTitle) {
		this.readTitle = readTitle;
	}
	public Integer getReadId() {
		return readId;
	}
	public void setReadId(Integer readId) {
		this.readId = readId;
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
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
	

}
