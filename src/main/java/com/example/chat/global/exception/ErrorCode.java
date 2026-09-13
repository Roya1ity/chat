package com.example.chat.global.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {
    LOGIN_REQUIRED(HttpStatus.UNAUTHORIZED,"로그인이 필요함"),
    TOKEN_EXPIRED(HttpStatus.UNAUTHORIZED,"엑세스 토큰이 만료됨. 재발급 후 이용바람"),
    ACCESS_DENIED(HttpStatus.FORBIDDEN,"접근 권한이 없음"),

    USER_NOT_FOUND(HttpStatus.NOT_FOUND,"사용자를 찾을 수 없음"),
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND,"요청한 경로를 찾을 수 없음"),

    INVALID_INPUT(HttpStatus.BAD_REQUEST,"입력값이 올바르지 않음"),
    MALFORMED_REQUEST(HttpStatus.BAD_REQUEST,"요청 본문을 읽을 수 없음"),

    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR,"서버 내부 오류 발생");

    private final HttpStatus status;
    private final String message;
}
