package purejava.buildnameishere.beanfind;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import purejava.buildnameishere.AppConfig;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        List<Integer> list = Arrays.asList(1, 2, 34, 7, 2);

        list.sort((a,b)->a-b);

        System.out.println("list: " + list);
    }
}
