package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링없는 순수한 di 컨테이너")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();
        //1.조회할때마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();
//        2. 조회 할때마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        //각자 다른 주소값 ;;

        assertThat(memberService1).isNotEqualTo(memberService2);


    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        //getInstance 메서드호출을통해 객체를받아오자

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);
        //same == 인스턴스가 같은지
        //equal
    }

    @Test
    @DisplayName("스프링컨테이너와 싱글톤")
    void SpringContainer() {

//        AppConfig appConfig = new AppConfig();
        //1.조회할때마다 객체를 생성 싱글톤 컨테이너가 객체를 관리
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);


        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);


        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);
        //각자 다른 주소값 ;;

        assertThat(memberService1).isSameAs(memberService2);

    }
}
