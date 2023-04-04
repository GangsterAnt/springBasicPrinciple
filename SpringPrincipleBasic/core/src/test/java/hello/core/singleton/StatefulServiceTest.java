package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statusfulService01 = ac.getBean(StatefulService.class);
        StatefulService statusfulService02 = ac.getBean(StatefulService.class);

        //사용자 A 10000원 주문
        statusfulService01.order("userA", 10000);
        //사용자 B 20000원 주문
        statusfulService02.order("userB", 20000);
        int price = statusfulService01.getPrice();

        System.out.println("price = " + price);
        Assertions.assertThat(price).isNotEqualTo(10000);
    }
    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}