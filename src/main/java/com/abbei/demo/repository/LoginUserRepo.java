package com.abbei.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.abbei.demo.entity.Users;

@Repository
public interface LoginUserRepo extends JpaRepository<Users, Long>{
	
	Users findByUserName(String username);
	
	@Query(value = "SELECT user_name as userName  FROM user where user_name=:userName ",nativeQuery = true)
	String getUsername(@Param("userName") String userName);


}
