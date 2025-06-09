package codesquad.popcafe.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name = "members")
public class Member {

	protected Member() {}

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String userId;

	private String password;

	public Member(String userId, String password) {
		this.userId = userId;
		this.password = password;
	}
}
