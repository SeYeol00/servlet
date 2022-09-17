package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;

import java.util.Map;

public interface ControllerV3 {

    //서블릿에 종속이 되지 않는다.
    ModelView process(Map<String,String> paramMap);
}
