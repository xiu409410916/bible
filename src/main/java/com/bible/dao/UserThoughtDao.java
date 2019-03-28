package com.bible.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bible.model.UserThought;

public interface UserThoughtDao extends JpaRepository<UserThought, Integer> {
	
	
	/**
	 * 更新用户感悟
	 * @param userInfo
	 */
	@Query("UPDATE UserThought SET thought_message = :#{#userThought.thoughtMessage},update_time=:#{#userThought.updateTime} WHERE thought_id=:#{#userThought.thoughtId}")
	@Modifying
	public void updateUserThought(@Param("userThought")UserThought userThought);
	
	/**
	 * 查找  一个节 下面的用户感悟数量
	 * @param sectionId
	 * @return
	 */
	@Query("SELECT COUNT(1) FROM UserThought WHERE section_id = :#{#sectionId}")
	public int getCountBySection(@Param("sectionId") Integer sectionId);

	
	/**
	 * 查找  一个用户的感悟数量
	 * @return
	 */
	@Query("SELECT COUNT(1) FROM UserThought WHERE user_id = :#{#userId}")
	public int getCountByUserId(@Param("userId") Integer userId);

	
}
