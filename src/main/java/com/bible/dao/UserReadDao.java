package com.bible.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bible.model.UserRead;

public interface UserReadDao extends JpaRepository<UserRead, Integer> {
	
	/**
	 * 查找  一个用户的阅读数量
	 * @return
	 */
	@Query("SELECT COUNT(1) FROM UserRead WHERE user_id = :#{#userId}")
	public int getCountByUserId(@Param("userId") Integer userId);

	
}
