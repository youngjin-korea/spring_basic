package purejava.buildnameishere.beanfind;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import purejava.buildnameishere.member.MemberRepository;
import purejava.buildnameishere.member.MemoryMemberRepository;

import java.util.Map;

public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameBeanConfig.class);

    @Test
    @DisplayName("타입으로 조회시 중복타입이 둘 이상 존재하면 오류가 발생")
    void findBeanByTypeDuplicate() {
        Assertions.assertThrows(NoUniqueBeanDefinitionException.class, () -> {
            ac.getBean(MemberRepository.class);
        });
    }

    @Test
    @DisplayName("같은 타입의 빈이 두개면 이름을 추가해준다.")
    void findBeanByTypeAndName() {
        MemberRepository repo = ac.getBean("memberRepository1", MemberRepository.class);
        org.assertj.core.api.Assertions.assertThat(repo).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("같은 타입의 빈 모두 출력")
    void findSameTypeBeansByType() {
        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for(String keyName : beansOfType.keySet()){
            System.out.println("keyName = " + keyName + "value: " + beansOfType.get(keyName));
        }
        System.out.println("beansOfType = " + beansOfType);
    }

    @Configuration
    static class SameBeanConfig {
        @Bean
        public MemberRepository memberRepository1() {
            return new MemoryMemberRepository();
        }

        @Bean
        public MemberRepository memberRepository2() {
            return new MemoryMemberRepository();
        }
    }
}
