package codesquad.popcafe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import codesquad.popcafe.domain.Article;
import codesquad.popcafe.repository.ArticleRepository;
import codesquad.popcafe.repository.CommentRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ArticleService {

	private final ArticleRepository articleRepository;
	private final CommentRepository commentRepository;

	public int save(Article article) {
		articleRepository.save(article);
		return article.getId();
	}

	public Article createArticle(String title, String content) {
		return new Article(title, content);
	}

	public Optional<Article> findOneArticle(int id) {
		return articleRepository.findById(id);
	}

	public List<Article> findAllArticle() {
		return articleRepository.findAll();
	}

	public void deleteArticle(int id) {
		articleRepository.deleteById(id);
	}
}
