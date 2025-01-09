package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * packageName    : hello.hello_spring.repository
 * fileName       : SpringDataJpaMemberRepository
 * author         : yoons
 * date           : 2025-01-10
 * description    :
 */
public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {
//JpaRepository를 사용하면 interface를 자동으로 Bean으로 만들어줘서 config에 따로 Bean 등록을 하지않아도 됨
    @Override
    Optional<Member> findByName(String name);
}
