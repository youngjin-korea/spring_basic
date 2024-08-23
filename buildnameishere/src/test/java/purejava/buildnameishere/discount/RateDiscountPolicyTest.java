package purejava.buildnameishere.discount;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import purejava.buildnameishere.member.Grade;
import purejava.buildnameishere.member.Member;

import static org.junit.jupiter.api.Assertions.*;

class RateDiscountPolicyTest {
    @Test
    @DisplayName("vip는 10프로 할인이 되어야함")
    void vip_o() {
        RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();
        //given
        Member member = new Member(Grade.VIP, 1L, "member1");
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("vip가 아닌 경우 할인이 안되어야한다.")
    void vip_x(){
        RateDiscountPolicy rateDiscountPolicy = new RateDiscountPolicy();

        //given
        Member member = new Member(Grade.BASIC,2L,"member2");
        //when
        int discount = rateDiscountPolicy.discount(member, 10000);
        //then
        Assertions.assertThat(discount).isEqualTo(0);
    }
}