package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;

    @Autowired
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public void join(Member member) {
        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }


    //테스트용 싱글톤이 제대로 형성되어있는지 서비스에서 오더에서 레파지토리 호출하는데 한개 만 생성되는지
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}