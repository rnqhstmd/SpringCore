package hello.core.member.discount;

import hello.core.member.Grade;
import hello.core.member.Member;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class FixDiscountPolicy implements DiscountPolicy{

    private int discountFixAmounts = 1000;//1000원 할인
    @Override
    public int discount(Member member, int price) {
        if(member.getGrade() == Grade.VIP){
            return discountFixAmounts;
        }
        else{
            return 0;
        }
    }
}
