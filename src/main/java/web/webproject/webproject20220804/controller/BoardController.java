package web.webproject.webproject20220804.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import web.webproject.webproject20220804.domain.Board;
import web.webproject.webproject20220804.domain.Comment1;
import web.webproject.webproject20220804.service.BoardService;
import web.webproject.webproject20220804.service.CommentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;
    @Autowired
    private CommentService commentService;
    //@Request Mapping 의 기능을 모두 쓸 수 있다
    //자식클래스 어노테이션이 아닌 부코클래스 어노테이션을 쓰는 이유는 기능의 한정을 통해서


    //redirect 페이지 전환 이동 ,
    @RequestMapping("/getBoardList")
    public String getBoardList(Model model, Board board) {
        List<Board> boardList = boardService.getBoardList(board);
        model.addAttribute("boardList", boardList);
        return "getBoardList";
    }

    @GetMapping("/insertBoard")
    public String insertBoardView() {
        return "insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(Board board) {
        System.out.println("--------chcek-------");
        boardService.insertBoard(board);
        return "redirect:getBoardList";
    }

    @GetMapping("/getBoard")
    public String getBoard(Board board, Comment1 comment, Model model) {
        model.addAttribute("board", boardService.getBoard(board));
        model.addAttribute("comment", commentService.getComment1List(comment));
        List<Comment1> commentList = commentService.getComment1List(comment);
        model.addAttribute("commentList", commentList);

        return "getBoard";
    }

    @PostMapping("/updateBoard")
    public String updateBoard(Board board) {
        boardService.updateBoard(board);
        return "forward:getBoardList";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(Board board) {
        boardService.deleteBoard(board);
        return "forward:getBoardList";
    }

    //댓글


    @PostMapping("/insertComment")
    public String insertComment(Comment1 comment, HttpServletRequest request) {
        System.out.println("--------chcek-------");
        String referer = request.getHeader("referer");
        commentService.insertComment1(comment);
        return "redirect:" + referer;
    }

    @GetMapping("/deleteComment")
    public String deleteComment(Comment1 comment) {
        commentService.deleteComment1(comment);
        return "forward:getBoardList";
    }
    @PostMapping("/updateComment")
    public String updateComment(Comment1 comment1) {
        commentService.updateComment1(comment1);
        return "forward:getBoardList";
    }
}

