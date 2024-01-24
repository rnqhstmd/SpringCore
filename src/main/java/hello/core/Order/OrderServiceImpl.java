package hello.core.Order;

import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import hello.core.member.discount.DiscountPolicy;
import hello.core.member.discount.FixDiscountPolicy;
import hello.core.member.discount.RateDiscountPolicy;

public class OrderServiceImpl implements OrderService{
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    // private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    //인터페이스가 아닌 구현체(fix, rate~)들이 아닌 인터페이스 discountPolicy에 의존하게 하여 DIP위반을 피한다.
    // private DiscountPolicy discountPolicy;
    //DIP위반은 피했지, 근데 값이 없기때문에 null값으로 되어 null point execption 에러가 남.

    //해결 방안 : 클라이언트 impl에 discountPolicy의 구현객체를 생성한 후 주입해주어야함

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice); //단일책암원칙 잘 지키ㅁ, 최종 가격 리튼하게끔

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
