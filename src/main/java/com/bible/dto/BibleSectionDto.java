package com.bible.dto;

import java.io.Serializable;


/**
 * 首页返回的圣经信息
 * @author xiuxiuzhang
 *
 */
public class BibleSectionDto implements Serializable {

	private static final long serialVersionUID = 7200742301632066393L;
	
	
	private Integer sectionId;
	private String sectionName;
	private String sectionMessage;
	private Integer chapterId;
	private String chapterName;
	private Integer ticketId;
	private String ticketName;
	private Integer versionId;
	private Integer userId;
	private Integer isPraise = 0;			//用户是否点赞 1:点赞 0:未点赞
	private Integer praiseCount = 0;		//用户点赞数量
	private Integer thoughtCount = 0;		//用户感悟数量
	
	
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
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
	public Integer getThoughtCount() {
		return thoughtCount;
	}
	public void setThoughtCount(Integer thoughtCount) {
		this.thoughtCount = thoughtCount;
	}
	public Integer getSectionId() {
		return sectionId;
	}
	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}
	public String getSectionName() {
		return sectionName;
	}
	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}
	public String getSectionMessage() {
		return sectionMessage;
	}
	public void setSectionMessage(String sectionMessage) {
		this.sectionMessage = sectionMessage;
	}
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
	 
	
	
	
}
