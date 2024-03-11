package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.beanfind.ApplicationContextExtendsFindTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService",StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService",StatefulService.class);

//        //Thread A사용자 10000원 주문
//        statefulService1.order("userA",10000);
//        //Thread B사용자 20000원 주문(A의 주문과 조회 사이에 B 주문이 낀 상황)
//        statefulService2.order("userB",20000);

        //해결
        int userAPrice = statefulService1.order("userA",10000);
        int userBPrice = statefulService1.order("userA",20000);


//        int price = statefulService1.getPrice();
        System.out.println("price = " + userAPrice);
//        Assertions.assertThat(statefulService1.getPrice()).isNotSameAs(statefulService2.getPrice());
    }

    static class TestConfig{
        @Bean
        public StatefulService statefulService(){
            return new StatefulService();
        }
    }
}
