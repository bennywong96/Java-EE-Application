package accountapp;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;


@Transactional(TxType.SUPPORTS)
public class TransactionDBImpl {
	
	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Transactional(TxType.REQUIRED)
    public Account create(Account account) {
        manager.persist(account);
        return account;
    }
	
	@Transactional(TxType.REQUIRED)
    public Account findAccount(Long id) {
        return manager.find(Account.class, id);
    }
	
	@Transactional(TxType.REQUIRED)
	public List<Account> getAllAccounts() {
        TypedQuery<Account> query = manager.createQuery("SELECT * FROM Account a ORDER BY a.id DESC", Account.class);
        return query.getResultList();
    }
	
	@Transactional(TxType.REQUIRED)
	public void deleteAccount(Account account) {
		manager.remove(account);
	}
	
	@Transactional(TxType.REQUIRED)
	public Account update(Account account, String firstName, String lastName, String accountNumber) {		
		account.setFirstName(firstName);
		account.setLastName(lastName);
		account.setAccountNumber(accountNumber);
		manager.refresh(account);
		return account;
	}


	



}
