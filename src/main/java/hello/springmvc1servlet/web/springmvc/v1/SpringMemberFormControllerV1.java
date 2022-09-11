package hello.springmvc1servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
RequstMapping을 이용한 핸들러 매핑 및 핸들러 어댑터 사용 처리.
 */
@Controller// 1.컴포넌트 스캔 대상 지정, 2.RequestMappingHandlerMapping 을 사용할 수 있도록 인식
public class SpringMemberFormControllerV1 {

    @RequestMapping("/springmvc/v1/members/new-form") //요청 정보를 매핑한다
    public ModelAndView process(){
        return new ModelAndView("new-form"); //ModelAndView모델과 뷰 정보를 담아서 반환
    }
}
