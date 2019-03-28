package com.bible.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bible.model.BibleSection;

public interface BibleSectionDao extends JpaRepository<BibleSection, Integer>{

	public BibleSection findBySectionId(Integer sectionId);
	
	

	
}
