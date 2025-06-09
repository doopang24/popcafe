package codesquad.popcafe.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import codesquad.popcafe.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {

	Optional<Member> findByUserId(String userId);
}
