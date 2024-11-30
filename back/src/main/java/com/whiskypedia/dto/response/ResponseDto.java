package com.whiskypedia.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.whiskypedia.common.ResponseCode;
import com.whiskypedia.common.ResponseMessage;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDto {
	private String code;
	private String message;

	public static ResponseEntity<ResponseDto> databaseError() {
		ResponseDto responseBody = new ResponseDto(ResponseCode.DB_ERROR, ResponseMessage.DB_ERROR);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
	}
}
