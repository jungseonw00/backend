package com.tobe.healthy.member.domain.dto.in;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "비밀번호 찾기 DTO")
public class MemberFindPWCommand {
	@Schema(description = "아이디" , example = "to-be-healthy")
	@NotEmpty(message = "아이디를 입력해 주세요.")
	private String userId;

	@Schema(description = "실명" , example = "홍길동")
	@NotEmpty(message = "실명을 입력해 주세요.")
	private String name;
}
