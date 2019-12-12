package io.trabe.teaching.rest.controller.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import io.trabe.teaching.rest.model.pojo.api.external.ApiAccount;
import io.trabe.teaching.rest.model.pojo.api.external.ApiOperation;
import io.trabe.teaching.rest.model.pojo.api.external.ApiPaymentMethod;
import io.trabe.teaching.rest.model.pojo.api.external.ApiUser;
import io.trabe.teaching.rest.model.pojo.Account;
import io.trabe.teaching.rest.model.pojo.Operation;
import io.trabe.teaching.rest.model.pojo.PaymentMethod;
import io.trabe.teaching.rest.model.pojo.User;

@Mapper(componentModel = "spring")
public interface ExternalApiMapper {

    ApiAccount toAccountApi(Account account);

    List<ApiAccount> toAccountApiList(List<Account> accounts);
    
    ApiUser toUserApi(User user);
    
    List<ApiUser> toUserApiList(List<User> users);
    
    ApiOperation toOperationApi(Operation operation);

	List<ApiOperation> toOperationApiList(List<Operation> operations);
	
	ApiPaymentMethod toPaymentMethodApi(PaymentMethod paymentMethod);
	
	List<ApiPaymentMethod> toPaymentMethodApiList(List<PaymentMethod> paymentMethods);
}
