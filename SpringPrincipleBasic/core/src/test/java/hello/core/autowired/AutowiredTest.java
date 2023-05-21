package hello.core.autowired;

import hello.core.member.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
    }

    static class TestBean{

//        @Autowired(required = true)
//        public void setNoBean1(Member member) {
//            System.out.println("member1 = " + member);
//        }
        // 오류가 난다 왜냐 -> member는 클래스지 빈이 아니다. 그러면? autowired를 할수 없다!
        // 수정자 자체가 호출이 안된다.

        @Autowired(required = false)
        public void setNoBean1(Member member) {
            System.out.println("member1 = " + member);
        }

        @Autowired()
        public void setNoBean2(@Nullable Member member) {
            System.out.println("member2 = " + member);
        }

        @Autowired()
        public void setNoBean3(Optional<Member> member) {
            System.out.println("member3 = " + member);
        }
    }
}
