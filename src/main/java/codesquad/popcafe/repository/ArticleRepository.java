package codesquad.popcafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import codesquad.popcafe.domain.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
}
