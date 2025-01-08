package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

/**
 * packageName    : hello.hello_spring.repository
 * fileName       : MemoryMemberRepositoryTest
 * author         : yoons
 * date           : 2025-01-08
 * description    :
 */
public class MemoryMemberRepositoryTest {
    MemoryMemberRepository memoryMemberRepository = new MemoryMemberRepository();

    @AfterEach // 콜백 함수
    public void afterEach() {
        memoryMemberRepository.clearStore();
    }
    @Test
    public void save() {
        Member member = new Member();
        member.setName("윤수현");

        memoryMemberRepository.save(member);
        Member result = memoryMemberRepository.findById(member.getId()).get();

        // 기본 junit에서 제공하는 것
        Assertions.assertEquals(result, member);

        // assertj를 사용한 것
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        Member result = memoryMemberRepository.findByName("spring1").get();
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        memoryMemberRepository.save(member2);

        List<Member> result = memoryMemberRepository.findAll();
        assertThat(result.size()).isEqualTo(2);

    }
}
