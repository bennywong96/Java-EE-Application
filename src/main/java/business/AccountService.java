package business;

import javax.inject.Inject;

import constants.Constants;
import domain.Account;
import repo.ITransaction;

public class AccountService  {
	
	
	@Inject
	private ITransaction repo;
	
	@Inject
	private IAccountChecker accountChecker;
	
	
	public String getAllAccounts() {
		return repo.getAllAccounts();
	}
	
	
	public Account findAccount(Long id) {
		return repo.findAccount(id);
	}

	
	public String addAccount(String account) {
		if(!accountChecker.checkAccountNumber(account)) {
			return Constants.BANNED_ACCOUNT_MESSAGE;
		} else {
			return repo.addAccount(account);
		}
	}

	
	public String updateAccount(Long id, String accountToUpdate) {
		if(!accountChecker.checkAccountNumber(accountToUpdate)) {
			return Constants.BANNED_ACCOUNT_MESSAGE;
		} else {
			return repo.updateAccount(id, accountToUpdate);
		}
	}

	
	public String deleteAccount(Long id) {
		return repo.deleteAccount(id);
	}


	
	
	

}
