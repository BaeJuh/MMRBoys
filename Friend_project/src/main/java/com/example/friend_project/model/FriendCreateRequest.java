package com.example.friend_project.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FriendCreateRequest {
    private String name;
    private Integer age;
    private String give;
    private String take;
}
