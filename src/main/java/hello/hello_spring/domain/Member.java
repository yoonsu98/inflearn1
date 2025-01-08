package hello.hello_spring.domain;

/**
 * packageName    : hello.hello_spring.domain
 * fileName       : Member
 * author         : yoons
 * date           : 2025-01-08
 * description    :
 */
public class Member {
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
