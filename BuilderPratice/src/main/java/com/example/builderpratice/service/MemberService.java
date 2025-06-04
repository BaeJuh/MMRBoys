package com.example.builderpratice.service;

import com.example.builderpratice.entity.Member;
import com.example.builderpratice.model.MemberCreateRequest;
import com.example.builderpratice.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    private boolean isDuplicateUsername(String username) {
        Optional<Member> member = memberRepository.findByUsername(username);

        return member.isPresent();
    }

    private boolean isDuplicateInfo(
            String username,
            String email,
            String mobilePhoneNumber,
            String regiNumber
    ) {
        long result = memberRepository.countByUsernameOrEmailOrMobilePhoneNumberOrRegiNumber(username, email, mobilePhoneNumber, regiNumber);

        return result > 0;
    }

    public void setMember(MemberCreateRequest request) {
        if (isDuplicateInfo(request.getUsername(), request.getEmail(), request.getMobilePhoneNumber(), request.getRegiNumber())) {
            throw new CMissingDataException();
        }

        Member member = new Member.Builder(request).build();
        memberRepository.save(member);
    }
}
