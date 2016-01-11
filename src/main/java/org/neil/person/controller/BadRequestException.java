package org.neil.person.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by neilsharpe on 1/9/16.
 */
@ResponseStatus(value= HttpStatus.BAD_REQUEST, reason="Please Provide either a list of persons or a person to post")
public class BadRequestException extends IllegalStateException {
}
