package codesquad.popcafe.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "articles")
public class Article {

	protected Article() {}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String title;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member writer;

	private String content;

	@OneToMany(mappedBy = "article", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Comment> comments;

	@Builder
	public Article(String title, String content) {
		this.title = title;
		// this.writer = member;
		this.content = content;
	}
}
