package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * packageName    : hello.hello_spring.repository
 * fileName       : MemoryMemberRepository
 * author         : yoons
 * date           : 2025-01-08
 * description    : DB가 정해지지 않았다는 가정 하에 작성한 repository
 */
public class MemoryMemberRepository implements MemberRepository{
    private static Map<Long, Member> store = new HashMap<>(); //static으로 선언하면 동시성 문제 때문에 Concurrent HashMap을 써야함!!
    private static long sequence = 0L; //이것도 동시성 문제때문에 원래는 atomic long으로 선언해야함..

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream().filter(member -> name.equals(member.getName())).findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
