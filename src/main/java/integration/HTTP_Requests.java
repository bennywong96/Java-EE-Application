package integration;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import business.AccountService;
import domain.Account;
import repo.ITransaction;

@Path("/account")
public class HTTP_Requests {
	
	@Inject
	private AccountService transaction;
	
	@Path("/json")
	@GET
	@Produces({ "application/json" })
	public String getAllAccounts() {
		return transaction.getAllAccounts();
	}
	
	@Path("/json/{id}")
	@GET
	@Produces({ "application/json" })
	public Account findAccount(@PathParam("id") long id) {
		return transaction.findAccount(id);
	}
	
	@Path("/json")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return transaction.addAccount(account);
	}
	
	@Path("/json/{id}")
	@PUT
	@Produces({"application/json"})
	public String updateAccount(@PathParam("id") Long id, String accountToUpdate) {
		return transaction.updateAccount(id, accountToUpdate);
	}
	
	@Path("/json/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return transaction.deleteAccount(id);

	}

}
