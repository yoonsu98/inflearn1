package hello.hello_spring.config;

import hello.hello_spring.aop.TimeTraceAop;
import hello.hello_spring.repository.*;
import hello.hello_spring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * packageName    : hello.hello_spring.config
 * fileName       : SpringConfig
 * author         : yoons
 * date           : 2025-01-09
 * description    :
 */
@Configuration
public class SpringConfig {

//    private EntityManager em;
//    private DataSource dataSource;

    private final MemberRepository memberRepository;

    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @Autowired
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

    @Bean
    public MemberService memberService() {

        return new MemberService(memberRepository);
    }
//    @Bean
//    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository(dataSource);
//        return new JdbcMemberRepository(dataSource);
//        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}
