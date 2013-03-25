package fi.codecenter.examples;

import javax.jws.WebService;

@WebService(endpointInterface = "fi.codecenter.examples.HelloPolicy")
public class HelloPolicyImpl implements HelloPolicy {
	public String sayHello(String name) {
		String response = "Hello " + name + "!";
		System.out.printf("sayHello responds '%s'\n", response);
		return response;
	}
}
