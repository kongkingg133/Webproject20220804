package web.webproject.webproject20220804.repository.account;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.webproject.webproject20220804.domain.account.Member;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long > {
  //  List<Member> findByIdOrPassword(String Password);

   // List<Member> findMembersByPasswordOrId (String Password, String Id);
    //Id 값의 일부분만 매개변수를 넣고 , 어이디 생성 날짜가 가장 최신인것
    @Query(value = "select m from Member m where m.email like %?1% ")
    List<Member> findByEmailLike(String email);
    @Query(value = "select m.email FROM Member m " , nativeQuery = true)
    List<Member> SelectByEmail();


}
