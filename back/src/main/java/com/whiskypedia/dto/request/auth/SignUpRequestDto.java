package com.whiskypedia.dto.request.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignUpRequestDto {
	@NotBlank
	@Email
	private String userEmail;

	@NotBlank
	private String userName;

	@NotBlank
	private String userPassword;

	@NotBlank
	private String userPwConfirm;
}
