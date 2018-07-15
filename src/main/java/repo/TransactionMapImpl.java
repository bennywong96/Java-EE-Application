package repo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import javax.persistence.PersistenceContext;

import domain.Account;
import util.JSONUtil;

@Alternative
@ApplicationScoped
public class TransactionMapImpl implements ITransaction {
	
	private Map <Long, Account> accountMap = new HashMap<Long, Account>();
	
	@Inject
	private JSONUtil util;
	
//	private Long LONG_INT = 1L;
//	private Long ID;
	
	@Override
    public String addAccount(String account) {
		Account newAccount = util.getObjectForJSON(account, Account.class);
		accountMap.put(newAccount.getID(), newAccount);
		return "Account Added";
        
    }
	
	@Override
    public String getAllAccounts() {
       return util.getJSONForObject(accountMap.values());
       
    }
        
	
//	@Override
//	public List<Account> getAllAccounts() {
//       List<Account> list;
//       if (accountMap.values() instanceof List) {
//    	   list = (List<Account>)accountMap.values();
//       }
//       else {
//    	   list = new ArrayList<Account>(accountMap.values());
//       }
//       return list;
//    }
	
	@Override
	public String deleteAccount(Long id) {
		if (accountMap.containsKey(id)) {
			accountMap.remove(id);
			
			return "Deleted Account with ID: " + id;
		}
		else {
		return "Account doesn't exist";
		}
	}
	
	@Override
	public String updateAccount(Long id, String account) {
		Account updatedAcc = util.getObjectForJSON(account, Account.class);
		accountMap.put(id, updatedAcc);
		return "Account Updated - " + updatedAcc;
	}
	
	public Account searchByFirstName(String name) {
			return accountMap.get(name);
			
		 }

	


}
