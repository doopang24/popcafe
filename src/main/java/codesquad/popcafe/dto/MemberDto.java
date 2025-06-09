package codesquad.popcafe.dto;

public class MemberDto {

	public record createMemberRequest(
		String userId,
		String password
	) {
	}

	public record loginRequest(
		String userId,
		String password
	) {
	}
}
