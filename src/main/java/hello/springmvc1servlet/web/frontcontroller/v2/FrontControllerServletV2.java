package hello.springmvc1servlet.web.frontcontroller.v2;

import hello.springmvc1servlet.web.frontcontroller.MyView;
import hello.springmvc1servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.springmvc1servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.springmvc1servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV2", urlPatterns = "/front-controller/v2/*")
public class FrontControllerServletV2 extends HttpServlet {

    private Map<String, ControllerV2> controllerMap = new HashMap<>();

    // url 정보 저장
    public FrontControllerServletV2() {
        controllerMap.put("/front-controller/v2/members/new-form", new MemberFormControllerV2());
        controllerMap.put("/front-controller/v2/members/save", new MemberSaveControllerV2());
        controllerMap.put("/front-controller/v2/members", new MemberListControllerV2());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String requestURI = request.getRequestURI(); // url 정보 조회

        // url 매칭되는 컨트롤ㄹ러 조회
        ControllerV2 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        // MyView로 반환
        MyView view = controller.process(request, response);
        //jsp 호출
        view.render(request, response);
    }
}
