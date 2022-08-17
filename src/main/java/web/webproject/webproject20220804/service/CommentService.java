package web.webproject.webproject20220804.service;



import web.webproject.webproject20220804.domain.Comment1;

import java.util.List;

public interface CommentService {
    List<Comment1> getComment1List(Comment1 comment);

    void insertComment1(Comment1 comment);

    void updateComment1(Comment1 comment);

    void deleteComment1(Comment1 comment);
}
