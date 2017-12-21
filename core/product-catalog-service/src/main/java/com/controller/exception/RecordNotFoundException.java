package com.controller.exception;

import com.service.exception.RecordDoesNotExistException;


public final class RecordNotFoundException extends ApiException {

	private static final long serialVersionUID = -1L;

	public RecordNotFoundException(RecordDoesNotExistException e){
		super(e.getMessage(), e);
	}
}
