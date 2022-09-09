package hello.springmvc1servlet.web.frontcontroller.v3.controller;

import hello.springmvc1servlet.domain.member.Member;
import hello.springmvc1servlet.domain.member.MemberRepository;
import hello.springmvc1servlet.web.frontcontroller.ModelView;
import hello.springmvc1servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberSaveControllerV3 implements ControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    public ModelView process(Map<String, String> paramMap) {
        // 요청데이터 조회
        String username = paramMap.get("username");
        int age = Integer.parseInt(paramMap.get("age"));
        // 멤버 객체 생성 및 저장
        Member member = new Member(username, age);
        memberRepository.save(member);
        // 뷰 안의 모델 객체에 데이터 저장
        ModelView mv = new ModelView("save-result");
        mv.getModel().put("member", member);
        return mv;
    }
}
