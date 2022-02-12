package com.home.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Required;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

public class Clients {
	
	private int clientId;
	private String clientName;
	private DataServices dataServices;
	
	
	
	

	public DataServices getDataServices() {
		return dataServices;
	}

	
	// (a) for primative type autowaireing is not possible. autowireing in only possible for object type value injection
	// (b) "@utowired" first try to inject value by using "byType" method. if "byType"  fail it try to inject value based on 
	//     "byName" approach.
	// (c)  but if both approaches (byname and bytype) are failed, in that case "@Qualifier()" annotation should be used for specify 
	//	    Dependency injection by name
	
	
	@Autowired
	@Qualifier("dataServicesObj_2")  // if you have multiple object for same class. in that case, which object will be injected is specified by @qualifier annotation
	public void setDataServices(DataServices dataServices) {
		this.dataServices = dataServices;
	}
	
	
	
	public int getClientId() {
		return clientId;
	}

	//@Required
	@Value("${client.id}")
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}


	public String getClientName() {
		return clientName;
	}

	
	@Value("Md Faysal Hossain")
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}


	public void invokeServices() {
		
		dataServices.invokeServices();
		System.out.println(getClientName());
		System.out.println(getClientId());
		
	}
	
	
	/*
	 //for interface
	 
	 	private Services services;

		public Services getServices() {
			return services;
		}
	
		public void setServices(Services services) {
			this.services = services;
		}
		
		public void invokeServices() {
			services.invokeServices();
			
		}
	 
	 
	 
	 */

	
	
	

}
