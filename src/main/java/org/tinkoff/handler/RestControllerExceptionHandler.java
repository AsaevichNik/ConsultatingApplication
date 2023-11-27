package org.tinkoff.handler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice(basePackages = "org.tinkoff.controllers")
public class RestControllerExceptionHandler extends ResponseEntityExceptionHandler {}
