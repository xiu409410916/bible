package com.bible.service;

import com.bible.commons.ReturnEntity;
import com.bible.dto.BibleSectionDto;

public interface BibleSectionSer {
	

	/**
	 * 数据的录入
	 */
	public void insert();
	
	
	/**
	 * 随机获取“圣经的一个节”信息
	 * @return
	 */
	public ReturnEntity<BibleSectionDto> randomBibleSection(Integer userId);
	

	/**
	 * 获取“圣经的一个节”信息
	 * @return
	 */
	public ReturnEntity<BibleSectionDto> getBibleSection(Integer userId,Integer sectionId);

}
