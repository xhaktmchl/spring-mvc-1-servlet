package hello.springmvc1servlet.web.frontcontroller.v5.adapter;

import hello.springmvc1servlet.web.frontcontroller.ModelView;
import hello.springmvc1servlet.web.frontcontroller.v4.ControllerV4;
import hello.springmvc1servlet.web.frontcontroller.v5.MyHandlerAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

public class ControllerV4HandlerAdapter implements MyHandlerAdapter {

    // 핸들러가 V4인지 체크
    @Override
    public boolean supports(Object handler) {
        return (handler instanceof ControllerV4);
    }

    @Override
    public ModelView handle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        ControllerV4 controller = (ControllerV4) handler; //handler를 ControllerV4로 케스팅

        Map<String, String> paramMap = createParamMap(request);
        Map<String, Object> model = new HashMap<>();

        String viewName = controller.process(paramMap, model);//, paramMap, model을 만들어서 해당 컨트롤러를 호출

        //어댑터 변환
        ModelView mv = new ModelView(viewName);
        mv.setModel(model); // 모델 세팅

        return mv;
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }
}
