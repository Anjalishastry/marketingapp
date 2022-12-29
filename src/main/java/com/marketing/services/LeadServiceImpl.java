package com.marketing.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketing.entities.lead;
import com.marketing.repositories.LeadRepository;

@Service
public class LeadServiceImpl implements LeadService {
	
	@Autowired
	private LeadRepository leadRepo;

	@Override
	public void saveOneLead(lead lead) {
		leadRepo.save(lead);
		
	}

	@Override
	public List<lead> getAllLeads() {
		List<lead> leads = leadRepo.findAll();
		return leads;
	}

	@Override
	public void deleteLead(long id) {
			leadRepo.deleteById(id);
	}

	@Override
	public lead getLeadbyId(long id) {
			Optional<lead> findById = leadRepo.findById(id);
			lead lead = findById.get();
			return lead;
	}

}
