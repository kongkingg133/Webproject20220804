package web.webproject.webproject20220804.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import web.webproject.webproject20220804.domain.Board;
import web.webproject.webproject20220804.repository.BoardRepository;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BoardServicempl implements BoardService {
    //JPA가 @Service로 선언된 클래스를 갖고 JDBC에게 기능 적인 구현을 위한 속성
    @Autowired (required = false)
    private BoardRepository boardRepo;

    @Override
    public List<Board> getBoardList(Board board) {
        return (List<Board>) boardRepo.findAll();
    }

    //클라이언트에서 받아온 board객체의 데이터를 boardrepositoty의
// 상속 받은 CrudRepositoty save 메서드를 통해 저장
    @Override
    public void insertBoard(Board board) {
        boardRepo.save(board);
    }

    @Override
    public Board getBoard(Board board) {

        return boardRepo.findById(board.getSeq()).get();
    }

    @Override
    public void updateBoard(Board board) {
        Board findBoard = boardRepo.findById(board.getSeq()).get();
        findBoard.setCategory(board.getCategory());
        findBoard.setTitle(board.getTitle());
        findBoard.setContent(board.getContent());
        boardRepo.save(findBoard);
    }

    @Override
    public void deleteBoard(Board board) {
        boardRepo.deleteById(board.getSeq());
    }

    @Transactional
    public int updateView(Long seq) {
        return boardRepo.updateCount(seq);
    }
}
