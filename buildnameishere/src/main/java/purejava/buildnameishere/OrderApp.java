package purejava.buildnameishere;

import purejava.buildnameishere.member.Grade;
import purejava.buildnameishere.member.Member;
import purejava.buildnameishere.member.MemberService;
import purejava.buildnameishere.member.MemberServiceImpl;
import purejava.buildnameishere.order.Order;
import purejava.buildnameishere.order.OrderService;
import purejava.buildnameishere.order.OrderServiceImpl;

public class OrderApp {
    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();

        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(Grade.VIP, memberId, "memberA");
        memberService.join(member);
        Order order = orderService.createOrder(memberId, "itemA", 10000);

        System.out.println("order: " + order.toString());
        System.out.println("calculatePr" + order.calculatePrice());
    }
}
