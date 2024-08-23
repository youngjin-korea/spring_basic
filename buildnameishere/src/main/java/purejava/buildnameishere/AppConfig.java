package purejava.buildnameishere;


import purejava.buildnameishere.discount.DiscountPolicy;
import purejava.buildnameishere.discount.FixDiscountPolicy;
import purejava.buildnameishere.member.MemberService;
import purejava.buildnameishere.member.MemberServiceImpl;
import purejava.buildnameishere.member.MemoryMemberRepository;
import purejava.buildnameishere.order.OrderService;
import purejava.buildnameishere.order.OrderServiceImpl;

// 메서드명: 역할, return 값 구현체를 한눈에 파악하도록 리팩토링
public class AppConfig {
    public MemberService memberService() {
        // 생성자 주입 - memberserviceImpl의 DIP 규칙을 만족시켜줌
        return new MemberServiceImpl(memberRepository());
    }

    private MemoryMemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
