package kr.ac.jbnu.kjy.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 WebConfig
 Interceptor를 실제로 "등록"하는 설정 클래스
 그냥 Interceptor만 만들어두면 아무도 안 불러서 동작 안 함 => addInterceptors()로 스프링에 등록해야 함
 */

@Configuration // 설정 클래스임을 스프링에 알림
public class WebConfig implements WebMvcConfigurer {

    // 스프링이 LoggingInterceptor Bean을 주입해줌
    @Autowired
    private LoggingInterceptor loggingInterceptor;

    //addInterceptors: 어떤 Interceptor를 어떤 경로에 적용할지 지정함
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(loggingInterceptor)
                .addPathPatterns("/**");
        // "/**" : 모든 경로에 인터셉터 적용, 어떤 API를 호출해도 [REQ] 로그가 찍힘
    }
}
