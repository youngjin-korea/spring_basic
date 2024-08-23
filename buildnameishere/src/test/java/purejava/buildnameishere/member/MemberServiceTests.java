package purejava.buildnameishere.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import purejava.buildnameishere.AppConfig;

public class MemberServiceTests {
    MemberService memberService;

    // test실행전에 실행되는 메소드
    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join(){
        //given
        Member member1 = new Member(Grade.VIP, 1L, "member1");
        //when
        memberService.join(member1);
        Member findmember = memberService.findMember(member1.getId());
        //then
        Assertions.assertThat(member1).isEqualTo(findmember);
    }
}
