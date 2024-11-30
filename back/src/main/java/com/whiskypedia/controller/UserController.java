package com.whiskypedia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whiskypedia.dto.response.user.GetSignInUserResponseDto;
import com.whiskypedia.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserController {
	private final UserService userService;

	@GetMapping("")
	public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(@AuthenticationPrincipal String userEmail) {
		ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(userEmail);
		return response;
	}
}
