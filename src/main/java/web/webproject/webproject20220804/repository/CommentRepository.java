package web.webproject.webproject20220804.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import web.webproject.webproject20220804.domain.Comment1;

@Repository
public interface CommentRepository extends CrudRepository<Comment1, Long> {
}
