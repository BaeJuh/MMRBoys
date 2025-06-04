package com.example.builderpratice.entity;

import com.example.builderpratice.interfaces.CommonModelBuilder;
import com.example.builderpratice.model.MemberCreateRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //회원명
    @Column(length = 15, nullable = false)
    private String name;

    //아이디
    @Column(length = 20, nullable = false, unique = true)
    private String username;

    //비밀번호
    @Column(length = 20, nullable = false)
    private String password;

    //이메일
    @Column(length = 50, nullable = false, unique = true)
    private String email;

    //휴대전화
    @Column(length = 20, nullable = false, unique = true)
    private String mobilePhoneNumber;

    //전화번호
    @Column(length = 20, nullable = true)
    private String phoneNumber;

    //가입일
    @Column(nullable = false)
    private LocalDate joinDate;

    //생년월일
    @Column(name = "birthDate", nullable = false)
    private LocalDate birthDate;


    //주민등록번호
    @Column(length = 15, nullable = false, unique = true)
    private String regiNumber;

    //도로명주소
    @Column(nullable = false)
    private String address; // 도로명 주소

    //상세주소
    @Column(nullable = false)
    private String detailAddress;

    //탈퇴여부
    @Column(nullable = false) // default = false
    private Boolean isLeave;

    private Member(Builder builder) {
        this.name = builder.name;
        this.username = builder.username;
        this.password = builder.password;
        this.email = builder.email;
        this.mobilePhoneNumber = builder.mobilePhoneNumber;
        this.phoneNumber = builder.phoneNumber;
        this.joinDate = builder.joinDate;
        this.birthDate = builder.birthDate;
        this.regiNumber = builder.regiNumber;
        this.address = builder.address;
        this.detailAddress = builder.detailAddress;
        this.isLeave = builder.isLeave;
    }

    public static class Builder implements CommonModelBuilder<Member> {
        private final String name;
        private final String username;
        private final String password;
        private final String email;
        private final String mobilePhoneNumber;
        private final String phoneNumber;
        private final LocalDate joinDate;
        private final LocalDate birthDate;
        private final String regiNumber;
        private final String address;
        private final String detailAddress;
        private final Boolean isLeave;

        public Builder(MemberCreateRequest request) {
            this.name = request.getName();
            this.username = request.getUsername();
            this.password = request.getPassword();
            this.email = request.getEmail();
            this.mobilePhoneNumber = request.getMobilePhoneNumber();
            this.phoneNumber = request.getPhoneNumber();
            this.joinDate = LocalDate.now();
            this.birthDate = LocalDate.of(request.getBirthYear(), request.getBirthMonth(), request.getBirthDate());
            this.regiNumber = request.getRegiNumber();
            this.address = request.getAddress();
            this.detailAddress = request.getDetailAddress();
            this.isLeave = false;
        }

        @Override
        public Member build() {
            return new Member(this);
        }
    }
}
