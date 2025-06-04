package com.example.builderpratice.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
public class MemberCreateRequest {
    private String name;
    private String username;
    private String password;
    private String email;
    private String mobilePhoneNumber;
    private String phoneNumber;
    private LocalDate joinDate;
    private Integer birthYear;
    private Integer birthMonth;
    private Integer birthDate;
    private String regiNumber;
    private String address;
    private String detailAddress;
    private Boolean isLeave;
}
