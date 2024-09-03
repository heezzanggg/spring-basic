package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SingletonService {

    //1.static 영역에 객체를 1개만 생성해둔다.
    private static final SingletonService instance = new SingletonService();

    //2. public으로 열어서 객체 인스턴스가 필요하면 이 static 메서드를 통해서만 조회하도록 허용한다.
    // 이 메서드를 호출하면 항상 같은 인스턴스를 반환함
    public static SingletonService getInstance(){
        return instance;
    }

    //3. 생성자를 private로 선언해서 외부에서 new 키워드를 사용한 객체 생성 못하게 막음
    private SingletonService(){
    }

    public void logic(){
        System.out.println("싱글톤 객체 로직호출");
    }

    @Test
    @DisplayName("싱글톤 패턴 적용한 객체 사용")
    public void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        //참조값 같음
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        //singletonService1 == singletonService2
        Assertions.assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //1. 조회: 호출할 때 마다 같은 객체를 반환
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        //2. 조회: 호출할 때 마다 같은 객체를 반환
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //참조값이 같은 것을 확인
        System.out.println("memberService1 = " + memberService1); System.out.println("memberService2 = " + memberService2);
        //memberService1 == memberService2
        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
