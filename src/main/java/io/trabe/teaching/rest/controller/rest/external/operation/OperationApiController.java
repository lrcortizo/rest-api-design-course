package io.trabe.teaching.rest.controller.rest.external.operation;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.trabe.teaching.rest.controller.mapper.ExternalApiMapper;
import io.trabe.teaching.rest.model.pojo.api.external.ApiOperation;
import io.trabe.teaching.rest.model.pojo.api.external.ApiOperationCreationRequest;
import io.trabe.teaching.rest.model.service.AccountService;

@RestController
@RequestMapping("/api/public/1/")
public class OperationApiController {

	private final AccountService accountService;
	private final ExternalApiMapper externalApiMapper;

	public OperationApiController(AccountService accountService, ExternalApiMapper externalApiMapper) {
		super();
		this.accountService = accountService;
		this.externalApiMapper = externalApiMapper;
	}

	@GetMapping(value = "/users/{userId}/accounts/{accountId}/operations")
	public List<ApiOperation> getOperations(@PathVariable long accountId,
			@RequestParam(required = false, value="paymentMethod") String paymentMethod) {
		return externalApiMapper.toOperationApiList(accountService.getAccountOperations(accountId));
	}

	@PostMapping("/users/{userId}/accounts/{accountId}/operations")
	public ApiOperation createOperation(@PathVariable long accountId,
			@RequestBody ApiOperationCreationRequest operationRequest) {
		return externalApiMapper.toOperationApi(accountService.createOperation(accountId,
				operationRequest.getDescription(), operationRequest.getAmount(), operationRequest.getPaymentMethod()));
	}
}
