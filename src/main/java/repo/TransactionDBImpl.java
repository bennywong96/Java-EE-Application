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

import domain.Account;
import util.JSONUtil;

@Default
@Transactional(TxType.SUPPORTS)
public class TransactionDBImpl implements ITransaction {
	
	@PersistenceContext(unitName = "primary")
	
	@Inject
	private JSONUtil util;
	
	private EntityManager manager;

	@Transactional(TxType.REQUIRED)
    public String addAccount(String account) {
		Account newAccount = util.getObjectForJSON(account, Account.class);
        manager.persist(newAccount);
        return "Added " + newAccount;
    }
	
	@Transactional(TxType.REQUIRED)
    public String getAllAccount() {
    	TypedQuery<Account> query = 
    			manager.createQuery("Select a FROM Account a",Account.class);
		
        return query.getResultList().toString();
    }
	
	@Transactional(TxType.REQUIRED)
	public List<Account> getAllAccounts() {
        TypedQuery<Account> query = 
        		manager.createQuery("SELECT a FROM Account a ORDER BY a.id DESC", Account.class);
        return query.getResultList();
    }
	
	@Transactional(TxType.REQUIRED)
	public String deleteAccount(Long id ) {
		
		manager.createQuery("DELETE a FROM Account a WHERE a.id = " + id, Account.class);
		 return "Deleted";
	}
	
	@Transactional(TxType.REQUIRED)
	public String updateAccount(Long id, String account) {		
		Account updatedAccount = util.getObjectForJSON(account, Account.class);
		Account accountFromDB = manager.find(Account.class, id);
		if (accountFromDB != null) {
			accountFromDB = updatedAccount;
			manager.merge(updatedAccount);
		}
		return "Account Updated";
		
	}
	
	@Transactional(TxType.REQUIRED)
	public Account searchByFirstName(String name) {
			return manager.find(Account.class, name);
		 }
	
	

	
//	public String deleteAccount(Account account) {
//		String accName = account.getAccountNumber();
//		manager.remove(account);
//		return accName + "has been deleted";
//	}




}
