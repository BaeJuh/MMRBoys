package com.example.friend_project.service;

import com.example.friend_project.entity.Friend;
import com.example.friend_project.model.FriendCreateRequest;
import com.example.friend_project.repository.FriendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class FriendService {
    private final FriendRepository friendRepository;

    public void setFriendData(FriendCreateRequest request) {
        Friend friend = new Friend();
        friend.setName(request.getName());
        friend.setAge(request.getAge());
        friend.setGive(request.getGive());
        friend.setTake(request.getTake());
        friend.setDate(LocalDate.now());

        friendRepository.save(friend);
    }
}
