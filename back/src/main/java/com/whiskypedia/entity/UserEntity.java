package com.whiskypedia.entity;

import com.whiskypedia.dto.request.auth.SignUpRequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "User")
@Table(name = "User")
public class UserEntity {
	@Id // Primary Key
	@Column(name = "user_email")
	private String userEmail;

	@Column(name = "user_name")
	private String userName;

	@Column(name = "user_password")
	private String userPassword;

	public UserEntity(SignUpRequestDto dto) {
		this.userEmail = dto.getUserEmail();
		this.userName = dto.getUserName();
		this.userPassword = dto.getUserPassword();
	}

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
}
