package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService =  appConfig.memberService();

        ApplicationContext applciationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applciationContext.getBean("memberService", MemberService.class);

//        MemberService memberService = new MemberServiceImpl();
        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member foundMember = memberService.findMember(1L);

        System.out.println("new member = " + memberA.getName());
        System.out.println("found member = " + foundMember.getName());
    }
}
