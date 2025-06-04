package com.example.builderpratice.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ResultCode {
    SUCCESS(0, "Success"),
    FAILED(-1, "Failed"),

    WRONG_PHONE_NUMBER(-1000, "Wrong Phone Number"),
    WRONG_ID(-1001, "Wrong ID"),
    WRONG_PASSWORD(-1002, "Wrong Password"),

    MISSING_DATA(-2000, "Missing data"),;

    private final Integer code;
    private final String message;
}
