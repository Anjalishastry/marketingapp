package com.marketing.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marketing.entities.lead;
import com.marketing.repositories.LeadRepository;

@RestController
@RequestMapping("/api/leads")
public class LeadRestController {
	
	@Autowired
	private LeadRepository leadRepo;
	
	
	@GetMapping
	//@GetMapping("/api/leads")
	public List<lead> getAllLeads(){
		List<lead> leads = leadRepo.findAll();
		return leads;
	}
	
	@PostMapping
	public void saveOneLead(@RequestBody lead lead) {
		leadRepo.save(lead);
		
	}
	
	@PutMapping
	public void updateOneLead(@RequestBody lead lead) {
		leadRepo.save(lead);
		
	}
	@DeleteMapping("/delete/{id}")
	public void deleteOneLead(@PathVariable("id") long id) {
		leadRepo.deleteById(id);
		
	}
	@GetMapping("/find/{id}")
	public lead getOneLead(@PathVariable("id") long id) {
		Optional<lead> findById = leadRepo.findById(id);
		lead lead = findById.get();
		return lead;
	}



}
