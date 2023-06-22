package com.juliano.task.validator;

public class ErrorFormDTO {
	private String field;
	private String error;

	public ErrorFormDTO(String field, String error) {
		this.field = field;
		this.error = error;
	}

	public String getCampo() {
		return field;
	}

	public String getErro() {
		return error;
	}
}
