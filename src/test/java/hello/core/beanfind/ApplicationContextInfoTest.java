package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void showAllBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionNames+"object = "+bean);
        }
    }
    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void showApplicationBean(){
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition =ac.getBeanDefinition(beanDefinitionName);//빈에대한 정보

            if(beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION){//빈 역할과 어플리케이션 빈인지
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionNames+"object = "+bean);
            }
        }
    }
}
