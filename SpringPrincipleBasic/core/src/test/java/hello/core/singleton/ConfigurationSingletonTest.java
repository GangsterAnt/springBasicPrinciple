package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberRepository;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConfigurationSingletonTest {

    @Test
    void configurationTest() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        MemberRepository memberRepository = memberService.getMemberRepository();
        System.out.println("memberRepository = " + memberRepository);

        MemberRepository memberRepository1 = orderService.getMemberRepository();
        System.out.println("memberRepository1 = " + memberRepository1);

        MemberRepository memberRepository2 = ac.getBean("memberRepository", MemberRepository.class);
        System.out.println("memberRepository2 = " + memberRepository2);

//        Assertions.assertThat(memberRepository).isSameAs(memberRepository1);
    }
}
