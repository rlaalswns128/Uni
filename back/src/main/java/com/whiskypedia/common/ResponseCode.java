package com.whiskypedia.common;

public interface ResponseCode {
	String SUCCESS = "SUC";

	String VALIDAT_FAILED = "VAL FAL";
	String DUPLIC_EMAIL = "DUP Emal";
	String DUPLIC_NAME = "DUP Name";
	String NOT_EXIST_USER = "No User";

	String SIGN_IN_FAIL = "SIGN_IN FAL";
	String SIGN_UP_FAIL = "SIGN_UP FAL";

	String NO_PERMIS = "NO PERMIS";

	String DB_ERROR = "DB ERR";
}
