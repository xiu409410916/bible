package com.bible.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bible.commons.PageQuery;


/**
 * 圣经券表
 * @author xiuxiuzhang
 *
 */
@Entity
public class BibleTicket extends PageQuery implements Serializable {

	private static final long serialVersionUID = -8056725887976576834L;

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer ticketId;
	private String ticketName;
	private Integer versionId;
	private String bibleType;
	private String strongName;
	private String englishName;
	private Timestamp createTime;
	
	
	public String getStrongName() {
		return strongName;
	}
	public void setStrongName(String strongName) {
		this.strongName = strongName;
	}
	public String getEnglishName() {
		return englishName;
	}
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	public Integer getTicketId() {
		return ticketId;
	}
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
	}
	public String getTicketName() {
		return ticketName;
	}
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	public Integer getVersionId() {
		return versionId;
	}
	public void setVersionId(Integer versionId) {
		this.versionId = versionId;
	}
	public String getBibleType() {
		return bibleType;
	}
	public void setBibleType(String bibleType) {
		this.bibleType = bibleType;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
}
