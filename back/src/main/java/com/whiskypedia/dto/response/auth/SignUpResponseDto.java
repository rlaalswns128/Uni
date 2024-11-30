package com.whiskypedia.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.whiskypedia.common.ResponseCode;
import com.whiskypedia.common.ResponseMessage;
import com.whiskypedia.dto.response.ResponseDto;

import lombok.Getter;

@Getter
public class SignUpResponseDto extends ResponseDto {
	private SignUpResponseDto() {
		super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
	}

	public static ResponseEntity<SignUpResponseDto> success() {
		SignUpResponseDto result = new SignUpResponseDto();
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	public static ResponseEntity<ResponseDto> duplicEmail() {
		ResponseDto result = new ResponseDto(ResponseCode.DUPLIC_EMAIL, ResponseMessage.DUPLIC_EMAIL);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

	public static ResponseEntity<ResponseDto> duplicName() {
		ResponseDto result = new ResponseDto(ResponseCode.DUPLIC_NAME, ResponseMessage.DUPLIC_NAME);
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}
}
