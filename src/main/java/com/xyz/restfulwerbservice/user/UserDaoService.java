package com.xyz.restfulwerbservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
	private static List<User> users = new ArrayList<>();
	
	private static int usersCount = 3; // 초기데이터가 3
	
	static {
		users.add(new User(1, "Kenneth", new Date()));
		users.add(new User(2, "Song", new Date()));
		users.add(new User(3, "Jimin", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	// 사용자 추가
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++usersCount);
		}
		
		return user;
	}
	
	// 개별데이터 반환
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}
