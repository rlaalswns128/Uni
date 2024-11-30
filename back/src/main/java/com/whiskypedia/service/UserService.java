package com.whiskypedia.service;

import org.springframework.http.ResponseEntity;

import com.whiskypedia.dto.response.user.GetSignInUserResponseDto;

public interface UserService {
	ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userEmail);
}
