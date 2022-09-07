package hello.springmvc1servlet.domain.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor // 빈 생생저
@AllArgsConstructor // 모든 인자 생성자
public class Member {

    private Long id;
    private String username;
    private int age;

    public Member(String username, int age){
        this.username = username;
        this.age = age;
    }
}
