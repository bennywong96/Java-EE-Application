package repo;


import java.util.Collection;
import java.util.List;


import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import constants.Constants;
import domain.Account;
import util.JSONUtil;

@Default
@Transactional(TxType.SUPPORTS)
public class TransactionDBImpl implements ITransaction {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;
	
	@Inject
	private JSONUtil util;
	
	@Override
	@Transactional(TxType.REQUIRED)
    public String addAccount(String account) {
		Account newAccount = util.getObjectForJSON(account, Account.class);
        manager.persist(newAccount);
        return Constants.NEW_MESSAGE;
    }
	
	@Override
	@Transactional(TxType.REQUIRED)
    public String getAllAccounts() {
    	TypedQuery<Account> query = 
    			manager.createQuery("SELECT a FROM Account a",Account.class);
		
        return util.getJSONForObject(query.getResultList());
    }
	

	
	@Override
	@Transactional(TxType.REQUIRED)
	public String deleteAccount(Long id ) {
		Account accountInDB = findAccount(id);
		if (accountInDB != null) {
			manager.remove(accountInDB);
			return Constants.DELETE_MESSAGE;
		}
		else {
			return Constants.NO_EXIST;
		}
		 
	}
	
	@Override
	@Transactional(TxType.REQUIRED)
	public String updateAccount(Long id, String account) {		
		Account updatedAccount = util.getObjectForJSON(account, Account.class);
		Account accountFromDB = findAccount(id);
		if (accountFromDB != null) {
			accountFromDB = updatedAccount;
			accountFromDB.setID(id);
			manager.merge(accountFromDB);
			return Constants.UPDATE_MESSAGE;
		}
		else {
			return Constants.NO_EXIST;
		}
		
	}
	
	@Transactional(TxType.SUPPORTS)
	public Account findAccount(Long id) {
			return manager.find(Account.class, id);
		 }
	
	
	
	

	
//	public String deleteAccount(Account account) {
//		String accName = account.getAccountNumber();
//		manager.remove(account);
//		return accName + "has been deleted";
//	}




}
