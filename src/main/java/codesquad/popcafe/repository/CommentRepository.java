package codesquad.popcafe.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import codesquad.popcafe.domain.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
	List<Comment> findByArticleId(Integer id);
}
