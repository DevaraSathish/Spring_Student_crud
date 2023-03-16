package org.jsp.student_crud.Helper;

import lombok.Data;

@Data
public class ResponseStructure <T>{
	
	int Code;
	String message;
	T data;
	}

