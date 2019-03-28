package com.bible.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bible.commons.PageQuery;


/**
 * 圣经章表
 * @author xiuxiuzhang
 *
 */
@Entity
public class BibleChapter extends PageQuery implements Serializable {

	private static final long serialVersionUID = -2050722234725307012L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer chapterId;
	private String chapterName;
	private Integer ticketId;
	private String ticketName;
	private Integer versionId;
	private String bibleType;
	private Timestamp createTime;
	
	
	public Integer getChapterId() {
		return chapterId;
	}
	public void setChapterId(Integer chapterId) {
		this.chapterId = chapterId;
	}
	public String getChapterName() {
		return chapterName;
	}
	public void setChapterName(String chapterName) {
		this.chapterName = chapterName;
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
