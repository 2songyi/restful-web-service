package com.xyz.restfulwerbservice.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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
		users.add(user);
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
	
	// 개별 데이터 삭제
	public User deleteById(int id) {
		// 유효성 검증
		Iterator<User> iterator = users.iterator();
		// 열거형 데이터를 순차적으로 접근해서 사용하는 열거형 데이터
		
		while(iterator.hasNext()) {
			User user = iterator.next();
			
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		
		return null;
	}
	
	
}
