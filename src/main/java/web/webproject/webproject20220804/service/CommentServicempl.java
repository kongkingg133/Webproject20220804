package web.webproject.webproject20220804.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import web.webproject.webproject20220804.domain.Comment1;

import web.webproject.webproject20220804.repository.CommentRepository;

import java.util.List;

@Service
public class CommentServicempl implements CommentService {
    @Autowired (required = false)
    private CommentRepository comRepo;

    @Override
    public List<Comment1> getComment1List(Comment1 comment) {
        return (List<Comment1>) comRepo.findAll();
    }

    @Override
    public void insertComment1(Comment1 comment) {

        comRepo.save(comment);
    }

    @Override
    public void updateComment1(Comment1 comment) {
        Comment1 findComment1 = comRepo.findById(comment.getC_seq()).get();
        findComment1.setC_writer(comment.getC_writer());
        findComment1.setComment1(comment.getComment1());
        comRepo.save(findComment1);
    }

    @Override
    public void deleteComment1(Comment1 comment) {

        comRepo.deleteById(comment.getC_seq());
    }
}
