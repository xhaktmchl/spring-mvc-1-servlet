package hello.springmvc1servlet.web.springmvc.v1;

import hello.springmvc1servlet.domain.member.Member;
import hello.springmvc1servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SpringMemberSaveControllerV1 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/springmvc/v1/members/save")
    public ModelAndView process(HttpServletRequest request, HttpServletResponse response){
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        // 멤버 생성 및 저장
        Member member = new Member(username, age);
        System.out.println("member = " + member);
        memberRepository.save(member);

        // ModelAndView  객체에 모델과 뷰 정보 담아서 반환
        ModelAndView mv = new ModelAndView("save-result");
        mv.addObject("member", member); // Model 데이터 추가
        return mv;
    }
}
