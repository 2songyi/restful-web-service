package com.xyz.restfulwerbservice.exception;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {
	private Date timestamp;
	private String message;
	private String details;
	
	// 예외에 담을 데이터
	// 핸들러, AOP기능
}
