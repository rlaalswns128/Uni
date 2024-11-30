package com.whiskypedia.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.whiskypedia.dto.request.auth.SignInRequestDto;
import com.whiskypedia.dto.request.auth.SignUpRequestDto;
import com.whiskypedia.dto.response.auth.SignInResponseDto;
import com.whiskypedia.dto.response.auth.SignUpResponseDto;

@Service
public interface AuthService {

	ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto);

	ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
}
