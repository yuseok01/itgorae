package hello.servlet.domain.member;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MemberRepositoryTest {
    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    } //
    //test 끝날때마다 클리어하기

    @Test
    void save() {
        //given
        Member member = new Member("hello", 20); //객체만들기
//when
        Member savedMember = memberRepository.save(member); //맴버저장
        //then
        Member findMember = memberRepository.findById(savedMember.getId()); //맴버 찾기
            assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    void findAll() {
        //given
        Member member1 = new Member("member1", 20);
        Member member2 = new Member("member2", 30);
        memberRepository.save(member1);
        memberRepository.save(member2);
        //when
        List<Member> result = memberRepository.findAll();
        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result).contains(member1, member2);
    }
}
