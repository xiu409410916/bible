package com.bible.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.bible.commons.PageQuery;


@Entity
public class UserThoughtPraise extends PageQuery implements Serializable {
	
	
	private static final long serialVersionUID = 7915798131296273709L;
	
	
	@Id
	private String thoughtPraiseId;
	private Integer userId;
	private Integer thoughtId;
	private Timestamp createTime;
	
	
	public String getThoughtPraiseId() {
		return thoughtPraiseId;
	}
	public void setThoughtPraiseId(String thoughtPraiseId) {
		this.thoughtPraiseId = thoughtPraiseId;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Integer getThoughtId() {
		return thoughtId;
	}
	public void setThoughtId(Integer thoughtId) {
		this.thoughtId = thoughtId;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	

	
	
}
