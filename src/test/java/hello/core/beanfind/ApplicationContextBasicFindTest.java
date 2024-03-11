package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac =new AnnotationConfigApplicationContext(AppConfig.class);
    
    @Test
    @DisplayName("빈 이름으로 조회")
    void findBindByName(){
        MemberService memberService = ac.getBean("memberService",MemberService.class);
        System.out.println("memberService = "+memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());
    }
    @Test
    @DisplayName("이름 없이 타입만으로 조회")
    void findBeanByType(){
        MemberService memberService=ac.getBean(MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("구체 타입으로 조회")
    void findByName2(){
        MemberServiceImpl memberServiceImpl = ac.getBean(MemberServiceImpl.class);
        Assertions.assertThat(memberServiceImpl).isInstanceOf(MemberServiceImpl.class);
    }
    @Test
    @DisplayName("빈 이름으로 조회 안 되는")
    void findBeanNameX(){
//        org.junit.jupiter.api.Assertions.assertThrows(NoSuchBeanDefinitionException.class,
//                ()->ac.getBean(MemberService.class));
    }
}
