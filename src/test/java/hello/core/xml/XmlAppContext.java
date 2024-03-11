package hello.core.xml;

import hello.core.AppConfig;
import hello.core.MemberApp;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class XmlAppContext {
    @Test
    void xmlAppContext(){
        ApplicationContext ac  =new GenericXmlApplicationContext("AppConfig.xml");
        MemberService memberService =ac.getBean("memberService", MemberService.class);
        Assertions.assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
