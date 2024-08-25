package purejava.buildnameishere.member;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import purejava.buildnameishere.AppConfig;

public class MemberApp {
    public static void main(String[] args) {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        Member member = new Member(Grade.VIP, 1L, "kim");
        memberService.join(member);
        Member member1 = memberService.findMember(1L);
        if (member1.equals(member)) {
            System.out.println("member1은 member를 서비스로 레퍼지토리에 넣고 다시 아이디 값으로 조회한 값이다.");
        }
    }
}
