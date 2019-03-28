package com.bible.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bible.model.BibleVersion;

public interface BibleVersionDao extends JpaRepository<BibleVersion, Integer> {

}
