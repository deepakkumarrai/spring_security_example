package com.daffodilsw.web.controller.endpoint;

import org.springframework.core.NestedRuntimeException;

/**
 * Created by hoozecn.
 */
public class EndPointException extends NestedRuntimeException {
    private final ErrorCode errorCode;

    public static enum ErrorCode {
        dataNotReady, canNotShareGroup, groupDoesNotExist,
    }

    public EndPointException(ErrorCode code) {
        super(code.toString());
        this.errorCode = code;
    }

    public EndPointException(ErrorCode code, String message) {
        super(message);
        this.errorCode = code;
    }

    public EndPointException(ErrorCode code, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = code;
    }

    public Body build() {
        return new Body(this);
    }

    public static class Body {
        public ErrorCode code;
        public String error;
        public String detail;

        public Body(EndPointException ex) {
            code = ex.errorCode;
            error = ex.getMessage();
            if (ex.getCause() != null && ex.getCause() != ex) {
                detail = ex.getCause().getMessage();
            }
        }

        public ErrorCode getCode() {
            return code;
        }

        public String getDetail() {
            return detail;
        }

        public String getError() {
            return error;
        }
    }
}
