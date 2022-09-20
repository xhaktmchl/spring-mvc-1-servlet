package hello.springmvc1servlet.web.springmvc.v3;

import hello.springmvc1servlet.domain.member.Member;
import hello.springmvc1servlet.domain.member.MemberRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;

@Controller
@RequestMapping("/springmvc/v3/members") // 공통 url 부분 묶음
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @GetMapping("/new-form")
    public String newForm() {
        return "new-form";
    }

/*
    @RequestParam 사용
    스프링은 HTTP 요청 파라미터를 @RequestParam 으로 받을 수 있다.
    @RequestParam("username") 은 request.getParameter("username") 와 같은 코드
 */
    @PostMapping("/save")
    public String save(@RequestParam("username") String username, @RequestParam("age") int age, Model model) {

        // 멤버 객체 생성 및 저장
        Member member = new Member(username, age);
        memberRepository.save(member);
        // ModelAndView에 회원 정보 저장해서 반환
        model.addAttribute("member", member);
        return "save-result";
    }

    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
        return "members";
    }
}
