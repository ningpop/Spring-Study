package jpabook2.jpashop2.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    @NotEmpty // 필수값 지정
    private String name;

    @Embedded
    private Address address;

    @JsonIgnore // 순환참조 방지
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
