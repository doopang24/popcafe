package codesquad.popcafe.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import codesquad.popcafe.domain.Member;
import codesquad.popcafe.dto.MemberDto;
import codesquad.popcafe.service.MemberService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequestMapping("/popcafe")
@AllArgsConstructor
@RestController
public class MemberController {

	private final MemberService memberService;

	@GetMapping("/members")
	public ResponseEntity<List<String>> showMemberList() {
		List<Member> memberList = memberService.findAllMember();
		List<String> memberIdList = new ArrayList<>();
		for (Member member : memberList) {
			memberIdList.add(member.getUserId());
		}
		return ResponseEntity.ok(memberIdList);
	}

	@PostMapping("/members")
	public ResponseEntity<String> join(@RequestBody MemberDto.createMemberRequest request) {
		Member created = memberService.createMember(request);
		memberService.save(created);
		return ResponseEntity.ok(created.getUserId());
	}

	@PostMapping("/members/login")
	public ResponseEntity<String> login(@RequestBody MemberDto.loginRequest request,
		HttpSession session) {
		Optional<Member> member = memberService.findOneMember(request.userId());
		if (member.isPresent() && member.get().getPassword().equals(request.password())) {
			session.setAttribute(request.userId(), member);
			return ResponseEntity.ok(request.userId());
		}
		return ResponseEntity.ok("로그인에 실패하였습니다.");
	}

	@PostMapping("/members/logout")
	public ResponseEntity<String> logout(HttpSession session) {
		session.invalidate();
		return ResponseEntity.ok("로그아웃에 성공했습니다.");
	}
}
