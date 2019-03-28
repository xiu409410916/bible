package com.bible.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bible.model.UserThoughtPraise;

public interface UserThoughtPraiseDao extends JpaRepository<UserThoughtPraise, String> {

	
	/**
	 * 查找 一条感悟 下面的用户点赞数量
	 * @param sectionId
	 * @return
	 */
	@Query("SELECT COUNT(1) FROM UserThoughtPraise WHERE thoughtId = :#{#thoughtId}")
	public int getCountByThoughtId(@Param("thoughtId") Integer thoughtId);
	
	public UserThoughtPraise findByThoughtPraiseId(String thoughtPraiseId);
}
