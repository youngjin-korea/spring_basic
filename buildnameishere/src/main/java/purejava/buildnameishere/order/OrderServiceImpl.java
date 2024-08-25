package purejava.buildnameishere.order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import purejava.buildnameishere.AppConfig;
import purejava.buildnameishere.discount.DiscountPolicy;
import purejava.buildnameishere.discount.FixDiscountPolicy;
import purejava.buildnameishere.member.Member;
import purejava.buildnameishere.member.MemberRepository;
import purejava.buildnameishere.member.MemoryMemberRepository;


public class OrderServiceImpl implements OrderService {
    // 추상뿐만 아니라 구현체에도 의존하고 있어서 DIP 위반이다.
    //MemberRepository memberRepository = new MemoryMemberRepository();
    //spring의 di가 필요한 이유
    //DiscountPolicy discountPolicy = new FixDiscountPolicy();

//    MemberRepository memberRepository;
//    DiscountPolicy discountPolicy;

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    MemberRepository memberRepository = ac.getBean("memberRepository", MemberRepository.class);
    DiscountPolicy discountPolicy = ac.getBean("discountPolicy", DiscountPolicy.class);

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(discountPrice, itemName, itemPrice, memberId);
    }
}
