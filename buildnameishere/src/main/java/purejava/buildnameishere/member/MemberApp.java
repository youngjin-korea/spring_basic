package purejava.buildnameishere.member;

public class MemberApp {
    public static void main(String[] args) {
        MemberService memberService = new MemberServiceImpl(new MemoryMemberRepository());
        Member member = new Member(Grade.BASIC, 1L, "member1");

        memberService.join(member);
        Member member1 = memberService.findMember(1L);
        if (member1.equals(member)) {
            System.out.println("member1은 member를 서비스로 레퍼지토리에 넣고 다시 아이디 값으로 조회한 값이다.");
        }
    }
}
