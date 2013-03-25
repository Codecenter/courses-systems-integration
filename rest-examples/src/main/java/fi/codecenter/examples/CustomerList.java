package fi.codecenter.examples;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class CustomerList implements Serializable {
	private List<Customer> customers;
	
	public CustomerList(Collection<Customer> customers) {
		this.customers = new ArrayList<Customer>(customers);
	}

	public CustomerList() {
	}
	
	@XmlElement(name = "customer")
	public List<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
}
