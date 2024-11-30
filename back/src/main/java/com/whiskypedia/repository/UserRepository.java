package com.whiskypedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.whiskypedia.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	boolean existsByUserEmail(String userEmail);

	boolean existsByUserName(String userName);

	UserEntity findByUserEmail(String userEmail);

	// @Query("SELECT COUNT(u) FROM UserEntity u WHERE u.user_email = :userEmail AND u.userPassword = :userPassword")
	// long countByUserEmailAndUserPassword(@Param("userEmail") String userEmail,
	// 		@Param("userPassword") String userPassword);
}