package repo;

import domain.Account;

public interface ITransaction {
	
	public String addAccount(String account);
	
	public String getAllAccount();
	
	String updateAccount(Long id, String accountToUpdate);
	
	public String deleteAccount(Long id);
}
