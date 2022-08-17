package web.webproject.webproject20220804.service.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.webproject.webproject20220804.domain.Board;
import web.webproject.webproject20220804.domain.account.Member;
import web.webproject.webproject20220804.repository.account.MemberRepository;


import java.util.List;
//게시판 : 사용자 관점, 시스템관점관리(회원관리, 게시판 관리, 컨텐츠 관리) [웹솔루션을 관리하는 오너]
//getAccountList: 전체 회원 목록 보기 : 웹솔루션에서 웹시스템을 관리하는 관리자 기능
@Service
public class memberServiceimpl implements MemberService {
    @Autowired
    private MemberRepository memberRepo;




    @Override
    public List<Member> getMemberWhereEmail(String Email) {
        return getMemberWhereEmail(Email);
    }

    @Override
    public List<Member> getMemberList(Member member) {
        List<Member> memberList =  memberRepo.findAll();

        for(int i =0; i<memberList.size(); i++){
            StringBuilder stb = new StringBuilder();
            for(int j =0; j < memberList.get(i).getEmail().length(); j++){
                String a = memberList.get(i).getEmail();
                if( j > 2){
                    stb.append("*");
                }
                else {
                    stb.append(a.charAt(j));
                }
            }
            memberList.get(i).setEmail(String.valueOf(stb));
        }
        return memberList;
    }

    @Override
    public void insertMember(Member member) {
        memberRepo.save(member);
    }
    @Override
    public Member getMember(Member member) {
        Member findMember = memberRepo.findById(member.getSeq()).get();
        return memberRepo.findById(member.getSeq()).get();
    }

    @Override
    public void updateMember(Member member) {
        Member findMember = memberRepo.findById(member.getSeq()).get();
        findMember.setId(member.getId());
        findMember.setPassword(member.getPassword());
        findMember.setEmail(member.getEmail());
        findMember.setAddress(member.getAddress());
        memberRepo.save(findMember);
    }

    @Override
    public void deleteMember(Member member) {
        memberRepo.deleteById(member.getSeq());
    }
}
