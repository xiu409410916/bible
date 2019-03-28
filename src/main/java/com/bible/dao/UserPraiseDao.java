package com.bible.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bible.model.UserPraise;

public interface UserPraiseDao extends JpaRepository<UserPraise, String> {
	
	
	/**
	 * 查找 一个节 下面的用户点赞数量
	 * @param sectionId
	 * @return
	 */
	@Query("SELECT COUNT(1) FROM UserPraise WHERE sectionId = :#{#sectionId}")
	public int getCountBySectionId(@Param("sectionId") Integer sectionId);
	
	public UserPraise findByPraiseId(String praiseId);

}
