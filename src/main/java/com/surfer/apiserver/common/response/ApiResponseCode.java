package com.surfer.apiserver.common.response;

public enum ApiResponseCode {
    //COMMON

    SUCCESS("OK", "SUCCESS"),
    CREATED("OK", "CREATED"),
    ACCEPTED("OK", "ACCEPTED"),
    UNKNOWN("UNKNOWN", "occured unknown error"),
    UNIQUE_CONSTRAINT_VIOLATED("UNIQUE_CONSTRAINT_VIOLATED", "unique value is duplicated"),
    UNKNOWN_DATABASE_EXCEPTION("UNKNOWN_DATABASE_EXCEPTION", "UNKNOWN DATABASE EXCEPTION"),
    NOT_FOUND("NOT_FOUND", "not found"),
    UNACCEPTED_REQUEST("UNACCEPTED_REQUEST", "unaccepted request"),
    //auth
    UNIQUE_PARAMETER_VIOLATION_EMAIL("UNIQUE_PARAMETER_VIOLATION_EMAIL", "unique parameter email is violation"),
    UNIQUE_PARAMETER_VIOLATION_NICKNAME("UNIQUE_PARAMETER_VIOLATION_NICKNAME", "unique parameter nickname is violation"),
    REGISTER_SUCCESS("REGISTER_SUCCESS", "register success"),
    FAILED_SIGN_UP_USER("ERR_SIGN_UP", "failed to add new user"),
    FAILED_SIGN_IN_USER("ERR_SIGN_IN", "failed to login because userid not exist"),
    INVALID_USER_ID("INVALID_USER_ID", "failed to load user because email is not exist"),
    INVALID_API_ACCESS_TOKEN("INVALID_API_ACCESS_TOKEN", "Invalid access_token"),
    INVALID_API_REFRESH_TOKEN("INVALID_API_REFRESH_TOKEN", "Invalid refresh_token"),
    ACCESS_TOKEN_EXPIRED("ACCESS_TOKEN_EXPIRED", "access token expired"),
    INVALID_CLIENT_ID_OR_CLIENT_SECRET("INVALID_CLIENT_ID_OR_CLIENT_SECRET", "invalid client-id or client-secret"),
    INVALID_PARAMETER_ERR("INVALID_PARAMETER_ERR", "invalid parameter error"),
    UNAUTHORIZED_ACCESS("UNAUTHORIZED_ACCESS", "not authorized user"),
    //song
    INVALID_SONG_ID("INVALID_SONG_ID","failed to load song because seq is not exist"),
    INVALID_ALBUM_ID("INVALID_ALBUM_ID", "failed to load album because seq is not exist"),
    INVALID_ALBUM_STATE("INVALID_ALBUM_STATE","invalid album state"),
    INVALID_REPLY_ID("INVALID_REPLY_ID","failed to load reply because seq is not exist"),
    FAILED_UPDATE_REPLY("ERR_UPDATE_REPLY","failed to update reply because user is not authorized")
    
    ;


    private String code;
    private String message;


    public String getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    ApiResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
