package web.webproject.webproject20220804.service.account;

import web.webproject.webproject20220804.domain.account.Member;

import java.util.List;


public interface MemberService {
    List<Member> getMemberWhereEmail(String Email);
    List<Member> getMemberList(Member member);


    void insertMember(Member member);
    Member getMember(Member member);
    void updateMember(Member member);
    void deleteMember(Member member);

}
