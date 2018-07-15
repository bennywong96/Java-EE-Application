package business;

import javax.inject.Inject;

import domain.Account;
import util.JSONUtil;

public class AccountChecker implements IAccountChecker {

@Inject
private JSONUtil util;

	public boolean checkAccountNumber(String account) {
		return util.getObjectForJSON(account, Account.class).getAccountNumber().equals("999999")? false:true;
	}
	
}
