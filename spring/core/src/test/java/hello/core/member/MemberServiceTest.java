package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

   MemberService memberService;

   @BeforeEach
   public void beforEach(){
       AppConfig appConfig = new AppConfig();
       //APPCONFIG 객체 생성후에
       memberService = appConfig.memberService();
       //member 서비스 할당
   }

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
