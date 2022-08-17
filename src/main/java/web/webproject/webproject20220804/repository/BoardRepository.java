package web.webproject.webproject20220804.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.webproject.webproject20220804.domain.Board;
@Repository
//CrudRepository를 상속 받음
//CrudRepository: create read update delete 기능을 하는인터페이스
//CrudRepository<Board, Long>의 매개변수 Board(Entity)와 Long(Pk)을 선언
//JPA가 어떤 객체로 어떤 타입으로 찾아야 하는지를
public interface BoardRepository extends JpaRepository<Board, Long> {
    @Modifying
    @Query("update Board p set p.cnt = p.cnt + 1 where p.seq = :seq")
    int updateCount(Long seq);

}
