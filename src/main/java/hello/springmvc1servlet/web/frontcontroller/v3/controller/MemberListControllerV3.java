package hello.springmvc1servlet.web.frontcontroller.v3.controller;

import hello.springmvc1servlet.domain.member.Member;
import hello.springmvc1servlet.domain.member.MemberRepository;
import hello.springmvc1servlet.web.frontcontroller.ModelView;
import hello.springmvc1servlet.web.frontcontroller.v3.ControllerV3;

import java.util.List;
import java.util.Map;

public class MemberListControllerV3 implements ControllerV3 {
    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        // 외원 조회
        List<Member> members = memberRepository.findAll();
        // 뷰에 모델에 멤버 리스트 저장
        ModelView mv = new ModelView("members");
        mv.getModel().put("members", members);
        return mv;
    }
}
