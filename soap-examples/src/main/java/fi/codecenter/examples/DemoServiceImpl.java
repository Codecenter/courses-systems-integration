package fi.codecenter.examples;

import javax.jws.WebService;

@WebService(endpointInterface = "fi.codecenter.examples.DemoService")
public class DemoServiceImpl implements DemoService {
	public void oneWayOperation(String myString, Integer myInteger) {
		System.out.printf("oneWayOperation: myString=%s myInteger=%d", 
				myString, myInteger);
	}
	
	public String singleReturnValueOperation(String myInput) {
		return "Returning myInput: " + myInput;
	}
	
	public DemoResponse performOperation(DemoRequest request) throws DemoFault {
		if (request.isReturnFault()) {
			throw new DemoFault("Message from DemoFault", "FaultInfo from DemoFault");
		}
		else {
			DemoResponse response = new DemoResponse();
			response.setMyInteger(request.getMyInteger());
			response.setMyString(request.getMyString());
			return response;
		}
	}
}
