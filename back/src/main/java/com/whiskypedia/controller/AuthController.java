package com.whiskypedia.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.whiskypedia.dto.request.auth.SignInRequestDto;
import com.whiskypedia.dto.request.auth.SignUpRequestDto;
import com.whiskypedia.dto.response.auth.SignInResponseDto;
import com.whiskypedia.dto.response.auth.SignUpResponseDto;
import com.whiskypedia.service.AuthService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthService authService;

//	@PostMapping("/signUp")
//	public ResponseDto<?> signUp(@RequestBody SignUpResponseDto requestBody) {
//		ResponseDto<?> result = authService.signUp(requestBody);
//		return result;
//	}

	@PostMapping("/signUp")
	public ResponseEntity<? super SignUpResponseDto> signUp(@RequestBody @Valid SignUpRequestDto requestBody) {

		ResponseEntity<? super SignUpResponseDto> response = authService.signUp(requestBody);
		System.out.println("Received signup request: " + requestBody);
		return response;
	}

	@PostMapping("/signIn")
	public ResponseEntity<? super SignInResponseDto> signIn(@RequestBody @Valid SignInRequestDto requestBody) {

		ResponseEntity<? super SignInResponseDto> response = authService.signIn(requestBody);
		System.out.println("Received signin request: " + requestBody);
		return response;
	}
}
