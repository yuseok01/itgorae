package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration //객체 주소값 저장
@ComponentScan(
//디폴트는 해당 패키지를 다 뒤짐
        basePackages = "hello.core",
        excludeFilters= @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //해당 클래스는 필터 기존의 appConfig는 제외
)
public class AutoAppConfig {

}
