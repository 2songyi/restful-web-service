package com.xyz.restfulwerbservice.user;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

//HTTP status code
//2XX -> 정상 동작
//4XX -> 클라이언트 측 에러
//5XX -> 서버 측 에러

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {
	//RuntimeException은 runtimeException이다.
	public UserNotFoundException(String message) {
		super(message);
	}
}
