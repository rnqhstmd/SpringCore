package hello.core;

import hello.core.Order.OrderService;
import hello.core.Order.OrderServiceImpl;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.member.discount.DiscountPolicy;
import hello.core.member.discount.FixDiscountPolicy;
import hello.core.member.discount.RateDiscountPolicy;

public class AppConfig { //구성영역
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());//이러한 방식을 생성자 주입 이라고 함.
        //멤버서비스임플을 만들고 그건 메모리멤버리포지토리 사용할 거다.
    }

    private static MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public OrderService orderService(){
        return new OrderServiceImpl(memberRepository(),
                discountPolicy());
    }
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy(); //여기만 고쳐주면 정책변경 적용가능
    }
}
