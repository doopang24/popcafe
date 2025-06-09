package codesquad.popcafe.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import codesquad.popcafe.domain.Member;
import codesquad.popcafe.dto.MemberDto;
import codesquad.popcafe.repository.MemberRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class MemberService {

	private final MemberRepository memberRepository;

	public int save(Member member) {
		memberRepository.save(member);
		return member.getId();
	}

	public Member createMember(MemberDto.createMemberRequest request) {
		return new Member(request.userId(), request.password());
	}

	public Optional<Member> findOneMember(String userId) {
		return memberRepository.findByUserId(userId);
	}

	public List<Member> findAllMember() {
		return memberRepository.findAll();
	}

	public void deletedMember(int id) {
		memberRepository.deleteById(id);
	}
}
