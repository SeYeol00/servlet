package hello.servlet;

import hello.servlet.web.springmvc.v1.SpringMemberFormControllerV1;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@ServletComponentScan//자동으로 서블릿을 찾아서 등록해줌, 서블릿 자동 등록
@SpringBootApplication
public class ServletApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServletApplication.class, args);
    }

    //빈 등록
//    @Bean
//    SpringMemberFormControllerV1 springMemberFormControllerV1(){
//        return new SpringMemberFormControllerV1();
//    }
}
