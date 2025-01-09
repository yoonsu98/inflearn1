package hello.hello_spring.domain;

import jakarta.persistence.*;

/**
 * packageName    : hello.hello_spring.domain
 * fileName       : Member
 * author         : yoons
 * date           : 2025-01-08
 * description    :
 */
@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) // DB가 ID를 자동으로 생성해주는 것 -> Identity 전략
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
