package purejava.buildnameishere.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTests {
    MemberService memberService = new MemberServiceImpl();

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
