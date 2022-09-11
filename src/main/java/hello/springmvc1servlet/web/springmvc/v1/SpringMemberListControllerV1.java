package hello.springmvc1servlet.web.springmvc.v1;

import hello.springmvc1servlet.domain.member.Member;
import hello.springmvc1servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class SpringMemberListControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("springmvc/v1/members")
    public ModelAndView process(){

        List<Member> members = memberRepository.findAll();

        // ModelAndView 객체에 모델과 뷰 정보 담아서 반환
        ModelAndView mv = new ModelAndView("members"); // 모델 뷰 객체 생성, 뷰 이름 저장
        mv.addObject("members", members); // Model 정보 저장
        return mv;
    }
}
