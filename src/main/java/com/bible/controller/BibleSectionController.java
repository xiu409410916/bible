package com.bible.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bible.commons.ReturnEntity;
import com.bible.dto.BibleSectionDto;
import com.bible.service.BibleSectionSer;

@RestController
@RequestMapping("/bibleSection")
public class BibleSectionController {
	
	@Autowired
	private BibleSectionSer bibleSectionSer;

	
	/**
	 * 随机获取“圣经的一个节”信息
	 * @return
	 */
	@RequestMapping("/randomBibleSection")
	public ReturnEntity<BibleSectionDto> randomBibleSection(Integer userId){
		return bibleSectionSer.randomBibleSection(userId);
	}
	
	

	/**
	 * 获取“圣经的一个节”信息
	 * @return
	 */
	@RequestMapping("/getBibleSection")
	public ReturnEntity<BibleSectionDto> getBibleSection(Integer userId,Integer sectionId){
		return bibleSectionSer.getBibleSection(userId, sectionId);
	}
	
	
	
}
