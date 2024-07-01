package jpabook.jpashop.domain;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded //내장 타입 포함
    private Address address;

    @OneToMany(mappedBy = "member")
    //오더테이블에 있는 맴버 필드의 거울 member가 바뀌면 바뀜
    private List<Order> order = new ArrayList<>();

}
