package com.staragile.insurance.policy;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PolicyController {
	
	@Autowired
	PolicyService policySvc ;
	
	@RequestMapping("hello")
	public String doSomething(){
		return "Hello World!!!";

}
	

	@RequestMapping("/policy/{id}")
	public Optional<Policy> getPolicy(@PathVariable String id){
		System.out.println("Inside getCompany");
		return policySvc.getPolicy(id);
	}
		
	@RequestMapping("/policy")
	public List<Policy> getPolicies (){
		return policySvc.getPolicies();

	}
	
	@RequestMapping(method= RequestMethod.POST, value="/policy")
	public void addPolicy(@RequestBody Policy policy) {
		policySvc.addPolicy(policy) ;
		
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/policy/{id}")
	public String updatePolicy(@RequestBody Policy policy,@PathVariable String id ){
		policySvc.updatePolicy(id, policy);	
         return "updated successfully";
	}

	
	@RequestMapping(method=RequestMethod.DELETE, value="/policy/{id}")
	public String deletePolicy(@RequestBody Policy policy,@PathVariable String id ){
		policySvc.deletePolicy(id);	
         return "updated successfully";
	}
}