package repo;


import java.util.HashMap;

import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import constants.Constants;
import domain.Account;
import util.JSONUtil;

@ApplicationScoped
@Alternative
public class TransactionMapImpl implements ITransaction {
	
	private Long ID;
	private Map <Long, Account> accountMap;
	
	@Inject
	private JSONUtil util;
	
	public TransactionMapImpl() {
		this.accountMap = new HashMap<Long, Account>();
		ID = 0L;
	}
	
	@Override
    public String addAccount(String account) {
		ID++;
		Account newAccount = util.getObjectForJSON(account, Account.class);
		newAccount.setID(ID);
		accountMap.put(newAccount.getID(), newAccount);
		return Constants.NEW_MESSAGE;
        
    }
	
	public Account findAccount(Long id) {
		return accountMap.get(id);
	 }
	
	@Override
    public String getAllAccounts() {
       return util.getJSONForObject(accountMap.values());
       
    }
        
	
	
	@Override
	public String deleteAccount(Long id) {
		if (accountMap.containsKey(id)) {
			accountMap.remove(id);
			
			return Constants.DELETE_MESSAGE;
		}
		else {
		return Constants.NO_EXIST;
		}
	}
	
	@Override
	public String updateAccount(Long id, String account) {
		Account updatedAcc = util.getObjectForJSON(account, Account.class);
		updatedAcc.setID(id);
		accountMap.put(id, updatedAcc);
		return Constants.UPDATE_MESSAGE;
	}
	


	


}
