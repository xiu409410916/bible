package com.bible.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bible.commons.PageQuery;


/**
 * 圣经译本表
 * @author xiuxiuzhang
 *
 */
@Entity
public class BibleVersion extends PageQuery implements Serializable {

	private static final long serialVersionUID = -8056725887976576834L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer versionId;
	private String versionName;
	private Timestamp createTime;
	
	public Integer getVersionId() {
		return versionId;
	}
	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}
	public String getVersionName() {
		return versionName;
	}
	public void setVersionName(String versionName) {
		this.versionName = versionName;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
}
