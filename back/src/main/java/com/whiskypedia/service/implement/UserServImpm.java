package com.whiskypedia.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.whiskypedia.dto.response.ResponseDto;
import com.whiskypedia.dto.response.user.GetSignInUserResponseDto;
import com.whiskypedia.entity.UserEntity;
import com.whiskypedia.repository.UserRepository;
import com.whiskypedia.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServImpm implements UserService {

	private final UserRepository userRepository;

	@Override
	public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userEmail) {
		UserEntity userEntity = null;

		try {
			userEntity = userRepository.findByUserEmail(userEmail);
			if (userEntity == null)
				return GetSignInUserResponseDto.notExistUser();
		} catch (Exception exception) {
			exception.printStackTrace();
			return ResponseDto.databaseError();
		}
		return GetSignInUserResponseDto.success(userEntity);
	}
}
