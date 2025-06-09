package codesquad.popcafe.dto;

import java.util.List;

import codesquad.popcafe.domain.Comment;
import codesquad.popcafe.domain.Member;
import lombok.Builder;

public class ArticleDto {

	public record ArticleListItem(
		int id,
		String title,
		String writer,
		String content
	) {
	}

	public record ArticleList(
		int totalCount,
		List<ArticleListItem> articles
	) {
	}

	@Builder
	public record ArticleDetail(
		int id,
		List<Comment> articleWithComments
	) {
		public ArticleDetail(int id, List<Comment> articleWithComments) {
			this.id = id;
			this.articleWithComments = articleWithComments;
		}

	}

	public record CommentCreateRequest(
		int memberId,
		String content
	) {
	}
}
