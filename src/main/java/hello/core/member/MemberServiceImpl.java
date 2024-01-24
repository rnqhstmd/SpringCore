package hello.core.member;

public class MemberServiceImpl implements MemberService{
    private final MemberRepository memberRepository;
    //new로 직접 할당하지 말고 생성자를 생성해준다.
    //여기엔 이제 추상화에만 의존함  이제 MemoryMemberRepository언급도 없음 다 appconfig에서 선언해줄 것임.
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
}
