package purejava.buildnameishere.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import purejava.buildnameishere.discount.DiscountPolicy;
import purejava.buildnameishere.discount.FixDiscountPolicy;
import purejava.buildnameishere.discount.RateDiscountPolicy;

import java.util.Map;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextExtendsFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(Config.class);

    @Test
    @DisplayName("부모타입으로 모두 조회하기")
    void findBeanBySubType(){
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("부모타입으로 조회 자식이 둘 이상 있으면 중복 오류가 발생")
    void findBeanByParentTypeDuplicate() {
        assertThrows(NoUniqueBeanDefinitionException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ac.getBean(DiscountPolicy.class);
            }
        });
    }

    @Test
    @DisplayName("부모타입으로 조회시 자식이 둘 이상이면 빈 이름을 지정하면 된다.")
    void findBeanByParentTypeWithName(){
        DiscountPolicy discountPolicy = ac.getBean("discountPolicy", DiscountPolicy.class);
        assertThat(discountPolicy).isInstanceOf(RateDiscountPolicy.class);
        DiscountPolicy discountPolicy1 = ac.getBean("discountPolicy2", DiscountPolicy.class);
        assertThat(discountPolicy1).isInstanceOf(FixDiscountPolicy.class);
    }


    @Configuration
    static class Config {
        @Bean
        public DiscountPolicy discountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy discountPolicy2() {
            return new FixDiscountPolicy();
        }
    }
}
