package purejava.buildnameishere;


import purejava.buildnameishere.discount.FixDiscountPolicy;
import purejava.buildnameishere.member.MemberService;
import purejava.buildnameishere.member.MemberServiceImpl;
import purejava.buildnameishere.member.MemoryMemberRepository;
import purejava.buildnameishere.order.OrderService;
import purejava.buildnameishere.order.OrderServiceImpl;

public class AppConfig {
    public MemberService memberService() {
        // 생성자 주입 - memberserviceImpl의 DIP 규칙을 만족시켜줌
        return new MemberServiceImpl(new MemoryMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
