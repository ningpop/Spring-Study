package study.datajpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
public class Member {

    @Id @GeneratedValue
    private Long id;

    private String username;

    // proxy 객체를 생성 시 필요하기에 protected 사용
    protected Member() {
    }

    public Member(String username) {
        this.username = username;
    }
}
