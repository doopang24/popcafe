package codesquad.popcafe.service;

import java.util.List;

import org.springframework.stereotype.Service;

import codesquad.popcafe.domain.Article;
import codesquad.popcafe.domain.Comment;
import codesquad.popcafe.repository.CommentRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class CommentService {

	private final CommentRepository commentRepository;

	public List<Comment> getCommentList(Article article) {
		int articleId = article.getId();
		return commentRepository.findByArticleId(articleId);
	}
}
