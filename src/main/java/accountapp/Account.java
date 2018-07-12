package accountapp;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Account {

	
	
	
	@Id @GeneratedValue (strategy=GenerationType.SEQUENCE)
	private long id;
	@Column (length = 100)
	private String firstName;
	@Column (length = 100)
	private String lastName;
	@Column (length = 6)
	private String accountNumber;
	@OneToMany(
	        mappedBy = "account"
	        )
	private List<Transactions> transactions;
	

	public Account(String firstName, String lastName, String accountNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}
