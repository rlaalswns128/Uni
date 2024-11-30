package com.whiskypedia.common;

public interface ResponseMessage {
	String SUCCESS = "SUCCESS";

	String VALIDAT_FAILED = "VALIDATION FAIL";
	String DUPLIC_EMAIL = "DUPLICATED Emall";
	String DUPLIC_NAME = "DUPLICATED Name";
	String NOT_EXIST_USER = "Not Existing User";

	String SIGN_IN_FAIL = "SIGN IN FAIL";
	String SIGN_UP_FAIL = "SIGN UP FAIL";

	String NO_PERMIS = "NO PERMISSION";

	String DB_ERROR = "DB ERROR";
}
