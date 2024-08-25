package purejava.buildnameishere.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import purejava.buildnameishere.AppConfig;

public class ApplicatioinContextInfoTest {
    // 스프링 컨테이너
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("스프링 컨테이너의 모든 이름, 빈 출력")
     void findAllBean() {
        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            //해당 이름의 빈객체를 리턴
            Object bean = context.getBean(beanDefinitionName);
            System.out.println("beanDefinitionName: " + beanDefinitionName + " bean = " + bean);
        }
    }
}
