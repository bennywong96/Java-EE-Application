package repo;



public interface ITransaction {
	
	 String addAccount(String account);
	
	 String getAllAccounts();
	
	 String updateAccount(Long id, String accountToUpdate);
	
	 String deleteAccount(Long id);
}
