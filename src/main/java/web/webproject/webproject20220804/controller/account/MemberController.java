package web.webproject.webproject20220804.controller.account;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.webproject.webproject20220804.domain.account.Member;
import web.webproject.webproject20220804.service.account.MemberService;


import java.util.Date;
import java.util.List;
@RequestMapping(path = "/account")

@Controller
public class MemberController {

    @Autowired
    private final MemberService memberService;


    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
    //modal: 컨트롤러에서 작업한 결과물을 HTML에 전달하기 위한 메개체
    //addAttribute: key/value으로 데이터를 저장하는 메서드
    //attributeName(key): enldp 뒤에있는 value를 호풀하기 위한 문자열(key)
    //memberService.getMemberList() :@ Autowired로 선언된 MemberService 클래스를 호출하여
    //getMemberList() 메서드 실행
    //Member 라는 매개변수로 controller에전달
    //Member 라는 (Entity)이고 DTO(data Transfer object)
    //어디선가 받거나 만든 데이터를 객체로 만드는것
    @GetMapping("/getMemberList")
    public String getMemberList(Member member, Model model) {
        List<Member> memberList = memberService.getMemberList(member);

        model.addAttribute("memberList", memberList);
        return "account/getMemberList";

    }

    @GetMapping("/getMember")
    public String getMember(Model model, Member member) {
        model.addAttribute("member", memberService.getMember(member));
        return "account/getMember";
    }
    //회원정보 삭제
    //회원정보 수정
    //회원정보 1개의 테이블에서 관리 XX > 1년지난 회원은 로그린을 안한 장기 휴식회원

    @GetMapping("/insertAccount")
    public String insertMember() {
        return "account/insertAccount";
    }


    @PostMapping("/insertAccount")
    public String insertAccount(Member member) {
        System.out.println("--------chcek-------");
        member.setCreateDate(new Date());
        member.setUpdateDate(new Date());
        memberService.insertMember(member);
        return "redirect:getMemberList";
    }

    @PostMapping("/updateAccount")
    public String updateAccount(Member member) {
        memberService.updateMember(member);
        return "redirect:getMemberList";
    }

    @GetMapping("/deleteAccount")
    public String deleteAccount(Member member) {
        memberService.deleteMember(member);
        return "forward:account/getMemberList";
    }
    @GetMapping("/selectAccount")
    public String selectAccount() {
        return "account/selectAccount";
    }

    @PostMapping("/selectAccount")
    public String resultAccount(Member member, Model model) {
        model.addAttribute("memberList", memberService.getMemberWhereEmail(member.getEmail()));
        return "account/resultAccount";
    }


}



