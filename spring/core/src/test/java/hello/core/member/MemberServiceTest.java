package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join(){
        //given 맴버 객체를 생성했고
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when 그맴버로 조인했을때
        memberService.join(member);
        Member findMember  =memberService.findMember(1L);

        //then 같니?
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
