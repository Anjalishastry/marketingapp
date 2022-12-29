package com.marketing.services;

import java.util.List;

import com.marketing.entities.lead;


public interface LeadService {
	public void saveOneLead(lead lead);

	public List<lead> getAllLeads();

	public void deleteLead(long id);

	public lead getLeadbyId(long id);

}
