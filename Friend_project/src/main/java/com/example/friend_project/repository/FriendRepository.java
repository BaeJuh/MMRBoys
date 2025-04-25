package com.example.friend_project.repository;

import com.example.friend_project.entity.Friend;
import org.springframework.data.repository.CrudRepository;

public interface FriendRepository extends CrudRepository<Friend, Long> {
}
