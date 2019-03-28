package com.bible.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bible.model.BibleChapter;

public interface BibleChapterDao extends JpaRepository<BibleChapter, Integer> {

	public List<BibleChapter> findByTicketId(Integer ticketId);
	
}
