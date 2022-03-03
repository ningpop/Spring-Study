package hello.core.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // @ComponentScan의 대상이 되기 위해 붙여준다.
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Autowired // 자동으로 의존 관계 주입이 가능하게 함, ac.getBean(MemberRepository.class)와 같이 동작
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    //테스트 용도
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
