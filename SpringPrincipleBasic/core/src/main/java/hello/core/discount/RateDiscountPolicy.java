package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.stereotype.Component;

@Component
public class RateDiscountPolicy implements DiscountPolicy {

    private double discountPercent = 0.1d;
    @Override
    public int discount(Member member, int price) {
        if (member.getGradle() == Grade.VIP) {
            return (int) (price * discountPercent);
        }
        return 0;
    }
}
