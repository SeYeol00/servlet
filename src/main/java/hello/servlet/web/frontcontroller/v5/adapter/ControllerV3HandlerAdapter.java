package hello.servlet.web.frontcontroller.v5.adapter;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;
import hello.servlet.web.frontcontroller.v4.ControllerV4;
import hello.servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControllerV3HandlerAdapter implements MyHandlerAdapter {

    @Override
    public boolean supports(Object handler) {
        // 인스턴스오브 -> 불린 값 반환하는 매서드로 이 핸들러가 이거 맞아? 하는 매서드
        return (handler instanceof ControllerV3);
    }

    @Override
    public ModelView handle(HttpServletResponse response, HttpServletRequest request,Object handler) throws ServletException, IOException {
        // 타입 캐스팅
        ControllerV3 controller = (ControllerV3) handler;

        // 프론트 컨트롤러의 역할을 일정 부분 가자욘다. ex) 파람맵 만들기
        Map<String, String> paramMap = createParamMap(request);
        return controller.process(paramMap);
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String,String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName->paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
