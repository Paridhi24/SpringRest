package com.cg.api.util;

import com.cg.api.entity.Student;

public class PayloadValidator {

	public static boolean validateCreatePayload(Student payload) {
		if (payload.getId() > 0){
			return false;
		}
		return true;
	}
	

}
