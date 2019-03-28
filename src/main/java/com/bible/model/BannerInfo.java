package com.bible.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.bible.commons.PageQuery;


/**
 * 轮播图信息
 * @author xiuxiuzhang
 *
 */
@Entity
public class BannerInfo extends PageQuery implements Serializable {

	private static final long serialVersionUID = -8640271681016613892L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer bannerId;
	private String bannerImgUrl;
	private Timestamp createTime;
	
	
	public Integer getBannerId() {
		return bannerId;
	}
	public void setBannerId(Integer bannerId) {
		this.bannerId = bannerId;
	}
	public String getBannerImgUrl() {
		return bannerImgUrl;
	}
	public void setBannerImgUrl(String bannerImgUrl) {
		this.bannerImgUrl = bannerImgUrl;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
	

}
