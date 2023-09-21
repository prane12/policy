package com.staragile.insurance.policy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {
	
	
	
	
	@Autowired
	PolicyDAORepository policyDAORepository;
	
	public List<Policy> getPolicies(){
		
		/*return Arrays.asList(
			new Policy("1", "pranesh.","pranesh address", "123456789"),
			new Policy("2", "kumar.", "kumar address", "234567891"),
			new Policy("3", "kadasi", "kadasi address", "345678912")
		);*/
		
		List<Policy> policyList = new ArrayList<Policy>() ;
		policyDAORepository.findAll().forEach(policyList::add);
		return policyList;
	}
	
	public Optional<Policy> getPolicy(String id) {
		return policyDAORepository.findById(id);
	}
	
	public void addPolicy(Policy policy) {
		policyDAORepository.save( policy);
	}
	
	public void updatePolicy(String id, Policy policy) {
		policyDAORepository.save(policy);
	}

	public void deletePolicy(String id) {
		policyDAORepository.deleteById(id);
}
}
