package com.whiskypedia.service.implement;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.whiskypedia.dto.request.auth.SignInRequestDto;
import com.whiskypedia.dto.request.auth.SignUpRequestDto;
import com.whiskypedia.dto.response.ResponseDto;
import com.whiskypedia.dto.response.auth.SignInResponseDto;
import com.whiskypedia.dto.response.auth.SignUpResponseDto;
import com.whiskypedia.entity.UserEntity;
import com.whiskypedia.repository.UserRepository;
import com.whiskypedia.security.JwtProvider;
import com.whiskypedia.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServImp implements AuthService {

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    private final JwtProvider jwtProvider;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super SignUpResponseDto> signUp(SignUpRequestDto dto) {
        try {
            String userEmail = dto.getUserEmail();
            boolean existedUserEmail = userRepository.existsByUserEmail(userEmail);
            if (existedUserEmail)
                return SignUpResponseDto.duplicEmail();

            String userName = dto.getUserName();
            boolean existedUserName = userRepository.existsByUserName(userName);
            if (existedUserName)
                return SignUpResponseDto.duplicName();

            String userPassword = dto.getUserPassword();
            String encodedPassword = passwordEncoder.encode(userPassword);
            UserEntity userEntity = new UserEntity(dto);
            userEntity.setUserPassword(encodedPassword);

            userRepository.save(userEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignUpResponseDto.success();
    }

    @Override
    public ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto) {
        String token = null;
        try {
            String userEmail = dto.getUserEmail();
            UserEntity userEntity = userRepository.findByUserEmail(userEmail);
            if (userEntity == null)
                return SignInResponseDto.signInFail();

            String userPassword = dto.getUserPassword();
            String encodedPassword = userEntity.getUserPassword();
            boolean isMatched = passwordEncoder.matches(userPassword, encodedPassword);
            if (!isMatched)
                return SignInResponseDto.signInFail();

            token = jwtProvider.create(userEmail);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SignInResponseDto.success(token);
    }
}