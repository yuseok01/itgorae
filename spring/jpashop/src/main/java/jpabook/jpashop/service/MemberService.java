package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) //스프링이 제공하는 트렌젝션 쓰자!
@RequiredArgsConstructor //생성자 없이 인젝션
public class MemberService {


    private final MemberRepository memberRepository;

    /*
    회원가입
     */
    @Transactional(readOnly = false)
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();

    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw  new IllegalArgumentException("이미 존재하는 회원입니다. ");
        }
    }
    //회원 전체조회

    public List<Member> findAll() {
        return memberRepository.findAll();
    }
    public Member findOme(Long memberId) {
        return memberRepository.findOne(memberId);
    }
}
