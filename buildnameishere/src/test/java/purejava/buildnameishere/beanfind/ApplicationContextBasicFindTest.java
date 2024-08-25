package purejava.buildnameishere.beanfind;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import purejava.buildnameishere.AppConfig;
import purejava.buildnameishere.member.MemberService;
import purejava.buildnameishere.member.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        // 컨테이너에서 빈을 조회후 원하는 클래스의 인스턴스가 맞는지 확인하는 테스트
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService = " + memberService);
        System.out.println("memberService = " + memberService.getClass());

        // assertThat(검증할 것).is~~~(기대값); 의 형식으로 테스트가 대부분 진행됨
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

    @Test
    @DisplayName("빈 타입으로 조회")
    void findBeanByType() {
        // 컨테이너에서 빈을 조회후 원하는 클래스의 인스턴스가 맞는지 확인하는 테스트
        MemberService memberService = ac.getBean(MemberService.class);

        System.out.println("memberService = " + memberService);
        System.out.println("memberService = " + memberService.getClass());

        // assertThat(검증할 것).is~~~(기대값); 의 형식으로 테스트가 대부분 진행됨
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("구현체 빈 타입으로 조회")
    void findBeanType2() {
        // 컨테이너에서 빈을 조회후 원하는 클래스의 인스턴스가 맞는지 확인하는 테스트
        MemberService memberService = ac.getBean(MemberServiceImpl.class);

        // assertThat(검증할 것).is~~~(기대값); 의 형식으로 테스트가 대부분 진행됨
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

}
