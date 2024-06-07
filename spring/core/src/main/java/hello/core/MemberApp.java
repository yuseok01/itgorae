package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//인터페이스에 만 의존하는게 포인트임
//        AppConfig appConfig = new AppConfig();


        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //모든 시작
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        //서비스이름을 주고 , 반환 타입을 줘야함

       Member member =  new Member( 1L ,  "memberA", Grade.VIP);
       memberService.join(member);

       Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("find member = " + findMember.getName() );
    }
}
