package codesquad.popcafe.api;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import codesquad.popcafe.domain.Article;
import codesquad.popcafe.domain.Comment;
import codesquad.popcafe.dto.ArticleDto;
import codesquad.popcafe.service.ArticleService;
import codesquad.popcafe.service.CommentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/popcafe")
@AllArgsConstructor
@RestController
public class ArticleController {

	private final ArticleService articleService;
	private final CommentService commentService;

	@GetMapping("/")
	public ResponseEntity<List<Article>> showArticleList() {
		List<Article> articleList = articleService.findAllArticle();
		return ResponseEntity.ok(articleList);
	}

	@GetMapping("/articles/{id}")
	public ResponseEntity<ArticleDto.ArticleDetail> showDetail(
		@RequestParam("id") int id) {
		Article article = articleService.findOneArticle(id)
			.orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
		List<Comment> comments = commentService.getCommentList(article);
		ArticleDto.ArticleDetail detail = new ArticleDto.ArticleDetail(article.getId(), comments);
		return ResponseEntity.ok(detail);
	}

	@PostMapping("/articles")
	public ResponseEntity<Article> createArticle(
		@RequestParam("title") String title,
		@RequestParam("content") String content) {
		Article created = articleService.createArticle(title, content);
		articleService.save(created);
		return ResponseEntity.ok(created);
	}

	@PostMapping("/articles/{id}/comment")
	public ResponseEntity<Comment> createComment(@RequestParam("id") int id, @RequestBody ArticleDto.CommentCreateRequest request) {
		Article currentArticle = articleService.findOneArticle(id)
			.orElseThrow(() -> )
	}
}


