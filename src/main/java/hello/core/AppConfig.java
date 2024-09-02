package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    //AppConfig는 구체 클래스 선택함(구현 객체 생성, 연결하는  책임)
    /**
     * 스프링 컨테이너 생성: ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
     * 스프링 빈 등록: @Bean
     * 스프이 빈 의존관계 설정
     */


    @Bean
    public MemberService memberService(){
//        return new MemberServiceImpl(new MemoryMemberRepository());
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
//        return new OrderServiceImpl(new MemoryMemberRepository(),new FixDiscountPolicy());
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
