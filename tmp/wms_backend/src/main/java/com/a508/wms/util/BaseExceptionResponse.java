package com.a508.wms.util;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDateTime;
import lombok.Getter;

/**
 * 에러가 발생했을 시 기본으로 반환할 클래스
 * 성공여부, 상태코드, 메시지, 시간을 담은 BaseExceptionResponse 클래스
 * 예외가 발생했을 때라 결과값이 따로 없음
 */
@Getter
@JsonPropertyOrder({"success", "statusCode", "httpStatus", "message", "timestamp"})
public class BaseExceptionResponse extends Exception{

    private final boolean success;
    private final int statusCode;
    private final int httpStatus;
    private final String message;
    private final LocalDateTime timestamp;

    public BaseExceptionResponse(boolean success, int statusCode, int httpStatus, String message) {
        this.success = success;
        this.statusCode = statusCode;
        this.httpStatus = httpStatus;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }
}
