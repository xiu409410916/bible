package com.bible.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bible.model.UserInfo;

public interface UserInfoDao extends JpaRepository<UserInfo, Integer> {
	/**
	 * 根据openId获取
	 * @return
	 */
	public UserInfo findByOpenId(String openId);
	
	/**
	 * 根据userId获取
	 * @return
	 */
	public UserInfo findByUserId(Integer userId);
	
	/**
	 * 更新用户信息
	 * @param userInfo
	 */
	@Query("UPDATE UserInfo SET nickName = :#{#userInfo.nickName},avatarUrl=:#{#userInfo.avatarUrl},gender=:#{#userInfo.gender} WHERE userId=:#{#userInfo.userId}")
	@Modifying
	public void updateUserInfo(@Param("userInfo")UserInfo userInfo);
}
