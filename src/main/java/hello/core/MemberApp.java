package hello.core;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();//appconfig를 통해 동작
        //수정 전 MemberService memberService = new MemberServiceImpl();
        //cmd option v
        Member member = new Member(1L, "memberA", Grade.VIP);
        //id,name 설정, 등급은 vip로
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        //가입멤과 find멤과 같은지
        System.out.println("member = "+member.getName());
        System.out.println("findmember = "+findMember.getName());
    }
}
