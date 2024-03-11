package hello.core;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //ApplicationContext는 스프링컨테이너 최상위 인터페이스로 다양한 구현체 가짐
        //AnnotationConfigApplicationContext는 @Configuration 어노테이션을 사용하여 자바 기반의 설정 클래스를 통해 빈을 등록해주는 스프링 컨테이너
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);

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
