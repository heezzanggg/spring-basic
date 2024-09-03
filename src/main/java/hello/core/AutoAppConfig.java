package hello.core;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

import static org.springframework.context.annotation.ComponentScan.*;

@Configuration
@ComponentScan(excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = Configuration.class))
public class AutoAppConfig {
    //AppConfig와 다르게 @Bean으로 등록한 클래스가 하나도 없음
    //ComponentScan: @Component 애노테이션이 붙은 클래스를 스캔해서 스프링 빈으로 등록

}
