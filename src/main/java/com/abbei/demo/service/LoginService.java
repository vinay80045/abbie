package com.abbei.demo.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abbei.demo.entity.Users;
import com.abbei.demo.repository.LoginUserRepo;

@Service
public class LoginService {

	@Autowired
	private LoginUserRepo loginRepo;

	public ResponseEntity<?> login(String username) {
		Map<String, Object> map = new HashMap<>();
		Map<String, String> userData = new HashMap<>();
		Users userDtl = loginRepo.findByUserName(username);
		if (userDtl != null) {
			userData.put("firstName", userDtl.getFirstName());
			userData.put("lastName", userDtl.getLastName());
			userData.put("userCode", userDtl.getUserCode());
			map.put("message", "User login successfully");
			map.put("userDtl", userData);
			map.put("status", HttpStatus.OK.value());
			return ResponseEntity.ok(map);
		} else {
			map.put("message", "Invalid Credentials");
		}
		map.put("status", HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.badRequest().body(map);
	}
	
	public ResponseEntity<?> registerUser(Users user) {
		Map<String, Object> map = new HashMap<>();
		Users userDtl = null;
		try {
			String userName = loginRepo.getUsername(user.getUserName());
			if (userName == null) {
				user.setUserCode(user.getFirstName()+"00");
				userDtl = loginRepo.save(user);
			}else {
				map.put("message", "User Already exist");
				map.put("status", HttpStatus.OK.value());
				return ResponseEntity.ok(map);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		if (userDtl != null) {
			map.put("message", "User Register successfully");
			map.put("status", HttpStatus.OK.value());
			return ResponseEntity.ok(map);
		} else {
			map.put("message", "Unsuccessfull Server site error");
		}
		map.put("status", HttpStatus.BAD_REQUEST.value());
		return ResponseEntity.badRequest().body(map);
	}

}
