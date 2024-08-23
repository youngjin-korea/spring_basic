package purejava.buildnameishere.discount;

import purejava.buildnameishere.member.Grade;
import purejava.buildnameishere.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    //10%할인
    private final int discountPercent = 10;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        }
        return 0;
    }
}
