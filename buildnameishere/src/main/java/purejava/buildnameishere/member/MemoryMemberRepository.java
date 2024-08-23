package purejava.buildnameishere.member;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository {

    //    동시성 문제를 해결하기 위해 ConcurrentHashMap로 생성
    private static Map<Long, Member> store = new ConcurrentHashMap<>();

    @Override
    public void save(Member member) {
        if (member == null) {

            throw new NullPointerException();
        }
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {

        return store.get(memberId);
    }
}
