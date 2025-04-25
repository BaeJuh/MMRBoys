package com.example.friend_project.controller;

import com.example.friend_project.entity.Friend;
import com.example.friend_project.model.FriendCreateRequest;
import com.example.friend_project.service.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/friend")
public class FriendController {
    private final FriendService friendService;

    @PostMapping("/new")
    public String setFriend(@RequestBody FriendCreateRequest request) {
        friendService.setFriendData(request);

        return "connect";
    }
}
