package com.whiskypedia.dto.response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.whiskypedia.common.ResponseCode;
import com.whiskypedia.common.ResponseMessage;
import com.whiskypedia.dto.response.ResponseDto;
import com.whiskypedia.entity.UserEntity;

import lombok.Getter;

@Getter
public class GetSignInUserResponseDto extends ResponseDto {
	private String userEmail;
	private String userName;

	private GetSignInUserResponseDto(UserEntity userEntity) {
		super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
		this.userEmail = userEntity.getUserEmail();
		this.userName = userEntity.getUserName();
	}

	public static ResponseEntity<GetSignInUserResponseDto> success(UserEntity userEntity) {
		GetSignInUserResponseDto result = new GetSignInUserResponseDto(userEntity);
		return ResponseEntity.status(HttpStatus.OK).body(result);
	}

	public static ResponseEntity<ResponseDto> notExistUser() {
		ResponseDto result = new ResponseDto(ResponseCode.NOT_EXIST_USER, ResponseMessage.NOT_EXIST_USER);
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
	}
}
