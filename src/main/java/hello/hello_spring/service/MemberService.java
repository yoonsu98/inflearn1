package hello.hello_spring.service;

import hello.hello_spring.domain.Member;
import hello.hello_spring.repository.MemberRepository;
import hello.hello_spring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * packageName    : hello.hello_spring.service
 * fileName       : MemberService
 * author         : yoons
 * date           : 2025-01-08
 * description    :
 */
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     *
     * @param member
     * @return
     */
    @Transactional
    public Long join(Member member) {
        // 중복 회원 불가
        validateDuplicateMember(member);

        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 중복 회원 검증
     * @param member
     */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName()).ifPresent(m -> {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
