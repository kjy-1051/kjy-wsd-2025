package kr.ac.jbnu.kjy.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

// 미들웨어, 요청 로그 출력
@Component // 스프링이 이 클래스를 자동으로 Bean으로 등록하게 함
public class LoggingInterceptor implements HandlerInterceptor {

    /*
     preHandle
     컨트롤러 메소드 실행 전에 호출됨
     true: 요청이 계속 진행(컨트롤러로 넘어감)
     false: 요청을 여기서 막음(권한 체크 등에 사용됨)
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) {

        // 요청 URL과 메소드 로그 출력
        System.out.println("[REQ] "
                + request.getMethod()
                + " "
                + request.getRequestURI());

        return true;
    }
}
