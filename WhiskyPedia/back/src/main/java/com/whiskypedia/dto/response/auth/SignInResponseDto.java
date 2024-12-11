package com.whiskypedia.dto.response.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.whiskypedia.common.ResponseCode;
import com.whiskypedia.common.ResponseMessage;
import com.whiskypedia.dto.response.ResponseDto;
import lombok.Getter;

@Getter
public class SignInResponseDto extends ResponseDto {
    private String token;
    private int exprTime;

    private SignInResponseDto(String token) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.token = token;
        this.exprTime = 3600;
    }

    public static ResponseEntity<SignInResponseDto> success(String token) {
        SignInResponseDto result = new SignInResponseDto(token);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> signInFail() {
        ResponseDto result = new ResponseDto(ResponseCode.SIGN_IN_FAIL, ResponseMessage.SIGN_IN_FAIL);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(result);
    }
}