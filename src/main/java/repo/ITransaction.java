package repo;

import domain.Account;

public interface ITransaction {
	
	 String addAccount(String account);
	
	 String getAllAccounts();
	
	 String updateAccount(Long id, String accountToUpdate);
	
	 String deleteAccount(Long id);
	 
	 Account findAccount(Long id);
}
