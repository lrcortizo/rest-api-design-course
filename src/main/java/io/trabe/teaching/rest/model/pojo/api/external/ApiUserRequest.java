package io.trabe.teaching.rest.model.pojo.api.external;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ApiUserRequest {
	private String login;
}
