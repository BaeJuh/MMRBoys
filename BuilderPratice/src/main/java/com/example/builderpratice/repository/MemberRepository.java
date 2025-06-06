package com.example.builderpratice.repository;

import com.example.builderpratice.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByUsername(String username);

    Long countByUsernameOrEmailOrMobilePhoneNumberOrRegiNumber(
            String username,
            String email,
            String mobilePhoneNumber,
            String regiNumber
    );
}
