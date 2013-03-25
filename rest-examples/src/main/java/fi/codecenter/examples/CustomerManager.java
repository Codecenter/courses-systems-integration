package fi.codecenter.examples;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/customers")
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml","application/json"})
public class CustomerManager {
	private Map<Integer,Customer> customerDAO = Collections
			.synchronizedMap(new HashMap<Integer,Customer>());
	private int identityCounter = 1;

	public CustomerManager() {
		customerDAO.put(1, createCustomer(1, "ACME Drilling Company",
				createAddress("PL 101", "00101", "Helsinki"),
				createAddress("Eerikinkatu 24", "00100", "Helsinki")));
	}

	private Customer createCustomer(int id, String name, Address billingAddress,
			Address deliveryAddress) {
		Customer customer = new Customer();
		customer.setId(id);
		customer.setName(name);
		customer.setBillingAddress(billingAddress);
		customer.setDeliveryAddress(deliveryAddress);
		return customer;
	}

	private Address createAddress(String line1, String zipCode, String city) {
		Address address = new Address();
		address.setLine1(line1);
		address.setZipCode(zipCode);
		address.setCity(city);
		return address;
	}

	@GET
	public CustomerList getCustomers() {
		return new CustomerList(customerDAO.values());
	}

	@GET
	@Path("{id}")
	public Response getCustomer(@PathParam("id") int id) {
		Customer customer = customerDAO.get(id);
		return customer != null 
				? Response.ok(customer).build() 
				: Response.status(Response.Status.NOT_FOUND).build();
	}

	@POST
	public Response insertCustomer(Customer customer) {
		if (!isValid(customer)) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		synchronized (customerDAO) {
			identityCounter++;
			customer.setId(identityCounter);
			customerDAO.put(identityCounter, customer);
		}
		return Response.created(URI.create("/customers/" + customer.getId())).build();
	}

	@PUT
	@Path("/{id}")
	public Response updateCustomer(@PathParam("id") int id, Customer customer) {
		if (!isValid(customer)) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		synchronized (customerDAO) {
			customer.setId(id);
			customerDAO.put(id, customer);
		}
		return Response.accepted().build();
	}

	protected boolean isValid(Customer customer) {
		String name = customer.getName();
		return name != null && !"".equals(name.trim());
	}
	
	@DELETE
	@Path("/{id}")
	public Response deleteCustomer(@PathParam("id") int id) {
		customerDAO.remove(id);
		return Response.ok().build();
	}
}
