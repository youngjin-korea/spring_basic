package purejava.buildnameishere.discount;

import purejava.buildnameishere.member.Member;

public interface DiscountPolicy {
    int discount(Member member,int price);
}
