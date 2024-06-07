package hello.core.singleton;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void StatefulServiceSingleton() {
        ApplicationContext  ac =  new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);


//        A사용자 10000원 주문
        int userAPrice = statefulService1.order("UserA", 10000);
//        b사용자 2000원주문
        int userBPrice = statefulService2.order("UserB", 20000);

//        사용자 a 주문 금액 조회
//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService (){
            return new StatefulService();
        }
    }

}