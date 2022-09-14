package hello.servlet.basic.request;

import org.springframework.util.StreamUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();//바디의 바이트 코드를 들고 온다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        //스트림유틸이라고 스프링에서 제공해주는 클래스가 있다. 여기서 메서드를 통해서 변환
        // 캐릭터셋을 지정해주어야한다.
        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("ok");
    }
}
