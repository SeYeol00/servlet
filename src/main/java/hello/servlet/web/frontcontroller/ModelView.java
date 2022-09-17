package hello.servlet.web.frontcontroller;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ModelView {
    private String viewName;// 뷰 파일 이름
    private Map<String, Object> model = new HashMap<>();
    //모든 데이터를 담기 때문에 가장 데이터 타입 범위가 넒은 오브젝트로 지정해줬다.


    public ModelView(String viewName) {
        this.viewName = viewName;
    }
}
