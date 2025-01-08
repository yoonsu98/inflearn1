package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import java.util.*;

/**
 * packageName    : hello.hello_spring.repository
 * fileName       : MemberRepository
 * author         : yoons
 * date           : 2025-01-08
 * description    :
 */
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
